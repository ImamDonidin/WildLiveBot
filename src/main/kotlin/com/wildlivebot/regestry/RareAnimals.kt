package com.wildlivebot.regestry

import com.wildlivebot.model.Animal
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
            region = Region.GRASSLANDS,
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
        )
    )
}