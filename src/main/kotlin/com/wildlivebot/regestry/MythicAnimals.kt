package com.wildlivebot.regestry

import com.wildlivebot.model.Animal
import com.wildlivebot.model.AnimalType
import com.wildlivebot.model.Fact
import com.wildlivebot.model.Rarity
import com.wildlivebot.model.Region

object MythicAnimals {
    val list = listOf(
        Animal(
            id = "bearded_vulture",
            nameEn = "Bearded Vulture",
            nameRu = "Бородач",
            nameUk = "Бородач",
            aliasesEn = listOf("bearded vulture", "lammergeier", "bearded eagle"),
            aliasesRu = listOf("бородач", "ягнятник"),
            aliasesUk = listOf("бородач", "ягнятник"),
            rarity = Rarity.MYTHIC,
            imagePath = "/images/bearded_vulture.jpg",
            region = Region.MOUNTAINS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Bearded vultures inhabit mountain ranges across southern Europe, Africa, and Asia.",
                    ru = "Бородачи обитают в горных районах Южной Европы, Африки и Азии.",
                    uk = "Бородачі мешкають у гірських районах Південної Європи, Африки та Азії."
                ),
                Fact(
                    en = "Unlike most birds of prey, about 70–90% of their diet consists of bones. They drop large bones onto rocks to break them open and eat the nutritious marrow inside.",
                    ru = "В отличие от большинства хищных птиц, около 70–90% их рациона составляют кости. Крупные кости они сбрасывают на скалы, чтобы расколоть их и добраться до питательного костного мозга.",
                    uk = "На відміну від більшості хижих птахів, близько 70–90% їхнього раціону становлять кістки. Великі кістки вони скидають на скелі, щоб розбити їх і дістатися до поживного кісткового мозку."
                ),
                Fact(
                    en = "Bearded vultures have declined in many regions because of persecution, poisoning, and habitat loss. Protecting these remarkable birds is far better than harming them.",
                    ru = "Во многих регионах численность бородачей сократилась из-за преследования человеком, отравлений и утраты мест обитания. Эти удивительные птицы заслуживают защиты, а не уничтожения.",
                    uk = "У багатьох регіонах чисельність бородачів скоротилася через переслідування людиною, отруєння та втрату місць існування. Ці дивовижні птахи заслуговують на захист, а не на знищення."
                )
            )
        ),
        Animal(
            id = "blue_and_yellow_macaw",
            nameEn = "Blue-and-yellow Macaw",
            nameRu = "Сине-жёлтый ара",
            nameUk = "Синьо-жовтий ара",
            aliasesEn = listOf("blue-and-yellow macaw", "blue and yellow macaw"),
            aliasesRu = listOf("сине-жёлтый ара", "сине желтый ара"),
            aliasesUk = listOf("синьо-жовтий ара"),
            rarity = Rarity.MYTHIC,
            imagePath = "/images/blue_and_yellow_macaw.jpg",
            region = Region.TROPICAL_RAINFORESTS,
            hints = mapOf(
                "папуга" to "game.hint.parrot_generic",
                "попугай" to "game.hint.parrot_generic",
                "parrot" to "game.hint.parrot_generic",
                "ара" to "game.hint.parrot_generic",
                "macaw" to "game.hint.parrot_generic"
            ),
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Blue-and-yellow macaws inhabit the tropical rainforests and wetlands of South America.",
                    ru = "Сине-жёлтые ара обитают во влажных тропических лесах и заболоченных районах Южной Америки.",
                    uk = "Синьо-жовті ара мешкають у вологих тропічних лісах і заболочених районах Південної Америки."
                ),
                Fact(
                    en = "They are highly intelligent parrots capable of solving problems and using simple tools.",
                    ru = "Это очень умные попугаи, способные решать несложные задачи и использовать простые инструменты.",
                    uk = "Це дуже розумні папуги, здатні розв'язувати нескладні завдання та використовувати прості інструменти."
                ),
                Fact(
                    en = "They can imitate human speech remarkably well, but they usually do not understand language the way humans do. Instead, they learn to associate certain sounds with objects, people, or situations.",
                    ru = "Они способны очень точно повторять человеческую речь, но обычно не понимают язык так, как люди. Вместо этого они связывают отдельные слова и звуки с предметами, людьми или определёнными ситуациями.",
                    uk = "Вони здатні дуже точно наслідувати людську мову, але зазвичай не розуміють її так, як люди. Натомість вони пов'язують окремі слова й звуки з предметами, людьми або певними ситуаціями."
                )
            )
        ),
        Animal(
            id = "blue_whale",
            nameEn = "Blue Whale",
            nameRu = "Синий кит",
            nameUk = "Синій кит",
            aliasesEn = listOf("blue whale", "whale"),
            aliasesRu = listOf("синий кит", "кит"),
            aliasesUk = listOf("синій кит", "кит"),
            rarity = Rarity.MYTHIC,
            imagePath = "/images/blue_whale.jpg",
            region = Region.OCEANS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Blue whales are the largest animals known to have ever lived on Earth, reaching lengths of over 30 meters and weights exceeding 180 tons.",
                    ru = "Синие киты — крупнейшие животные из всех, когда-либо существовавших на Земле. Их длина превышает 30 метров, а масса может достигать более 180 тонн.",
                    uk = "Сині кити — найбільші тварини з усіх, що коли-небудь існували на Землі. Їхня довжина перевищує 30 метрів, а маса може сягати понад 180 тонн."
                ),
                Fact(
                    en = "They produce extremely low-frequency calls that can travel hundreds of kilometers through the ocean, helping them communicate with other whales across vast distances.",
                    ru = "Они издают очень низкочастотные звуки, способные распространяться на сотни километров под водой. Так киты поддерживают связь с сородичами на огромных расстояниях.",
                    uk = "Вони видають дуже низькочастотні звуки, які можуть поширюватися під водою на сотні кілометрів. Так кити підтримують зв'язок із родичами на величезних відстанях."
                ),
                Fact(
                    en = "The ancestors of whales once lived on land. They evolved from four-legged mammals closely related to modern even-toed ungulates, making hippos their closest living relatives.",
                    ru = "Предки китов когда-то жили на суше. Они произошли от четвероногих млекопитающих, тесно связанных с современными парнокопытными, а ближайшими ныне живущими родственниками китов считаются бегемоты.",
                    uk = "Предки китів колись жили на суходолі. Вони походять від чотириногих ссавців, тісно пов'язаних із сучасними парнокопитними, а найближчими сучасними родичами китів вважаються бегемоти."
                )
            )
        ),
        Animal(
            id = "pangolin",
            nameEn = "Pangolin",
            nameRu = "Панголин",
            nameUk = "Панголін",
            aliasesEn = listOf("pangolin", "scaly anteater"),
            aliasesRu = listOf("панголин", "ящер"),
            aliasesUk = listOf("панголін", "ящір"),
            rarity = Rarity.MYTHIC,
            imagePath = "/images/pangolin.jpg",
            region = Region.TROPICAL_RAINFORESTS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Pangolins are the world's only mammals completely covered in protective keratin scales.",
                    ru = "Панголины — единственные в мире млекопитающие, полностью покрытые защитной кератиновой чешуёй.",
                    uk = "Панголіни — єдині у світі ссавці, повністю вкриті захисною кератиновою лускою."
                ),
                Fact(
                    en = "When threatened, a pangolin curls into a tight ball. Its scales are so tough that they can protect it from most natural predators.",
                    ru = "При опасности панголин сворачивается в плотный шар. Его чешуя настолько прочная, что защищает его от большинства естественных хищников.",
                    uk = "У разі небезпеки панголін згортається у щільну кулю. Його луска настільки міцна, що захищає його від більшості природних хижаків."
                ),
                Fact(
                    en = "Despite their excellent natural armor, pangolins are the world's most illegally trafficked mammals. Protect them—never buy products made from their scales.",
                    ru = "Несмотря на превосходную природную броню, панголины — самые незаконно продаваемые млекопитающие в мире. Берегите их и никогда не покупайте изделия из их чешуи.",
                    uk = "Попри чудовий природний захист, панголіни є найбільш незаконно продаваними ссавцями у світі. Бережіть їх і ніколи не купуйте вироби з їхньої луски."
                )
            )
        ),
        Animal(
            id = "sperm_whale",
            nameEn = "Sperm Whale",
            nameRu = "Кашалот",
            nameUk = "Кашалот",
            aliasesEn = listOf("sperm whale", "cachalot"),
            aliasesRu = listOf("кашалот"),
            aliasesUk = listOf("кашалот"),
            rarity = Rarity.MYTHIC,
            imagePath = "/images/sperm_whale.jpg",
            region = Region.OCEANS,
            type = AnimalType.ANIMAL,
            facts = listOf(
                Fact(
                    en = "Sperm whales are the largest toothed predators on Earth, with males reaching over 16 meters in length.",
                    ru = "Кашалоты — крупнейшие зубатые хищники на Земле. Самцы могут достигать более 16 метров в длину.",
                    uk = "Кашалоти — найбільші зубаті хижаки на Землі. Самці можуть сягати понад 16 метрів завдовжки."
                ),
                Fact(
                    en = "They can dive to depths of more than 2,000 meters and remain underwater for over an hour while hunting giant squid.",
                    ru = "Они способны погружаться на глубину более 2000 метров и оставаться под водой свыше часа, охотясь на гигантских кальмаров.",
                    uk = "Вони здатні занурюватися на глибину понад 2000 метрів і залишатися під водою більше години, полюючи на гігантських кальмарів."
                ),
                Fact(
                    en = "The huge block in a sperm whale's head contains a waxy substance called spermaceti, which helps with echolocation and deep diving.",
                    ru = "Огромный орган в голове кашалота содержит особое вещество — спермацет, которое помогает при эхолокации и глубоководных погружениях.",
                    uk = "Величезний орган у голові кашалота містить особливу речовину — спермацет, яка допомагає під час ехолокації та глибоководних занурень."
                )
            )
        ),
        Animal(
            id = "kakapo",
            nameEn = "Kakapo",
            nameRu = "Какапо",
            nameUk = "Какапо",
            aliasesEn = listOf("kakapo", "owl parrot"),
            aliasesRu = listOf("какапо", "совиный попугай"),
            aliasesUk = listOf("какапо", "совиний папуга"),
            rarity = Rarity.MYTHIC,
            imagePath = "/images/kakapo.jpg",
            hints = mapOf(
                "папуга" to "game.hint.parrot_generic",
                "попугай" to "game.hint.parrot_generic",
                "parrot" to "game.hint.parrot_generic"
            ),
            region = Region.TEMPERATE_FORESTS,
            type = AnimalType.BIRD,
            facts = listOf(
                Fact(
                    en = "Kakapos are large nocturnal parrots found only in New Zealand.",
                    ru = "Какапо — крупные ночные попугаи, обитающие только в Новой Зеландии.",
                    uk = "Какапо — великі нічні папуги, що мешкають лише в Новій Зеландії."
                ),
                Fact(
                    en = "Unlike most parrots, kakapos cannot fly and are the heaviest parrots in the world.",
                    ru = "В отличие от большинства попугаев, какапо не умеют летать и являются самыми тяжёлыми попугаями в мире.",
                    uk = "На відміну від більшості папуг, какапо не вміють літати та є найважчими папугами у світі."
                ),
                Fact(
                    en = "Male kakapos produce deep booming calls that can travel several kilometers during the breeding season.",
                    ru = "В брачный период самцы какапо издают низкие гулкие звуки, которые можно услышать за несколько километров.",
                    uk = "У шлюбний період самці какапо видають низькі гулкі звуки, які можна почути за кілька кілометрів."
                )
            )
        )
    )
}