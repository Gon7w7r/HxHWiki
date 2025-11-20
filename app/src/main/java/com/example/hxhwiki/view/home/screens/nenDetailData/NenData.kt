package com.example.hxhwiki.data

import com.example.hxhwiki.R

data class NenUser(
    val name: String,
    val imageRes: Int
)

data class NenType(
    val title: String,
    val description: String,
    val users: List<NenUser>
)

object NenData {
    //Usuarios de la lista nen
    //comment
    val nenTypes = listOf(
        NenType(
            title = "Enhancement",
            description = "Los Enhancers o potenciadores tienen la habilidad de usar el aura para incrementar las habilidades de un objeto o el propio cuerpo. Por lo tanto, los potenciadores son capaces de aumentar en gran medida su ataque físico y defensa, y son los más adecuados para el combate cuerpo a cuerpo.",
            users = listOf(
                NenUser("Gon Freecss", R.drawable.gonactual),
                NenUser("Uvogin", R.drawable.uvogin),
                NenUser("Gido", R.drawable.gido),
                NenUser("Palm Siberia", R.drawable.palm),
                NenUser("Isaac Netero", R.drawable.netero),
                NenUser("Phinks", R.drawable.phinks),
                NenUser("Maha Zoldyck", R.drawable.maha),
                NenUser("Wing", R.drawable.wing),
                NenUser("Nobunaga", R.drawable.nobunaga),
                NenUser("Menthunthuyoupi", R.drawable.menthuthuyoupi),
                NenUser("Tsezguerra", R.drawable.tsezguerra),
                NenUser("Rabid Dog", R.drawable.rabiddog),
            )
        ),
        NenType(
            title = "Emission",
            description = "Los Emmiters o emisores les resulta más fácil separar su aura de su cuerpo. Debido a sus propiedades, la Emisión se emplea típicamente en habilidades con énfasis en el alcance y/o aquellas que tienen efectos duraderos. Las aplicaciones básicas incluyen disparar proyectiles o rayos de aura a alta velocidad.",
            users = listOf(
                NenUser("Leorio Paradinight", R.drawable.leorio),
                NenUser("Razor", R.drawable.razor),
                NenUser("Bat", R.drawable.bat),
                NenUser("Bloster", R.drawable.bloster),
                NenUser("Franklin Bordeau", R.drawable.franklin),
                NenUser("Goreinu", R.drawable.goreinu),
                NenUser("Izunavi", R.drawable.izunavi),
                NenUser("Knuckle Vine", R.drawable.knuckle),
                NenUser("Montreux", R.drawable.montreux),
                NenUser("Pokkle", R.drawable.pokkle),
                NenUser("Riehlvelt", R.drawable.riehlvelt),
                NenUser("Shachmono Tocino", R.drawable.schachmono)

            )
        ),
        NenType(
            title = "Transmutation",
            description = "Los Transmuters o transmutadors pueden cambiar las propiedades de su aura para imitar algo diferente o replicar atributos específicos. El aura transmutada puede adoptar las propiedades de elementos naturales, sustancias artificiales e incluso animales, entre otras cosas.",
            users = listOf(
                NenUser("Killua Zoldyck", R.drawable.killua),
                NenUser("Hisoka Morow", R.drawable.hisoka),
                NenUser("Biscuit Krueger", R.drawable.biscuit),
                NenUser("Feitan Portor", R.drawable.feitan),
                NenUser("Machi Komachine", R.drawable.machi),
                NenUser("Porcupine", R.drawable.porcupine),
                NenUser("Sadaso", R.drawable.sadaso),
                NenUser("Silva Zoldyck", R.drawable.silva),
                NenUser("Worm", R.drawable.worm),
                NenUser("Zazan", R.drawable.zazan),
                NenUser("Zeno Zoldyck", R.drawable.zeno)
            )
        ),
        NenType(
            title = "Manipulation",
            description = "Los Manipulators o manipuladores pueden controlar seres vivos e inertes, incluyendo construcciones de aura. La principal ventaja de esta categoría en combate es la capacidad de manipular al propio enemigo.",
            users = listOf(
                NenUser("Shalnark", R.drawable.shalnark),
                NenUser("Zushi", R.drawable.zushi) ,
                NenUser("Baise", R.drawable.baise),
                NenUser("Boki", R.drawable.boki),
                NenUser("Hiru", R.drawable.hiru),
                NenUser("Illumi Zoldyck", R.drawable.illumi),
                NenUser("Kalluto Zoldyck", R.drawable.kalluto),
                NenUser("Kikyo Zoldyck", R.drawable.kikyo),
                NenUser("Morel Mackernasey", R.drawable.morel),
                NenUser("Shaiapouf", R.drawable.shaiapouf),
                NenUser("Shoot McMahon", R.drawable.shoot),
                NenUser("Squala", R.drawable.squala),
                NenUser("Togari", R.drawable.togari),

            )
        ),
        NenType(
            title = "Conjuration",
            description = "Los Conjurers o conjuradores, crean objetos a partir de su aura. Son perfeccionistas y racionales. En la mayoría de los casos, la Conjuración implica la creación de un objeto físico, independiente y material a partir del aura.",
            users = listOf(
                NenUser("Kurapika", R.drawable.kurapika),
                NenUser("Kortopi", R.drawable.kortopi),
                NenUser("Kite", R.drawable.kite),
                NenUser("Abengane", R.drawable.abengane),
                NenUser("Cheetu", R.drawable.cheetu),
                NenUser("Genthru", R.drawable.genthru),
                NenUser("Owl", R.drawable.owl),
                NenUser("Shizuku Murasaki", R.drawable.shizuku),
                NenUser("Tsubone", R.drawable.tsubone),
                NenUser("Welfin", R.drawable.welfin),


            )
        ),
        NenType(
            title = "Specialization",
            description = "Los Specialists o especicalistas, en términos generales, poseen cualquier habilidad que no pertenezca a ninguna de las otras cinco categorías, lo que la convierte en el tipo de Nen más impreciso. También parece ser el más raro. los Especialistas no están limitados por afinidades como otros usuarios de Nen, por lo que pueden combinar múltiples tipos de Nen.",
            users = listOf(
                NenUser("Neon Nostrade", R.drawable.neon),
                NenUser("Chrollo Lucilfer", R.drawable.chrollo),
                NenUser("Kurapika (Ojos Escarlata)", R.drawable.kurapikascarleteyes),
                NenUser("Alluka Zoldyck", R.drawable.alluka),
                NenUser("Binolt", R.drawable.binolt),
                NenUser("Leol", R.drawable.leol),
                NenUser("Meleoron", R.drawable.meleoron),
                NenUser("Meruem", R.drawable.meruem),
                NenUser("Neferpitou", R.drawable.neferpitou),
                NenUser("Pakunoda", R.drawable.pakunoda),



        )
        )
    )
}
