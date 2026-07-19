package com.wildlivebot.regestry

import com.wildlivebot.model.Animal
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.Fact
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.Region

object LegendaryAnimals {
    val list = listOf(
        Animal(
            id = "bandicoot",
            nameEn = "Bandicoot",
            nameRu = "Бандикут",
            nameUk = "Бандікут",
            aliasesEn = listOf("bandicoot"),
            aliasesRu = listOf("бандикут", "сумчатый барсук"),
            aliasesUk = listOf("бандікут", "сумчастий борсук"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/bandicoot.jpg",
            region = Region.TROPICAL_RAINFORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Bandicoots are ground-foraging marsupials that dig extensively in soil while searching for invertebrates.",
                    ru = "Бандикуты — наземные сумчатые, активно роющие почву в поисках беспозвоночных.",
                    uk = "Бандікути — наземні сумчасті, що активно риють ґрунт у пошуках безхребетних."
                ),
                Fact(
                    en = "Their gestation period is one of the shortest among mammals, lasting about 11–12 days.",
                    ru = "Беременность у бандикутов одна из самых коротких среди млекопитающих — около 11–12 дней.",
                    uk = "Вагітність у бандікутів одна з найкоротших серед ссавців — близько 11–12 днів."
                ),
                Fact(
                    en = "Their pouches face backward so they don't fill with dirt while digging.",
                    ru = "Их сумки открываются назад, чтобы внутрь не набивалась земля во время копания.",
                    uk = "Їхні сумки відкриваються назад, щоб усередину не набивалася земля під час копання."
                )
            )
        ),
        Animal(
            id = "african_lion",
            nameEn = "African Lion",
            nameRu = "Африканский лев",
            nameUk = "Африканський лев",
            aliasesEn = listOf("african lion", "lion"),
            aliasesRu = listOf("африканский лев", "лев"),
            aliasesUk = listOf("африканський лев", "лев", "левчик"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/lion.jpg",
            region = Region.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "A lion's roar is so loud it can be heard from up to 8 kilometers away.",
                    ru = "Рык льва настолько громкий, что слышен на расстоянии до 8 километров.",
                    uk = "Рік лева настільки гучний, що його чути на відстані до 8 кілометрів."
                ),
                Fact(
                    en = "Unlike other cats, they are highly social and live in family groups called prides.",
                    ru = "В отличие от других кошачьих, они социальны и живут большими семьями — прайдами.",
                    uk = "На відміну від інших котячих, вони є соціальними й живуть великими родинами — прайдами."
                ),
                Fact(
                    en = "Male lion manes vary in color and density, and are influenced by age, genetics, and environmental conditions.",
                    ru = "Цвет и густота гривы у львов зависят от возраста, генетики и условий среды.",
                    uk = "Колір і густота гриви у левів залежать від віку, генетики та умов середовища."
                )
            )
        ),
        Animal(
            id = "snow_leopard",
            nameEn = "Snow Leopard",
            nameRu = "Снежный барс",
            nameUk = "Сніговий барс",
            aliasesEn = listOf("snow leopard", "leopard"),
            aliasesRu = listOf("снежный барс", "ирбис", "барс"),
            aliasesUk = listOf("сніговий барс", "ірбіс", "барс"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/snow_leopard.jpg",
            region = Region.MOUNTAINS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Known as the 'ghost of the mountains' because they are incredibly well-camouflaged and solitary.",
                    ru = "Их называют «призраками гор», так как они идеально маскируются и живут в строгом одиночестве.",
                    uk = "Їх називають «привидами гір», оскільки вони ідеально маскуються і живуть у строгому усамітненні."
                ),
                Fact(
                    en = "Snow leopards cannot produce a true roar due to differences in their larynx anatomy compared to big roaring cats.",
                    ru = "Снежные барсы не способны рычать из-за особенностей строения гортани, отличающих их от «рычащих» крупных кошек.",
                    uk = "Снігові барси не здатні ричати через особливості будови гортані, які відрізняють їх від «рикуючих» великих котів."
                ),
                Fact(
                    en = "Their long, thick tails are used for balance and wrapped around their faces like a blanket for warmth.",
                    ru = "Длинный пушистый хвост служит им балансиром при прыжках и согревает морду в мороз как одеяло.",
                    uk = "Довгий пухнастий хвост служить їм балансиром при стрибках і зігріває морду в мороз як ковдра."
                )
            )
        ),
        Animal(
            id = "grizzly_bear",
            nameEn = "Grizzly Bear",
            nameRu = "Гризли",
            nameUk = "Ведмідь гризлі",
            aliasesEn = listOf("grizzly bear", "grizzly", "silvertip"),
            aliasesRu = listOf("гризли", "серый медведь", "медведь гризли"),
            aliasesUk = listOf("гризлі", "ведмідь гризлі"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/grizzly.jpg",
            region = Region.BOREAL_FORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Grizzlies have an incredible sense of smell, able to detect food sources from miles away, outperforming even hounds.",
                    ru = "У гризли невероятное обоняние — они чуют еду за многие километры, превосходя в этом даже ищеек.",
                    uk = "У гризлі неймовірний нюх — вони чують їжу за багато кілометрів, перевершуючи в цьому навіть шукачів."
                ),
                Fact(
                    en = "The shoulder hump is composed of muscle mass that supports digging and short bursts of running.",
                    ru = "Горб на плечах состоит из мышечной массы, которая помогает при рытье и коротких рывках бега.",
                    uk = "Горб на плечах складається з м’язової маси, яка допомагає при ритті та коротких ривках бігу."
                )
            )
        ),
        Animal(
            id = "cougar",
            nameEn = "Cougar",
            nameRu = "Пума",
            nameUk = "Пума",
            aliasesEn = listOf("cougar", "mountain lion", "puma", "panther"),
            aliasesRu = listOf("пума", "кугуар", "горный лев"),
            aliasesUk = listOf("пума", "кугуар", "гірський лев"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/cougar.jpg",
            region = Region.MOUNTAINS,
            hints = mapOf(
                "лев" to "game.hint.cougar_not_lion",
                "lion" to "game.hint.cougar_not_lion",
                "пантера" to "game.hint.cougar_not_panther",
                "panther" to "game.hint.cougar_not_panther"
            ),
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Cougars are known by many regional names across the Americas, reflecting their wide distribution.",
                    ru = "Пумы имеют множество региональных названий в Америке из-за широкого ареала обитания.",
                    uk = "Пуми мають багато регіональних назв в Америці через широкий ареал поширення."
                ),
                Fact(
                    en = "They are unmatched jumpers, capable of leaping up to 5.5 meters vertically into the air.",
                    ru = "Они непревзойденные прыгуны, способные взлетать по вертикали вверх почти на 5,5 метров.",
                    uk = "Вони є неперевершеними стрибунами, здатними злітати по вертикалі вгору майже на 5,5 метрів."
                )
            )
        ),
        Animal(
            id = "pink_fairy_armadillo",
            nameEn = "Pink Fairy Armadillo",
            nameRu = "Плащеносный броненосец",
            nameUk = "Плащеносець казковий",
            aliasesEn = listOf("pink fairy armadillo", "fairy armadillo", "pichiciego"),
            aliasesRu = listOf("плащеносный броненосец", "розовый броненосец", "сказочный броненосец", "малый броненосец"),
            aliasesUk = listOf("плащеносець казковий", "рожевий броненосець", "казковий броненосець", "плащеносець"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/pink_fairy_armadillo.jpg",
            region = Region.GRASSLANDS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "They are the smallest armadillos in the world, easily fitting into a human palm.",
                    ru = "Это самые крошечные броненосцы в мире, которые легко помещаются на ладони человека.",
                    uk = "Це найменші броненосці у світі, які легко поміщаються на долоні людини."
                ),
                Fact(
                    en = "Their vascularized shell helps with thermoregulation in sandy desert environments.",
                    ru = "Их панцирь с развитой сетью сосудов помогает регулировать температуру тела в песчаных пустынях.",
                    uk = "Їхній панцир із розвиненою мережею судин допомагає регулювати температуру тіла в піщаних пустелях."
                ),
                Fact(
                    en = "They are 'sand swimmers'—they can completely bury themselves in loose soil within seconds if startled.",
                    ru = "Их называют «песчаными пловцами» — испугавшись, они могут за секунды целиком зарыться в рыхлую землю.",
                    uk = "Їх називають «піщаними плавцями» — злякавшись, вони можуть за лічені секунди повністю заритися в пухку землю."
                )
            )
        ),
        Animal(
            id = "wolverine",
            nameEn = "Wolverine",
            nameRu = "Росомаха",
            nameUk = "Росомаха",
            aliasesEn = listOf("wolverine", "glutton"),
            aliasesRu = listOf("росомаха"),
            aliasesUk = listOf("росомаха"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/wolverine.jpg",
            region = Region.TEMPERATE_FORESTS,
            hints = mapOf(
                "барсук" to "game.hint.wolverine_not_badger",
                "badger" to "game.hint.wolverine_not_badger"
            ),
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Wolverines are highly aggressive and can defend kills against larger predators when necessary.",
                    ru = "Росомахи отличаются высокой агрессивностью и способны защищать добычу от более крупных хищников.",
                    uk = "Росомахи відрізняються високою агресивністю та здатні захищати здобич від більших хижаків."
                ),
                Fact(
                    en = "Their dense frost-resistant fur is unique because it doesn't trap moisture, preventing it from freezing.",
                    ru = "Их плотный мех уникален: он полностью отталкивает влагу, благодаря чему никогда не покрывается коркой льда.",
                    uk = "Їхнє щільне хутро унікальне: воно повністю відштовхує вологу, завдяки чому ніколи не покривається кіркою льоду."
                )
            )
        ),
        Animal(
            id = "european_bison",
            nameEn = "European Bison",
            nameRu = "Зубр",
            nameUk = "Зубр",
            aliasesEn = listOf("european bison", "wisent"),
            aliasesRu = listOf("зубр", "европейский бизон"),
            aliasesUk = listOf("зубр", "європейський бізон"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/european_bison.jpg",
            region = Region.TEMPERATE_FORESTS,
            hints = mapOf(
                "бизон" to "game.hint.wisent_not_bison",
                "bison" to "game.hint.wisent_not_bison",
                "american bison" to "game.hint.wisent_not_bison"
            ),
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "The European bison is the heaviest land animal in Europe, saved from total extinction through careful breeding programs.",
                    ru = "Зубр — самое тяжелое наземное животное Европы, которое удалось спасти от полного вымирания буквально в последний момент.",
                    uk = "Зубр — найважча наземна тварина Європи, яку вдалося врятувати від повного вимирання буквально в останній момент."
                ),
                Fact(
                    en = "They are strictly forest dwellers, unlike their open-plain American cousins.",
                    ru = "В отличие от американских сородичей, предпочитающих открытые прерии, зубры — исключительно лесные жители.",
                    uk = "На відміну від американських родичів, які віддають перевагу відкритим преріям, зубри — виключно лісові мешканці."
                )
            )
        ),
        Animal(
            id = "african_elephant",
            nameEn = "African Elephant",
            nameRu = "Африканский слон",
            nameUk = "Африканський слон",
            aliasesEn = listOf("african elephant", "elephant"),
            aliasesRu = listOf("африканский слон", "слон", "слоник"),
            aliasesUk = listOf("африканський слон", "слон", "слоник"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/african_elephant.jpg",
            region = Region.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Their trunks contain over 40,000 different muscles, allowing them to pick up a single blade of grass or knock down trees.",
                    ru = "Их хобот содержит более 40 000 различных мышц, что позволяет им поднимать как одну травинку, так и валить огромные деревья.",
                    uk = "Їхній хобот містить понад 40 000 різних м'язів, що дозволяє їм піднімати як одну травинку, так і валити величезні дерева."
                ),
                Fact(
                    en = "African elephants communicate using powerful low-frequency sounds that can travel several kilometers, allowing distant herds to stay in contact.",
                    ru = "Африканские слоны общаются с помощью мощных инфразвуковых сигналов, которые распространяются на несколько километров и позволяют стадам поддерживать связь на больших расстояниях.",
                    uk = "Африканські слони спілкуються за допомогою потужних інфразвукових сигналів, які поширюються на кілька кілометрів і дозволяють стадам підтримувати зв'язок на великих відстанях."
                ),
                Fact(
                    en = "They use their massive ears not just for hearing, but as air conditioners to cool down blood pumping through them.",
                    ru = "Они используют свои массивные уши как кондиционеры для охлаждения крови, циркулирующей по многочисленным сосудам.",
                    uk = "Вони використовують свої масивні вуха як кондиціонери для охолодження крові, що циркулює по численних судинах."
                ),
                Fact(
                    en = "African elephants have exceptional long-term memory. They can remember migration routes, water sources, and recognize other elephants even after many years.",
                    ru = "Африканские слоны обладают феноменальной долговременной памятью. Они запоминают маршруты миграций, водопои и узнают других слонов даже спустя многие годы.",
                    uk = "Африканські слони мають феноменальну довготривалу пам'ять. Вони запам'ятовують маршрути міграції, водопої та впізнають інших слонів навіть через багато років."
                ),
                Fact(
                    en = "Adult males periodically enter a state called musth, during which testosterone levels rise dramatically, making them far more aggressive and increasing their chances of mating.",
                    ru = "Взрослые самцы периодически входят в состояние, называемое муст. В это время уровень тестостерона резко возрастает, из-за чего они становятся значительно агрессивнее и получают больше шансов на размножение.",
                    uk = "Дорослі самці періодично входять у стан, який називається муст. У цей час рівень тестостерону різко зростає, через що вони стають значно агресивнішими та мають більше шансів на розмноження."
                )
            )
        ),
        Animal(
            id = "axolotl",
            nameEn = "Axolotl",
            nameRu = "Аксолотль",
            nameUk = "Аксолотль",
            aliasesEn = listOf("axolotl", "water dragon"),
            aliasesRu = listOf("аксолотль", "водяной дракон", "водяной дракончик", "аксик"),
            aliasesUk = listOf("аксолотль", "водяний дракон", "аксик"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/axolotl.jpg",
            region = Region.RIVERS_LAKES,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Axolotls are famous for their incredible healing powers, capable of perfectly regenerating lost limbs, tails, and even parts of their brains.",
                    ru = "Аксолотли знамениты своей невероятной регенерацией: они могут полностью восстанавливать утраченные лапы, хвост и даже части мозга.",
                    uk = "Аксолотлі знамениті своєю неймовірною регенерацією: вони можуть повністю відновлювати втрачені лапи, хвіст і навіть частини мозку."
                ),
                Fact(
                    en = "They retain their larval features their entire lives without ever undergoing full metamorphosis, a trait known as neoteny.",
                    ru = "Они всю жизнь сохраняют личиночный вид и не проходят через полноценное превращение во взрослую амфибию — это называется неотенией.",
                    uk = "Вони все життя зберігають личинковий вигляд і не проходять через повноцінне перетворення на дорослу амфібію — це називається неотенією."
                )
            )
        ),
        Animal(
            id = "polar_bear",
            nameEn = "Polar Bear",
            nameRu = "Белый медведь",
            nameUk = "Полярний ведмідь",
            aliasesEn = listOf("polar bear", "ice bear"),
            aliasesRu = listOf("белый медведь", "полярный медведь"),
            aliasesUk = listOf("полярний ведмідь", "білий ведмідь"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/polar_bear.jpg",
            region = Region.ARCTIC,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Underneath their thick white camouflage fur, polar bears actually have pitch-black skin to absorb heat from the sun.",
                    ru = "Под густым белым маскировочным мехом у белых медведей скрывается абсолютно чёрная кожа, помогающая поглощать солнечное тепло.",
                    uk = "Під густим білим маскувальним хутром у білих ведмедів ховається абсолютно чорна шкіра, що допомагає поглинати сонячне тепло."
                ),
                Fact(
                    en = "Polar bears are marine mammals in a biological sense due to their dependence on sea ice habitats and marine hunting.",
                    ru = "Белые медведи считаются морскими млекопитающими из-за зависимости от морского льда и морской добычи.",
                    uk = "Білі ведмеді вважаються морськими ссавцями через залежність від морського льоду та морського полювання."
                )
            )
        ),
        Animal(
            id = "ostrich",
            nameEn = "Common Ostrich",
            nameRu = "Обыкновенный страус",
            nameUk = "Страус звичайний",
            aliasesEn = listOf("common ostrich", "ostrich"),
            aliasesRu = listOf("обыкновенный страус", "страус"),
            aliasesUk = listOf("страус звичайний", "страус"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/ostrich.jpg",
            hints = mapOf(
                "ему" to "game.hint.ostrich_not_emu",
                "эму" to "game.hint.ostrich_not_emu",
                "emu" to "game.hint.ostrich_not_emu"
            ),
            region = Region.SAVANNAS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Contrary to a popular myth, ostriches do not bury their heads in the sand. They lower their heads to turn eggs, inspect nests, or search for food.",
                    ru = "Вопреки распространённому мифу, страусы не прячут голову в песок. Они опускают её к земле, чтобы переворачивать яйца, проверять гнездо или искать пищу.",
                    uk = "Попри поширений міф, страуси не ховають голову в пісок. Вони опускають її до землі, щоб перевертати яйця, перевіряти гніздо або шукати їжу."
                ),
                Fact(
                    en = "The common ostrich is the largest living bird in the world, reaching up to 2.7 meters in height.",
                    ru = "Обыкновенный страус — крупнейшая современная птица в мире, достигающая почти 2,7 метра в высоту.",
                    uk = "Страус звичайний — найбільший сучасний птах у світі, що сягає майже 2,7 метра заввишки."
                ),
                Fact(
                    en = "Although they cannot fly, ostriches can run at speeds of up to 70 km/h, making them the fastest birds on land.",
                    ru = "Несмотря на неспособность летать, страусы развивают скорость до 70 км/ч и являются самыми быстрыми птицами на суше.",
                    uk = "Попри нездатність літати, страуси розвивають швидкість до 70 км/год і є найшвидшими птахами на суходолі."
                )
            )
        ),
        Animal(
            id = "southern_cassowary",
            nameEn = "Southern Cassowary",
            nameRu = "Южный казуар",
            nameUk = "Південний казуар",
            aliasesEn = listOf("southern cassowary", "cassowary"),
            aliasesRu = listOf("южный казуар", "казуар"),
            aliasesUk = listOf("південний казуар", "казуар"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/southern_cassowary.jpg",
            region = Region.TROPICAL_RAINFORESTS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Southern cassowaries inhabit the tropical rainforests of northeastern Australia and New Guinea.",
                    ru = "Южные казуары обитают во влажных тропических лесах северо-востока Австралии и Новой Гвинеи.",
                    uk = "Південні казуари мешкають у вологих тропічних лісах північного сходу Австралії та Нової Гвінеї."
                ),
                Fact(
                    en = "Cassowaries are among the largest birds in the world and have a sharp claw on each foot that can reach up to 12 cm in length.",
                    ru = "Казуары — одни из крупнейших птиц в мире. На каждой ноге у них есть острый коготь длиной до 12 см.",
                    uk = "Казуари — одні з найбільших птахів у світі. На кожній нозі вони мають гострий кіготь завдовжки до 12 см."
                ),
                Fact(
                    en = "Female cassowaries lay striking emerald-green eggs, after which the male incubates them and raises the chicks alone.",
                    ru = "Самки казуаров откладывают удивительные изумрудно-зелёные яйца, после чего самец самостоятельно высиживает их и заботится о птенцах.",
                    uk = "Самки казуарів відкладають дивовижні смарагдово-зелені яйця, після чого самець самостійно висиджує їх і доглядає за пташенятами."
                )
            )
        ),
        Animal(
            id = "king_penguin",
            nameEn = "King Penguin",
            nameRu = "Королевский пингвин",
            nameUk = "Королівський пінгвін",
            aliasesEn = listOf("king penguin", "penguin"),
            aliasesRu = listOf("королевский пингвин", "пингвин"),
            aliasesUk = listOf("королівський пінгвін", "пінгвін"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/king_penguin.jpg",
            region = Region.ANTARCTICA,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "King penguins inhabit subantarctic islands and the cold waters surrounding Antarctica.",
                    ru = "Королевские пингвины обитают на субантарктических островах и в холодных водах, окружающих Антарктиду.",
                    uk = "Королівські пінгвіни мешкають на субантарктичних островах і в холодних водах навколо Антарктиди."
                ),
                Fact(
                    en = "King penguins do not build nests. Instead, they balance their single egg on their feet and keep it warm beneath a fold of skin.",
                    ru = "Королевские пингвины не строят гнёзд. Единственное яйцо они удерживают на лапах и согревают под специальной кожной складкой.",
                    uk = "Королівські пінгвіни не будують гнізд. Єдине яйце вони тримають на лапах і зігрівають під спеціальною шкірною складкою."
                ),
                Fact(
                    en = "Parents take turns caring for the egg and chick, sometimes traveling hundreds of kilometers across the ocean in search of food.",
                    ru = "Родители по очереди заботятся о яйце и птенце, иногда преодолевая сотни километров по океану в поисках пищи.",
                    uk = "Батьки по черзі доглядають за яйцем і пташеням, іноді долаючи сотні кілометрів океаном у пошуках їжі."
                )
            )
        ),
        Animal(
            id = "narwhal",
            nameEn = "Narwhal",
            nameRu = "Нарвал",
            nameUk = "Нарвал",
            aliasesEn = listOf("narwhal"),
            aliasesRu = listOf("нарвал", "морской единорог"),
            aliasesUk = listOf("нарвал", "морський єдиноріг"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/narwhal.jpg",
            region = Region.OCEANS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Narwhals inhabit the icy Arctic waters around Greenland, Canada, and Russia.",
                    ru = "Нарвалы обитают в холодных арктических водах у берегов Гренландии, Канады и России.",
                    uk = "Нарвали мешкають у холодних арктичних водах біля берегів Гренландії, Канади та Росії."
                ),
                Fact(
                    en = "The famous 'horn' of a narwhal is actually an elongated canine tooth that can grow up to 3 meters long and contains millions of nerve endings.",
                    ru = "Знаменитый «рог» нарвала на самом деле является сильно удлинённым клыком, который может достигать 3 метров в длину и содержит миллионы нервных окончаний.",
                    uk = "Знаменитий «ріг» нарвала насправді є сильно видовженим іклом, яке може сягати 3 метрів завдовжки та містить мільйони нервових закінчень."
                ),
                Fact(
                    en = "Because of their long tusk, narwhals have often been called the 'unicorns of the sea'.",
                    ru = "Из-за длинного бивня нарвалов часто называют «морскими единорогами».",
                    uk = "Через довгий бивень нарвалів часто називають «морськими єдинорогами»."
                )
            )
        ),
        Animal(
            id = "red_kangaroo",
            nameEn = "Red Kangaroo",
            nameRu = "Рыжий кенгуру",
            nameUk = "Рудий кенгуру",
            aliasesEn = listOf("red kangaroo", "kangaroo"),
            aliasesRu = listOf("рыжий кенгуру", "кенгуру"),
            aliasesUk = listOf("рудий кенгуру", "кенгуру"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/red_kangaroo.jpg",
            region = Region.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Red kangaroos are the largest marsupials in the world and inhabit the arid regions of Australia.",
                    ru = "Рыжие кенгуру — крупнейшие сумчатые животные на планете, обитающие в засушливых районах Австралии.",
                    uk = "Руді кенгуру — найбільші сумчасті тварини на планеті, що мешкають у посушливих районах Австралії."
                ),
                Fact(
                    en = "Male kangaroos are much larger and more muscular than females, often engaging in boxing matches to compete for mates.",
                    ru = "Самцы кенгуру значительно крупнее и мускулистее самок и часто устраивают «боксёрские» поединки за право спаривания.",
                    uk = "Самці кенгуру значно більші та мускулистіші за самок і часто влаштовують «боксерські» поєдинки за право спаровування."
                ),
                Fact(
                    en = "Large kangaroos can leap up to 3 meters high and more than 8 meters long in a single bound.",
                    ru = "Крупные кенгуру способны прыгать на высоту до 3 метров и преодолевать более 8 метров в длину одним прыжком.",
                    uk = "Великі кенгуру здатні стрибати на висоту до 3 метрів і долати понад 8 метрів у довжину одним стрибком."
                )
            )
        ),
        Animal(
            id = "palm_cockatoo",
            nameEn = "Palm Cockatoo",
            nameRu = "Пальмовый какаду",
            nameUk = "Пальмовий какаду",
            aliasesEn = listOf("palm cockatoo", "goliath cockatoo"),
            aliasesRu = listOf("пальмовый какаду", "чёрный какаду"),
            aliasesUk = listOf("пальмовий какаду", "чорний какаду"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/palm_cockatoo.jpg",
            hints = mapOf(
                "папуга" to "game.hint.parrot_generic",
                "попугай" to "game.hint.parrot_generic",
                "parrot" to "game.hint.parrot_generic"
            ),
            region = Region.TROPICAL_RAINFORESTS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Palm cockatoos inhabit the tropical forests of New Guinea and northern Australia.",
                    ru = "Пальмовые какаду обитают во влажных тропических лесах Новой Гвинеи и северной Австралии.",
                    uk = "Пальмові какаду мешкають у вологих тропічних лісах Нової Гвінеї та північної Австралії."
                ),
                Fact(
                    en = "They are the largest cockatoos in the world and are easily recognized by their huge crest and red facial skin.",
                    ru = "Это самые крупные какаду в мире, которых легко узнать по огромному хохлу и красным голым щекам.",
                    uk = "Це найбільші какаду у світі, яких легко впізнати за величезним чубом і червоними голими щоками."
                ),
                Fact(
                    en = "Palm cockatoos are among the few animals known to use tools to make music, drumming on tree trunks with sticks.",
                    ru = "Пальмовые какаду — одни из немногих животных, использующих инструменты для создания ритма: они барабанят палками по стволам деревьев.",
                    uk = "Пальмові какаду — одні з небагатьох тварин, що використовують інструменти для створення ритму: вони барабанять палицями по стовбурах дерев."
                )
            )
        ),
        Animal(
            id = "sable_antelope",
            nameEn = "Sable Antelope",
            nameRu = "Чёрная антилопа",
            nameUk = "Чорна антилопа",
            aliasesEn = listOf("sable antelope", "sable"),
            aliasesRu = listOf("чёрная антилопа", "черная антилопа"),
            aliasesUk = listOf("чорна антилопа"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/sable_antelope.jpg",
            hints = mapOf(
                "антилопа" to "game.hint.antelope_generic",
                "газель" to "game.hint.antelope_generic",
                "antelope" to "game.hint.antelope_generic",
                "gazelle" to "game.hint.antelope_generic"
            ),
            region = Region.SAVANNAS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Sable antelopes inhabit woodlands and savannas of eastern and southern Africa.",
                    ru = "Чёрные антилопы обитают в редколесьях и саваннах Восточной и Южной Африки.",
                    uk = "Чорні антилопи мешкають у рідколіссях і саванах Східної та Південної Африки."
                ),
                Fact(
                    en = "Both males and females possess impressive curved horns, but those of males can exceed 150 cm in length.",
                    ru = "И самцы, и самки имеют впечатляющие изогнутые рога, однако у самцов их длина может превышать 150 см.",
                    uk = "І самці, і самки мають вражаючі вигнуті роги, проте у самців їхня довжина може перевищувати 150 см."
                ),
                Fact(
                    en = "Sable antelopes are known for their courage and may aggressively defend themselves against predators, including lions.",
                    ru = "Чёрные антилопы известны своей смелостью и могут яростно защищаться даже от львов.",
                    uk = "Чорні антилопи відомі своєю сміливістю й можуть люто захищатися навіть від левів."
                )
            )
        ),
        Animal(
            id = "orca",
            nameEn = "Orca",
            nameRu = "Косатка",
            nameUk = "Косатка",
            aliasesEn = listOf("orca", "killer whale"),
            aliasesRu = listOf("косатка"),
            aliasesUk = listOf("косатка"),
            rarity = Rarity.LEGENDARY,
            imagePath = "/images/orca.jpg",
            region = Region.OCEANS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Orcas are the largest members of the dolphin family and can be found in every ocean on Earth.",
                    ru = "Косатки — крупнейшие представители семейства дельфиновых и встречаются во всех океанах Земли.",
                    uk = "Косатки — найбільші представники родини дельфінових і трапляються в усіх океанах Землі."
                ),
                Fact(
                    en = "Different populations of orcas specialize in different prey. Some hunt fish almost exclusively, while others prefer seals, dolphins, sharks, or even large whales.",
                    ru = "Разные популяции косаток специализируются на разной добыче. Одни питаются почти исключительно рыбой, тогда как другие охотятся на тюленей, дельфинов, акул и даже крупных китов.",
                    uk = "Різні популяції косаток спеціалізуються на різній здобичі. Одні харчуються майже виключно рибою, тоді як інші полюють на тюленів, дельфінів, акул і навіть великих китів."
                ),
                Fact(
                    en = "These hunting traditions are passed down through generations. Different groups of orcas have their own cultures, dialects, and hunting techniques.",
                    ru = "Все охотничьи традиции передаются из поколения в поколение. Разные группы косаток имеют собственную культуру, диалекты и уникальные способы охоты.",
                    uk = "Ці мисливські традиції передаються з покоління в покоління. Різні групи косаток мають власну культуру, діалекти та унікальні способи полювання."
                )
            )
        )
    )
}