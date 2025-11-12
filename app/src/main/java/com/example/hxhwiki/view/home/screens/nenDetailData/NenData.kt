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
    val nenTypes = listOf(
        NenType(
            title = "Enhancement",
            description = "Los Enhancers fortalecen sus habilidades físicas y ataques. Se caracterizan por su determinación y espíritu.",
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
            description = "Los Emmiters proyectan su aura a distancia. Son impulsivos y enérgicos.",
            users = listOf(
                NenUser("Leorio Paradinight", R.drawable.leorio),
                NenUser("Razor", R.drawable.razor)
            )
        ),
        NenType(
            title = "Transmutation",
            description = "Los Transmuters cambian la naturaleza de su aura. Son impredecibles y creativos.",
            users = listOf(
                NenUser("Killua Zoldyck", R.drawable.killua),
                NenUser("Hisoka Morow", R.drawable.hisoka)
            )
        ),
        NenType(
            title = "Manipulation",
            description = "Los Manipulators controlan objetos o personas con su aura. Son calculadores y metódicos.",
            users = listOf(
                NenUser("Shalnark", R.drawable.shalnark),
                NenUser("Zushi", R.drawable.zushi)
            )
        ),
        NenType(
            title = "Conjuration",
            description = "Los Conjurers crean objetos a partir de su aura. Son perfeccionistas y racionales.",
            users = listOf(
                NenUser("Kurapika", R.drawable.kurapika),
                NenUser("Kortopi", R.drawable.kortopi)
            )
        ),
        NenType(
            title = "Specialization",
            description = "Los Specialists poseen habilidades únicas e impredecibles. No se ajustan a ninguna categoría.",
            users = listOf(
                NenUser("Neon Nostrade", R.drawable.neon),
                NenUser("Chrollo Lucilfer", R.drawable.chrollo),
                NenUser("Kurapika(Ojos Escarlata)", R.drawable.kurapikascarleteyes)

            )
        )
    )
}
