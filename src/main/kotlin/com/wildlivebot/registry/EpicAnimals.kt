package com.wildlivebot.registry

import com.wildlivebot.model.Animal
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.Fact
import com.wildlivebot.model.Biome
import com.wildlivebot.model.Rarity

object EpicAnimals {
    val list = listOf(
        Animal(
            id = "wild_boar",
            nameEn = "Wild Boar",
            nameRu = "Кабан",
            nameUk = "Дикий кабан",
            aliasesEn = listOf("wild boar", "boar"),
            aliasesRu = listOf("кабан", "вепрь", "дикий кабан", "боров"),
            aliasesUk = listOf("кабан", "вепр", "дикий кабан", "сікач"),
            rarity = Rarity.EPIC,
            imagePath = "/images/wild_boar.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            hints = mapOf(
                "бородавочник" to "game.hint.boar_not_warthog",
                "warthog" to "game.hint.boar_not_warthog",
                "свинья" to "game.hint.pig_generic",
                "pig" to "game.hint.pig_generic"
            ),
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Wild boars are widespread suids native to Eurasia and North Africa, inhabiting forests, grasslands, and wetlands.",
                    ru = "Дикие кабаны — широко распространённые представители семейства свиных, обитающие в Евразии и Северной Африке.",
                    uk = "Дикі кабани — широко поширені представники родини свиневих, що мешкають у Євразії та Північній Африці."
                ),
                Fact(
                    en = "They are highly adaptable omnivores with strong rooting behavior used to forage in soil.",
                    ru = "Это всеядные животные с выраженным поведением рытья почвы в поисках пищи.",
                    uk = "Це всеїдні тварини з вираженою поведінкою риття ґрунту в пошуках їжі."
                ),
                Fact(
                    en = "Their continuously growing tusks are enlarged canine teeth used for defense and intraspecific competition.",
                    ru = "Их постоянно растущие клыки являются увеличенными резцами, используемыми для защиты и конкуренции.",
                    uk = "Їхні постійно зростаючі ікла є збільшеними зубами, що використовуються для захисту та конкуренції всередині виду."
                )
            )
        ),
        Animal(
            id = "armadillo",
            nameEn = "Nine-Banded Armadillo",
            nameRu = "Девятипоясный броненосец",
            nameUk = "Дев'ятипоясний броненосець",
            aliasesEn = listOf("armadillo", "nine-banded armadillo"),
            aliasesRu = listOf("броненосец", "девятипоясный броненосец"),
            aliasesUk = listOf("броненосець", "дев'ятипоясний броненосець"),
            rarity = Rarity.EPIC,
            imagePath = "/images/armadillo.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Nine-banded armadillos are armored mammals native to the Americas, with a carapace formed by osteoderms.",
                    ru = "Девятипоясные броненосцы — броненосные млекопитающие Америки с панцирем из остеодерм.",
                    uk = "Дев'ятипоясні броненосці — броньовані ссавці Америки з панцирем з остеодерм."
                ),
                Fact(
                    en = "They typically give birth to genetically identical quadruplets due to a single fertilized egg splitting.",
                    ru = "Обычно рождают генетически идентичных четверняшек из-за деления одной оплодотворённой яйцеклетки.",
                    uk = "Зазвичай народжують генетично ідентичних четверню через поділ однієї заплідненої яйцеклітини."
                ),
                Fact(
                    en = "Armadillos can perform a vertical jump as a startle response when threatened.",
                    ru = "Броненосцы способны совершать вертикальный прыжок как реакцию испуга.",
                    uk = "Броненосці здатні виконувати вертикальний стрибок як реакцію переляку."
                )
            )
        ),
        Animal(
            id = "platypus",
            nameEn = "Platypus",
            nameRu = "Утконос",
            nameUk = "Качкодзьоб",
            aliasesEn = listOf("platypus", "duckbill"),
            aliasesRu = listOf("утконос"),
            aliasesUk = listOf("качкодзьоб"),
            rarity = Rarity.EPIC,
            imagePath = "/images/platypus.jpg",
            biome = Biome.RIVERS_LAKES,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Platypuses are monotremes native to eastern Australia and Tasmania, laying eggs instead of giving birth.",
                    ru = "Утконосы — яйцекладущие млекопитающие, обитающие в восточной Австралии и Тасмании.",
                    uk = "Качкодзьоби — яйцекладні ссавці, що мешкають у східній Австралії та Тасманії."
                ),
                Fact(
                    en = "Males possess venomous spurs on their hind limbs that deliver a painful toxin.",
                    ru = "Самцы имеют ядовитые шпоры на задних конечностях, выделяющие болезненный токсин.",
                    uk = "Самці мають отруйні шпори на задніх кінцівках, що виділяють болісний токсин."
                ),
                Fact(
                    en = "They use electroreception in the bill to detect prey underwater.",
                    ru = "Они используют электролокацию в клюве для обнаружения добычи под водой.",
                    uk = "Вони використовують електрорецепцію в дзьобі для виявлення здобичі під водою."
                )
            )
        ),
        Animal(
            id = "american_beaver",
            nameEn = "North American Beaver",
            nameRu = "Канадский бобр",
            nameUk = "Канадський бобер",
            aliasesEn = listOf("american beaver", "beaver"),
            aliasesRu = listOf("канадский бобр", "бобр", "бобёр"),
            aliasesUk = listOf("канадський бобер", "бобер", "бобр"),
            rarity = Rarity.EPIC,
            imagePath = "/images/beaver.jpg",
            biome = Biome.RIVERS_LAKES,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "North American beavers are large semi-aquatic rodents native to freshwater ecosystems.",
                    ru = "Канадские бобры — крупные полуводные грызуны пресноводных экосистем.",
                    uk = "Канадські бобри — великі напівводні гризуни прісноводних екосистем."
                ),
                Fact(
                    en = "They modify landscapes by constructing dams that regulate water flow and create wetlands.",
                    ru = "Они изменяют ландшафт, строя плотины, регулирующие поток воды и создающие водно-болотные угодья.",
                    uk = "Вони змінюють ландшафт, будуючи греблі, що регулюють потік води та створюють водно-болотні угіддя."
                ),
                Fact(
                    en = "Their incisors are continuously growing and strengthened by iron compounds.",
                    ru = "Их резцы постоянно растут и укреплены соединениями железа.",
                    uk = "Їхні різці постійно ростуть і зміцнені сполуками заліза."
                )
            )
        ),
        Animal(
            id = "european_badger",
            nameEn = "European Badger",
            nameRu = "Европейский барсук",
            nameUk = "Європейський борсук",
            aliasesEn = listOf("european badger", "badger"),
            aliasesRu = listOf("европейский барсук", "барсук"),
            aliasesUk = listOf("європейський борсук", "борсук"),
            rarity = Rarity.EPIC,
            imagePath = "/images/european_badger.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "European badgers are fossorial mustelids living in extensive underground burrow systems.",
                    ru = "Европейские барсуки — норные представители семейства куньих, живущие в сложных подземных системах.",
                    uk = "Європейські борсуки — нірні представники родини куницевих, що живуть у складних підземних системах."
                ),
                Fact(
                    en = "Their social groups maintain and expand long-used burrow networks called setts.",
                    ru = "Их социальные группы поддерживают и расширяют многолетние системы нор.",
                    uk = "Їхні соціальні групи підтримують і розширюють багаторічні системи нір."
                ),
                Fact(
                    en = "They exhibit regular sanitation behavior by separating latrine sites from living areas.",
                    ru = "Они демонстрируют санитарное поведение, разделяя места туалетов и жилые зоны.",
                    uk = "Вони демонструють санітарну поведінку, розділяючи місця туалетів і житлові зони."
                )
            )
        ),
        Animal(
            id = "saiga_antelope",
            nameEn = "Saiga Antelope",
            nameRu = "Сайгак",
            nameUk = "Сайгак",
            aliasesEn = listOf("saiga antelope", "saiga"),
            aliasesRu = listOf("сайгак", "сайга", "степная антилопа"),
            aliasesUk = listOf("сайгак", "сайга", "степова антилопа"),
            rarity = Rarity.EPIC,
            imagePath = "/images/saiga_antelope.jpg",
            hints = mapOf(
                "антилопа" to "game.hint.antelope_generic",
                "газель" to "game.hint.antelope_generic",
                "antelope" to "game.hint.antelope_generic",
                "gazelle" to "game.hint.antelope_generic"
            ),
            biome = Biome.GRASSLANDS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Saiga antelopes are steppe-dwelling ungulates native to Central Asia.",
                    ru = "Сайгаки — степные копытные животные Центральной Азии.",
                    uk = "Сайгаки — степові копитні тварини Центральної Азії."
                ),
                Fact(
                    en = "Their enlarged nasal structure conditions inhaled air by filtering dust and warming cold air.",
                    ru = "Их увеличенный нос фильтрует пыль и согревает холодный воздух.",
                    uk = "Їхній збільшений ніс фільтрує пил і зігріває холодне повітря."
                ),
                Fact(
                    en = "They are highly mobile herd animals capable of seasonal migrations.",
                    ru = "Это подвижные стадные животные, совершающие сезонные миграции.",
                    uk = "Це рухливі стадні тварини, що здійснюють сезонні міграції."
                )
            )
        ),
        Animal(
            id = "african_buffalo",
            nameEn = "African Buffalo",
            nameRu = "Африканский буйвол",
            nameUk = "Африканський буйвіл",
            aliasesEn = listOf("african buffalo", "cape buffalo", "buffalo"),
            aliasesRu = listOf("африканский буйвол", "капский буйвол", "буйвол"),
            aliasesUk = listOf("африканський буйвіл", "капський буйвіл", "буйвіл"),
            rarity = Rarity.EPIC,
            imagePath = "/images/african_buffalo.jpg",
            biome = Biome.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "African buffalo are large bovids native to sub-Saharan Africa, living in herds of varying sizes.",
                    ru = "Африканские буйволы — крупные полорогие, обитающие в Африке к югу от Сахары.",
                    uk = "Африканські буйволи — великі порожнисторогі тварини, що мешкають у Субсахарській Африці."
                ),
                Fact(
                    en = "Their fused horn bases form a protective boss that provides structural reinforcement.",
                    ru = "Сросшиеся основания рогов образуют защитный костный щит.",
                    uk = "Зрощені основи рогів утворюють захисний кістковий щит."
                ),
                Fact(
                    en = "Herd movement decisions involve collective behavior influenced by multiple individuals.",
                    ru = "Решения о движении стада принимаются коллективно с участием разных особей.",
                    uk = "Рішення про рух стада приймаються колективно за участі різних особин."
                )
            )
        ),
        Animal(
            id = "giraffe",
            nameEn = "Giraffe",
            nameRu = "Жираф",
            nameUk = "Жираф",
            aliasesEn = listOf("giraffe"),
            aliasesRu = listOf("жираф", "жирафа"),
            aliasesUk = listOf("жираф", "жирафа"),
            rarity = Rarity.EPIC,
            imagePath = "/images/giraffe.jpg",
            biome = Biome.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Giraffes are the tallest terrestrial mammals, native to African savannas and woodlands.",
                    ru = "Жирафы — самые высокие наземные млекопитающие, обитающие в саваннах Африки.",
                    uk = "Жирафи — найвищі наземні ссавці, що мешкають у саванах Африки."
                ),
                Fact(
                    en = "Despite their long necks, they have seven cervical vertebrae like most mammals.",
                    ru = "Несмотря на длинную шею, у жирафов семь шейных позвонков, как и у большинства млекопитающих.",
                    uk = "Попри довгу шию, у жирафів сім шийних хребців, як і в більшості ссавців."
                ),
                Fact(
                    en = "Their tongue is prehensile and adapted for browsing foliage from trees.",
                    ru = "Их язык цепкий и приспособлен для питания листвой деревьев.",
                    uk = "Їхній язик хапальний і пристосований для живлення листям дерев."
                )
            )
        ),
        Animal(
            id = "grey_wolf",
            nameEn = "Grey Wolf",
            nameRu = "Волк",
            nameUk = "Вовк",
            aliasesEn = listOf("grey wolf", "wolf", "timber wolf"),
            aliasesRu = listOf("волк", "серый волк", "волчок", "волчара"),
            aliasesUk = listOf("вовк", "сірий вовк", "вовчик"),
            rarity = Rarity.EPIC,
            imagePath = "/images/grey_wolf.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Grey wolves are social canids that live in structured packs with cooperative behavior.",
                    ru = "Серые волки — социальные псовые, живущие в структурированных стаях.",
                    uk = "Сірі вовки — соціальні псові, що живуть у структурованих зграях."
                ),
                Fact(
                    en = "Pack members cooperate in hunting, territory defense, and pup rearing.",
                    ru = "Члены стаи совместно охотятся, защищают территорию и выращивают потомство.",
                    uk = "Члени зграї спільно полюють, захищають територію та виховують потомство."
                )
            )
        ),
        Animal(
            id = "walrus",
            nameEn = "Walrus",
            nameRu = "Морж",
            nameUk = "Морж",
            aliasesEn = listOf("walrus"),
            aliasesRu = listOf("морж", "моржик"),
            aliasesUk = listOf("морж", "моржик"),
            rarity = Rarity.EPIC,
            imagePath = "/images/walrus.jpg",
            hints = mapOf(
                "тюлень" to "game.hint.seal_not_walrus",
                "seal" to "game.hint.seal_not_walrus"
            ),
            biome = Biome.ARCTIC,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Walruses are large pinnipeds inhabiting Arctic marine environments.",
                    ru = "Моржи — крупные ластоногие, обитающие в арктических морях.",
                    uk = "Моржі — великі ластоногі, що мешкають в арктичних морях."
                ),
                Fact(
                    en = "Their tusks are elongated canine teeth used in social interactions and hauling onto ice.",
                    ru = "Их бивни — удлинённые клыки, используемые в социальных взаимодействиях и при выходе на лёд.",
                    uk = "Їхні бивні — подовжені ікла, що використовуються в соціальних взаємодіях і для виходу на лід."
                ),
                Fact(
                    en = "Vibrissae are highly sensitive and used to locate benthic invertebrates.",
                    ru = "Вибриссы очень чувствительны и помогают находить донных беспозвоночных.",
                    uk = "Вібриси дуже чутливі та допомагають знаходити донних безхребетних."
                )
            )
        ),
        Animal(
            id = "elephant_seal",
            nameEn = "Southern Elephant Seal",
            nameRu = "Южный морской слон",
            nameUk = "Південний морський слон",
            aliasesEn = listOf("southern elephant seal", "elephant seal"),
            aliasesRu = listOf("южный морской слон", "морской слон"),
            aliasesUk = listOf("південний морський слон", "морський слон"),
            rarity = Rarity.EPIC,
            imagePath = "/images/elephant_seal.jpg",
            biome = Biome.ANTARCTICA,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Southern elephant seals are the largest pinnipeds and are highly adapted to marine life.",
                    ru = "Южные морские слоны — крупнейшие ластоногие, полностью приспособленные к морской жизни.",
                    uk = "Південні морські слони — найбільші ластоногі, повністю пристосовані до морського життя."
                ),
                Fact(
                    en = "Adult males develop an inflatable proboscis used in acoustic amplification during mating displays.",
                    ru = "У самцов развивается раздувающийся хобот, усиливающий звуковые сигналы во время брачных демонстраций.",
                    uk = "У самців розвивається роздувний хобот, що підсилює звукові сигнали під час шлюбних демонстрацій."
                )
            )
        ),
        Animal(
            id = "spur_thighed_tortoise",
            nameEn = "Greek Tortoise",
            nameRu = "Средиземноморская сухопутная черепаха",
            nameUk = "Середземноморська сухопутна черепаха",
            aliasesEn = listOf("greek tortoise", "spur-thighed tortoise", "testudo graeca"),
            aliasesRu = listOf("сухопутная черепаха", "греческая черепаха", "черепаха"),
            aliasesUk = listOf("сухопутна черепаха", "грецька черепаха"),
            rarity = Rarity.EPIC,
            imagePath = "/images/tortoise.jpg",
            biome = Biome.GRASSLANDS,
            hints = mapOf(
                "болотная черепаха" to "game.hint.tortoise_not_pond",
                "морская черепаха" to "game.hint.tortoise_not_sea",
                "sea turtle" to "game.hint.tortoise_not_sea"
            ),
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "They are fully terrestrial reptiles and do not swim; deep water can be dangerous for them.",
                    ru = "Это полностью наземные рептилии, не приспособленные к плаванию; глубокая вода для них опасна.",
                    uk = "Це повністю наземні рептилії, не пристосовані до плавання; глибока вода для них небезпечна."
                ),
                Fact(
                    en = "They can live for several decades, with many individuals reaching 50–100 years in suitable conditions.",
                    ru = "Могут жить несколько десятилетий, часто достигая возраста 50–100 лет при хороших условиях.",
                    uk = "Можуть жити кілька десятиліть, часто досягаючи 50–100 років за сприятливих умов."
                ),
                Fact(
                    en = "They are herbivores, feeding mainly on grasses, leaves, and flowers.",
                    ru = "Травоядные, питаются в основном травой, листьями и цветами.",
                    uk = "Травоїдні, живляться переважно травою, листям і квітами."
                )
            )
        ),
        Animal(
            id = "indian_peafowl",
            nameEn = "Indian Peafowl",
            nameRu = "Индийский павлин",
            nameUk = "Індійський павич",
            aliasesEn = listOf("indian peafowl", "peafowl", "peacock", "peahen", "peacock bird"),
            aliasesRu = listOf("индийский павлин", "павлин", "пава"),
            aliasesUk = listOf("індійський павич", "павич", "пава"),
            rarity = Rarity.EPIC,
            imagePath = "/images/indian_peafowl.jpg",
            biome = Biome.TROPICAL_RAINFORESTS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Male Indian peafowl have spectacular colorful trains, while females are mostly brown and lack the long ornamental feathers.",
                    ru = "Самцы индийского павлина имеют огромный яркий хвост, а самки окрашены в скромные буро-зелёные цвета и лишены длинных декоративных перьев.",
                    uk = "Самці індійського павича мають величезний яскравий хвіст, а самки забарвлені в скромні буро-зелені кольори й не мають довгого декоративного пір'я."
                ),
                Fact(
                    en = "The famous 'tail' is actually made of elongated upper tail coverts. The real tail is much shorter and supports the display feathers.",
                    ru = "Знаменитый «хвост» павлина на самом деле состоит из удлинённых надхвостных перьев. Настоящий хвост гораздо короче и лишь поддерживает этот веер.",
                    uk = "Відомий «хвіст» павича насправді складається з подовженого надхвістя. Справжній хвіст значно коротший і лише підтримує цей віял."
                ),
                Fact(
                    en = "During courtship, a male fans out his train and vibrates it, producing a rustling sound and shimmering effect that attracts females.",
                    ru = "Во время брачного ритуала самец раскрывает свой веер и быстро вибрирует им, создавая шелест и мерцающий эффект, привлекающий самок.",
                    uk = "Під час шлюбного ритуалу самець розкриває свій віял і швидко вібрує ним, створюючи шелест і мерехтливий ефект, що приваблює самок."
                )
            )
        ),
        Animal(
            id = "shoebill",
            nameEn = "Shoebill",
            nameRu = "Китоглав",
            nameUk = "Китоголов",
            aliasesEn = listOf("shoebill", "shoebill stork", "whalehead"),
            aliasesRu = listOf("китоглав"),
            aliasesUk = listOf("китоголов"),
            rarity = Rarity.EPIC,
            imagePath = "/images/shoebill.jpg",
            biome = Biome.WETLANDS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Shoebills inhabit the vast freshwater swamps of Central and East Africa, where they patiently hunt fish.",
                    ru = "Китоглавы обитают на обширных пресноводных болотах Центральной и Восточной Африки, где терпеливо охотятся на рыбу.",
                    uk = "Китоголови мешкають на великих прісноводних болотах Центральної та Східної Африки, де терпляче полюють на рибу."
                ),
                Fact(
                    en = "Their enormous shoe-shaped bill allows them to catch large prey such as lungfish, catfish, and even young crocodiles.",
                    ru = "Огромный клюв в форме башмака позволяет им ловить крупную добычу: двоякодышащих рыб, сомов и даже молодых крокодилов.",
                    uk = "Величезний дзьоб у формі черевика дає змогу ловити велику здобич: дводишних риб, сомів і навіть молодих крокодилів."
                ),
                Fact(
                    en = "Shoebills are threatened by habitat loss and illegal hunting. Protect these remarkable birds—never buy wildlife trophies or products made from them.",
                    ru = "Китоглавам угрожают уничтожение болот и незаконная охота. Берегите этих удивительных птиц — никогда не покупайте трофеи и изделия из диких животных.",
                    uk = "Китоголовам загрожують знищення боліт і незаконне полювання. Бережіть цих дивовижних птахів — ніколи не купуйте трофеї та вироби з диких тварин."
                )
            )
        ),
        Animal(
            id = "gerenuk",
            nameEn = "Gerenuk",
            nameRu = "Геренук",
            nameUk = "Геренук",
            aliasesEn = listOf("gerenuk", "giraffe gazelle"),
            aliasesRu = listOf("геренук", "жирафовая газель"),
            aliasesUk = listOf("геренук", "жирафова газель"),
            rarity = Rarity.EPIC,
            imagePath = "/images/gerenuk.jpg",
            hints = mapOf(
                "антилопа" to "game.hint.antelope_generic",
                "газель" to "game.hint.antelope_generic",
                "antelope" to "game.hint.antelope_generic",
                "gazelle" to "game.hint.antelope_generic"
            ),
            biome = Biome.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Gerenuks have unusually long necks and legs, allowing them to reach leaves that most other antelopes cannot.",
                    ru = "Геренуки отличаются необычайно длинной шеей и ногами, благодаря которым могут доставать листья, недоступные большинству других антилоп.",
                    uk = "Геренуки мають надзвичайно довгу шию та ноги, завдяки яким можуть діставати листя, недоступне більшості інших антилоп."
                ),
                Fact(
                    en = "They often stand upright on their hind legs while feeding, balancing without support for several minutes.",
                    ru = "Во время кормления они часто встают на задние ноги и могут удерживать равновесие без опоры в течение нескольких минут.",
                    uk = "Під час живлення вони часто стають на задні ноги й можуть утримувати рівновагу без опори протягом кількох хвилин."
                ),
                Fact(
                    en = "Unlike many other antelopes, gerenuks can survive for long periods without drinking, obtaining most of their water from the plants they eat.",
                    ru = "В отличие от многих других антилоп, геренуки могут долго обходиться без питья, получая большую часть влаги из растений.",
                    uk = "На відміну від багатьох інших антилоп, геренуки можуть довго обходитися без пиття, отримуючи більшість вологи з рослин."
                )
            )
        ),
        Animal(
            id = "mountain_goat",
            nameEn = "Mountain Goat",
            nameRu = "Горный козёл",
            nameUk = "Гірський козел",
            aliasesEn = listOf("mountain goat", "goat"),
            aliasesRu = listOf("горный козёл", "горный козел", "козёл", "козел", "снежная коза"),
            aliasesUk = listOf("гірський козел", "козел", "cнігова коза"),
            rarity = Rarity.EPIC,
            imagePath = "/images/mountain_goat.jpg",
            biome = Biome.MOUNTAINS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Mountain goats inhabit steep rocky mountains in western North America.",
                    ru = "Горные козлы обитают на крутых скалистых склонах западной части Северной Америки.",
                    uk = "Гірські козли мешкають на крутих скелястих схилах заходу Північної Америки."
                ),
                Fact(
                    en = "Their hooves have hard outer edges and soft rubber-like pads, giving them exceptional grip on narrow cliffs.",
                    ru = "Их копыта имеют твёрдый внешний край и мягкие цепкие подушечки, благодаря которым они уверенно держатся даже на почти отвесных скалах.",
                    uk = "Їхні копита мають твердий зовнішній край і м'які чіпкі подушечки, завдяки яким вони впевнено тримаються навіть на майже стрімких скелях."
                ),
                Fact(
                    en = "Both males and females have black horns that continue growing throughout their lives.",
                    ru = "И самцы, и самки имеют чёрные рога, которые продолжают расти на протяжении всей жизни.",
                    uk = "І самці, і самки мають чорні роги, які ростуть упродовж усього життя."
                )
            )
        ),
        Animal(
            id = "harpy_eagle",
            nameEn = "Harpy Eagle",
            nameRu = "Гарпия",
            nameUk = "Гарпія",
            aliasesEn = listOf("harpy eagle", "harpy"),
            aliasesRu = listOf("гарпия", "орёл гарпия"),
            aliasesUk = listOf("гарпія", "орел гарпія"),
            rarity = Rarity.EPIC,
            imagePath = "/images/harpy_eagle.jpg",
            biome = Biome.TROPICAL_RAINFORESTS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Harpy eagles inhabit the tropical rainforests of Central and South America, where they hunt in the forest canopy.",
                    ru = "Гарпии обитают во влажных тропических лесах Центральной и Южной Америки, охотясь высоко в кронах деревьев.",
                    uk = "Гарпії мешкають у вологих тропічних лісах Центральної та Південної Америки, полюючи високо в кронах дерев."
                ),
                Fact(
                    en = "Their talons can reach 13 cm in length—longer than the claws of a grizzly bear—and are powerful enough to seize monkeys and sloths.",
                    ru = "Их когти достигают 13 см в длину — они длиннее когтей медведя гризли и способны удерживать обезьян и ленивцев.",
                    uk = "Їхні кігті сягають 13 см завдовжки — вони довші за кігті ведмедя гризлі й здатні утримувати мавп і лінивців."
                ),
                Fact(
                    en = "Harpy eagles are among the strongest birds of prey in the world, capable of lifting prey weighing several kilograms.",
                    ru = "Гарпии — одни из самых сильных хищных птиц в мире и способны поднимать добычу весом в несколько килограммов.",
                    uk = "Гарпії — одні з найсильніших хижих птахів у світі й здатні підіймати здобич вагою в кілька кілограмів."
                )
            )
        ),
        Animal(
            id = "stoat",
            nameEn = "Stoat",
            nameRu = "Горностай",
            nameUk = "Горностай",
            aliasesEn = listOf("stoat", "ermine", "short-tailed weasel"),
            aliasesRu = listOf("горностай"),
            aliasesUk = listOf("горностай"),
            rarity = Rarity.EPIC,
            imagePath = "/images/stoat.jpg",
            hints = mapOf(
                "ласка" to "game.hint.stoat_not_weasel",
                "weasel" to "game.hint.stoat_not_weasel"
            ),
            biome = Biome.BOREAL_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Stoats inhabit forests, tundra, and grasslands across much of the Northern Hemisphere.",
                    ru = "Горностаи обитают в лесах, тундрах и открытых ландшафтах большей части Северного полушария.",
                    uk = "Горностаї мешкають у лісах, тундрі та відкритих ландшафтах більшої частини Північної півкулі."
                ),
                Fact(
                    en = "In winter, their fur often turns completely white, while the tip of the tail remains black.",
                    ru = "Зимой их мех часто становится полностью белым, но кончик хвоста остаётся чёрным.",
                    uk = "Взимку їхнє хутро часто стає повністю білим, але кінчик хвоста залишається чорним."
                ),
                Fact(
                    en = "Despite their small size, stoats are fearless predators capable of hunting prey larger than themselves.",
                    ru = "Несмотря на небольшие размеры, горностаи являются бесстрашными хищниками и могут охотиться на добычу крупнее себя.",
                    uk = "Попри невеликі розміри, горностаї є безстрашними хижаками й можуть полювати на здобич більшу за себе."
                )
            )
        ),
        Animal(
            id = "bottlenose_dolphin",
            nameEn = "Bottlenose Dolphin",
            nameRu = "Дельфин-афалина",
            nameUk = "Афаліна звичайна",
            aliasesEn = listOf("bottlenose dolphin", "dolphin"),
            aliasesRu = listOf("дельфин-афалина", "афалина", "дельфин"),
            aliasesUk = listOf("афаліна", "дельфін-афаліна", "дельфін"),
            rarity = Rarity.EPIC,
            imagePath = "/images/bottlenose_dolphin.jpg",
            biome = Biome.OCEANS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Bottlenose dolphins inhabit warm and temperate seas around the world and are among the most studied marine mammals.",
                    ru = "Дельфины-афалины обитают в тёплых и умеренных морях по всему миру и являются одними из самых изученных морских млекопитающих.",
                    uk = "Афаліни мешкають у теплих і помірних морях по всьому світу та є одними з найвивченіших морських ссавців."
                ),
                Fact(
                    en = "Their large and highly developed brains are associated with advanced learning, problem-solving, self-recognition, and complex social behavior.",
                    ru = "Их крупный и хорошо развитый мозг связан со способностью к обучению, решению задач, узнаванию себя в зеркале и сложному социальному поведению.",
                    uk = "Їхній великий і добре розвинений мозок пов'язаний зі здатністю до навчання, розв'язання задач, упізнавання себе в дзеркалі та складною соціальною поведінкою."
                ),
                Fact(
                    en = "Dolphins are known to play with fish and other animals, and some observations suggest they may deliberately interact with pufferfish, possibly because of the toxins they contain.",
                    ru = "Дельфины известны своей игривостью: они могут играть с рыбами и другой добычей. Некоторые наблюдения также показывают, что они специально взаимодействуют с иглобрюхами, возможно из-за содержащихся в них токсинов.",
                    uk = "Дельфіни відомі своєю грайливістю: вони можуть гратися з рибою та іншою здобиччю. Деякі спостереження також свідчать, що вони навмисно взаємодіють із рибами-іглобрюхами, можливо через токсини, які ті містять."
                )
            )
        ),
        Animal(
            id = "blue_footed_booby",
            nameEn = "Blue-footed Booby",
            nameRu = "Голубоногая олуша",
            nameUk = "Блакитнонога олуша",
            aliasesEn = listOf("blue-footed booby", "booby"),
            aliasesRu = listOf("голубоногая олуша", "олуша"),
            aliasesUk = listOf("блакитнонога олуша", "олуша"),
            rarity = Rarity.EPIC,
            imagePath = "/images/blue_footed_booby.jpg",
            biome = Biome.COASTS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Blue-footed boobies inhabit the Pacific coasts and islands of Central and South America, especially the Galápagos Islands.",
                    ru = "Голубоногие олуши обитают на тихоокеанском побережье и островах Центральной и Южной Америки, особенно на Галапагосах.",
                    uk = "Блакитноногі олуші мешкають на тихоокеанському узбережжі та островах Центральної й Південної Америки, особливо на Галапагоських островах."
                ),
                Fact(
                    en = "Their bright blue feet are a sign of health and play a major role in courtship displays.",
                    ru = "Их ярко-голубые лапы служат показателем здоровья и играют важную роль в брачных танцах.",
                    uk = "Їхні яскраво-блакитні лапи є показником здоров'я та відіграють важливу роль у шлюбних танцях."
                ),
                Fact(
                    en = "They hunt fish by diving from the air and can hit the water at speeds exceeding 90 km/h.",
                    ru = "Они охотятся на рыбу, пикируя с воздуха, и могут входить в воду на скорости свыше 90 км/ч.",
                    uk = "Вони полюють на рибу, пірнаючи з повітря, і можуть входити у воду на швидкості понад 90 км/год."
                )
            )
        ),
        Animal(
            id = "african_grey_parrot",
            nameEn = "African Grey Parrot",
            nameRu = "Жако",
            nameUk = "Жако",
            aliasesEn = listOf("african grey parrot", "grey parrot", "african gray parrot"),
            aliasesRu = listOf("жако", "серый попугай"),
            aliasesUk = listOf("жако", "сірий папуга"),
            rarity = Rarity.EPIC,
            imagePath = "/images/african_grey_parrot.jpg",
            biome = Biome.TROPICAL_RAINFORESTS,
            hints = mapOf(
                "папуга" to "game.hint.parrot_generic",
                "попугай" to "game.hint.parrot_generic",
                "parrot" to "game.hint.parrot_generic"
            ),
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "African grey parrots inhabit tropical forests of Central and West Africa.",
                    ru = "Жако обитают во влажных тропических лесах Центральной и Западной Африки.",
                    uk = "Жако мешкають у вологих тропічних лісах Центральної та Західної Африки."
                ),
                Fact(
                    en = "They are considered among the most intelligent birds on Earth and can learn hundreds of words.",
                    ru = "Они считаются одними из самых умных птиц на Земле и способны запоминать сотни слов.",
                    uk = "Вони вважаються одними з найрозумніших птахів на Землі та здатні запам'ятовувати сотні слів."
                ),
                Fact(
                    en = "Some African grey parrots can associate words with objects, colors, numbers, and simple concepts.",
                    ru = "Некоторые жако способны связывать слова с предметами, цветами, числами и простыми понятиями.",
                    uk = "Деякі жако здатні пов'язувати слова з предметами, кольорами, числами та простими поняттями."
                )
            )
        ),
        Animal(
            id = "common_eland",
            nameEn = "Common Eland",
            nameRu = "Обыкновенная канна",
            nameUk = "Канна звичайна",
            aliasesEn = listOf("common eland", "eland"),
            aliasesRu = listOf("обыкновенная канна", "канна", "антилопа канна"),
            aliasesUk = listOf("канна звичайна", "канна"),
            rarity = Rarity.EPIC,
            imagePath = "/images/common_eland.jpg",
            hints = mapOf(
                "антилопа" to "game.hint.antelope_generic",
                "газель" to "game.hint.antelope_generic",
                "antelope" to "game.hint.antelope_generic",
                "gazelle" to "game.hint.antelope_generic"
            ),
            biome = Biome.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The common eland is the largest antelope in the world and can weigh nearly one ton.",
                    ru = "Обыкновенная канна — крупнейшая антилопа в мире. Масса крупных самцов может приближаться к одной тонне.",
                    uk = "Канна звичайна — найбільша антилопа у світі. Маса великих самців може наближатися до однієї тонни."
                ),
                Fact(
                    en = "Despite their size, elands can jump over fences more than 2 meters high.",
                    ru = "Несмотря на огромные размеры, канны способны перепрыгивать препятствия высотой более 2 метров.",
                    uk = "Попри величезні розміри, канни здатні перестрибувати перешкоди заввишки понад 2 метри."
                ),
                Fact(
                    en = "When walking, their tendons produce audible clicking sounds that can be heard from hundreds of meters away.",
                    ru = "Во время ходьбы их сухожилия издают характерные щелчки, которые можно услышать на расстоянии в сотни метров.",
                    uk = "Під час ходьби їхні сухожилля видають характерні клацання, які можна почути на відстані сотень метрів."
                )
            )
        ),
        Animal(
            id = "common_wombat",
            nameEn = "Common Wombat",
            nameRu = "Обыкновенный вомбат",
            nameUk = "Вомбат звичайний",
            aliasesEn = listOf("common wombat", "wombat"),
            aliasesRu = listOf("обыкновенный вомбат", "вомбат"),
            aliasesUk = listOf("вомбат звичайний", "вомбат"),
            rarity = Rarity.EPIC,
            imagePath = "/images/common_wombat.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Common wombats are burrowing marsupials native to southeastern Australia.",
                    ru = "Обыкновенные вомбаты — роющие сумчатые животные, обитающие на юго-востоке Австралии.",
                    uk = "Вомбати звичайні — риючі сумчасті тварини, що мешкають на південному сході Австралії."
                ),
                Fact(
                    en = "Wombats produce distinctive cube-shaped droppings, which help prevent them from rolling away on uneven terrain.",
                    ru = "Вомбаты известны своими кубическими экскрементами, которые не скатываются с камней и помогают метить территорию.",
                    uk = "Вомбати відомі своїми кубічними екскрементами, які не скочуються з каміння та допомагають позначати територію."
                ),
                Fact(
                    en = "Their rear end is reinforced with thick cartilage and tough skin, allowing them to block burrow entrances from predators.",
                    ru = "Задняя часть тела вомбата укреплена толстой кожей и хрящами, благодаря чему он может буквально затыкать вход в нору от хищников.",
                    uk = "Задня частина тіла вомбата укріплена товстою шкірою та хрящами, завдяки чому він може буквально затуляти вхід до нори від хижаків."
                )
            )
        ),
        Animal(
            id = "caracal",
            nameEn = "Caracal",
            nameRu = "Каракал",
            nameUk = "Каракал",
            aliasesEn = listOf("caracal"),
            aliasesRu = listOf("каракал"),
            aliasesUk = listOf("каракал"),
            rarity = Rarity.EPIC,
            imagePath = "/images/caracal.jpg",
            hints = mapOf(
                "шлёпа" to "game.hint.caracal_not_bigfloppa",
                "шлепа" to "game.hint.caracal_not_bigfloppa",
                "floppa" to "game.hint.caracal_not_bigfloppa",
                "big floppa" to "game.hint.caracal_not_bigfloppa"
            ),
            biome = Biome.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Caracals inhabit Africa, the Middle East, and parts of Central Asia, living in savannas, semi-deserts, and dry woodlands.",
                    ru = "Каракалы обитают в Африке, на Ближнем Востоке и в некоторых районах Центральной Азии, населяя саванны, полупустыни и редколесья.",
                    uk = "Каракали мешкають в Африці, на Близькому Сході та в деяких районах Центральної Азії, населяючи савани, напівпустелі й рідколісся."
                ),
                Fact(
                    en = "Their powerful hind legs allow them to leap over 3 meters into the air and catch birds in flight.",
                    ru = "Благодаря мощным задним лапам каракалы способны подпрыгивать более чем на 3 метра и ловить птиц прямо в воздухе.",
                    uk = "Завдяки потужним заднім лапам каракали можуть стрибати більш ніж на 3 метри у висоту й ловити птахів просто в повітрі."
                ),
                Fact(
                    en = "Their long black ear tufts improve visual communication, although their exact purpose is still being studied.",
                    ru = "Длинные чёрные кисточки на ушах помогают каракалам общаться между собой с помощью визуальных сигналов, хотя их точная функция до сих пор изучается.",
                    uk = "Довгі чорні китички на вухах допомагають каракалам спілкуватися за допомогою візуальних сигналів, хоча їхня точна функція досі вивчається."
                ),
                Fact(
                    en = "Caracals became internet celebrities thanks to the famous meme cat 'Big Floppa', introducing millions of people to this wild species.",
                    ru = "Каракалы стали настоящими интернет-знаменитостями благодаря знаменитому мему «Шлёпа» (Big Floppa), благодаря которому миллионы людей впервые узнали об этом виде.",
                    uk = "Каракали стали справжніми інтернет-знаменитостями завдяки знаменитому мему «Шльопа» (Big Floppa), завдяки якому мільйони людей вперше дізналися про цей вид."
                )
            )
        ),
        Animal(
            id = "pallas_cat",
            nameEn = "Pallas's Cat",
            nameRu = "Манул",
            nameUk = "Манул",
            aliasesEn = listOf("pallas's cat", "pallas cat", "manul"),
            aliasesRu = listOf("манул"),
            aliasesUk = listOf("манул"),
            rarity = Rarity.EPIC,
            imagePath = "/images/pallas_cat.jpg",
            hints = mapOf(
                "кот" to "game.hint.cat_generic",
                "кошка" to "game.hint.cat_generic",
                "cat" to "game.hint.cat_generic"
            ),
            biome = Biome.MOUNTAINS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Pallas's cats inhabit the cold steppes and rocky mountains of Central Asia, where their dense fur protects them from harsh winters.",
                    ru = "Манулы обитают в холодных степях и горных районах Центральной Азии, где их очень густой мех защищает от суровых зим.",
                    uk = "Манули мешкають у холодних степах і гірських районах Центральної Азії, де їхнє дуже густе хутро захищає від суворих зим."
                ),
                Fact(
                    en = "Unlike domestic cats, Pallas's cats are solitary animals and are extremely difficult to tame. They become stressed around humans and are not suitable as pets.",
                    ru = "В отличие от домашних кошек, манулы — одиночки. Они очень плохо переносят присутствие человека и практически не поддаются приручению.",
                    uk = "На відміну від домашніх кішок, манули — одинаки. Вони дуже погано переносять присутність людини й практично не піддаються прирученню."
                ),
                Fact(
                    en = "Despite their grumpy expression, Pallas's cats became internet celebrities thanks to countless photos and memes featuring their unique appearance.",
                    ru = "Несмотря на своё «недовольное» выражение морды, манулы стали настоящими звёздами интернета благодаря своему необычному внешнему виду.",
                    uk = "Попри свій «невдоволений» вираз морди, манули стали справжніми зірками інтернету завдяки своїй незвичайній зовнішності."
                )
            )
        ),
        Animal(
            id = "eurasian_lynx",
            nameEn = "Eurasian Lynx",
            nameRu = "Европейская рысь",
            nameUk = "Рись євразійська",
            aliasesEn = listOf("eurasian lynx", "lynx"),
            aliasesRu = listOf("европейская рысь", "рысь"),
            aliasesUk = listOf("рись євразійська", "рись"),
            rarity = Rarity.RARE,
            imagePath = "/images/eurasian_lynx.jpg",
            hints = mapOf(
                "кот" to "game.hint.cat_generic",
                "кошка" to "game.hint.cat_generic",
                "cat" to "game.hint.cat_generic"
            ),
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The Eurasian lynx is the largest lynx species and inhabits forests across Europe and northern Asia.",
                    ru = "Евразийская рысь — самый крупный представитель рода рысей, обитающий в лесах Европы и северной Азии.",
                    uk = "Рись євразійська — найбільший представник роду рисей, що мешкає в лісах Європи та північної Азії."
                ),
                Fact(
                    en = "Its tufted ears improve hearing and help determine the direction of sounds while hunting.",
                    ru = "Кисточки на ушах помогают рыси лучше определять направление звука во время охоты.",
                    uk = "Китички на вухах допомагають рисі краще визначати напрямок звуку під час полювання."
                ),
                Fact(
                    en = "In many ecosystems, lynx numbers closely follow hare populations. When hares become abundant, lynx populations grow; when hares decline, lynx numbers also decrease.",
                    ru = "Во многих экосистемах численность рысей тесно связана с численностью зайцев. Когда зайцев становится много, популяция рысей тоже растёт, а когда их становится мало — сокращается и число рысей.",
                    uk = "У багатьох екосистемах чисельність рисей тісно пов'язана з чисельністю зайців. Коли зайців стає багато, популяція рисей також зростає, а коли їх меншає — скорочується й кількість рисей."
                )
            )
        ),
        Animal(
            id = "giant_anteater",
            nameEn = "Giant Anteater",
            nameRu = "Гигантский муравьед",
            nameUk = "Великий мурахоїд",
            aliasesEn = listOf("giant anteater", "anteater"),
            aliasesRu = listOf("гигантский муравьед", "муравьед"),
            aliasesUk = listOf("великий мурахоїд", "мурахоїд"),
            rarity = Rarity.EPIC,
            imagePath = "/images/giant_anteater.jpg",
            hints = mapOf(
                "муравей" to "game.hint.anteater_not_ant",
                "ant" to "game.hint.anteater_not_ant"
            ),
            biome = Biome.TROPICAL_RAINFORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Giant anteaters inhabit grasslands, savannas, and tropical forests of Central and South America.",
                    ru = "Гигантские муравьеды обитают в саваннах, лугах и тропических лесах Центральной и Южной Америки.",
                    uk = "Великі мурахоїди мешкають у саванах, луках і тропічних лісах Центральної та Південної Америки."
                ),
                Fact(
                    en = "Their tongue can reach up to 60 cm in length and flicks in and out over 150 times per minute, allowing them to consume thousands of ants and termites every day.",
                    ru = "Их язык достигает 60 см в длину и высовывается до 150 раз в минуту, позволяя съедать тысячи муравьёв и термитов каждый день.",
                    uk = "Їхній язик сягає 60 см завдовжки й висовується до 150 разів на хвилину, дозволяючи з'їдати тисячі мурах і термітів щодня."
                ),
                Fact(
                    en = "Despite having no teeth, giant anteaters possess huge curved claws powerful enough to tear open termite mounds and defend themselves from jaguars.",
                    ru = "Несмотря на отсутствие зубов, гигантские муравьеды обладают огромными изогнутыми когтями, которыми вскрывают термитники и даже могут защищаться от ягуаров.",
                    uk = "Попри відсутність зубів, великі мурахоїди мають величезні вигнуті кігті, якими розкривають термітники й навіть можуть захищатися від ягуарів."
                )
            )
        ),
        Animal(
            id = "eurasian_otter",
            nameEn = "Eurasian Otter",
            nameRu = "Обыкновенная выдра",
            nameUk = "Видра річкова",
            aliasesEn = listOf(
                "eurasian otter",
                "otter",
                "common otter",
                "european otter"
            ),
            aliasesRu = listOf(
                "обыкновенная выдра",
                "выдра",
                "речная выдра"
            ),
            aliasesUk = listOf(
                "видра річкова",
                "видра",
                "європейська видра"
            ),
            rarity = Rarity.EPIC,
            imagePath = "/images/eurasian_otter.jpg",
            biome = Biome.RIVERS_LAKES,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The Eurasian otter is a semi-aquatic mammal found across large parts of Europe and Asia, usually near freshwater habitats.",
                    ru = "Обыкновенная выдра — полуводное млекопитающее, распространённое в значительной части Европы и Азии, обычно вблизи пресных водоёмов.",
                    uk = "Видра річкова — напівводний ссавець, поширений у значній частині Європи та Азії, зазвичай поблизу прісних водойм."
                ),
                Fact(
                    en = "Its streamlined body, webbed feet, and powerful tail make it well adapted for swimming and underwater hunting.",
                    ru = "Обтекаемое тело, перепончатые лапы и мощный хвост хорошо приспособлены для плавания и охоты под водой.",
                    uk = "Обтічне тіло, перетинчасті лапи та потужний хвіст добре пристосовані до плавання й полювання під водою."
                ),
                Fact(
                    en = "Eurasian otters have extremely dense fur that helps insulate their bodies in cold water.",
                    ru = "У обыкновенных выдр чрезвычайно густой мех, который помогает сохранять тепло в холодной воде.",
                    uk = "У річкових видр надзвичайно густе хутро, яке допомагає зберігати тепло в холодній воді."
                ),
                Fact(
                    en = "They mainly feed on fish but also eat amphibians, crustaceans, insects, and other aquatic or semi-aquatic animals.",
                    ru = "Основу их рациона обычно составляет рыба, но они также едят земноводных, ракообразных, насекомых и других водных или полуводных животных.",
                    uk = "Основу їхнього раціону зазвичай становить риба, але вони також їдять земноводних, ракоподібних, комах та інших водних або напівводних тварин."
                )
            )
        ),
        Animal(
            id = "south_american_tapir",
            nameEn = "South American Tapir",
            nameRu = "Равнинный тапир",
            nameUk = "Рівнинний тапір",
            aliasesEn = listOf("south american tapir", "lowland tapir", "tapir"),
            aliasesRu = listOf("равнинный тапир", "южноамериканский тапир", "тапир"),
            aliasesUk = listOf("рівнинний тапір", "південноамериканський тапір", "тапір"),
            rarity = Rarity.EPIC,
            imagePath = "/images/south_american_tapir.jpg",
            biome = Biome.TROPICAL_RAINFORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "South American tapirs inhabit forests, wetlands, and grasslands across much of northern and central South America.",
                    ru = "Равнинные тапиры обитают в лесах, заболоченных местах и на лугах в значительной части северной и центральной Южной Америки.",
                    uk = "Рівнинні тапіри мешкають у лісах, заболочених місцевостях і на луках у значній частині північної та центральної Південної Америки."
                ),
                Fact(
                    en = "Their flexible trunk-like snout is used to grasp leaves, fruits, and other vegetation.",
                    ru = "Их гибкий хоботок используется для захвата листьев, плодов и другой растительности.",
                    uk = "Їхнє гнучке хоботоподібне рило використовується для захоплення листя, плодів та іншої рослинності."
                ),
                Fact(
                    en = "South American tapirs are strong swimmers and often enter water to cool down, escape danger, or feed on aquatic vegetation.",
                    ru = "Равнинные тапиры хорошо плавают и часто заходят в воду, чтобы охладиться, спастись от опасности или питаться водной растительностью.",
                    uk = "Рівнинні тапіри добре плавають і часто заходять у воду, щоб охолодитися, втекти від небезпеки або живитися водною рослинністю."
                )
            )
        ),
        Animal(
            id = "greater_flamingo",
            nameEn = "Greater Flamingo",
            nameRu = "Розовый фламинго",
            nameUk = "Рожевий фламінго",
            aliasesEn = listOf("greater flamingo", "flamingo"),
            aliasesRu = listOf("розовый фламинго", "фламинго"),
            aliasesUk = listOf("рожевий фламінго", "фламінго"),
            rarity = Rarity.EPIC,
            imagePath = "/images/greater_flamingo.jpg",
            biome = Biome.WETLANDS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Greater flamingos live in shallow wetlands such as lagoons, salt lakes, estuaries, and coastal mudflats.",
                    ru = "Розовые фламинго обитают на мелководных водоёмах, включая лагуны, солёные озёра, эстуарии и прибрежные илистые отмели.",
                    uk = "Рожеві фламінго мешкають на мілководних водно-болотних угіддях, зокрема в лагунах, солоних озерах, естуаріях і прибережних мулистих мілинах."
                ),
                Fact(
                    en = "Their pink and reddish coloration comes mainly from carotenoid pigments in the algae and small aquatic organisms they eat.",
                    ru = "Их розовая и красноватая окраска в основном обусловлена каротиноидными пигментами из водорослей и мелких водных организмов, которыми они питаются.",
                    uk = "Їхнє рожеве та червонувате забарвлення переважно зумовлене каротиноїдними пігментами з водоростей і дрібних водних організмів, якими вони живляться."
                ),
                Fact(
                    en = "Greater flamingos use their specialized bills to filter small organisms and particles from water and mud.",
                    ru = "Розовые фламинго используют особый клюв, чтобы отфильтровывать из воды и ила мелкие организмы и частицы пищи.",
                    uk = "Рожеві фламінго використовують спеціалізований дзьоб, щоб фільтрувати з води та мулу дрібні організми й частинки їжі."
                )
            )
        )
    )
}