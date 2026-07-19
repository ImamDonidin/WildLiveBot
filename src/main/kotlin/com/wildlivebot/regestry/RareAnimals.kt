package com.wildlivebot.regestry

import com.wildlivebot.model.Animal
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.Fact
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.Region

object RareAnimals {
    val list = listOf(
        Animal(
            id = "bison",
            nameEn = "American Bison",
            nameRu = "Американский бизон",
            nameUk = "Американський бізон",
            aliasesEn = listOf("american bison", "bison", "buffalo"),
            aliasesRu = listOf("американский бизон", "бизон", "буффало"),
            aliasesUk = listOf("американський бізон", "бізон", "буффало"),
            rarity = Rarity.RARE,
            imagePath = "/images/bison.jpg",
            region = Region.GRASSLANDS,
            hints = mapOf(
                "зубр" to "game.hint.bison_not_wisent",
                "european bison" to "game.hint.bison_not_wisent",
                "wisent" to "game.hint.bison_not_wisent"
            ),
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "American bison are the largest terrestrial mammals in North America and are native to grassland ecosystems.",
                    ru = "Американские бизоны — крупнейшие наземные млекопитающие Северной Америки, обитающие в степных экосистемах.",
                    uk = "Американські бізони — найбільші наземні ссавці Північної Америки, що мешкають у степових екосистемах."
                ),
                Fact(
                    en = "Their shoulder hump consists of enlarged muscles that support head movement and foraging in snow.",
                    ru = "Горб на плечах состоит из развитой мускулатуры, поддерживающей движение головы и питание в снегу.",
                    uk = "Горб на плечах складається з розвиненої мускулатури, що підтримує рух голови та живлення у снігу."
                ),
                Fact(
                    en = "Their dense winter coat provides insulation and allows snow accumulation without rapid melting.",
                    ru = "Густая зимняя шерсть обеспечивает теплоизоляцию и может удерживать снег на поверхности тела.",
                    uk = "Густе зимове хутро забезпечує теплоізоляцію та може утримувати сніг на поверхні тіла."
                )
            )
        ),
        Animal(
            id = "giant_panda",
            nameEn = "Giant Panda",
            nameRu = "Большая панда",
            nameUk = "Велика панда",
            aliasesEn = listOf("giant panda", "panda"),
            aliasesRu = listOf("большая панда", "панда"),
            aliasesUk = listOf("велика панда", "панда"),
            rarity = Rarity.RARE,
            imagePath = "/images/panda.jpg",
            region = Region.TROPICAL_RAINFORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Giant pandas are bears native to central China, primarily inhabiting temperate bamboo forests.",
                    ru = "Большие панды — медведи, обитающие в центральном Китае, преимущественно в бамбуковых лесах.",
                    uk = "Великі панди — ведмеді, що мешкають у центральному Китаї, переважно в бамбукових лісах."
                ),
                Fact(
                    en = "They possess a modified radial sesamoid bone that functions as a pseudo-thumb for handling bamboo.",
                    ru = "У них есть видоизменённая сесамовидная кость лучевой кости, выполняющая функцию псевдопальца.",
                    uk = "У них є видозмінена сесамоподібна кістка променевої кістки, що виконує функцію псевдопальця."
                ),
                Fact(
                    en = "Despite being classified as carnivores, bamboo constitutes over 99% of their diet.",
                    ru = "Несмотря на классификацию как хищников, более 99% их рациона составляет бамбук.",
                    uk = "Попри класифікацію як хижаків, понад 99% їх раціону становить бамбук."
                )
            )
        ),
        Animal(
            id = "pronghorn",
            nameEn = "Pronghorn",
            nameRu = "Вилорог",
            nameUk = "Вилоріг",
            aliasesEn = listOf("pronghorn", "pronghorn antelope"),
            aliasesRu = listOf("вилорог", "вилорогая антилопа"),
            aliasesUk = listOf("вилоріг", "вилорога антилопа"),
            rarity = Rarity.RARE,
            imagePath = "/images/pronghorn.jpg",
            hints = mapOf(
                "антилопа" to "game.hint.antelope_generic",
                "газель" to "game.hint.antelope_generic",
                "antelope" to "game.hint.antelope_generic",
                "gazelle" to "game.hint.antelope_generic"
            ),
            region = Region.GRASSLANDS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Pronghorns are North American ungulates and the fastest long-distance runners in the Western Hemisphere.",
                    ru = "Вилороги — копытные Северной Америки и самые быстрые бегуны на длинные дистанции в Западном полушарии.",
                    uk = "Вилороги — копитні Північної Америки та найшвидші бігуни на довгі дистанції в Західній півкулі."
                ),
                Fact(
                    en = "Their large eyes provide a wide field of vision, aiding in predator detection.",
                    ru = "Крупные глаза обеспечивают широкое поле зрения для обнаружения хищников.",
                    uk = "Великі очі забезпечують широке поле зору для виявлення хижаків."
                )
            )
        ),
        Animal(
            id = "red_deer",
            nameEn = "Red Deer",
            nameRu = "Благородный олень",
            nameUk = "Благородний олень",
            aliasesEn = listOf("red deer", "stag", "hind"),
            aliasesRu = listOf("благородный олень", "олень", "марал"),
            aliasesUk = listOf("благородний олень", "олень"),
            rarity = Rarity.RARE,
            imagePath = "/images/red_deer.jpg",
            region = Region.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Red deer are widespread cervids native to Europe, parts of Asia, and North Africa.",
                    ru = "Благородные олени — представители семейства оленевых, распространённые в Европе, Азии и Северной Африке.",
                    uk = "Благородні олені — представники родини оленевих, поширені в Європі, Азії та Північній Африці."
                ),
                Fact(
                    en = "Males shed and regrow antlers annually, with growth influenced by hormonal cycles.",
                    ru = "Самцы ежегодно сбрасывают и отращивают рога, рост которых зависит от гормональных циклов.",
                    uk = "Самці щороку скидають і відрощують роги, ріст яких залежить від гормональних циклів."
                ),
                Fact(
                    en = "During rutting season, males produce loud vocalizations to establish dominance.",
                    ru = "В период гона самцы издают громкие звуки для установления доминирования.",
                    uk = "У період гону самці видають гучні звуки для встановлення домінування."
                )
            )
        ),
        Animal(
            id = "bactrian_camel",
            nameEn = "Bactrian Camel",
            nameRu = "Двугорбый верблюд",
            nameUk = "Двогорбий верблюд",
            aliasesEn = listOf("bactrian camel", "camel"),
            aliasesRu = listOf("двугорбый верблюд", "верблюд", "бактриан"),
            aliasesUk = listOf("двогорбий верблюд", "верблюд", "бактріан"),
            rarity = Rarity.RARE,
            imagePath = "/images/bactrian_camel.jpg",
            region = Region.DESERTS_SEMIDESERTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Bactrian camels are large ungulates native to Central Asia and adapted to extreme continental climates.",
                    ru = "Двугорбые верблюды — крупные копытные Центральной Азии, адаптированные к экстремальному климату.",
                    uk = "Двогорбі верблюди — великі копитні Центральної Азії, адаптовані до екстремального клімату."
                ),
                Fact(
                    en = "Their humps store fat reserves that can be metabolized into energy when food is scarce.",
                    ru = "Их горбы содержат жировые запасы, которые используются как источник энергии при нехватке пищи.",
                    uk = "Їхні горби містять жирові запаси, що використовуються як джерело енергії при нестачі їжі."
                ),
                Fact(
                    en = "They tolerate extreme temperature ranges from severe winter cold to desert heat.",
                    ru = "Они переносят экстремальные температуры от сильных морозов до жары пустыни.",
                    uk = "Вони витримують екстремальні температури від сильних морозів до пустельної спеки."
                )
            )
        ),
        Animal(
            id = "warthog",
            nameEn = "Warthog",
            nameRu = "Бородавочник",
            nameUk = "Бородавочник",
            aliasesEn = listOf("warthog"),
            aliasesRu = listOf("бородавочник", "африканский кабан"),
            aliasesUk = listOf("бородавочник"),
            rarity = Rarity.RARE,
            imagePath = "/images/warthog.jpg",
            region = Region.SAVANNAS,
            hints = mapOf(
                "кабан" to "game.hint.warthog_not_boar",
                "wild boar" to "game.hint.warthog_not_boar",
                "boar" to "game.hint.warthog_not_boar",
                "свинья" to "game.hint.pig_generic",
                "pig" to "game.hint.pig_generic"
            ),
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Warthogs are wild suids native to African savannas and open woodlands.",
                    ru = "Бородавочники — дикие свиньи, обитающие в саваннах и редколесьях Африки.",
                    uk = "Бородавочники — дикі свині, що мешкають у саванах і рідколіссі Африки."
                ),
                Fact(
                    en = "They often enter burrows backwards to allow tusks to face outward for defense.",
                    ru = "Они часто заходят в норы задом наперёд, чтобы клыки оставались направленными наружу для защиты.",
                    uk = "Вони часто заходять у нори задом наперед, щоб ікла були спрямовані назовні для захисту."
                ),
                Fact(
                    en = "Facial protuberances are fibrous skin structures that provide protection during male combat.",
                    ru = "Кожные образования на лице представляют собой защитные утолщения, используемые в боях самцов.",
                    uk = "Шкірні утворення на морді є захисними потовщеннями, що використовуються в бійках самців."
                )
            )
        ),
        Animal(
            id = "sea_lion",
            nameEn = "California Sea Lion",
            nameRu = "Калифорнийский морской лев",
            nameUk = "Каліфорнійський морський лев",
            aliasesEn = listOf("california sea lion", "sea lion"),
            aliasesRu = listOf("калифорнийский морской лев", "морской лев"),
            aliasesUk = listOf("каліфорнійський морський лев", "морський лев"),
            rarity = Rarity.RARE,
            imagePath = "/images/sea_lion.jpg",
            hints = mapOf(
                "тюлень" to "game.hint.seal_not_sealion",
                "нерпа" to "game.hint.seal_not_sealion",
                "seal" to "game.hint.seal_not_sealion"
            ),
            region = Region.OCEANS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "California sea lions are eared seals native to the eastern North Pacific Ocean.",
                    ru = "Калифорнийские морские львы — ушастые тюлени, обитающие в восточной части Тихого океана.",
                    uk = "Каліфорнійські морські леви — вухаті тюлені, що мешкають у східній частині Тихого океану."
                ),
                Fact(
                    en = "They use their foreflippers for locomotion on land and propulsion in water.",
                    ru = "Передние ласты используются для передвижения на суше и плавания в воде.",
                    uk = "Передні ласти використовуються для пересування на суші та плавання у воді."
                ),
                Fact(
                    en = "California sea lions are highly intelligent and easily trained, making them popular performers in aquariums and marine parks around the world.",
                    ru = "Калифорнийские морские львы отличаются высоким интеллектом и легко поддаются дрессировке, благодаря чему часто выступают в океанариумах и морских парках по всему миру.",
                    uk = "Каліфорнійські морські леви вирізняються високим інтелектом і легко піддаються дресируванню, тому часто виступають в океанаріумах і морських парках по всьому світу."
                )
            )
        ),
        Animal(
            id = "common_raven",
            nameEn = "Common Raven",
            nameRu = "Обыкновенный ворон",
            nameUk = "Крук",
            aliasesEn = listOf(
                "common raven",
                "raven"
            ),
            aliasesRu = listOf(
                "обыкновенный ворон",
                "ворон"
            ),
            aliasesUk = listOf(
                "крук",
                "звичайний крук"
            ),
            rarity = Rarity.RARE,
            imagePath = "/images/common_raven.jpg",
            hints = mapOf(
                "ворона" to "game.hint.raven_not_crow",
                "crow" to "game.hint.raven_not_crow"
            ),
            region = Region.TEMPERATE_FORESTS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Common ravens are among the most intelligent birds, capable of solving complex problems and using tools.",
                    ru = "Обыкновенные вороны — одни из самых умных птиц. Они способны решать сложные задачи и даже использовать простые орудия.",
                    uk = "Круки — одні з найрозумніших птахів. Вони здатні розв'язувати складні завдання й навіть використовувати прості знаряддя."
                ),
                Fact(
                    en = "They can imitate a wide variety of sounds, including human speech, when raised around people.",
                    ru = "При жизни рядом с человеком они способны подражать самым разным звукам, включая человеческую речь.",
                    uk = "Живучи поруч із людьми, вони здатні наслідувати найрізноманітніші звуки, зокрема людську мову."
                ),
                Fact(
                    en = "Ravens are much larger than crows and can be recognized by their massive bill and wedge-shaped tail in flight.",
                    ru = "Вороны заметно крупнее ворон, а в полёте их легко узнать по массивному клюву и клиновидному хвосту.",
                    uk = "Круки значно більші за ворон, а в польоті їх легко впізнати за масивним дзьобом і клиноподібним хвостом."
                )
            )
        ),
        Animal(
            id = "barn_swallow",
            nameEn = "Barn Swallow",
            nameRu = "Деревенская ласточка",
            nameUk = "Сільська ластівка",
            aliasesEn = listOf("barn swallow", "swallow"),
            aliasesRu = listOf("деревенская ласточка", "ласточка", "касатка"),
            aliasesUk = listOf("сільська ластівка", "ластівка", "касатка"),
            rarity = Rarity.RARE,
            imagePath = "/images/barn_swallow.jpg",
            hints = mapOf(
                "стриж" to "game.hint.swallow_not_swift",
                "swift" to "game.hint.swallow_not_swift"
            ),
            region = Region.GRASSLANDS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Barn swallows are migratory birds found across Europe, Asia, Africa, and the Americas.",
                    ru = "Деревенские ласточки — перелётные птицы, распространённые в Европе, Азии, Африке и Америке.",
                    uk = "Сільські ластівки — перелітні птахи, поширені в Європі, Азії, Африці та Америці."
                ),
                Fact(
                    en = "They catch insects in flight, spending most of the day hunting while airborne.",
                    ru = "Они ловят насекомых прямо в полёте, проводя большую часть дня в воздухе.",
                    uk = "Вони ловлять комах просто в польоті, проводячи більшу частину дня в повітрі."
                ),
                Fact(
                    en = "Although often confused with swifts, barn swallows have a deeply forked tail and can perch on branches and wires.",
                    ru = "Их часто путают со стрижами, однако ласточек легко узнать по глубоко раздвоенному хвосту и способности сидеть на ветках и проводах.",
                    uk = "Їх часто плутають зі стрижами, проте ластівок легко впізнати за глибоко роздвоєним хвостом і здатністю сидіти на гілках та дротах."
                )
            )
        ),
        Animal(
            id = "plains_zebra",
            nameEn = "Plains Zebra",
            nameRu = "Равнинная зебра",
            nameUk = "Рівнинна зебра",
            aliasesEn = listOf("plains zebra", "zebra"),
            aliasesRu = listOf("равнинная зебра", "зебра"),
            aliasesUk = listOf("рівнинна зебра", "зебра"),
            rarity = Rarity.RARE,
            imagePath = "/images/plains_zebra.jpg",
            region = Region.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Despite popular belief, zebras have black skin. Their white stripes are areas where the fur lacks pigment.",
                    ru = "Несмотря на распространённое мнение, кожа у зебр чёрная. Белые полосы — это участки шерсти, лишённые пигмента.",
                    uk = "Попри поширену думку, шкіра зебр чорна. Білі смуги — це ділянки шерсті без пігменту."
                ),
                Fact(
                    en = "Every zebra has a unique stripe pattern, much like a human fingerprint.",
                    ru = "У каждой зебры уникальный рисунок полос, подобно отпечаткам пальцев у человека.",
                    uk = "Кожна зебра має унікальний візерунок смуг, подібно до відбитків пальців у людини."
                ),
                Fact(
                    en = "Living in herds helps zebras spot predators early and increases their chances of survival.",
                    ru = "Жизнь в стаде помогает зебрам раньше замечать хищников и повышает их шансы на выживание.",
                    uk = "Життя в табуні допомагає зебрам раніше помічати хижаків і підвищує їхні шанси на виживання."
                )
            )
        ),
        Animal(
            id = "black_skimmer",
            nameEn = "Black Skimmer",
            nameRu = "Чёрный водорез",
            nameUk = "Чорний водоріз",
            aliasesEn = listOf("black skimmer", "skimmer"),
            aliasesRu = listOf("чёрный водорез", "черный водорез", "водорез"),
            aliasesUk = listOf("чорний водоріз", "водоріз"),
            rarity = Rarity.RARE,
            imagePath = "/images/black_skimmer.jpg",
            region = Region.COASTS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Black skimmers are coastal birds famous for their unique hunting technique. They fly low over the water with the lower half of their bill slicing through the surface until it snaps shut on a fish.",
                    ru = "Чёрные водорезы — прибрежные птицы, знаменитые необычным способом охоты. Они летят прямо над водой, погружая нижнюю часть клюва в воду, пока та не захлопнется на добыче.",
                    uk = "Чорні водорізи — прибережні птахи, відомі своїм незвичайним способом полювання. Вони летять просто над водою, занурюючи нижню частину дзьоба у воду, доки він не захлопнеться на здобичі."
                ),
                Fact(
                    en = "They are primarily ichthyophagous, meaning that fish make up the majority of their diet.",
                    ru = "Они являются преимущественно ихтиофагами — основу их рациона составляет рыба.",
                    uk = "Вони є переважно іхтіофагами — основу їхнього раціону становить риба."
                ),
                Fact(
                    en = "The lower mandible of a black skimmer is noticeably longer than the upper one, a rare adaptation among birds.",
                    ru = "Нижняя часть клюва у чёрного водореза заметно длиннее верхней — это очень редкое приспособление среди птиц.",
                    uk = "Нижня частина дзьоба у чорного водоріза помітно довша за верхню — це дуже рідкісне пристосування серед птахів."
                )
            )
        ),
        Animal(
            id = "grey_heron",
            nameEn = "Grey Heron",
            nameRu = "Серая цапля",
            nameUk = "Сіра чапля",
            aliasesEn = listOf("grey heron", "gray heron", "heron"),
            aliasesRu = listOf("серая цапля", "цапля"),
            aliasesUk = listOf("сіра чапля", "чапля"),
            rarity = Rarity.RARE,
            imagePath = "/images/grey_heron.jpg",
            region = Region.WETLANDS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Grey herons inhabit wetlands, lakes, rivers, and coastal areas across Europe, Asia, and parts of Africa.",
                    ru = "Серые цапли обитают на болотах, озёрах, реках и морских побережьях Европы, Азии и части Африки.",
                    uk = "Сірі чаплі мешкають на болотах, озерах, річках і морських узбережжях Європи, Азії та частини Африки."
                ),
                Fact(
                    en = "They are primarily ichthyophagous, feeding mainly on fish, though they also catch amphibians, reptiles, insects, and small mammals.",
                    ru = "Они являются преимущественно ихтиофагами, питаясь в основном рыбой, хотя также ловят земноводных, пресмыкающихся, насекомых и мелких млекопитающих.",
                    uk = "Вони є переважно іхтіофагами, живлячись головним чином рибою, хоча також ловлять земноводних, плазунів, комах і дрібних ссавців."
                ),
                Fact(
                    en = "Grey herons can stand perfectly still for several minutes before striking prey with a lightning-fast stab of their bill.",
                    ru = "Серые цапли могут неподвижно стоять несколько минут, а затем молниеносно пронзить добычу своим длинным клювом.",
                    uk = "Сірі чаплі можуть нерухомо стояти кілька хвилин, а потім блискавично вразити здобич своїм довгим дзьобом."
                )
            )
        ),
        Animal(
            id = "kirks_dik_dik",
            nameEn = "Kirk's Dik-dik",
            nameRu = "Дик-дик Кирка",
            nameUk = "Дік-дік Кірка",
            aliasesEn = listOf("kirk's dik-dik", "dik-dik", "dikdik"),
            aliasesRu = listOf("дик-дик кирка", "дик-дик", "дикдик"),
            aliasesUk = listOf("дік-дік Кірка", "дік-дік", "дікдік"),
            rarity = Rarity.RARE,
            imagePath = "/images/kirks_dik_dik.jpg",
            region = Region.SAVANNAS,
            hints = mapOf(
                "антилопа" to "game.hint.antelope_generic",
                "газель" to "game.hint.antelope_generic",
                "antelope" to "game.hint.antelope_generic",
                "gazelle" to "game.hint.antelope_generic"
            ),
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Kirk's dik-diks are among the smallest antelopes in the world, standing only about 35–45 cm tall.",
                    ru = "Дик-дики Кирка — одни из самых маленьких антилоп в мире. Их высота составляет всего около 35–45 см.",
                    uk = "Дік-діки Кірка — одні з найменших антилоп у світі. Їхня висота становить лише близько 35–45 см."
                ),
                Fact(
                    en = "Their name comes from the sharp alarm call they make when frightened, which sounds like 'dik-dik'.",
                    ru = "Своё название они получили благодаря тревожному крику, который звучит примерно как «дик-дик».",
                    uk = "Свою назву вони отримали завдяки тривожному крику, який звучить приблизно як «дік-дік»."
                ),
                Fact(
                    en = "Unlike many antelopes, dik-diks usually form lifelong pairs and defend a shared territory together.",
                    ru = "В отличие от многих антилоп, дик-дики обычно образуют пары на всю жизнь и вместе защищают свою территорию.",
                    uk = "На відміну від багатьох антилоп, дік-діки зазвичай утворюють пари на все життя й разом захищають свою територію."
                )
            )
        ),
        Animal(
            id = "pukeko",
            nameEn = "Pūkeko",
            nameRu = "Пукеко",
            nameUk = "Пукеко",
            aliasesEn = listOf("pukeko", "purple swamphen"),
            aliasesRu = listOf("пукеко", "султанка"),
            aliasesUk = listOf("пукеко", "султанка"),
            rarity = Rarity.RARE,
            imagePath = "/images/pukeko.jpg",
            region = Region.WETLANDS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Pūkeko are colorful wetland birds native to New Zealand and belong to the rail family.",
                    ru = "Пукеко — ярко окрашенные болотные птицы Новой Зеландии, относящиеся к семейству пастушковых.",
                    uk = "Пукеко — яскраво забарвлені болотні птахи Нової Зеландії, що належать до родини пастушкових."
                ),
                Fact(
                    en = "Their long red legs and oversized feet help them walk across muddy ground and marsh vegetation.",
                    ru = "Их длинные красные ноги и большие лапы помогают передвигаться по грязи и болотной растительности.",
                    uk = "Їхні довгі червоні ноги та великі лапи допомагають пересуватися болотистою місцевістю та серед рослинності."
                ),
                Fact(
                    en = "Pūkeko often live in family groups where several adults may help raise and protect chicks.",
                    ru = "Пукеко часто живут семейными группами, где несколько взрослых птиц помогают выращивать и защищать птенцов.",
                    uk = "Пукеко часто живуть сімейними групами, де кілька дорослих птахів допомагають вирощувати та захищати пташенят."
                )
            )
        ),
        Animal(
            id = "major_mitchell_cockatoo",
            nameEn = "Major Mitchell's Cockatoo",
            nameRu = "Розовый какаду",
            nameUk = "Рожевий какаду",
            aliasesEn = listOf("major mitchell's cockatoo", "pink cockatoo"),
            aliasesRu = listOf("розовый какаду", "какаду инка", "инка какаду"),
            aliasesUk = listOf("рожевий какаду", "какаду інка"),
            rarity = Rarity.RARE,
            imagePath = "/images/major_mitchell_cockatoo.jpg",
            region = Region.SAVANNAS,
            hints = mapOf(
                "папуга" to "game.hint.parrot_generic",
                "попугай" to "game.hint.parrot_generic",
                "parrot" to "game.hint.parrot_generic"
            ),
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Major Mitchell's cockatoos inhabit dry woodlands and savannas of Australia.",
                    ru = "Розовые какаду обитают в редколесьях и саваннах Австралии.",
                    uk = "Рожеві какаду мешкають у рідколіссях і саванах Австралії."
                ),
                Fact(
                    en = "They are famous for their spectacular crest colored in red, yellow, and white.",
                    ru = "Они знамениты своим роскошным хохлом, окрашенным в красные, жёлтые и белые цвета.",
                    uk = "Вони відомі своїм розкішним чубчиком, забарвленим у червоні, жовті та білі кольори."
                ),
                Fact(
                    en = "Many ornithologists consider them among the most beautiful parrots in the world.",
                    ru = "Многие орнитологи считают их одними из самых красивых попугаев в мире.",
                    uk = "Багато орнітологів вважають їх одними з найкрасивіших папуг у світі."
                )
            )
        ),
        Animal(
            id = "cockatiel",
            nameEn = "Cockatiel",
            nameRu = "Корелла",
            nameUk = "Корела",
            aliasesEn = listOf("cockatiel"),
            aliasesRu = listOf("корелла"),
            aliasesUk = listOf("корела"),
            rarity = Rarity.RARE,
            imagePath = "/images/cockatiel.jpg",
            region = Region.SAVANNAS,
            hints = mapOf(
                "папуга" to "game.hint.parrot_generic",
                "попугай" to "game.hint.parrot_generic",
                "parrot" to "game.hint.parrot_generic"
            ),
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Cockatiels are small parrots native to Australia and are among the world's most popular pet birds.",
                    ru = "Кореллы — небольшие попугаи Австралии и одни из самых популярных домашних птиц в мире.",
                    uk = "Корели — невеликі папуги Австралії та одні з найпопулярніших домашніх птахів у світі."
                ),
                Fact(
                    en = "They can learn to whistle melodies and imitate various household sounds.",
                    ru = "Они способны насвистывать мелодии и подражать различным бытовым звукам.",
                    uk = "Вони здатні насвистувати мелодії та наслідувати різні побутові звуки."
                ),
                Fact(
                    en = "Their expressive crest helps communicate mood and emotions.",
                    ru = "Их подвижный хохолок помогает выражать настроение и эмоции.",
                    uk = "Їхній рухливий чубчик допомагає виражати настрій та емоції."
                )
            )
        ),
        Animal(
            id = "arabian_oryx",
            nameEn = "Arabian Oryx",
            nameRu = "Белый орикс",
            nameUk = "Білий орикс",
            aliasesEn = listOf("arabian oryx", "oryx"),
            aliasesRu = listOf("белый орикс", "орикс"),
            aliasesUk = listOf("білий орикс", "орикс"),
            rarity = Rarity.RARE,
            imagePath = "/images/arabian_oryx.jpg",
            hints = mapOf(
                "антилопа" to "game.hint.antelope_generic",
                "газель" to "game.hint.antelope_generic",
                "antelope" to "game.hint.antelope_generic",
                "gazelle" to "game.hint.antelope_generic"
            ),
            region = Region.DESERTS_SEMIDESERTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The Arabian oryx inhabits the deserts of the Arabian Peninsula and is well adapted to extreme heat.",
                    ru = "Белый орикс обитает в пустынях Аравийского полуострова и прекрасно приспособлен к экстремальной жаре.",
                    uk = "Білий орикс мешкає в пустелях Аравійського півострова та чудово пристосований до екстремальної спеки."
                ),
                Fact(
                    en = "It can survive for long periods without drinking water, obtaining much of its moisture from plants.",
                    ru = "Орикс способен долго обходиться без воды, получая значительную часть влаги из растений.",
                    uk = "Орикс здатний довго обходитися без води, отримуючи значну частину вологи з рослин."
                ),
                Fact(
                    en = "Its long straight horns inspired some ancient legends about unicorns.",
                    ru = "Его длинные прямые рога могли стать одним из источников древних легенд о единорогах.",
                    uk = "Його довгі прямі роги могли стати одним із джерел давніх легенд про єдинорогів."
                )
            )
        ),
        Animal(
            id = "veiled_chameleon",
            nameEn = "Veiled Chameleon",
            nameRu = "Йеменский хамелеон",
            nameUk = "Єменський хамелеон",
            aliasesEn = listOf("veiled chameleon", "chameleon"),
            aliasesRu = listOf("йеменский хамелеон", "хамелеон"),
            aliasesUk = listOf("єменський хамелеон", "хамелеон"),
            rarity = Rarity.RARE,
            imagePath = "/images/veiled_chameleon.jpg",
            region = Region.TROPICAL_RAINFORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Veiled chameleons are native to the mountainous regions of Yemen and southwestern Saudi Arabia.",
                    ru = "Йеменские хамелеоны обитают в горных районах Йемена и юго-западной части Саудовской Аравии.",
                    uk = "Єменські хамелеони мешкають у гірських районах Ємену та південно-західної частини Саудівської Аравії."
                ),
                Fact(
                    en = "Their eyes can move independently, allowing them to observe two different directions at the same time.",
                    ru = "Их глаза могут двигаться независимо друг от друга, позволяя одновременно наблюдать за двумя разными направлениями.",
                    uk = "Їхні очі можуть рухатися незалежно одне від одного, дозволяючи одночасно спостерігати за двома різними напрямками."
                ),
                Fact(
                    en = "Contrary to popular belief, chameleons do not mainly change color for camouflage. Their colors often reflect mood, body temperature, and communication with other chameleons.",
                    ru = "Вопреки популярному мифу, хамелеоны меняют цвет не только для маскировки. Окраска часто отражает их настроение, температуру тела и помогает общаться с другими хамелеонами.",
                    uk = "Всупереч поширеному міфу, хамелеони змінюють колір не лише для маскування. Забарвлення часто відображає їхній настрій, температуру тіла та допомагає спілкуватися з іншими хамелеонами."
                )
            )
        )
    )
}