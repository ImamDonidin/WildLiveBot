package com.wildlivebot.registry

import com.wildlivebot.model.Animal
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.Fact
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.Biome

object CommonAnimals {
    val list = listOf(
        Animal(
            id = "capybara",
            nameEn = "Capybara",
            nameRu = "Капибара",
            nameUk = "Капібара",
            aliasesEn = listOf("capybara", "capy", "carpincho"),
            aliasesRu = listOf("капибара", "капи"),
            aliasesUk = listOf("капібара", "капі", "капібарка"),
            rarity = Rarity.COMMON,
            imagePath = "/images/capybara.jpg",
            biome = Biome.TROPICAL_RAINFORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Capybaras are the largest living rodents, native to South America, and are closely associated with aquatic habitats.",
                    ru = "Капибары — крупнейшие современные грызуны, обитающие в Южной Америке и тесно связанные с водной средой.",
                    uk = "Капібари — найбільші сучасні гризуни Південної Америки, тісно пов’язані з водними середовищами."
                ),
                Fact(
                    en = "They are semi-aquatic herbivores that use water bodies for thermoregulation and predator avoidance.",
                    ru = "Это полуводные травоядные животные, использующие воду для терморегуляции и защиты от хищников.",
                    uk = "Це напівводні травоїдні тварини, що використовують воду для терморегуляції та захисту від хижаків."
                ),
                Fact(
                    en = "Capybaras are highly social animals living in stable groups with complex social interactions.",
                    ru = "Капибары — социальные животные, живущие в устойчивых группах со сложными взаимодействиями.",
                    uk = "Капібари — соціальні тварини, що живуть у стабільних групах зі складними взаємодіями."
                )
            )
        ),
        Animal(
            id = "red_fox",
            nameEn = "Red Fox",
            nameRu = "Рыжая лисица",
            nameUk = "Руда лисиця",
            aliasesEn = listOf("red fox", "fox"),
            aliasesRu = listOf("рыжая лисица", "лисица", "лиса", "лиска"),
            aliasesUk = listOf("руда лисиця", "лисиця", "лисичка", "лиса"),
            rarity = Rarity.COMMON,
            imagePath = "/images/red_fox.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The red fox is the most widely distributed wild canid, occurring across the entire Northern Hemisphere and parts of North Africa.",
                    ru = "Рыжая лисица — самый широко распространённый дикий представитель псовых в Северном полушарии и частично в Северной Африке.",
                    uk = "Руда лисиця — найпоширеніший дикий представник псових у Північній півкулі та частково в Північній Африці."
                ),
                Fact(
                    en = "It is an opportunistic omnivore with a highly variable diet depending on habitat and season.",
                    ru = "Это всеядный оппортунист с очень изменчивым рационом в зависимости от среды и сезона.",
                    uk = "Це всеїдний опортуніст із дуже змінним раціоном залежно від середовища та сезону."
                ),
                Fact(
                    en = "Red foxes use acute hearing to detect small prey movements, including sounds beneath snow cover.",
                    ru = "Лисицы используют острый слух для обнаружения мелкой добычи, включая звуки под снегом.",
                    uk = "Лисиці використовують гострий слух для виявлення дрібної здобичі, включно зі звуками під снігом."
                )
            )
        ),
        Animal(
            id = "raccoon",
            nameEn = "Raccoon",
            nameRu = "Енот",
            nameUk = "Єнот",
            aliasesEn = listOf("raccoon", "coon"),
            aliasesRu = listOf("енот", "енотик"),
            aliasesUk = listOf("єнот", "єнотик", "ракун"),
            rarity = Rarity.COMMON,
            imagePath = "/images/raccoon.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Raccoons are native to North America and are highly adaptable omnivores that thrive in diverse habitats, including urban environments.",
                    ru = "Еноты родом из Северной Америки и являются адаптивными всеядными, успешно живущими в различных средах, включая города.",
                    uk = "Єноти походять із Північної Америки та є адаптивними всеїдними, що успішно живуть у різних середовищах, включно з містами."
                ),
                Fact(
                    en = "They possess highly dexterous forepaws with enhanced tactile sensitivity used for manipulating objects.",
                    ru = "У них очень ловкие передние лапы с высокой тактильной чувствительностью для манипуляции объектами.",
                    uk = "Вони мають дуже спритні передні лапи з високою тактильною чутливістю для маніпуляції об’єктами."
                ),
                Fact(
                    en = "Raccoons are primarily nocturnal and often exploit human-related food resources.",
                    ru = "Еноты преимущественно ночные животные и часто используют пищевые ресурсы, связанные с человеком.",
                    uk = "Єноти переважно нічні тварини та часто використовують харчові ресурси, пов’язані з людиною."
                )
            )
        ),
        Animal(
            id = "striped_skunk",
            nameEn = "Striped Skunk",
            nameRu = "Полосатый скунс",
            nameUk = "Смугастий скунс",
            aliasesEn = listOf("striped skunk", "skunk"),
            aliasesRu = listOf("полосатый скунс", "скунс"),
            aliasesUk = listOf("смугастий скунс", "скунс"),
            rarity = Rarity.COMMON,
            imagePath = "/images/striped_skunk.jpg",
            biome = Biome.GRASSLANDS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Striped skunks are native to North America and are known for their chemical defense system involving sulfur-containing spray.",
                    ru = "Полосатые скунсы обитают в Северной Америке и известны химической защитой с серосодержащим секретом.",
                    uk = "Смугасті скунси мешкають у Північній Америці та відомі хімічним захистом із сірковмісним секретом."
                ),
                Fact(
                    en = "They typically display warning behaviors such as stamping and tail raising before spraying.",
                    ru = "Перед распылением они обычно демонстрируют предупреждающее поведение: топот и поднятие хвоста.",
                    uk = "Перед розпиленням вони зазвичай демонструють попереджувальну поведінку: тупіт і підняття хвоста."
                ),
                Fact(
                    en = "The spray is an effective deterrent against predators and can cause temporary irritation and disorientation.",
                    ru = "Секрет служит эффективной защитой от хищников, вызывая временное раздражение и дезориентацию.",
                    uk = "Секрет є ефективним захистом від хижаків, спричиняючи тимчасове подразнення та дезорієнтацію."
                )
            )
        ),
        Animal(
            id = "european_hedgehog",
            nameEn = "European Hedgehog",
            nameRu = "Обыкновенный ёж",
            nameUk = "Їжак європейський",
            aliasesEn = listOf("european hedgehog", "hedgehog", "hoglet"),
            aliasesRu = listOf("обыкновенный ёж", "ёж", "ёжик", "ежик"),
            aliasesUk = listOf("їжак європейський", "їжак", "їжачок"),
            rarity = Rarity.COMMON,
            imagePath = "/images/european_hedgehog.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The European hedgehog is a nocturnal insectivorous mammal native to Europe.",
                    ru = "Обыкновенный ёж — ночное насекомоядное млекопитающее Европы.",
                    uk = "Європейський їжак — нічний комахоїдний ссавець Європи."
                ),
                Fact(
                    en = "Its spines are modified hairs made of keratin, used as a passive defense mechanism.",
                    ru = "Иглы представляют собой видоизменённые кератиновые волосы, выполняющие защитную функцию.",
                    uk = "Голки є видозміненими кератиновими волосинами, що виконують захисну функцію."
                ),
                Fact(
                    en = "It has an omnivorous diet dominated by invertebrates such as insects and earthworms.",
                    ru = "Рацион всеядный, но в основном состоит из беспозвоночных, таких как насекомые и черви.",
                    uk = "Раціон всеїдний, але переважно складається з безхребетних, таких як комахи та черви."
                )
            )
        ),
        Animal(
            id = "meerkat",
            nameEn = "Meerkat",
            nameRu = "Сурикат",
            nameUk = "Сурикат",
            aliasesEn = listOf("meerkat", "suricate"),
            aliasesRu = listOf("сурикат", "сурикатик"),
            aliasesUk = listOf("сурикат", "сурикатик"),
            rarity = Rarity.COMMON,
            imagePath = "/images/meerkat.jpg",
            biome = Biome.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Meerkats are small carnivorous mammals native to southern Africa.",
                    ru = "Сурикаты — небольшие хищные млекопитающие юга Африки.",
                    uk = "Сурикати — невеликі хижі ссавці півдня Африки."
                ),
                Fact(
                    en = "They live in social groups with cooperative care of young.",
                    ru = "Они живут в социальных группах и совместно заботятся о потомстве.",
                    uk = "Вони живуть у соціальних групах і спільно доглядають за потомством."
                ),
                Fact(
                    en = "They stand upright as sentries to watch for predators.",
                    ru = "Они встают вертикально, выполняя функцию дозорных.",
                    uk = "Вони стають вертикально, виконуючи роль дозорців."
                )
            )
        ),
        Animal(
            id = "european_hare",
            nameEn = "European Hare",
            nameRu = "Заяц-русак",
            nameUk = "Заєць сірий",
            aliasesEn = listOf("european hare", "hare", "jackrabbit"),
            aliasesRu = listOf("заяц-русак", "заяц", "зайчик", "заяц русак", "русак"),
            aliasesUk = listOf("заєць сірий", "заєць", "зайчик", "заєць-русак", "вухань"),
            rarity = Rarity.COMMON,
            imagePath = "/images/european_hare.jpg",
            hints = mapOf(
                "кролик" to "game.hint.rabbit_not_hare",
                "кроль" to "game.hint.rabbit_not_hare",
                "rabbit" to "game.hint.rabbit_not_hare",
                "bunny" to "game.hint.rabbit_not_hare"
            ),
            biome = Biome.GRASSLANDS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The European hare is a fast-running lagomorph adapted to open landscapes and does not construct permanent burrows.",
                    ru = "Заяц-русак — быстрый зайцеобразный, приспособленный к открытым ландшафтам и не роющий постоянных нор.",
                    uk = "Заєць-русак — швидкий зайцеподібний, пристосований до відкритих ландшафтів і не риє постійних нір."
                ),
                Fact(
                    en = "Leverets are born fully furred, with open eyes and are capable of locomotion shortly after birth.",
                    ru = "Зайчата рождаются покрытыми шерстью, зрячими и способными к движению вскоре после рождения.",
                    uk = "Зайченята народжуються вкритими шерстю, зрячими та здатними до руху невдовзі після народження."
                ),
                Fact(
                    en = "Hares rely on speed, endurance, and evasive zigzag running to escape predators.",
                    ru = "Зайцы используют скорость, выносливость и зигзагообразный бег для ухода от хищников.",
                    uk = "Зайці використовують швидкість, витривалість і біг зигзагами для втечі від хижаків."
                )
            )
        ),
        Animal(
            id = "european_rabbit",
            nameEn = "European Rabbit",
            nameRu = "Дикий кролик",
            nameUk = "Дикий кріль",
            aliasesEn = listOf("european rabbit", "rabbit", "bunny"),
            aliasesRu = listOf("дикий кролик", "кролик", "кроль", "кролик"),
            aliasesUk = listOf("дикий кріль", "кріль", "кролик", "кролик"),
            rarity = Rarity.COMMON,
            imagePath = "/images/european_rabbit.png",
            biome = Biome.GRASSLANDS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The European rabbit is a burrowing lagomorph that lives in complex underground warrens.",
                    ru = "Дикий кролик — норный зайцеобразный, живущий в сложных подземных колониях.",
                    uk = "Дикий кріль — нірний зайцеподібний, що живе у складних підземних колоніях."
                ),
                Fact(
                    en = "Kits are born altricial, blind and hairless, requiring significant parental care.",
                    ru = "Крольчата рождаются беспомощными, слепыми и без шерсти, нуждаются в заботе родителей.",
                    uk = "Кроленята народжуються безпомічними, сліпими та без шерсті, потребують батьківського догляду."
                ),
                Fact(
                    en = "Rabbits are social animals that communicate using scent marking and body language.",
                    ru = "Кролики — социальные животные, использующие запахи и язык тела для общения.",
                    uk = "Кролі — соціальні тварини, що спілкуються за допомогою запахів і мови тіла."
                )
            )
        ),
        Animal(
            id = "guinea_pig",
            nameEn = "Guinea Pig",
            nameRu = "Морская свинка",
            nameUk = "Морська свинка",
            aliasesEn = listOf("guinea pig", "cavy"),
            aliasesRu = listOf("морская свинка", "свинка"),
            aliasesUk = listOf("морська свинка", "кавія", "свинка"),
            rarity = Rarity.COMMON,
            imagePath = "/images/guinea_pig.jpg",
            biome = Biome.GRASSLANDS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Guinea pigs are domesticated herbivorous rodents native to the Andes of South America.",
                    ru = "Морские свинки — одомашненные травоядные грызуны, родом из Анд Южной Америки.",
                    uk = "Морські свинки — одомашнені травоїдні гризуни з Анд Південної Америки."
                ),
                Fact(
                    en = "They communicate using a wide range of vocalizations including whistles, chirps, and purr-like sounds.",
                    ru = "Они используют широкий спектр звуков: свисты, щебетание и урчание.",
                    uk = "Вони використовують широкий спектр звуків: свист, щебетання та муркотіння."
                ),
                Fact(
                    en = "Unlike most mammals, they require dietary vitamin C as they cannot synthesize it endogenously.",
                    ru = "В отличие от большинства млекопитающих, они нуждаются в витамине C из пищи.",
                    uk = "На відміну від більшості ссавців, вони потребують вітаміну C з їжі."
                )
            )
        ),
        Animal(
            id = "harbor_seal",
            nameEn = "Harbor Seal",
            nameRu = "Обыкновенный тюлень",
            nameUk = "Тюлень звичайний",
            aliasesEn = listOf("harbor seal", "seal", "common seal"),
            aliasesRu = listOf("обыкновенный тюлень", "тюлень", "нерпа"),
            aliasesUk = listOf("тюлень звичайний", "тюлень", "нерпа"),
            rarity = Rarity.COMMON,
            imagePath = "/images/harbor_seal.jpg",
            biome = Biome.OCEANS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Harbor seals are true seals native to coastal waters of the North Atlantic and North Pacific oceans.",
                    ru = "Обыкновенные тюлени — настоящие тюлени, обитающие в прибрежных водах Северной Атлантики и Тихого океана.",
                    uk = "Звичайні тюлені — справжні тюлені, що мешкають у прибережних водах Північної Атлантики та Тихого океану."
                ),
                Fact(
                    en = "They are strong swimmers and can dive for extended periods, typically several minutes up to half an hour.",
                    ru = "Они сильные пловцы и могут нырять на продолжительное время — обычно от нескольких минут до получаса.",
                    uk = "Вони сильні плавці й можуть пірнати на тривалий час — зазвичай від кількох хвилин до пів години."
                ),
                Fact(
                    en = "Harbor seals haul out on land or ice to rest, molt, and reproduce.",
                    ru = "Тюлени выходят на сушу или лёд для отдыха, линьки и размножения.",
                    uk = "Тюлені виходять на сушу або лід для відпочинку, линьки та розмноження."
                ),
                Fact(
                    en = "Harbor seals sometimes slap the surface of the water with their bellies or flippers to communicate with other seals, especially during the breeding season.",
                    ru = "Обыкновенные тюлени иногда громко хлопают животом или ластами по поверхности воды, общаясь с другими тюленями, особенно в период размножения.",
                    uk = "Звичайні тюлені іноді голосно ляскають животом або ластами по поверхні води, спілкуючись з іншими тюленями, особливо під час сезону розмноження."
                )
            )
        ),
        Animal(
            id = "house_sparrow",
            nameEn = "House Sparrow",
            nameRu = "Домовый воробей",
            nameUk = "Горобець хатній",
            aliasesEn = listOf(
                "house sparrow",
                "sparrow"
            ),
            aliasesRu = listOf(
                "домовый воробей",
                "воробей",
                "воробушек"
            ),
            aliasesUk = listOf(
                "горобець хатній",
                "горобець",
                "горобчик"
            ),
            rarity = Rarity.COMMON,
            imagePath = "/images/house_sparrow.jpg",
            biome = Biome.GRASSLANDS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Male and female house sparrows look noticeably different: males have a black bib and gray crown, while females are mostly brown.",
                    ru = "Самцы и самки домовых воробьёв заметно отличаются внешне: у самцов есть чёрное пятно на груди и серая «шапочка», а самки окрашены в основном в коричневые тона.",
                    uk = "Самці й самки хатнього горобця помітно відрізняються зовні: у самців є чорна пляма на грудях і сіра «шапочка», а самки переважно бурого кольору."
                ),
                Fact(
                    en = "House sparrows have lived alongside humans for thousands of years and are one of the world's most widespread birds.",
                    ru = "Домовые воробьи сопровождают человека уже тысячи лет и являются одними из самых широко распространённых птиц в мире.",
                    uk = "Хатні горобці живуть поруч із людиною вже тисячі років і є одними з найпоширеніших птахів світу."
                ),
                Fact(
                    en = "Although small, they are highly social birds that communicate using a wide variety of chirps and calls.",
                    ru = "Несмотря на небольшой размер, это очень общительные птицы, использующие множество различных чириканий и других звуков для общения.",
                    uk = "Попри невеликий розмір, це дуже товариські птахи, які використовують безліч різних цвірінькань та інших звуків для спілкування."
                )
            )
        ),
        Animal(
            id = "rock_pigeon",
            nameEn = "Rock Pigeon",
            nameRu = "Сизый голубь",
            nameUk = "Сизий голуб",
            aliasesEn = listOf("rock pigeon", "pigeon", "common pigeon"),
            aliasesRu = listOf("сизый голубь", "голубь", "дикий голубь", "голуб"),
            aliasesUk = listOf("сизий голуб", "голуб", "дикий голуб"),
            rarity = Rarity.COMMON,
            imagePath = "/images/rock_pigeon.jpg",
            biome = Biome.CLIFFS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "The rock pigeon is the wild ancestor of all domestic and feral pigeons found in cities around the world.",
                    ru = "Сизый голубь — дикий предок всех домашних и городских голубей, встречающихся по всему миру.",
                    uk = "Сизий голуб — дикий предок усіх свійських і міських голубів, яких можна зустріти по всьому світу."
                ),
                Fact(
                    en = "Rock pigeons have excellent navigation abilities and can return to their nests from hundreds of kilometers away.",
                    ru = "Сизые голуби обладают превосходной ориентацией и способны возвращаться к своему гнезду с расстояния в сотни километров.",
                    uk = "Сизі голуби мають чудову здатність орієнтуватися та можуть повертатися до свого гнізда з відстані у сотні кілометрів."
                ),
                Fact(
                    en = "Both parents produce a nutritious substance called crop milk to feed their chicks during the first days of life.",
                    ru = "Оба родителя вырабатывают особое «голубиное молочко», которым кормят птенцов в первые дни жизни.",
                    uk = "Обоє батьків виробляють особливе «голубине молочко», яким годують пташенят у перші дні життя."
                )
            )
        ),
        Animal(
            id = "thomsons_gazelle",
            nameEn = "Thomson's Gazelle",
            nameRu = "Газель Томсона",
            nameUk = "Газель Томсона",
            aliasesEn = listOf(
                "thomson's gazelle",
                "thomsons gazelle",
                "gazelle",
                "thomson gazelle"
            ),
            aliasesRu = listOf(
                "газель томсона",
                "газель",
                "газель томпсона"
            ),
            aliasesUk = listOf(
                "газель томсона",
                "газель"
            ),
            rarity = Rarity.COMMON,
            imagePath = "/images/thomsons_gazelle.jpg",
            biome = Biome.SAVANNAS,
            hints = mapOf(
                "антилопа" to "game.hint.antelope_generic",
                "antelope" to "game.hint.antelope_generic"
            ),
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Thomson's gazelles are among the fastest land mammals and can reach speeds of up to 80 km/h (50 mph).",
                    ru = "Газели Томсона — одни из самых быстрых наземных млекопитающих. Они способны развивать скорость до 80 км/ч.",
                    uk = "Газелі Томсона — одні з найшвидших наземних ссавців. Вони здатні розвивати швидкість до 80 км/год."
                ),
                Fact(
                    en = "When threatened, they perform high, springing jumps called stotting, which may confuse predators and demonstrate their fitness.",
                    ru = "При опасности они совершают высокие прыжки, называемые стоттингом. Такое поведение может сбивать хищников с толку и демонстрировать отличную физическую форму.",
                    uk = "У разі небезпеки вони виконують високі стрибки, що називаються стотингом. Така поведінка може збивати хижаків з пантелику та демонструвати чудову фізичну форму."
                ),
                Fact(
                    en = "They are an important prey species for lions, cheetahs, leopards, and many other African predators.",
                    ru = "Они являются одной из основных жертв львов, гепардов, леопардов и многих других африканских хищников.",
                    uk = "Вони є однією з основних здобичей левів, гепардів, леопардів та багатьох інших африканських хижаків."
                )
            )
        ),
        Animal(
            id = "black_winged_stilt",
            nameEn = "Black-winged Stilt",
            nameRu = "Ходулочник",
            nameUk = "Ходуличник",
            aliasesEn = listOf("black-winged stilt", "stilt"),
            aliasesRu = listOf("ходулочник"),
            aliasesUk = listOf("ходуличник"),
            rarity = Rarity.COMMON,
            imagePath = "/images/black_winged_stilt.jpg",
            biome = Biome.WETLANDS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Black-winged stilts inhabit shallow wetlands, marshes, and lake shores across much of the world.",
                    ru = "Ходулочники обитают на мелководных болотах, озёрах и других водно-болотных угодьях во многих частях света.",
                    uk = "Ходуличники мешкають на мілководних болотах, озерах та інших водно-болотних угіддях у багатьох куточках світу."
                ),
                Fact(
                    en = "Their legs are among the longest relative to body size of any bird, allowing them to wade through shallow water with ease.",
                    ru = "Их ноги — одни из самых длинных относительно размеров тела среди всех птиц, что позволяет им легко передвигаться по мелководью.",
                    uk = "Їхні ноги — одні з найдовших відносно розміру тіла серед усіх птахів, що дозволяє їм легко пересуватися мілководдям."
                ),
                Fact(
                    en = "They feed by carefully picking insects, crustaceans, and other small aquatic animals from the water's surface or mud.",
                    ru = "Они осторожно собирают с поверхности воды и ила насекомых, ракообразных и других мелких водных животных.",
                    uk = "Вони обережно збирають з поверхні води та мулу комах, ракоподібних та інших дрібних водних тварин."
                )
            )
        ),
        Animal(
            id = "greater_egyptian_jerboa",
            nameEn = "Greater Egyptian Jerboa",
            nameRu = "Большой египетский тушканчик",
            nameUk = "Великий єгипетський тушканчик",
            aliasesEn = listOf("greater egyptian jerboa", "egyptian jerboa", "jerboa"),
            aliasesRu = listOf("большой египетский тушканчик", "египетский тушканчик", "тушканчик"),
            aliasesUk = listOf("великий єгипетський тушканчик", "єгипетський тушканчик", "тушканчик"),
            rarity = Rarity.COMMON,
            imagePath = "/images/greater_egyptian_jerboa.jpg",
            biome = Biome.DESERTS_SEMIDESERTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Greater Egyptian jerboas inhabit the deserts and semi-deserts of North Africa and the Middle East, where they spend the daytime in underground burrows.",
                    ru = "Большие египетские тушканчики обитают в пустынях и полупустынях Северной Африки и Ближнего Востока, проводя день в подземных норах.",
                    uk = "Великі єгипетські тушканчики мешкають у пустелях і напівпустелях Північної Африки та Близького Сходу, проводячи день у підземних норах."
                ),
                Fact(
                    en = "They travel by long, kangaroo-like jumps and can leap several meters in a single bound while using their tail for balance.",
                    ru = "Они передвигаются длинными прыжками, словно миниатюрные кенгуру, и используют хвост для удержания равновесия.",
                    uk = "Вони пересуваються довгими стрибками, немов крихітні кенгуру, і використовують хвіст для підтримання рівноваги."
                ),
                Fact(
                    en = "Their enormous ears provide excellent hearing and help release excess body heat, an important adaptation for surviving in hot deserts.",
                    ru = "Их огромные уши обеспечивают превосходный слух и помогают отводить лишнее тепло — важное приспособление для жизни в жаркой пустыне.",
                    uk = "Їхні величезні вуха забезпечують чудовий слух і допомагають відводити зайве тепло — важливе пристосування для життя в спекотній пустелі."
                )
            )
        ),
        Animal(
            id = "woodcock",
            nameEn = "Eurasian Woodcock",
            nameRu = "Вальдшнеп",
            nameUk = "Вальдшнеп",
            aliasesEn = listOf("eurasian woodcock", "woodcock"),
            aliasesRu = listOf("вальдшнеп"),
            aliasesUk = listOf("вальдшнеп"),
            rarity = Rarity.COMMON,
            imagePath = "/images/woodcock.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "The Eurasian woodcock is a forest-dwelling wading bird found across Europe and Asia.",
                    ru = "Вальдшнеп — лесная болотная птица, широко распространённая в Европе и Азии.",
                    uk = "Вальдшнеп — лісовий болотний птах, поширений у Європі та Азії."
                ),
                Fact(
                    en = "Its long sensitive bill helps it locate and extract earthworms and other invertebrates from soft soil.",
                    ru = "Длинный чувствительный клюв помогает ему находить и доставать дождевых червей и других беспозвоночных из мягкой почвы.",
                    uk = "Довгий чутливий дзьоб допомагає йому знаходити та діставати дощових черв'яків та інших безхребетних із м'якого ґрунту."
                ),
                Fact(
                    en = "Woodcocks walk with a distinctive bobbing motion that helps them detect prey hidden in the soil.",
                    ru = "Вальдшнепы ходят характерной покачивающейся походкой, которая помогает им обнаруживать добычу, скрытую в почве.",
                    uk = "Вальдшнепи ходять характерною похитуючою ходою, яка допомагає їм виявляти здобич, приховану в ґрунті."
                ),
                Fact(
                    en = "Their calls have become an internet meme, as some people compare the sounds they make to the word 'meep'.",
                    ru = "Их голос стал интернет-мемом, поскольку некоторые люди сравнивают издаваемые ими звуки со словом «мип».",
                    uk = "Їхній голос став інтернет-мемом, оскільки дехто порівнює звуки, які вони видають, зі словом «міп»."
                )
            )
        ),
        Animal(
            id = "european_ground_squirrel",
            nameEn = "European Ground Squirrel",
            nameRu = "Европейский суслик",
            nameUk = "Європейський ховрах",
            aliasesEn = listOf("european ground squirrel", "ground squirrel", "suslik"),
            aliasesRu = listOf("европейский суслик", "суслик"),
            aliasesUk = listOf("європейський ховрах", "ховрах", "суслик"),
            rarity = Rarity.COMMON,
            imagePath = "/images/european_ground_squirrel.jpg",
            biome = Biome.GRASSLANDS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "European ground squirrels inhabit steppes, meadows, and grasslands, where they live in extensive burrow systems.",
                    ru = "Европейские суслики обитают в степях, лугах и открытых травянистых местностях, где роют сложные системы нор.",
                    uk = "Європейські ховрахи мешкають у степах, луках і відкритих трав'янистих місцевостях, де риють складні системи нір."
                ),
                Fact(
                    en = "When danger approaches, they emit loud alarm calls that warn other members of the colony.",
                    ru = "При появлении опасности они издают громкие тревожные сигналы, предупреждая остальных членов колонии.",
                    uk = "При появі небезпеки вони видають гучні тривожні сигнали, попереджаючи інших членів колонії."
                ),
                Fact(
                    en = "European ground squirrels spend several months in hibernation during winter to survive periods of cold and food scarcity.",
                    ru = "Зимой европейские суслики впадают в длительную спячку, которая может продолжаться несколько месяцев.",
                    uk = "Взимку європейські ховрахи впадають у тривалу сплячку, яка може тривати кілька місяців."
                )
            )
        ),
        Animal(
            id = "springbok",
            nameEn = "Springbok",
            nameRu = "Спрингбок",
            nameUk = "Спрингбок",
            aliasesEn = listOf("springbok"),
            aliasesRu = listOf("спрингбок"),
            aliasesUk = listOf("спрингбок"),
            rarity = Rarity.COMMON,
            imagePath = "/images/springbok.jpg",
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
                    en = "Springboks are medium-sized antelopes native to southern Africa.",
                    ru = "Спрингбоки — антилопы среднего размера, обитающие на юге Африки.",
                    uk = "Спрингбоки — антилопи середнього розміру, що мешкають на півдні Африки."
                ),
                Fact(
                    en = "When excited or alarmed, they perform spectacular leaps called pronking, reaching heights of over 3 meters.",
                    ru = "При возбуждении или тревоге они совершают эффектные прыжки, называемые пронкингом, поднимаясь более чем на 3 метра.",
                    uk = "Коли вони збуджені або стривожені, то виконують видовищні стрибки, що називаються пронкінгом, підіймаючись більш ніж на 3 метри."
                ),
                Fact(
                    en = "The springbok is the national animal of South Africa.",
                    ru = "Спрингбок является национальным животным Южно-Африканской Республики.",
                    uk = "Спрингбок є національною твариною Південно-Африканської Республіки."
                )
            )
        ),
        Animal(
            id = "llama",
            nameEn = "Llama",
            nameRu = "Лама",
            nameUk = "Лама",
            aliasesEn = listOf("llama"),
            aliasesRu = listOf("лама"),
            aliasesUk = listOf("лама"),
            rarity = Rarity.COMMON,
            imagePath = "/images/llama.jpg",
            biome = Biome.MOUNTAINS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Llamas are domesticated camelids native to the Andes Mountains of South America, where they have served as pack animals for thousands of years.",
                    ru = "Ламы — одомашненные представители семейства верблюдовых, обитающие в Андах Южной Америки. Уже тысячи лет они используются людьми как вьючные животные.",
                    uk = "Лами — одомашнені представники родини верблюдових, що мешкають в Андах Південної Америки. Уже тисячі років вони використовуються людьми як в'ючні тварини."
                ),
                Fact(
                    en = "When annoyed or threatened, llamas spit a mixture of saliva and stomach contents to warn rivals or predators.",
                    ru = "Если лама раздражена или чувствует угрозу, она может плюнуть смесью слюны и содержимого желудка, отпугивая соперников или хищников.",
                    uk = "Якщо лама роздратована або відчуває загрозу, вона може плюнути сумішшю слини й вмісту шлунка, відлякуючи суперників або хижаків."
                ),
                Fact(
                    en = "Unlike camels, llamas do not have humps. They store fat throughout their bodies instead of in a hump.",
                    ru = "В отличие от верблюдов, у лам нет горбов. Запасы жира распределяются по всему телу, а не накапливаются в одном месте.",
                    uk = "На відміну від верблюдів, лами не мають горбів. Запаси жиру розподіляються по всьому тілу, а не накопичуються в одному місці."
                )
            )
        ),
        Animal(
            id = "virginia_opossum",
            nameEn = "Virginia Opossum",
            nameRu = "Опоссум виргинский",
            nameUk = "Опосум віргінський",
            aliasesEn = listOf(
                "virginia opossum",
                "opossum",
                "common opossum"
            ),
            aliasesRu = listOf(
                "опоссум виргинский",
                "опоссум",
                "опосум"
            ),
            aliasesUk = listOf(
                "опосум віргінський",
                "опосум",
                "віргінський опосум"
            ),
            rarity = Rarity.COMMON,
            imagePath = "/images/virginia_opossum.jpg",
            biome = Biome.TEMPERATE_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The Virginia opossum is the only marsupial native to the United States and Canada.",
                    ru = "Опоссум виргинский — единственный сумчатый, естественный ареал которого охватывает США и Канаду.",
                    uk = "Опосум віргінський — єдиний сумчастий, природний ареал якого охоплює США та Канаду."
                ),
                Fact(
                    en = "Virginia opossums are opportunistic omnivores that eat a wide variety of foods, including insects, fruits, small vertebrates, and carrion.",
                    ru = "Опоссумы виргинские — всеядные оппортунисты, питающиеся насекомыми, плодами, мелкими позвоночными и падалью.",
                    uk = "Віргінські опосуми — всеїдні опортуністи, що живляться комахами, плодами, дрібними хребетними та падаллю."
                ),
                Fact(
                    en = "When threatened, a Virginia opossum may enter an involuntary state of apparent death, commonly known as 'playing possum'.",
                    ru = "При угрозе опоссум виргинский может впасть в непроизвольное состояние, при котором выглядит мёртвым. Такое поведение обычно называют «притвориться мёртвым».",
                    uk = "У разі загрози віргінський опосум може мимоволі впасти у стан, за якого виглядає мертвим. Таку поведінку зазвичай називають «прикинутися мертвим»."
                ),
                Fact(
                    en = "Newborn Virginia opossums are extremely small and continue developing inside their mother's pouch after birth.",
                    ru = "Новорождённые опоссумы виргинские чрезвычайно малы и продолжают развиваться в сумке матери после рождения.",
                    uk = "Новонароджені віргінські опосуми надзвичайно малі й продовжують розвиватися в сумці матері після народження."
                )
            )
        )
    )
}