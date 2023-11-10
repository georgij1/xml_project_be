package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetClimateConditionsNote {
    public static Node getClimateConditionsNote(org.w3c.dom.Document doc) {
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
}