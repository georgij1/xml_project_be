package com.xml_project_be.xml_project.xml_file;

import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.words.Document;
import com.aspose.words.NodeType;
import com.aspose.words.Paragraph;
import com.aspose.words.SaveFormat;
import com.groupdocs.parser.options.IDocumentInfo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import com.groupdocs.parser.Parser;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class ControllerFile {
    JdbcTemplate jdbcTemplate;
    // define a location
    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

    // Define a method to upload files
    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFiles(
            @RequestParam("files") List<MultipartFile> multipartFiles,
            @RequestParam("NameCompany") String NameCompany,
            @RequestParam("Author") String Author,
            @RequestParam("TimeStamp") String TimeStamp
    ) throws IOException {
        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(select image_name from files where image_name=? and author=?)", Boolean.class, filename, Author))) {
                if (file.getOriginalFilename().contains(String.valueOf("doc"))) {
                    Path fileStorage = get(DIRECTORY + NameCompany, filename).toAbsolutePath().normalize();
                    copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
                    filenames.add(filename);
                    jdbcTemplate.update(
                            "insert into files(image_name, time_stamp, author, name_company) values (?,?,?, ?)",
                            file.getOriginalFilename(),
                            TimeStamp,
                            Author,
                            NameCompany
                    );
                } else {
                    return ResponseEntity.ok().body(Collections.singletonList("NotCorrect type of file"));
                }
            }
        }
        return ResponseEntity.ok().body(filenames);
    }

    @PostMapping("/list")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> list_files(
            @RequestBody Form NameCompany
    ) {
        if (Boolean.TRUE.equals(jdbcTemplate.queryForObject("select exists(select name_company from files where name_company=?)", Boolean.class, NameCompany.getNameCompany()))) {
            File f = new File(System.getProperty("user.home") + "/Downloads/uploads/" + NameCompany.getNameCompany());
            File[] files = f.listFiles();
            ArrayList<String> NameFiles = new ArrayList<>();
            for (File file_1 : Objects.requireNonNull(files)) {
                NameFiles.add(file_1.getName());
            }
            return ResponseEntity.ok().body(
                    jdbcTemplate.queryForList("select * from files where name_company=?", NameCompany.getNameCompany())
            );
        } else {
            ArrayList<DomainBean> arr = new ArrayList<>();
            DomainBean domainBean = new DomainBean();
            domainBean.setId_image("1");
            domainBean.setImage_name("Not found file");
            domainBean.setTime_stamp("Not found file");
            domainBean.setAuthor("Not found file");
            domainBean.setCompany("Not found file");
            arr.add(domainBean);
            return ResponseEntity.ok().body(arr);
        }
    }

    // read content word file
    @GetMapping("/read/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readFile(
            @PathVariable("FileName") Integer FileName,
            @PathVariable("NameCompany") String NameCompany
    ) {
        Document doc = new Document(System.getProperty("user.home") + "\\Downloads\\uploads\\" + NameCompany + "\\" + jdbcTemplate.queryForList("select image_name from files where id_image=?", FileName).get(0).get("image_name"));
        ArrayList<List> arrayList = new ArrayList<>();
        for (Object obj : doc.getChildNodes(NodeType.PARAGRAPH, true)) {
            Paragraph para = (Paragraph) obj;
            arrayList.add(Collections.singletonList(para.toString(SaveFormat.TEXT)));
        }
        return ResponseEntity.ok().body(arrayList);
    }

    // convert xml
    @GetMapping("/read/XML/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readXMLFile(
            @PathVariable("FileName") Integer IdFile,
            @PathVariable("NameCompany") String NameCompany
    ) {
        File file_dir = new File(System.getProperty("user.home") + "/Downloads/uploads/" + NameCompany + "/xml");
        if (!file_dir.exists()) file_dir.mkdir();
        String DEST = String.valueOf(get(System.getProperty("user.home") + "/Downloads/uploads" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        String DEST_XML = String.valueOf(get(System.getProperty("user.home") + "/Downloads/uploads" + "/" + NameCompany + "/xml/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name"))) + ".xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.newDocument();
            Element rootElement = doc.createElement("Conclusion");
            doc.appendChild(rootElement);
            rootElement.setAttribute("ConclusionGUID", "d1ca32e2-a8f0-4776-a499-1d946c6f6064");
            rootElement.setAttribute("SchemaVersion", "01.00");
            rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "conclusion.xsd");
            rootElement.appendChild(getExpertOrganization(doc));
            rootElement.appendChild(getApprover(doc));
            rootElement.appendChild(getExaminationObject(doc));
            rootElement.appendChild(getDocuments(doc));
            rootElement.appendChild(getPreviousConclusions(doc));
            rootElement.appendChild(getPreviousSimpleConclusions(doc));
            rootElement.appendChild(getObject(doc));
            rootElement.appendChild(getCadastralNumber(doc));
            rootElement.appendChild(getDeclarant(doc));
            rootElement.appendChild(getProjectDocumentsDeveloper(doc));
            rootElement.appendChild(getFinance(doc));
            rootElement.appendChild(getClimateConditions(doc));
            rootElement.appendChild(getClimateConditionsNote(doc));
            rootElement.appendChild(getDesigner(doc));
            rootElement.appendChild(getExpertProjectDocuments(doc));
            rootElement.appendChild(getSummary(doc));
            rootElement.appendChild(getExperts(doc));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(DEST_XML));
            transformer.transform(source, file);
            transformer.transform(source, console);
            System.out.println("Создание XML файла закончено");

            return ResponseEntity.ok().body(console);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body("");
    }

    private static Node getExperts(org.w3c.dom.Document doc) {
        Element node = doc.createElement("Experts");
        node.appendChild(doc.createElement("Expert")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("Матвеев"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("Алексей"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("Александрович"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertType")).appendChild(doc.createTextNode("10."));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificate")).appendChild(doc.createTextNode("МС-Э-1-10-13222"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateBeginDate")).appendChild(doc.createTextNode("2020-01-29"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateEndDate")).appendChild(doc.createTextNode("2025-01-29"));
        return node;
    }

    private static Node getSummary(org.w3c.dom.Document doc) {
        Element node = doc.createElement("Summary");
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("1"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("2"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("4"));
        node.appendChild(doc.createElement("ProjectDocumentsSummary")).appendChild(doc.createTextNode("Изменения, внесенные в проектные решения, не повлияли на общую устойчивость и\n" +
                "            конструктивную неизменяемость объекта в целом, не влекут за собой превышение предельных параметров\n" +
                "            разрешенного строительства объекта (высоты, этажности, объема), полностью совместимы с ранее принятыми\n" +
                "            техническими решениями в разделах, изменения в которые не вносились.\n" +
                "\n" +
                "            Проектная документация соответствует требованиям технических регламентов и сводов правил (применение которых\n" +
                "            на обязательной основе включен в перечень, утвержденный Постановлением Правительства РФ № 985 от\n" +
                "            04.07.2020), иным установленным требованиям, а также результатам инженерных изысканий, выполненных для\n" +
                "            подготовки проектной документации, и заданию на проектирование."));
        node.appendChild(doc.createElement("ProjectDocumentsSummaryDate")).appendChild(doc.createTextNode("Экспертная оценка проведена на соответствие требованиям, примененным при\n" +
                "            первоначальном проведении экспертизы проектной документации и результатов инженерных изысканий, по\n" +
                "            результатам которого было получено положительное заключение от 17.03.2021 № 66-2-1-012042-2021."));
        node.appendChild(doc.createElement("ExaminationSummary")).appendChild(doc.createTextNode("Проектная документация по объекту: «Жилая многоэтажная застройка квартала 4.15.1 в границах\n" +
                "            улиц Краснолесья – Рябинина – Очеретина в Академическом районе\n" +
                "            г. Екатеринбурга»\n" +
                "            - соответствует результатам инженерных изысканий, выполненных для её подготовки;\n" +
                "            - соответствует заданию на проектирование;\n" +
                "            - соответствует техническим регламентам и иным установленным требованиям."));
        return node;
    }

    private static Node getExpertProjectDocuments(org.w3c.dom.Document doc) {
        Element node = doc.createElement("ExpertProjectDocuments");
        node.setAttribute("ExpertType", "5.");
        node.appendChild(doc.createElement("ProjectDocumentsReview")).appendChild(doc.createTextNode("В административном отношении земельный участок расположен по адресу: Свердловская\n" +
                "            область, муниципальное образование «город Екатеринбург», район Верх-Исетский, квартал 4.15.1 в границах улиц\n" +
                "            Краснолесья - Рябинина - Очеретина.\n" +
                "            Участок граничит:\n" +
                "            - с северо-западной стороны - с ул. Рябинина;\n" +
                "            - с юго-западной стороны - с ул. Краснолесья;\n" +
                "            - с юго-восточной - с ул. Очеретина.\n" +
                "            На территории, предназначенной для новой застройки, отсутствуют капитальные постройки. Абсолютные отметки\n" +
                "            поверхности изменяются от 273,80 до 272,80 м.\n" +
                "            Район и подрайон строительства по климатическому районированию относится к 1В.\n" +
                "            В соответствии с ГПЗУ № RU 66302000-15495 от 26.12.2019 земельный участок с кадастровым номером\n" +
                "            66:41:0313121:85 площадью 14087 м2, на котором планируется осуществить новое строительство, расположен в\n" +
                "            территориальной зоне Ж-5 - «Зона многоэтажной жилой застройки».\n" +
                "            Проектной документацией предусмотрено строительство жилой застройки, являющейся единым жилым комплексом с\n" +
                "            помещениями общественного назначения и встроенно-пристроенной автостоянкой.\n" +
                "            Строительство объекта предусмотрено в 2 этапа строительства:\n" +
                "            1 этап строительства:\n" +
                "            - № 1 (по ПЗУ) – жилое 3-секционное здание переменной этажности (13, 17, 21-этажные секции) с жилыми\n" +
                "            помещениями, со встроенными помещениями коммерческого назначения, с одноуровневым подземным паркингом;\n" +
                "            - № 2 (по ПЗУ) – 25-ти этажное здание с жилыми помещениями, со встроенными помещениями коммерческого\n" +
                "            назначения, с одноуровневым подземным паркингом. (в АР-жилой односекционный 25-этажный дом, с крышной\n" +
                "            газовой котельной);\n" +
                "            - № 4.1 (по ПЗУ) – встроенно-пристроенная подземная автостоянка с рампой въезда-выезда;\n" +
                "            - № 5 (по ПЗУ) – трансформаторная подстанция;\n" +
                "            2 этап строительства:\n" +
                "            - № 3 (по ПЗУ) – 25-ти этажное здание с жилыми помещениями, с одноуровневым подземным паркингом. (в АР -\n" +
                "            односекционный 25-этажный дом);\n" +
                "            - № 4.2 (по ПЗУ) – встроенно-пристроенная подземная автостоянка.\n" +
                "            Размещение проектируемого здания выполнено в соответствии с «Чертежом градостроительного плана земельного\n" +
                "            участка и линий градостроительного регулирования» по ГПЗУ.\n" +
                "            Площадь участка в границе отвода согласно ГПЗУ - 14087 м2, в т.ч.:\n" +
                "            - площадь благоустройства 1 этапа строительства - 8606 м2;\n" +
                "            - площадь благоустройства 2 этапа строительства - 4647 м2;\n" +
                "            - площадь перспективного развития - 834 м2.\n" +
                "            Общая площадь квартир:\n" +
                "            1 этап строительства: Жилой дом №1 (секция 1, 2, 3) - 13 744,80 м2, Жилой дом №2 - 12 738,0 м2;\n" +
                "            2 этап строительства: Жилой дом №3 - 12 955,88 м2.\n" +
                "            Жилищная обеспеченность принята:\n" +
                "            - для всех очередей строительства - 35 м2 (в соответствии с Заданием на проектирование).\n" +
                "            Количество жителей 1126 чел., в т.ч.:\n" +
                "            1 этап строительства: Жилой дом №1 (секция 1, 2, 3) - 396 чел., Жилой дом №2 - 360 чел;\n" +
                "            2 этап строительства: Жилой дом №3 - 370 чел.\n" +
                "            Общая площадь коммерческих помещений в проектируемых домах 867,1 м2, в т.ч.:\n" +
                "            1 этап строительства: Жилой дом №1 (секция 1, 2, 3) - 520,9 м2, Жилой дом №2 - 346,2 м2.\n" +
                "            В состав проектируемого комплекса входят:\n" +
                "            - офисные помещения в Жилом доме №1 на 46 человек;\n" +
                "            - офисные помещения в Жилом доме №2 на 26 человек;\n" +
                "            - в паркинге 1 этап строительства - 138 м/м;\n" +
                "            - в паркинге 2 этап строительства - 81 м/м.\n" +
                "            Заезд на внутридворовую территорию проектируемого жилого квартала предлагается осуществлять с ул.\n" +
                "            Краснолесья между жилым домом №2 и секцией 3 жилого дома №1. Заезд в подземный паркинг расположен с ул.\n" +
                "            Рябинина. Проектируемые въезды запроектированы под прямым углом, ширина составляет 6,0м.\n" +
                "            Проект благоустройства территории предусматривает:\n" +
                "            - устройство внутриплощадочных проездов из укрепленного тротуарного камня «Бехатон»;\n" +
                "            - устройство пешеходного тротуара из тротуарного камня «Бехатон»;\n" +
                "            - устройство резинового покрытия на детских и спортивных площадках\n" +
                "            - устройство газонов и цветников;\n" +
                "            - устройство заглубленной отмостки из мембраны PlanterGeo (или аналог) шириной не менее 600 мм с верхним\n" +
                "            покрытием по проекту благоустройства;\n" +
                "            - посадка деревьев и кустарников.\n" +
                "            Придомовая территория запроектирована с учетом обязательного размещения элементов благоустройства (площадок:\n" +
                "            ПД - игровых площадок для детей дошкольного и младшего школьного возраста, ПО - для отдыха взрослого\n" +
                "            населения, ПС - для занятий физкультурой) и расстояний от них до нормируемых объектов в соответствии с\n" +
                "            СП 42.13330.2016, СП 4.13130.2013, СП 59.13330.2012 и СанПиН 2.2.1/2.1.1.1200-03. Нормируемые площади\n" +
                "            спортивных площадок сокращены на 50% на основании п. 7.5 СП 42.13330.2016 при наличии единого спорт-ядра\n" +
                "            микрорайона-стадиона, находящегося в радиусе доступности не более 500 м.\n" +
                "            Расчет автостоянок для жителей выполнен на основании «Нормативов градостроительного проектирования\n" +
                "            городского округа – муниципального образования «город Екатеринбург» от 22.12.2015 г. п. 43п.\n" +
                "            По расчету для хранения транспорта проектируемого жилого дома требуется\n" +
                "            500 м/место, в том числе:\n" +
                "            для 1 этапа строительства:\n" +
                "            66 м/мест (20%) - для временного хранения автомобилей жителей;\n" +
                "            264 м/мест (80%) - для постоянного хранения автомобилей жителей;\n" +
                "            8 м/м - для временного хранения автомобилей для нежилых помещений;\n" +
                "            для 2 этапа строительства:\n" +
                "            32 м/места (20%) - для временного хранения автомобилей жителей;\n" +
                "            130 м/мест (80%) - для постоянного хранения автомобилей жителей.\n" +
                "            Проектом предусмотрено устройство автостоянок общей обеспеченностью\n" +
                "            277 (недостаток-500-277=223 м/места) м/мест в т.ч.:\n" +
                "            - для постоянного хранения автомобилей жителей- подземном паркинге 219 м/ мест (недостаток 264+130-219=175\n" +
                "            м/мест);\n" +
                "            - для временного хранения автомобилей жителей - 50 м/мест на открытых парковках (поз. А1, А4, А5, А10А11,\n" +
                "            А12, А14 по ПЗУ) по ул. Краснолесья на участке с кадастровым номером 66:41:0313121:9805 (разрешенное\n" +
                "            использование – для объектов общественно-делового значения) и в соответствии с Проектом планировки и\n" +
                "            проектом межевания и территории первой очереди застройки планировочного района «Академический» в Ленинском и\n" +
                "            Верх-Исетском районах города Екатеринбурга (ш. 02-16-ПП) и на участке с кадастровым номером\n" +
                "            66:41:0313121:2037 для использования после строительства и ввода в эксплуатацию дорожной сети по ул.\n" +
                "            Рябинина, согласно ППТ ш. 02-16-ПП (заключении экспертизы № 66-2-3-049345-2020 от 02.10.2020);\n" +
                "            - для временного хранения автомобилей для нежилых помещений 8 м/мест на парковке А5 (6 м/мест) и на парковке\n" +
                "            А4 (2 м/места).\n" +
                "            Недостающие по расчету 223 м/места (44,7%) предполагается разместить на участке с кадастровым №\n" +
                "            66:41:0313121:0043 по ул. Краснолесье согласно договору аренды земельного участка № 38/А от 27.08.2007.\n" +
                "            Расчет накопления твердых коммунальных отходов (ТКО) выполнен на основании данных НГПСО 1.2009-66 «Нормативы\n" +
                "            градостроительного проектирования Свердловской области», табл. 26 и 27. Сбор и накопление твердых\n" +
                "            коммунальных отходов для жилого дома осуществляется во встроенных мусорокамерах с отсеками для\n" +
                "            крупногабаритных отходов в каждом доме с установкой 3 контейнеров для 1 этапа строительства и 2 контейнеров\n" +
                "            для 2 этапа строительства. Объем 1 контейнера 1,1 м3. Вывоз мусора осуществляется спецтехникой по договору с\n" +
                "            ЕМУП «Специализированная автобаза».\n" +
                "            Проектом предусматривается сплошная вертикальная планировка, внутридворовое пространство приподнято\n" +
                "            относительно окружающей территории для размещения паркинга под дворовой территорией. Организация рельефа\n" +
                "            обеспечивает отвод поверхностных вод, выполняется вертикальной планировкой по проектируемым проездам, к\n" +
                "            существующему и проектируемому дождеприёмным колодцам по\n" +
                "            ул. Краснолесья.\n" +
                "            Проектные уклоны спланированной территории колеблются от 4 до 30‰.\n" +
                "            Поперечные уклоны тротуаров не превышают 20‰, продольные - 30‰.\n" +
                "            Водоотвод ливневых стоков с крыш зданий по внутреннему водостоку, по лоткам до проезжей части.\n" +
                "            За относительную отметку 0,000 принята отметка пола 1 этажа жилого дома соответствующая абсолютной отметке\n" +
                "            273,65 м.\n" +
                "            Инженерные сети запроектированы согласно нормативам и техническим условиям.\n" +
                "\n" +
                "            Обеспечение доступа инвалидов\n" +
                "            План благоустройства выполнен в соответствии с требованиями СП 59-13330.2012 «Доступность зданий и\n" +
                "            сооружений для маломобильных групп населения» (актуализированная редакция СП 35-103-2001).\n" +
                "            Уклоны пешеходных тротуаров – продольный не более 50 ‰, поперечный – не более 20‰.\n" +
                "            Ширина тротуаров на внутридворовой территории – не менее 2,00 м, на прилегающих тротуарах улиц - не менее\n" +
                "            3,00 м.\n" +
                "            Количество парковочных мест для инвалидов определено в соответствии с рекомендациями СП 59-13330.2012, п.\n" +
                "            4.2.1. Габаритные размеры м/места для инвалидов выполнены рекомендации местной общественной организации\n" +
                "            «Екатеринбургская городская общественная организация инвалидов-колясочников «Свободное движение» и\n" +
                "            составляет 3,60 м х 6,00 м. Все места оборудуются специальной разметкой, а также соответствующими дорожными\n" +
                "            знаками.\n" +
                "            Количество парковочных мест для ММГН принято 10% от количества временных гостевых парковок. Временные\n" +
                "            парковки (в т.ч для нежилых помещений)- 107 м/мест.\n" +
                "            Общее количество м/мест для ММГН, размещаемых на открытых автостоянках (поз. А5, А1, А4) – 12 м/мест.\n" +
                "\n" +
                "            Зоны с особыми условиями использования территории (ЗОУИТ)\n" +
                "            Проектными решениями предусмотрено строительство комплекса Многоэтажных домов с встроенными нежилыми\n" +
                "            помещениями не производственного характера и подземной автостоянкой. Организация санитарно-защитной зоны от\n" +
                "            объекта не требуется.\n" +
                "            В непосредственной близости от границ проектирования расположены объекты, в отношении которых\n" +
                "            устанавливаются санитарно-защитные зоны и санитарные разрывы:\n" +
                "            - с западной стороны по ул. Краснолесья расположена открытая автопарковка, от которой выдержан санитарный\n" +
                "            разрыв 50м до стен проектируемых зданий;\n" +
                "            - с западной стороны на расстоянии 1000м расположен ТЦ «Лента». СанПиН2.2.1/2.1.1.1200-03 размер СЗЗ\n" +
                "            составляет 50 м;\n" +
                "            - с южной стороны на расстоянии 500м расположен ТЦ «Академический». СанПиН2.2.1/2.1.1.1200-03 размер СЗЗ\n" +
                "            составляет 50 м.\n" +
                "            Площадка проектируемого строительства жилого дома размещается за пределами санитарно-защитных зон\n" +
                "            предприятий, сооружений и иных объектов.\n" +
                "            В соответствии с картой градостроительного зонирования в составе «Правил землепользования и застройки\n" +
                "            городского округа-МО «город Екатеринбург», утвержденных Решением Екатеринбургской думой от 19.06.18 г.\n" +
                "            №22/83. (в ред. от 12 февраля 2019 года №23/10), участок изысканий расположен в зоне многоэтажной жилой\n" +
                "            застройки (ЖК-5). Зона многоэтажной жилой застройки Ж-5 выделена для формирования жилых районов, на\n" +
                "            территориях которых размещаются многоквартирные дома с площадками для отдыха, игр, спортивными площадками,\n" +
                "            объекты социальной, транспортной инфраструктуры, а также объекты обслуживания жилой застройки с ограниченным\n" +
                "            спектром услуг, коммунальные предприятия. Основные виды разрешенного использования: многоэтажная жилая\n" +
                "            застройка (высотой до 100 метров), многоэтажная жилая застройка.\n" +
                "            Площадка для размещения объекта с его инфраструктурой не располагается на территориях, отнесенных к особо\n" +
                "            охраняемым природным территориям. Отсутствие в границах участка особо охраняемых природных территорий\n" +
                "            федерального значения подтверждается сведениями из официального сайта http://oopt.kosmosnimki.ru.\n" +
                "            Заповедных зон и заказников вблизи контуров размещения площадки под настоящий объект, зарегистрированных\n" +
                "            Постановлением Правительства Свердловской области, нет.\n" +
                "            Объекты, расположенные на земельном участке проектирования и в непосредственной близости от него, имеют\n" +
                "            охранные зоны и зоны с особыми условиями использования территории (ЗОУИТ).\n" +
                "            Здания объекта запроектировано с соблюдением санитарных разрывов:\n" +
                "            - Проезды автотранспорта, ведущие на автостоянки, - 7,0 м (СанПиН2.2.1/2.1.1.1200-03 «Санитарно-защитные\n" +
                "            зоны и санитарная классификация предприятий, сооружений и иных объектов», раздел 7.1.12);\n" +
                "            - Запроектирован въезд в подземную автостоянку.\n" +
                "            В соответствии с примечаниями к табл. 7.1.1 СанПиН2.2.1/2.1.1.1200-03 для подземных, полуподземных и\n" +
                "            обвалованных гаражей-стоянок регламентируется расстояние от въезда-выезда и от вентиляционных шахт до жилых\n" +
                "            домов, площадок отдыха и др., которое должно составлять не менее 15 метров. Решениям проекта, вентиляционные\n" +
                "            шахты проектируемого паркинга предусматривается разместить на кровле жилых домов;\n" +
                "            - парковки легкового транспорта до 10 м/мест – СЗЗ 10м.\n" +
                "            Здание 2 этапа строительства объекта запроектировано с соблюдением противопожарных разрывов:\n" +
                "            Открытые площадки для временного хранения автомобилей – не менее 10,0 м до жилых и общественных зданий.\n" +
                "            Охранные зоны инженерных сетей:\n" +
                "            1. Теплотрасса – 3,0 м (Приказ Мин. архитектуры, строительства и жилищно-коммунального хозяйства РФ №197 от\n" +
                "            17 августа 1992 года «О типовых правилах охраны коммунальных тепловых сетей, п. 4);\n" +
                "            2. Водопровод – 5,0 м (СП 42.13330.2016 «Градостроительство. Планировка и застройка городских и сельских\n" +
                "            поселений» (актуализированная редакция СНиП 2.07.01-89*)», раздел 12.35, таблица 12.5);\n" +
                "            3. Бытовая канализация – 3,0 м (СП 42.13330.2016 «Градостроительство. Планировка и застройка городских и\n" +
                "            сельских поселений» (актуализированная редакция\n" +
                "            СНиП 2.07.01-89*)», раздел 12.35, таблица 12.5);\n" +
                "            4. Ливневая канализация – 3,0 м (СП 42.13330.2016 «Градостроительство. Планировка и застройка городских и\n" +
                "            сельских поселений» (актуализированная редакция\n" +
                "            СНиП 2.07.01-89*)», раздел 12.35, таблица 12.5);\n" +
                "            5. Подземная кабельная линия электропередач (кабель связи) КЛ 0,4 кВ – 1,0 м (Постановление Правительства РФ\n" +
                "            от 24 февраля 2009 г. №160 в редакции 21.12.2018 г.). При прохождении кабельных линий напряжением до 1,0 кВ\n" +
                "            в городах под тротуарами - на 0,6 м в сторону зданий и сооружений и на 1,0 м в сторону проезжей части улицы.\n" +
                "            6. Подземная низковольтная кабельная линия электропередачи КЛ – 1,0 м (Постановление Правительства РФ от 24\n" +
                "            февраля 2009 г.№160);\n" +
                "            7. охранная зона ТП (Постановление Правительства РФ от 24 февраля 2009 г. №160);\n" +
                "            - Согласно ГПЗУ RU 66302000-15495, часть участка выделена как территория общего пользования.\n" +
                "            Выделен участок для размещения инженерных сетей.\n" +
                "            Проектируемый объект не нарушает режим охранных зон. В пределах охранных зон подземных коммуникаций не\n" +
                "            допускается производить действия, которые могут повлечь нарушения в нормальной работе сетей, их повреждение,\n" +
                "            несчастные случаи или препятствующие ремонту: размещать автозаправочные станции, хранилища горюче-смазочных\n" +
                "            материалов, складировать агрессивные химические материалы; загромождать подходы и подъезды к объектам и\n" +
                "            сооружениям сетей, складировать тяжелые и громоздкие материалы, возводить временные строения и заборы.\n" +
                "            Вывод: Проектируемый жилой комплекс учитывает размещение данных охранных зон, не нарушает режим пользования\n" +
                "            территории в данных зонах и размещен в границах земельного участка без ограничений."));
        return node;
    }

    private static Node getDesigner(org.w3c.dom.Document doc) {
        Element node = doc.createElement("Designer");
        node.setAttribute("General", "нет");
        node.appendChild(doc.createElement("IP")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("ГАБЗАЛИЛОВА"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("МАРИНА"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("РАВИЛЬЕВНА"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("OGRNIP")).appendChild(doc.createTextNode("320665800123804"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("PostAddress")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Россия"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("66"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("PostIndex")).appendChild(doc.createTextNode("623281"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("г Ревда"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("ул Ленина"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("34"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("58"));
        return node;
    }

    private static Node getProjectDocumentsDeveloper(org.w3c.dom.Document doc) {
        Element node = doc.createElement("ProjectDocumentsDeveloper");
        node.appendChild(doc.createElement("Organization")).appendChild(doc.createElement("OrgFullName")).appendChild(doc.createTextNode("ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ СПЕЦИАЛИЗИРОВАННЫЙ ЗАСТРОЙЩИК ЛИДЕР КОНСТРАКШН"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgOGRN")).appendChild(doc.createTextNode("1076671026728"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgINN")).appendChild(doc.createTextNode("6671236301"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgKPP")).appendChild(doc.createTextNode("665801001"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("66"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Г. ЕКАТЕРИНБУРГ"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("УЛ. ВИКУЛОВА"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Д. 59/К. 1"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("ОФИС 303"));
        return node;
    }

    private static Node getFinance(org.w3c.dom.Document doc) {
        Element node = doc.createElement("Finance");
        node.appendChild(doc.createElement("FinanceType")).appendChild(doc.createTextNode("3"));
        node.appendChild(doc.createElement("FinanceSize")).appendChild(doc.createTextNode("100.0"));
        return node;
    }

    private static Node getClimateConditions(org.w3c.dom.Document doc) {
        Element node = doc.createElement("ClimateConditions");
        node.appendChild(doc.createElement("ClimateDistrict")).appendChild(doc.createTextNode("IВ"));
        node.appendChild(doc.createElement("GeologicalConditions")).appendChild(doc.createTextNode("II"));
        node.appendChild(doc.createElement("WindDistrict")).appendChild(doc.createTextNode("I"));
        node.appendChild(doc.createElement("SnowDistrict")).appendChild(doc.createTextNode("III"));
        node.appendChild(doc.createElement("SeismicActivity")).appendChild(doc.createTextNode("7"));
        return node;
    }

    private static Node getClimateConditionsNote(org.w3c.dom.Document doc) {
        Element node = doc.createElement("ClimateConditionsNote");
        node.appendChild(doc.createTextNode("Инженерно-геодезические условия\n" +
                "        Рельеф участка ровный. Абсолютные отметки поверхности изменяются в пределах: северный участок съемки - от 272,74\n" +
                "        до 269,69 м; южный участок съемки - от 273,49 до 269,55 м.\n" +
                "        В геоморфологическом отношении район работ расположен в пределах горно-холмистого рельефа Центрального Урала и\n" +
                "        его увального восточного склона.\n" +
                "\n" +
                "        Инженерно-геологические условия\n" +
                "        Исследуемая площадка находится в зоне развития Балтымского габбрового массива (D2-3), сложенного габбро\n" +
                "        уралитизированными, уралитовыми, соссюритовыми и цоизитовыми, различной степени выветривания.\n" +
                "        На изучаемой площадке скальные грунты представлены габбро серого, серо-желтого, серовато-зеленого,\n" +
                "        серо-коричневого, серо-бурого цвета, различной степени выветривания (от сильновыветрелых (полускальных) до\n" +
                "        слабовыветрелых разностей). Скальный массив сильно раздроблен системой трещин. Выветривание пород носит\n" +
                "        неравномерный характер, нередко наблюдается прослои пород различной степени выветрелости или наличие останцов\n" +
                "        менее выветрелых пород в более выветрелых и наоборот.\n" +
                "        Кровля скальных и полускальных грунтов носит достаточно ровный характер и была вскрыта на глубине, в основном,\n" +
                "        1,2 - 2,5 м в пределах абсолютных отметок 267,32 - 268,70 м. Максимальная глубина залегания кровли скального\n" +
                "        массива была зафиксирована из-за наличия навалов и уступов насыпных грунтов на отметке 4,2 - 5,0 м (абсолютные\n" +
                "        отметки 267,84 - 268,14 м) в юго- восточной части площадки.\n" +
                "        Практически во всех выработках в кровле габбрового массива залегают грунты дисперсной зоны коры выветривания.\n" +
                "        Грунты представлены элювиальными супесями, реже суглинками, серо-желтого, серовато-синего, серо-зеленого и\n" +
                "        серого цвета, с дресвой. Кровля дисперсных грунтов была зафиксирована на глубине 0,9 - 1,7 м, в юго-восточной\n" +
                "        части участка - на глубине 4,2 м, в пределах абсолютных отметок 268,22 - 269,13 м. Мощность элювиальных\n" +
                "        дисперсных грунтов небольшая - 0,4 - 1,1 м.\n" +
                "        В кровле элювиальные образования и скальные грунты перекрыты четвертичными зерно-болотными отложениями,\n" +
                "        представленными глинами, реже суглинками, темно-серого цвета, с примесью торфа, на отдельных участках с тонкими\n" +
                "        линзами песка. Грунты были скрыты во всех выработках, за исключением скважин №№ 30 и 31, в кровле элювиальных\n" +
                "        полускальных грунтов (скважина № 5) маломощным слоем от 0,2 до 0,8 м.\n" +
                "        Озерно-болотные отложения в кровле перекрыты торфом черного и темно-коричневого цвета, слаборазложившимся,\n" +
                "        осушенным. Торф был встречен во всех скважинах, за исключением скважин №№ 30 и 31, мощностью 0,3 - 1,1 м. По\n" +
                "        характеру залегания торф на большей территории открытого залегания и лишь в небольшом количестве выработок\n" +
                "        искусственно погребен под насыпными грунтами.\n" +
                "        Непосредственно с поверхности площадка перекрыта почвенно-растительным слоем и насыпным грунтом. Насыпной грунт\n" +
                "        был вскрыт в части выработок (скважинами №№ 12, 18, 19, 21, 24 - 26, 29 - 31) и представлен щебнем, суглинком,\n" +
                "        песком, глыбами гранита. Мощность составила от 0,3 - 1,0 до 4,2 - 5,0 м.\n" +
                "        На основании анализа пространственной изменчивости частных показателей свойств грунтов, определенных\n" +
                "        лабораторными исследованиями, и на основании документации скважин в пределах площадки изысканий до изученной\n" +
                "        глубины 15 м выделены следующие инженерно-геологические элементы (ИГЭ):\n" +
                "        ИГЭ 1 – насыпной грунт представлен щебнем, суглинком, песком, глыбами гранита. По возрасту отсыпки грунты\n" +
                "        неслежавшиеся. Нормативное значение плотности грунта ρн=1,80 г/см3, расчетное сопротивление грунта R0=0,06 МПа.\n" +
                "        Коррозионная агрессивность к углеродистой и низколегированной стали – высокая. Степень агрессивного воздействия\n" +
                "        по содержанию сульфатов и хлоридов к бетону марок W4 - W20 – неагрессивная.\n" +
                "        ИГЭ 2 – торф слаборазложившийся, осушенный. Нормативное значение плотности грунта ρн=0,96 г/см3. Коррозионная\n" +
                "        агрессивность к углеродистой и низколегированной стали – высокая. Степень агрессивного воздействия по содержанию\n" +
                "        сульфатов и хлоридов к бетону марок W4 - W20 – неагрессивная.\n" +
                "        ИГЭ 3 – глина озерно-болотная мягкопластичная, с примесью торфа, на отдельных участках с тонкими линзами песка.\n" +
                "        Грунт ненабухающий, непросадочный, сильнопучинистый. Нормативное значение плотности грунта ρн=1,89 г/см3, модуль\n" +
                "        деформации Е=8,0 МПа, угол внутреннего трения φн=16 град, удельное сцепление сн=0,026 МПа. Коррозионная\n" +
                "        агрессивность к углеродистой и низколегированной стали – высокая. Степень агрессивного воздействия по содержанию\n" +
                "        сульфатов и хлоридов к бетону марок W4 - W20 – неагрессивная.\n" +
                "        ИГЭ 4 – супесь элювиальная пластичной консистенции, с дресвой. Грунт ненабухающий, непросадочный,\n" +
                "        слабопучинистый. Нормативное значение плотности грунта ρн=2,06 г/см3, модуль деформации Е=19,0 МПа, угол\n" +
                "        внутреннего трения φн=27 град, удельное сцепление сн=0,039 МПа. Коррозионная агрессивность к углеродистой и\n" +
                "        низколегированной стали – высокая. Степень агрессивного воздействия по содержанию сульфатов и хлоридов к бетону\n" +
                "        марок W4 - W20 – неагрессивная.\n" +
                "        ИГЭ 5 – габбро пониженной прочности сильновыветрелое, с суглинистым заполнителем по трещинам, на отдельных\n" +
                "        участках с «гнездами» скальных малопрочных грунтов. Нормативные значения характеристик: плотность грунта ρ=2,56\n" +
                "        г/см3, предел прочности на одноосное сжатие в водонасыщенном состоянии Rс=3,2 МПа.\n" +
                "        ИГЭ 6 – габбро малопрочное средневыветрелое, очень сильнотрещиноватое, на отдельных участках с суглинистым\n" +
                "        заполнителем по трещинам, с «гнездами» полускальных грунтов и скальных грунтов средней прочности. Нормативные\n" +
                "        значения характеристик: плотность грунта ρ=2,76 г/см3, предел прочности на одноосное сжатие в водонасыщенном\n" +
                "        состоянии Rс=9,9 МПа.\n" +
                "        ИГЭ 7 – габбро средней прочности слабовыветрелое, от очень сильнотрещиноватого до среднетрещиноватого, на\n" +
                "        отдельных участках с «гнездами» полускальных грунтов пониженной прочности и скальных малопрочных грунтов.\n" +
                "        Нормативные значения характеристик: плотность грунта ρ=2,86 г/см3, предел прочности на одноосное сжатие в\n" +
                "        водонасыщенном состоянии Rс=32,8 МПа.\n" +
                "        ИГЭ 8 – габбро прочное слабовыветрелое, от сильнотрещиноватого до слаботрещиноватого. Нормативные значения\n" +
                "        характеристик: плотность грунта ρ=3,00 г/см3, предел прочности на одноосное сжатие в водонасыщенном состоянии\n" +
                "        Rс=65,9 МПа.\n" +
                "        Нормативная глубина промерзания суглинков и глин – 1,57 м, супесей – 1,91 см, насыпных грунтов – 1,57 – 2,32 м\n" +
                "        (в зависимости от состава).\n" +
                "        На изучаемой территории развиты специфические грунты, представленные техногенными (ИГЭ 1), органическими (ИГЭ 2)\n" +
                "        и элювиальными грунтами (ИГЭ 4).\n" +
                "        В гидрогеологическом отношении исследуемый участок расположен в пределах развития нескольких водоносных\n" +
                "        горизонтов - горизонта, приуроченного к трещиноватой зоне скальных грунтов и остаточной трещиноватости в\n" +
                "        элювиальных образованиях коры выветривания, и горизонта четвертичных озерно-болотных и болотных отложений.\n" +
                "        Условный водоупор определяется глубиной распространения региональной трещиноватости и находится на глубине\n" +
                "        ориентировочно 50 м (по фондовым материалам).\n" +
                "        В целом оба горизонта гидравлически связаны между собой и имеют единую безнапорную поверхность. Ввиду\n" +
                "        осуществления мелиоративных мероприятий при разработке Широкореченского торфяного месторождения, а также\n" +
                "        строительного водопонижения при застройке района работ, уровень подземных вод был понижен. В настоящее время\n" +
                "        водовмещающими породами являются элювиальные грунты коры выветривания габбрового массива и в локальных случаях -\n" +
                "        четвертичные озерно-болотные отложения.\n" +
                "        Современное зеркало подземных вод (первая половина марта 2020 года) находится в зависимости от гипсометрического\n" +
                "        положения выработок на глубине 1,3 - 2,3 м (5,0 - 5,1 м в скважинах №№ 30 и 31) в пределах абсолютных отметок\n" +
                "        267,66 - 268,63 м.\n" +
                "        Питание единого водоносного горизонта осуществляется за счет инфильтрации атмосферных осадков. Основной объем\n" +
                "        питания происходит в осенне-весенний период. Разгрузка происходит в местный базис дренирования - р. Патрушиху.\n" +
                "        Скорость техногенного подъема уровней на застроенной территории в г. Екатеринбурге составляет 0,04 м/год.\n" +
                "        Величина подъема уровня подземных вод с учетом сезонного колебания и техногенного подтопления за расчетный\n" +
                "        период 15 лет составит 1,6 м, т.е. расчетный уровень будет располагаться на отметках 269,26 - 270,23 м и может\n" +
                "        достигнуть отметок земной поверхности.\n" +
                "        По химическому составу подземные воды на площадке гидрокарбонатные кальциево-магниевые. Подземные воды\n" +
                "        слабоагрессивные по содержанию агрессивной углекислоты для бетонов марки W4 и неагрессивные для бетонов марки W6\n" +
                "        - W12. По степени агрессивного воздействия жидких сульфатных сред, содержащих бикарбонаты, подземные воды\n" +
                "        неагрессивные к бетонам марки W4 - W8. По степени агрессивного воздействия жидких сульфатных сред подземные воды\n" +
                "        неагрессивные к бетонам марки W10 - W20. Степень агрессивного воздействия грунтов на металлические конструкции\n" +
                "        ниже уровня подземных вод слабая.\n" +
                "        Коэффициенты фильтрации (водопроницаемость) следующие:\n" +
                "        - насыпной грунт (ИГЭ 1) – 0,5 – 2,5 м/сут (водопроницаемый);\n" +
                "        - торф (ИГЭ 2) – 0,01 – 0,6 м/сут (слабоводопроницаемый и водопроницаемый);\n" +
                "        - глина озерно-болотная (ИГЭ 3) – 0,002 – 0,01 м/сут (водонепроницаемый и слабоводопроницаемый);\n" +
                "        - супесь элювиальная (ИГЭ 4) – 0,01 – 0,30 м/сут (слабоводопроницаемый);\n" +
                "        - полускальные грунты (ИГЭ 5) – 0,4 м/сут (водопроницаемый);\n" +
                "        - скальные грунты различной степени выветрелости и трещиноватости (ИГЭ 6, ИГЭ 7) – 0,9 – 3,0 м/сут\n" +
                "        (водопроницаемые).\n" +
                "        Территория застройки относится к району (I-Б) – подтопленная в техногенно-измененных условиях.\n" +
                "\n" +
                "        Инженерно-экологические условия\n" +
                "        Площадка проектируемого строительства расположена в Верх-Исетском районе г. Екатеринбурга, в квартале улиц\n" +
                "        Краснолесья - Рябинина - Очеретина.\n" +
                "        Естественный рельеф участка работ сильно изменен при строительном освоении района, вся изучаемая территория\n" +
                "        отсыпана насыпными грунтами.\n" +
                "        Площадка проектируемого строительства находится на землях населенных пунктов, в условиях городской застройки.\n" +
                "        В настоящее время большая часть участка работ поросла ивняком, высотой 3,0 - 4,0 м. Иногда встречаются\n" +
                "        заболоченные участки, поросшие болотной растительностью (камышом). Такие места были зафиксированы в восточной\n" +
                "        части участка и в центральной. Визуальных признаков загрязнения (свалок бытового мусора, розливов\n" +
                "        нефтепродуктов) не обнаружено.\n" +
                "        В соответствии с картой градостроительного зонирования в составе «Правил землепользования и застройки городского\n" +
                "        округа - МО «город Екатеринбург», утвержденных Решением Екатеринбургской думой от 19.06.2018 №22/83 (в ред. от\n" +
                "        12.02.2019№ 23/10), участок изысканий расположен в зоне многоэтажной жилой застройки (ЖК-5). Зона многоэтажной\n" +
                "        жилой застройки Ж-5 выделена для формирования жилых районов, на территориях которых размещаются многоквартирные\n" +
                "        дома с площадками для отдыха, игр, спортивными площадками, объекты социальной, транспортной инфраструктуры, а\n" +
                "        также объекты обслуживания жилой застройки с ограниченным спектром услуг, коммунальные предприятия. Основные\n" +
                "        виды разрешенного использования: многоэтажная жилая застройка (высотой до 100 м), многоэтажная жилая застройка.\n" +
                "        Размещение проектируемого объекта соответствует одному из основных видов разрешенного использования\n" +
                "        недвижимости, указанной зоны.\n" +
                "        Описание климатических условий в районе предполагаемого строительства выполнено на основании СП 131.13330.2012\n" +
                "        «Строительная климатология. Актуализированная версия СНиП 23-01-99*» для г. Екатеринбурга.\n" +
                "        Климат района резко-континентальный и характеризуется следующими основными данными:\n" +
                "        - средняя годовая температура наружного воздуха - плюс 2,7 °С;\n" +
                "        - самый холодный месяц - январь, самый теплый - июль;\n" +
                "        - абсолютная минимальная температура воздуха - минус 47 °С;\n" +
                "        - абсолютная максимальная температура воздуха - плюс 38 °С;\n" +
                "        - период со средней суточной температурой воздуха менее 0 °С - 159 суток;\n" +
                "        - годовая сумма осадков в среднем составляет 517 мм; количество зимних осадков (ноябрь-март) - 121 мм, летних\n" +
                "        (апрель-октябрь) - 396 мм;\n" +
                "        - по степени увлажнённости район относится к зоне достаточного увлажнения, воздух наиболее сухой в июле - 65 %;\n" +
                "        наиболее влажен в январе - 76 %;\n" +
                "        - преобладающее направление ветра в году - западное, юго-западное, среднемесячные значения скорости ветра от 2,4\n" +
                "        до 3,1 м/с;\n" +
                "        - район работ относится к строительно-климатическому подрайону 1В.\n" +
                "        Площадка работ расположена на левобережном склоне заболоченной долины р. Патрушиха, являющейся правым притоком\n" +
                "        р. Исеть и протекающей в 1,2 км юго-западнее участка застройки. Река Патрушиха вытекает из болота Медного,\n" +
                "        расположенного вблизи оз. Чусовского, протекает с запада на восток по искусственному каналу шириной 3,0 - 8,0 м\n" +
                "        и глубиной в среднем 0,5 - 0,7 м со слабым течением, впадая в Нижне-Исетский пруд. Общая длина реки составляет\n" +
                "        26,0 км, площадь водосбора - 283,0 км2. Это неширокая и неглубокая речка с более высоким правым берегом.\n" +
                "        Согласно положениям ст. 65 Водного кодекса РФ от 03.06.2006 № 74-ФЗ величина водоохранной зоны р. Патрушиха -\n" +
                "        100 м, прибрежной защитной полосы – 50 м. Обследуемый участок располагается вне границ водоохранной зоны и\n" +
                "        прибрежной защитной полосы указанного водотока.\n" +
                "        Современное зеркало подземных вод (первая половина марта) находится в зависимости от гипсометрического положения\n" +
                "        выработок на глубине 1,3 - 2,3 м (5,0 - 5,1 м в скважинах №№ 30 и 31) в пределах абсолютных отметок 267,66 -\n" +
                "        268,63 м.\n" +
                "        Согласно критериям п. 2.2.1.2 СанПиН 2.1.4.1110-02 «Зоны санитарной охраны источников водоснабжения и\n" +
                "        водопроводов питьевого назначения», подземные воды изучаемой территории относятся к недостаточно защищенным от\n" +
                "        проникновения загрязнения с поверхности.\n" +
                "        Данные об отсутствии источников питьевого водоснабжения и их зон санитарной охраны подтверждаются данными\n" +
                "        публичной кадастровой карты (pkk.rosreestr.ru) и письмом Министерства природных ресурсов и экологии Свердловской\n" +
                "        области № 12-17-02/б/д. Гидрогеологическое заключение ООО ГП «СвТЦОП» №9449/17-г от 28.02.2017, заключение ООО\n" +
                "        «УРАЛНЕДРА» №02-02/2757 от 02.11.2016.\n" +
                "        Участок изысканий находится в Березовском почвенном районе (согласно почвенной Карте Свердловской области 1986\n" +
                "        года масштаба 1:500 000), который входит в Екатеринбургский округ Зауральской южно-таежной почвенной провинции.\n" +
                "        В широтно-зональном плане данный район относится к южной тайге. Леса вторичные, производные, чаще всего\n" +
                "        сосновые, березовые и осиновые. Коренные лиственнично-сосновые зелено-мошные или травяно-кустарничковые леса\n" +
                "        сохранились только в зеленых зонах города.\n" +
                "        Почвообразование протекает на элювиально-делювиальных и делювиальных отложениях.\n" +
                "        Исследуемый участок расположен в условиях городской застройки, вне земель лесного фонда, особо охраняемых\n" +
                "        природных территорий.\n" +
                "        Травянистый покров густой, представлен синантропными видами, такими как мать-и-мачеха, репей, одуванчик\n" +
                "        лекарственный, клевер ползучий, тысячелистник обыкновенный, донник белый, подорожник большой, в западной части\n" +
                "        участка на заболоченном участке развита болотная растительность, представленная камышом, лабазником вязолистным,\n" +
                "        золотарником обыкновенным. Ценные и редкие виды растений, занесенные в Красную книгу не встречены.\n" +
                "        При маршрутном обследовании участка к руководству были приняты сведения Красной книги Свердловской области,\n" +
                "        находящейся в свободном доступе в сети Интернет (http://mprso.midural.ru/) и приложения 3 Красной книги\n" +
                "        Свердловской области «Перечень объектов животного и растительного мира, внесенных в Красную книгу Российской\n" +
                "        Федерации, встречающихся на территории Свердловской области».\n" +
                "        Ввиду того, что территория изысканий испытывает антропогенную нагрузку, принимая во внимание высокий фактор\n" +
                "        беспокойства и отсутствие пригодного местообитания, появление на участке редких видов животных и птиц исключено.\n" +
                "        Участок проектируемого строительства размещается за пределами особо охраняемых природных территорий (ООПТ).\n" +
                "        Сведения о социально-экономических условиях проживания приводятся по данным административных органов,\n" +
                "        находящимся в свободном доступе (информационный портал г. Екатеринбурга http://ekburg.ru).\n" +
                "        Заключение специально уполномоченных органов об отсутствии/ наличии полезных ископаемых в недрах под участком\n" +
                "        производства работ в черте города Екатеринбурга не требуется - ст. 25 закона от 21.02.1992 № 2396-1 «О недрах».\n" +
                "        Согласно информационному письму Управления государственной охраны объектов культурного наследия Свердловской\n" +
                "        области указанный участок расположен в Академическом районе г. Екатеринбурга в границах улиц Краснолесья -\n" +
                "        Рябинина - Очеретина на участке 4.15.1, который в свою очередь находится вне зон охраны и защитных зон объектов\n" +
                "        культурного наследия, включенных в единый государственный реестр объектов культурного наследия (памятников\n" +
                "        истории и культуры) народов Российской Федерации.\n" +
                "        В соответствии с ГН 2.1.6.3492-17 концентрации загрязняющих веществ в атмосфере: диоксид азота, оксид углерода -\n" +
                "        не превышают допустимые гигиенические нормативы для атмосферы воздуха населенных мест.\n" +
                "        Проба воды не соответствует СанПиН 2.1.4.1175-02 «Гигиенические требования к качеству воды нецентрализованного\n" +
                "        водоснабжения» по показателям марганец (30 ПДК), окисляемость перманганатная (1,15 ПДК), магний (1,29 ПДК).\n" +
                "        Анализ результатов лабораторных исследований показывает, что в соответствии с критериями СанПиН 2.1.7.1287-03,\n" +
                "        отобранные пробы грунта в основном относятся к категории загрязнения «чрезвычайно опасная», что объясняется\n" +
                "        сверхнормативным содержанием мышьяка в почве (>Кmах). Превышений по органическим показателям (нефтепродукты,\n" +
                "        бенз(а)пирен) не выявлено.\n" +
                "        В соответствии с требованиями СанПиН 2.1.7.1287-03 грунты с категорией загрязнения «чрезвычайно опасная»\n" +
                "        подлежат вывозу и утилизации на специализированных полигонах, грунты с категорией загрязнения «опасная» могут\n" +
                "        использоваться под отсыпки выемок и котлованов с перекрытием слоем чистого грунта не менее 0,5 м.\n" +
                "        По результатам лабораторных исследований пробы почв по санитарно- эпидемиологическим показателям соответствуют\n" +
                "        требованиям СанПиН 2.1.7.1287-03 «Санитарно-эпидемиологические требования к качеству почв» и относится к\n" +
                "        категории «чистая».\n" +
                "        Мощность дозы гамма-излучения не превышает допустимых значений для участков строительства зданий и сооружений\n" +
                "        жилищного и общественного назначения - 0,3 мкЗ/ч.\n" +
                "        Локальные радиационные аномалии на обследованной территории отсутствуют.\n" +
                "        Плотность потока радона с поверхности почвы на данной территории (среднее значение 40,0 мБк / (м2*c)) находится\n" +
                "        в пределах, установленных ОСПОРБ-99/2010 и СанПиН 2.6.1.2800-10 для участков, отводимых под строительство зданий\n" +
                "        и сооружений жилищного и общественного назначения - 80 мБк /( м2*с).\n" +
                "        В результате выполненных измерений установлено непревышение эквивалентного и максимального уровней звука. В\n" +
                "        связи с этим, можно сделать вывод о том, что уровень непостоянного шума соответствует требованиям СН\n" +
                "        2.2.4/2.1.8.562-96 для территорий, непосредственно прилегающим к жилым домам.\n" +
                "        При шпуровой съемке территории поверхностных биогазовых аномалий не выявлено.\n" +
                "\n" +
                "        Техногенные условия\n" +
                "        Площадка проектируемого строительства расположена в Верх-Исетском районе г. Екатеринбурга, в квартале улиц\n" +
                "        Краснолесья - Рябинина - Очеретина.\n" +
                "        Естественный рельеф участка работ сильно изменен при строительном освоении района, вся изучаемая территория\n" +
                "        отсыпана насыпными грунтами, уклон поверхности не прослеживается.\n" +
                "        Площадка проектируемого строительства находится на землях населенных пунктов, в условиях городской застройки.\n" +
                "        Северо-западная граница участка проходит вдоль ул. Рябинина, за которой располагается ЖК «Рябиновый квартал»,\n" +
                "        северо-восточная - граничит с ул. Очеретина и малоэтажной жилой застройкой, юго-западная - проходит вдоль ул.\n" +
                "        Краснолесья.\n" +
                "        Площадка работ свободна от капитальных строений, коммуникаций. В 14,0 - 20,0 м от северо-западной границы\n" +
                "        контура подземной парковки, вдоль улицы Рябинина, проложены водопровод, газопровод и линии электропередач. В 6,0\n" +
                "        - 10,0 м от юго-западного контура подземного паркинга протянуты линии электропередач столбов освещения и\n" +
                "        водопроводы."));
        return node;
    }

    private static Node getDeclarant(org.w3c.dom.Document doc) {
        Element node = doc.createElement("Declarant");
        node.appendChild(doc.createElement("Organization")).appendChild(doc.createElement("OrgFullName")).appendChild(doc.createTextNode("ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ СПЕЦИАЛИЗИРОВАННЫЙ ЗАСТРОЙЩИК ЛИДЕР КОНСТРАКШН"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgOGRN")).appendChild(doc.createTextNode("1076671026728"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgINN")).appendChild(doc.createTextNode("6671236301"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgKPP")).appendChild(doc.createTextNode("665801001"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("66"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Г. ЕКАТЕРИНБУРГ"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("УЛ. ВИКУЛОВА"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Д. 59/К. 1"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("ОФИС 303"));
        return node;
    }

    private static Node getCadastralNumber(org.w3c.dom.Document doc) {
        Element node = doc.createElement("CadastralNumber");
        node.appendChild(doc.createTextNode("66:41:0313121:85"));
        return node;
    }

    private static Node getObject(org.w3c.dom.Document doc) {
        Element node = doc.createElement("Object");
        node.appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Жилая многоэтажная застройка квартала 4.15.1 в границах улиц Краснолесья – Рябинина – Очеретина в Академическом районе г. Екатеринбурга"));
        node.appendChild(doc.createElement("Type")).appendChild(doc.createTextNode("2"));
        node.appendChild(doc.createElement("Functions")).appendChild(doc.createTextNode("жилые объекты для постоянного проживания -- многоэтажный многоквартирный жилой дом (код 19.7.1.5 в соответствии с Пр. Минстроя от 10.07.2020 № 374/пр)"));
        node.appendChild(doc.createElement("Address")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Россия"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("66"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Город Екатеринбург"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Note")).appendChild(doc.createTextNode("Верх-Исетский район, в границах улиц Амундсена – Институтской – дублера Серафимы Дерябиной"));
        node.appendChild(doc.createElement("TEI")).appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("1 этап строительства. Жилой дом № 1. Жилой дом № 2. Площадь земельного участка по ГПЗУ"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Measure")).appendChild(doc.createTextNode("м2"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Value")).appendChild(doc.createTextNode("14087,0"));
        return node;
    }

    private static Node getPreviousSimpleConclusions(org.w3c.dom.Document doc) {
        Element PreviousSimpleConclusions = doc.createElement("PreviousSimpleConclusions");
        PreviousSimpleConclusions.appendChild(getPreviousSimpleConclusion(
                doc,
                "PreviousSimpleConclusion",
                "Date",
                "2022-04-11",
                "Number",
                "0028-2022",
                "Result",
                "1"
        ));
        return PreviousSimpleConclusions;
    }

    private static Node getPreviousSimpleConclusion(
            org.w3c.dom.Document doc,
            String PreviousSimpleConclusion,
            String Date,
            String context_date,
            String Number,
            String context_number,
            String Result,
            String context_result
    ) {
        Element node = doc.createElement(PreviousSimpleConclusion);
        node.appendChild(doc.createElement(Date)).appendChild(doc.createTextNode(context_date));
        node.appendChild(doc.createElement(Number)).appendChild(doc.createTextNode(context_number));
        node.appendChild(doc.createElement(Result)).appendChild(doc.createTextNode(context_result));
        return node;
    }

    private static Node getPreviousConclusions(org.w3c.dom.Document doc) {
        Element PreviousConclusions = doc.createElement("PreviousConclusions");
        PreviousConclusions.appendChild(getOrgElementsValueFunc_PreviousConsultation(
                doc,
                PreviousConclusions,
                "PreviousConclusion",
                "Date",
                "2020-10-02"
        ));
        return PreviousConclusions;
    }

    public static Node getOrgElementsValueFunc_PreviousConsultation(
            org.w3c.dom.Document doc,
            Element element,
            String PreviousConclusion,
            String Date,
            String TextDate
    ) {
        Element node = doc.createElement(PreviousConclusion);
        node.appendChild(doc.createElement(Date)).appendChild(doc.createTextNode(TextDate));
        node.appendChild(doc.createElement("Number")).appendChild(doc.createElement("EGRZ")).appendChild(doc.createTextNode("66-2-1-3-049345-2020"));
        node.appendChild(doc.createElement("ExaminationObjectType")).appendChild(doc.createTextNode("3"));
        node.appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Жилая многоэтажная застройка квартала 4.15.1 в границах улиц Краснолесья - Рябинина - Очеретина в Академическом районе г. Екатеринбурга"));
        node.appendChild(doc.createElement("Result")).appendChild(doc.createTextNode("1"));
        return node;
    }

    private static Node getExpertOrganization(org.w3c.dom.Document doc) {
        Element ExpertOrganization = doc.createElement("ExpertOrganization");
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgFullName", "ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"УРАЛЬСКОЕ УПРАВЛЕНИЕ СТРОИТЕЛЬНОЙ ЭКСПЕРТИЗЫ\""));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgOGRN", "1156658096275"));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgINN", "6678066419"));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgKPP", "667801001"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Region", "66"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "City", "ГОРОД ЕКАТЕРИНБУРГ"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Street", "УЛИЦА НИКОЛАЯ НИКОНОВА"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Building", "ДОМ 18"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Room", "ПОМЕЩЕИЕ 73"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Room", "ПОМЕЩЕИЕ 73"));
        return ExpertOrganization;
    }

    private static Node getApprover(org.w3c.dom.Document doc) {
        Element Approver = doc.createElement("Approver");
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "FamilyName", "Арзамасцева"));
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "FirstName", "Надежда"));
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "SecondName", "Петровна"));
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "Position", "Управляющий – Индивидуальный предприниматель"));
        return Approver;
    }


    private static Node getExaminationObject(org.w3c.dom.Document doc) {
        Element ExaminationObject = doc.createElement("ExaminationObject");
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationForm", "2"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationResult", "1"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationObjectType", "2"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationType", "2"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ConstructionType", "1"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationStage", "3"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "Name", "Жилая многоэтажная застройка квартала 4.15.1 в границах улиц Краснолесья – Рябинина – Очеретина в\n" +
                "            Академическом районе г. Екатеринбурга"));

        return ExaminationObject;
    }

    private static Node getDocuments(org.w3c.dom.Document doc) {
        Element Documents = doc.createElement("Documents");
        Documents.appendChild(getOrgElementsValueFunc_7(
                doc, Documents,
                "Document",
                "DocType",
                "DocName",
                "DocIssueAuthor",
                "File",
                "DocDate",
                "DocNumber",
                "01.01",
                "Заявление на заключение договора на экспертное сопровождение в отношении проектной документации\n" +
                        "                объекта капитального строительства",
                "43/261",
                "2022-04-01",
                "ООО «Специализированный застройщик «Лидер констракшн»",
                "FileName",
                "Заявление о заключении договора.pdf",
                "pdf",
                "eebbdb54",
                "SignFile",
                "FileName",
                "Заявление о заключении договора.pdf.sig",
                "FileFormat",
                "sig",
                "FileChecksum",
                "3718b4c5"
        ));
        return Documents;
    }

    private static Node getOrgElementsValueTXT(
            org.w3c.dom.Document doc,
            Element element,
            String name,
            String value
    ) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    private static Node getOrgElementsValueFunc(
            org.w3c.dom.Document doc,
            Element element,
            String name,
            String value,
            String content
    ) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createElement(value)).appendChild(doc.createTextNode(content));
        return node;
    }

    private static Node getOrgElementsValueFunc_7(
            org.w3c.dom.Document doc,
            Element element,
            String name,
            String DocType,
            String DocName,
            String DocIssueAuthor,
            String File,
            String DocDate,
            String DocNumber,
            String content_1,
            String content_2,
            String content_3,
            String content_4,
            String content_5,
            String el_1,
            String content_6,
            String content_7,
            String content_8,
            String SignFile,
            String FileName,
            String content_9,
            String FileFormat,
            String content_10,
            String FileChecksum,
            String content_11
    ) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createElement(DocType)).appendChild(doc.createTextNode(content_1));
        node.appendChild(doc.createElement(DocName)).appendChild(doc.createTextNode(content_2));
        node.appendChild(doc.createElement(DocNumber)).appendChild(doc.createTextNode(content_3));
        node.appendChild(doc.createElement(DocDate)).appendChild(doc.createTextNode(content_4));
        node.appendChild(doc.createElement(DocIssueAuthor)).appendChild(doc.createTextNode(content_5));
        node.appendChild(doc.createElement(File)).appendChild(doc.createElement(el_1)).appendChild(doc.createTextNode(content_6));
        node.getElementsByTagName("File").item(0).appendChild(doc.createElement(FileFormat)).appendChild(doc.createTextNode(content_7));
        node.getElementsByTagName("File").item(0).appendChild(doc.createElement(FileChecksum)).appendChild(doc.createTextNode(content_8));
        node.getElementsByTagName("File").item(0).appendChild(doc.createElement(SignFile)).appendChild(doc.createElement(FileName)).appendChild(doc.createTextNode(content_9));
        node.getElementsByTagName("SignFile").item(0).appendChild(doc.createElement(FileFormat)).appendChild(doc.createTextNode(content_10));
        node.getElementsByTagName("SignFile").item(0).appendChild(doc.createElement(FileChecksum)).appendChild(doc.createTextNode(content_11));
        return node;
    }

    // converter pdf
    @GetMapping("/read/PDF/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readPDFFile(
            @PathVariable("FileName") Integer IdFile,
            @PathVariable("NameCompany") String NameCompany
    ) {
        File file = new File(System.getProperty("user.home") + "/Downloads/uploads/" + NameCompany + "/pdf");
        if (!file.exists()) file.mkdir();
        String DEST = String.valueOf(get(System.getProperty("user.home") + "/Downloads/uploads" + "/" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        String DEST_PDF = String.valueOf(get(System.getProperty("user.home") + "/Downloads/uploads" + "/" + NameCompany + "/pdf/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        try (com.aspose.pdf.Document document = new com.aspose.pdf.Document()) {
            Page page = document.getPages().add();
            try (Parser parser = new Parser(DEST)) {
                if (!parser.getFeatures().isText()) {
                    System.out.println("The document doesn't support text extraction.");
                }

                IDocumentInfo documentInfo = parser.getDocumentInfo();

                if (documentInfo.getPageCount() == 0) {
                    System.out.println("The document has zero pages.");
                }

                ArrayList<List> arrayList = new ArrayList<>();

                for (int p = 0; p < documentInfo.getPageCount(); p++) {
                    com.spire.doc.Document document1 = new com.spire.doc.Document();
                    document1.loadFromFile(DEST);
                    String content = document1.getText();
                    page.getParagraphs().add(new TextFragment(content));
                    document.save(DEST_PDF + ".pdf");
                    arrayList.add(Collections.singletonList("Page number: " + (p + 1) + "/" + documentInfo.getPageCount()));
                    arrayList.add(Collections.singletonList(content));
                    System.out.println(arrayList);
                }

                return ResponseEntity.ok().body(arrayList);
            }
        }
    }

    // Define a method to download files
    @GetMapping("/download/{NameCompany}/{filename}")
    @SneakyThrows
    public ResponseEntity<Resource> downloadFiles(
            @PathVariable("filename") String filename,
            @PathVariable("NameCompany") String NameCompany
    ) {
        Path filePath = get(DIRECTORY + NameCompany).toAbsolutePath().normalize().resolve(filename);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
    }

    @DeleteMapping("/delete/file/{NameCompany}/{NameFile}")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> deleteFile(
            @PathVariable("NameCompany") String NameCompany,
            @PathVariable("NameFile") Integer IdFile
    ) {
        Files.delete(Paths.get(System.getProperty("user.home") + "/Downloads/uploads" + "/" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        jdbcTemplate.update("delete from files where id_image=?", IdFile);
        return ResponseEntity.ok().body("Success delete file");
    }
}