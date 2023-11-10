package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetExpertProjectDocuments {
    public static Node getExpertProjectDocuments(org.w3c.dom.Document doc) {
        Element node = doc.createElement("ExpertProjectDocuments");
        node.setAttribute("ExpertType", "5.");
        node.appendChild(doc.createElement("ProjectDocumentsReview")).appendChild(doc.createTextNode("""
                В административном отношении земельный участок расположен по адресу: Свердловская
                            область, муниципальное образование «город Екатеринбург», район Верх-Исетский, квартал 4.15.1 в границах улиц
                            Краснолесья - Рябинина - Очеретина.
                            Участок граничит:
                            - с северо-западной стороны - с ул. Рябинина;
                            - с юго-западной стороны - с ул. Краснолесья;
                            - с юго-восточной - с ул. Очеретина.
                            На территории, предназначенной для новой застройки, отсутствуют капитальные постройки. Абсолютные отметки
                            поверхности изменяются от 273,80 до 272,80 м.
                            Район и подрайон строительства по климатическому районированию относится к 1В.
                            В соответствии с ГПЗУ № RU 66302000-15495 от 26.12.2019 земельный участок с кадастровым номером
                            66:41:0313121:85 площадью 14087 м2, на котором планируется осуществить новое строительство, расположен в
                            территориальной зоне Ж-5 - «Зона многоэтажной жилой застройки».
                            Проектной документацией предусмотрено строительство жилой застройки, являющейся единым жилым комплексом с
                            помещениями общественного назначения и встроенно-пристроенной автостоянкой.
                            Строительство объекта предусмотрено в 2 этапа строительства:
                            1 этап строительства:
                            - № 1 (по ПЗУ) – жилое 3-секционное здание переменной этажности (13, 17, 21-этажные секции) с жилыми
                            помещениями, со встроенными помещениями коммерческого назначения, с одноуровневым подземным паркингом;
                            - № 2 (по ПЗУ) – 25-ти этажное здание с жилыми помещениями, со встроенными помещениями коммерческого
                            назначения, с одноуровневым подземным паркингом. (в АР-жилой односекционный 25-этажный дом, с крышной
                            газовой котельной);
                            - № 4.1 (по ПЗУ) – встроенно-пристроенная подземная автостоянка с рампой въезда-выезда;
                            - № 5 (по ПЗУ) – трансформаторная подстанция;
                            2 этап строительства:
                            - № 3 (по ПЗУ) – 25-ти этажное здание с жилыми помещениями, с одноуровневым подземным паркингом. (в АР -
                            односекционный 25-этажный дом);
                            - № 4.2 (по ПЗУ) – встроенно-пристроенная подземная автостоянка.
                            Размещение проектируемого здания выполнено в соответствии с «Чертежом градостроительного плана земельного
                            участка и линий градостроительного регулирования» по ГПЗУ.
                            Площадь участка в границе отвода согласно ГПЗУ - 14087 м2, в т.ч.:
                            - площадь благоустройства 1 этапа строительства - 8606 м2;
                            - площадь благоустройства 2 этапа строительства - 4647 м2;
                            - площадь перспективного развития - 834 м2.
                            Общая площадь квартир:
                            1 этап строительства: Жилой дом №1 (секция 1, 2, 3) - 13 744,80 м2, Жилой дом №2 - 12 738,0 м2;
                            2 этап строительства: Жилой дом №3 - 12 955,88 м2.
                            Жилищная обеспеченность принята:
                            - для всех очередей строительства - 35 м2 (в соответствии с Заданием на проектирование).
                            Количество жителей 1126 чел., в т.ч.:
                            1 этап строительства: Жилой дом №1 (секция 1, 2, 3) - 396 чел., Жилой дом №2 - 360 чел;
                            2 этап строительства: Жилой дом №3 - 370 чел.
                            Общая площадь коммерческих помещений в проектируемых домах 867,1 м2, в т.ч.:
                            1 этап строительства: Жилой дом №1 (секция 1, 2, 3) - 520,9 м2, Жилой дом №2 - 346,2 м2.
                            В состав проектируемого комплекса входят:
                            - офисные помещения в Жилом доме №1 на 46 человек;
                            - офисные помещения в Жилом доме №2 на 26 человек;
                            - в паркинге 1 этап строительства - 138 м/м;
                            - в паркинге 2 этап строительства - 81 м/м.
                            Заезд на внутридворовую территорию проектируемого жилого квартала предлагается осуществлять с ул.
                            Краснолесья между жилым домом №2 и секцией 3 жилого дома №1. Заезд в подземный паркинг расположен с ул.
                            Рябинина. Проектируемые въезды запроектированы под прямым углом, ширина составляет 6,0м.
                            Проект благоустройства территории предусматривает:
                            - устройство внутриплощадочных проездов из укрепленного тротуарного камня «Бехатон»;
                            - устройство пешеходного тротуара из тротуарного камня «Бехатон»;
                            - устройство резинового покрытия на детских и спортивных площадках
                            - устройство газонов и цветников;
                            - устройство заглубленной отмостки из мембраны PlanterGeo (или аналог) шириной не менее 600 мм с верхним
                            покрытием по проекту благоустройства;
                            - посадка деревьев и кустарников.
                            Придомовая территория запроектирована с учетом обязательного размещения элементов благоустройства (площадок:
                            ПД - игровых площадок для детей дошкольного и младшего школьного возраста, ПО - для отдыха взрослого
                            населения, ПС - для занятий физкультурой) и расстояний от них до нормируемых объектов в соответствии с
                            СП 42.13330.2016, СП 4.13130.2013, СП 59.13330.2012 и СанПиН 2.2.1/2.1.1.1200-03. Нормируемые площади
                            спортивных площадок сокращены на 50% на основании п. 7.5 СП 42.13330.2016 при наличии единого спорт-ядра
                            микрорайона-стадиона, находящегося в радиусе доступности не более 500 м.
                            Расчет автостоянок для жителей выполнен на основании «Нормативов градостроительного проектирования
                            городского округа – муниципального образования «город Екатеринбург» от 22.12.2015 г. п. 43п.
                            По расчету для хранения транспорта проектируемого жилого дома требуется
                            500 м/место, в том числе:
                            для 1 этапа строительства:
                            66 м/мест (20%) - для временного хранения автомобилей жителей;
                            264 м/мест (80%) - для постоянного хранения автомобилей жителей;
                            8 м/м - для временного хранения автомобилей для нежилых помещений;
                            для 2 этапа строительства:
                            32 м/места (20%) - для временного хранения автомобилей жителей;
                            130 м/мест (80%) - для постоянного хранения автомобилей жителей.
                            Проектом предусмотрено устройство автостоянок общей обеспеченностью
                            277 (недостаток-500-277=223 м/места) м/мест в т.ч.:
                            - для постоянного хранения автомобилей жителей- подземном паркинге 219 м/ мест (недостаток 264+130-219=175
                            м/мест);
                            - для временного хранения автомобилей жителей - 50 м/мест на открытых парковках (поз. А1, А4, А5, А10А11,
                            А12, А14 по ПЗУ) по ул. Краснолесья на участке с кадастровым номером 66:41:0313121:9805 (разрешенное
                            использование – для объектов общественно-делового значения) и в соответствии с Проектом планировки и
                            проектом межевания и территории первой очереди застройки планировочного района «Академический» в Ленинском и
                            Верх-Исетском районах города Екатеринбурга (ш. 02-16-ПП) и на участке с кадастровым номером
                            66:41:0313121:2037 для использования после строительства и ввода в эксплуатацию дорожной сети по ул.
                            Рябинина, согласно ППТ ш. 02-16-ПП (заключении экспертизы № 66-2-3-049345-2020 от 02.10.2020);
                            - для временного хранения автомобилей для нежилых помещений 8 м/мест на парковке А5 (6 м/мест) и на парковке
                            А4 (2 м/места).
                            Недостающие по расчету 223 м/места (44,7%) предполагается разместить на участке с кадастровым №
                            66:41:0313121:0043 по ул. Краснолесье согласно договору аренды земельного участка № 38/А от 27.08.2007.
                            Расчет накопления твердых коммунальных отходов (ТКО) выполнен на основании данных НГПСО 1.2009-66 «Нормативы
                            градостроительного проектирования Свердловской области», табл. 26 и 27. Сбор и накопление твердых
                            коммунальных отходов для жилого дома осуществляется во встроенных мусорокамерах с отсеками для
                            крупногабаритных отходов в каждом доме с установкой 3 контейнеров для 1 этапа строительства и 2 контейнеров
                            для 2 этапа строительства. Объем 1 контейнера 1,1 м3. Вывоз мусора осуществляется спецтехникой по договору с
                            ЕМУП «Специализированная автобаза».
                            Проектом предусматривается сплошная вертикальная планировка, внутридворовое пространство приподнято
                            относительно окружающей территории для размещения паркинга под дворовой территорией. Организация рельефа
                            обеспечивает отвод поверхностных вод, выполняется вертикальной планировкой по проектируемым проездам, к
                            существующему и проектируемому дождеприёмным колодцам по
                            ул. Краснолесья.
                            Проектные уклоны спланированной территории колеблются от 4 до 30‰.
                            Поперечные уклоны тротуаров не превышают 20‰, продольные - 30‰.
                            Водоотвод ливневых стоков с крыш зданий по внутреннему водостоку, по лоткам до проезжей части.
                            За относительную отметку 0,000 принята отметка пола 1 этажа жилого дома соответствующая абсолютной отметке
                            273,65 м.
                            Инженерные сети запроектированы согласно нормативам и техническим условиям.

                            Обеспечение доступа инвалидов
                            План благоустройства выполнен в соответствии с требованиями СП 59-13330.2012 «Доступность зданий и
                            сооружений для маломобильных групп населения» (актуализированная редакция СП 35-103-2001).
                            Уклоны пешеходных тротуаров – продольный не более 50 ‰, поперечный – не более 20‰.
                            Ширина тротуаров на внутридворовой территории – не менее 2,00 м, на прилегающих тротуарах улиц - не менее
                            3,00 м.
                            Количество парковочных мест для инвалидов определено в соответствии с рекомендациями СП 59-13330.2012, п.
                            4.2.1. Габаритные размеры м/места для инвалидов выполнены рекомендации местной общественной организации
                            «Екатеринбургская городская общественная организация инвалидов-колясочников «Свободное движение» и
                            составляет 3,60 м х 6,00 м. Все места оборудуются специальной разметкой, а также соответствующими дорожными
                            знаками.
                            Количество парковочных мест для ММГН принято 10% от количества временных гостевых парковок. Временные
                            парковки (в т.ч для нежилых помещений)- 107 м/мест.
                            Общее количество м/мест для ММГН, размещаемых на открытых автостоянках (поз. А5, А1, А4) – 12 м/мест.

                            Зоны с особыми условиями использования территории (ЗОУИТ)
                            Проектными решениями предусмотрено строительство комплекса Многоэтажных домов с встроенными нежилыми
                            помещениями не производственного характера и подземной автостоянкой. Организация санитарно-защитной зоны от
                            объекта не требуется.
                            В непосредственной близости от границ проектирования расположены объекты, в отношении которых
                            устанавливаются санитарно-защитные зоны и санитарные разрывы:
                            - с западной стороны по ул. Краснолесья расположена открытая автопарковка, от которой выдержан санитарный
                            разрыв 50м до стен проектируемых зданий;
                            - с западной стороны на расстоянии 1000м расположен ТЦ «Лента». СанПиН2.2.1/2.1.1.1200-03 размер СЗЗ
                            составляет 50 м;
                            - с южной стороны на расстоянии 500м расположен ТЦ «Академический». СанПиН2.2.1/2.1.1.1200-03 размер СЗЗ
                            составляет 50 м.
                            Площадка проектируемого строительства жилого дома размещается за пределами санитарно-защитных зон
                            предприятий, сооружений и иных объектов.
                            В соответствии с картой градостроительного зонирования в составе «Правил землепользования и застройки
                            городского округа-МО «город Екатеринбург», утвержденных Решением Екатеринбургской думой от 19.06.18 г.
                            №22/83. (в ред. от 12 февраля 2019 года №23/10), участок изысканий расположен в зоне многоэтажной жилой
                            застройки (ЖК-5). Зона многоэтажной жилой застройки Ж-5 выделена для формирования жилых районов, на
                            территориях которых размещаются многоквартирные дома с площадками для отдыха, игр, спортивными площадками,
                            объекты социальной, транспортной инфраструктуры, а также объекты обслуживания жилой застройки с ограниченным
                            спектром услуг, коммунальные предприятия. Основные виды разрешенного использования: многоэтажная жилая
                            застройка (высотой до 100 метров), многоэтажная жилая застройка.
                            Площадка для размещения объекта с его инфраструктурой не располагается на территориях, отнесенных к особо
                            охраняемым природным территориям. Отсутствие в границах участка особо охраняемых природных территорий
                            федерального значения подтверждается сведениями из официального сайта http://oopt.kosmosnimki.ru.
                            Заповедных зон и заказников вблизи контуров размещения площадки под настоящий объект, зарегистрированных
                            Постановлением Правительства Свердловской области, нет.
                            Объекты, расположенные на земельном участке проектирования и в непосредственной близости от него, имеют
                            охранные зоны и зоны с особыми условиями использования территории (ЗОУИТ).
                            Здания объекта запроектировано с соблюдением санитарных разрывов:
                            - Проезды автотранспорта, ведущие на автостоянки, - 7,0 м (СанПиН2.2.1/2.1.1.1200-03 «Санитарно-защитные
                            зоны и санитарная классификация предприятий, сооружений и иных объектов», раздел 7.1.12);
                            - Запроектирован въезд в подземную автостоянку.
                            В соответствии с примечаниями к табл. 7.1.1 СанПиН2.2.1/2.1.1.1200-03 для подземных, полуподземных и
                            обвалованных гаражей-стоянок регламентируется расстояние от въезда-выезда и от вентиляционных шахт до жилых
                            домов, площадок отдыха и др., которое должно составлять не менее 15 метров. Решениям проекта, вентиляционные
                            шахты проектируемого паркинга предусматривается разместить на кровле жилых домов;
                            - парковки легкового транспорта до 10 м/мест – СЗЗ 10м.
                            Здание 2 этапа строительства объекта запроектировано с соблюдением противопожарных разрывов:
                            Открытые площадки для временного хранения автомобилей – не менее 10,0 м до жилых и общественных зданий.
                            Охранные зоны инженерных сетей:
                            1. Теплотрасса – 3,0 м (Приказ Мин. архитектуры, строительства и жилищно-коммунального хозяйства РФ №197 от
                            17 августа 1992 года «О типовых правилах охраны коммунальных тепловых сетей, п. 4);
                            2. Водопровод – 5,0 м (СП 42.13330.2016 «Градостроительство. Планировка и застройка городских и сельских
                            поселений» (актуализированная редакция СНиП 2.07.01-89*)», раздел 12.35, таблица 12.5);
                            3. Бытовая канализация – 3,0 м (СП 42.13330.2016 «Градостроительство. Планировка и застройка городских и
                            сельских поселений» (актуализированная редакция
                            СНиП 2.07.01-89*)», раздел 12.35, таблица 12.5);
                            4. Ливневая канализация – 3,0 м (СП 42.13330.2016 «Градостроительство. Планировка и застройка городских и
                            сельских поселений» (актуализированная редакция
                            СНиП 2.07.01-89*)», раздел 12.35, таблица 12.5);
                            5. Подземная кабельная линия электропередач (кабель связи) КЛ 0,4 кВ – 1,0 м (Постановление Правительства РФ
                            от 24 февраля 2009 г. №160 в редакции 21.12.2018 г.). При прохождении кабельных линий напряжением до 1,0 кВ
                            в городах под тротуарами - на 0,6 м в сторону зданий и сооружений и на 1,0 м в сторону проезжей части улицы.
                            6. Подземная низковольтная кабельная линия электропередачи КЛ – 1,0 м (Постановление Правительства РФ от 24
                            февраля 2009 г.№160);
                            7. охранная зона ТП (Постановление Правительства РФ от 24 февраля 2009 г. №160);
                            - Согласно ГПЗУ RU 66302000-15495, часть участка выделена как территория общего пользования.
                            Выделен участок для размещения инженерных сетей.
                            Проектируемый объект не нарушает режим охранных зон. В пределах охранных зон подземных коммуникаций не
                            допускается производить действия, которые могут повлечь нарушения в нормальной работе сетей, их повреждение,
                            несчастные случаи или препятствующие ремонту: размещать автозаправочные станции, хранилища горюче-смазочных
                            материалов, складировать агрессивные химические материалы; загромождать подходы и подъезды к объектам и
                            сооружениям сетей, складировать тяжелые и громоздкие материалы, возводить временные строения и заборы.
                            Вывод: Проектируемый жилой комплекс учитывает размещение данных охранных зон, не нарушает режим пользования
                            территории в данных зонах и размещен в границах земельного участка без ограничений."""));
        return node;
    }
}