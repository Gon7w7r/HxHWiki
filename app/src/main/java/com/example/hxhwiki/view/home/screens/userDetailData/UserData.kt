package com.example.hxhwiki.view.home.screens.userDetailData



import com.example.hxhwiki.R
import com.example.hxhwiki.data.NenUser

data class Character(
    val name: String,
    val age: String,
    val origin : String,
    val power: String,
    val goal: String,
    val imageRes: Int
)

object UserData {
    val characters = listOf(
        //POTENCIADORES
        Character("Gon Freecss", "14","Isla Ballena", "Jajanken", "Encontrar a su padre", R.drawable.gonactual),
        Character("Uvogin","29" ,"Ciudad Meteoro","Fuerza física sobrehumana","La búsqueda de batallas emocionantes y el fortalecimiento de su poder físico",R.drawable.uvogin),
        Character("Gido", "???","Coliseo del Cielo" ,"Trompo Tornado","Impedir que usuarios nuevos suban de piso en el coliseo del cielo",R.drawable.gido),
        Character("Palm Siberia","22 ", "Ciudad Meteoro","Clarividencia de Tritón", "Cumplir la misión de la Asociación de Cazadores",R.drawable.palm),
        Character("Isaac Netero","110 - 120 años", "Mundo Conocido","Guanyin de 100 Tipos","Exterminar a las hormigas quimera y a su rey, Meruem, para proteger a la humanidad.",R.drawable.netero),
        Character("Phinks","33","Ciudad Meteoro","Gran Fuerza y el segundo mas fuerte dentro de las arañas despues de Uvogin","Servir a las arañas",R.drawable.phinks),
        Character("Maha Zoldyck","98", "República de Padokia","Desconocido, pero el mas fuerte de la familia Zoldyck", "Ser un asesino extremadamente hábil",R.drawable.maha),
        Character("Wing", "30","Desconocido","Domina los principios del Nen","Asegurarse de que sus estudiantes aprendan a manejar el nen de manera responsable y segura",R.drawable.wing),
        Character("Nobunaga", "32","Desconocido", "Maestro Espadachin","Vengar la muerte de su compañero", R.drawable.nobunaga),
        Character("Menthunthuyoupi", "40 dias","Continente de NGL","Explosion de Furia","Servir al Rey Meruem",R.drawable.menthuthuyoupi),
        Character("Tsezguerra", "40 - 50","no se ha revelado su habilidad Nen específica","No se ha revelado su habilidad Nen específica","Es considerado un Cazador Jackpot, un cazador que solo busca ganar dinero.",R.drawable.tsezguerra),
        Character("Rabid Dog", "???", "Desconocido","Incrementar la velocidad y la fuerza de su mandíbula.","Reclamar la recompensa puesta por la cabeza de las arañas",R.drawable.rabiddog),



        //EMISORES


        Character("Leorio Paradinight", "19", "Ciudad desconocida", "Emisión (Golpe Remoto)", "Convertirse en un doctor y ayudar a quienes lo necesitan", R.drawable.leorio),
        Character("Razor", "Desconocido", "Dentro del juego Greed Island", "Habilidades basadas en Emitir, especialmente control de bolas y fuerza bruta", "Cumplir su rol como Game Master de Greed Island", R.drawable.razor),
        Character("Bat", "Desconocido", "NGL", "Control aéreo y velocidad)", "servir a las hormigas quimera", R.drawable.bat),
        Character("Bloster", "Desconocido", "NGL", "Tiro de proyectiles con alta precisión", "Servir a Meruem como guardia de élite", R.drawable.bloster),
        Character("Franklin Bordeau", "Desconocido (30-40 aprox.)", "Ciudad Meteoro", "Machine Gun Nen (emitir balas desde sus dedos)", "Servir al Ryodan (Tropa Fantasma)", R.drawable.franklin),
        Character("Goreinu", "Desconocido", "Desconocido", "Invocación: gorilas creados con Nen", "Ganar en Greed Island y mejorar su habilidad Nen", R.drawable.goreinu),
        Character("Izunavi", "Desconocido", "Desconocido", "Transmisión (Instructor experto de Kurapika)", "Entrenar usuarios de Nen y cumplir misiones de Cazador", R.drawable.izunavi),
        Character("Knuckle Vine", "Desconocido (20+)", "Desconocido", "Hakoware (Ability: PotClean)", "Proteger a los débiles y cumplir misiones como Cazador", R.drawable.knuckle),
        Character("Montreux", "Desconocido", "Continente desconocido", "Desconocido", "Cumplir su misión como Cazador y sobrevivir", R.drawable.montreux),
        Character("Pokkle", "Desconocido (15-20)", "Desconocido", "Transmutación: Flechas nen con efectos especiales", "Convertirse en un Cazador profesional y estudiar criaturas", R.drawable.pokkle),
        Character("Riehlvelt", "Desconocido", "Coliseo del Cielo", "Equipo eléctrico para tortura y combate", "Ascender en el Coliseo del Cielo", R.drawable.riehlvelt),
        Character("Shachmono Tocino", "Desconocido", "Desconocido", "Controlar muñecos-soldados al emitir Nen dentro de globos", "Proteger a Neon Nostrade", R.drawable.schachmono),


        //TRANSMUTACION
        Character("Killua Zoldyck", "14","Montaña Kukuroo", "Electricidad (Transmutación)", "Ser libre de su familia", R.drawable.killua),
        Character("Hisoka Morow", "28","Glam Gastland", "Bungee Gum", "Peleas interesantes", R.drawable.hisoka),
        Character("Biscuit Krueger", "57", "Desconocido", "Transformación física (Refuerzo + Manipulación) y conocimiento avanzado del Nen", "Entrenar a usuarios de Nen y perfeccionar sus habilidades", R.drawable.biscuit),
        Character("Feitan Portor", "Desconocido", "Desconocido (posible Ciudad Meteoro)", "Pain Packer: Ryūseigun (Retribución)", "Servir a las Arañas y vengar a sus compañeros", R.drawable.feitan),
        Character("Machi Komachine", "24", "Ciudad Meteoro", "Hilos de Nen (Transmutación)", "Cumplir misiones del Ryodan y proteger a Chrollo", R.drawable.machi),
        Character("Porcupine", "Desconocido", "NGL", "Transformación en erizo humano, ataque con púas", "Reclamar la recompensa puesta por la cabeza de las arañas", R.drawable.porcupine),
        Character("Sadaso", "Desconocido", "Coliseo del Cielo", "Manipulación (extorsión usando Nen en sus extremidades)", "Ascender en el Coliseo y obtener poder", R.drawable.sadaso),
        Character("Silva Zoldyck", "Desconocido (40-50)", "Montaña Kukuroo", "Orbes de Nen (posible Emisión + Transmutación)", "Dirigir a la familia Zoldyck y cumplir misiones de asesinato", R.drawable.silva),
        Character("Worm", "Desconocido", "Ciudad Meteoro", "Enterrarse y desplazarse bajo tierra", "Reclamar la recompensa puesta por la cabeza de las arañas", R.drawable.worm),
        Character("Zazan", "Desconocido", "NGL", "Transformación: forma monstruosa con aumento extremo de fuerza", "Convertirse en Reina y crear su propio reino", R.drawable.zazan),
        Character("Zeno Zoldyck", "67", "Montaña Kukuroo", "Dragón de Nen (Emisión + Manipulación)", "Cumplir misiones de asesino profesional y entrenar a su familia", R.drawable.zeno),


        //MANIPULADORES
        Character("Baise", "22", "Desconocido", "Amor Incondicional (Manipulación)", "Trabajar como Cazadora Profesional usando su habilidad de control", R.drawable.baise),
        Character("Boki", "Desconocido", "NGL", "Desconocido", "Servir a Zazan", R.drawable.boki),
        Character("Hiru", "Desconocido", "Ciudad Meteoro", "Desconocido", "Reclamar la recompensa puesta por la cabeza de las arañas", R.drawable.hiru),
        Character("Illumi Zoldyck", "24", "Montaña Kukuroo", "Agujas de Manipulación (Manipulación)", "Cumplir misiones de asesinato y fortalecer el legado Zoldyck", R.drawable.illumi),
        Character("Kalluto Zoldyck", "10", "Montaña Kukuroo", "Manipulación con papel (Shikigami)", "Volverse más fuerte y superar a sus hermanos", R.drawable.kalluto),
        Character("Kikyo Zoldyck", "Desconocido", "Montaña Kukuroo", "Desconocido", "Supervisar a sus hijos y apoyar la tradición asesina de la familia", R.drawable.kikyo),
        Character("Morel Mackernasey", "Desconocido (40+)", "Desconocido", "Deep Purple (Manipulación de humo)", "Detener a las Hormigas Quimera y cumplir su rol como Cazador", R.drawable.morel),
        Character("Shaiapouf", "Desconocido", "NGL", "Manipulación y Emisión (poderes emocionales + clones)", "Servir al Rey Meruem", R.drawable.shaiapouf),
        Character("Shalnark", "17", "Ciudad Meteoro", "Antena de Control (Manipulación)", "Servir al Ryodan y analizar situaciones complejas", R.drawable.shalnark),
        Character("Shoot McMahon", "Desconocido (30+)", "Desconocido", "Cajas aislantes + manos invisibles (Materialización + Manipulación)", "Derrotar a las Hormigas Quimera y superar sus miedos", R.drawable.shoot),
        Character("Squala", "Desconocido", "Yorknew City", "Control de perros (Manipulación)", "Proteger a Neon Nostrade", R.drawable.squala),
        Character("Togari", "Desconocido", "Desconocido", "Dominio de shuriken giratorios", "Servir como Cazador Profesional", R.drawable.togari),
        Character("Zushi", "10", "Desconocido", "Principios básicos de Nen (Refuerzo)", "Convertirse en un maestro del Nen bajo Wing", R.drawable.zushi),


                //CONJURADORES


        Character("Kite", "Desconocido (20+)", "Desconocido", "Crazy Slots (Materialización)", "Explorar el mundo como Cazador y entrenar a Gon", R.drawable.kite),
        Character("Kortopi", "Desconocido", "Ciudad Meteoro", "Doble de Objetos (Materialización)", "Servir al Ryodan", R.drawable.kortopi),
        Character("Kurapika", "17", "Tribu Kurta", "Habilidades de Cadenas (Especialización + varias ramas de Nen)", "Vengar a su clan y recuperar los Ojos Escarlata", R.drawable.kurapika),
        Character("Abengane", "Desconocido", "Desconocido", "Exorcismo Nen (Especialización)", "Eliminar maldiciones de Nen y cumplir su rol como Cazador", R.drawable.abengane),
        Character("Cheetu", "Desconocido", "NGL", "Velocidad extrema (refuerzo + mutación)", "Volverse más fuerte para impresionar al Rey", R.drawable.cheetu),
        Character("Genthru", "Desconocido", "Desconocido", "Little Flower (Explosión por toque)", "Ganar Greed Island y convertirse en su vencedor", R.drawable.genthru),
        Character("Owl", "Desconocido", "Desconocido", "Materialización: Caja Transportadora (Transport Box)", "Reclamar la recompensa puesta por la cabeza de las arañas", R.drawable.owl),
        Character("Shizuku Murasaki", "19–21", "Ciudad Meteoro", "Deme-chan (Aspiradora Nen)", "Servir al Ryodan", R.drawable.shizuku),
        Character("Tsubone", "Desconocido (50+)", "Desconocido", "Máquina Transformable (Transformación)", "Proteger a la familia Zoldyck", R.drawable.tsubone),
        Character("Welfin", "Desconocido", "NGL", "Missileman (Misiles de Nen guiados por emoción)", "Encontrar su pasado y libertad", R.drawable.welfin),


        //ESPECIALISTAS

        Character("Alluka Zoldyck", "7-10", "Montaña Kukuroo", "Nanika (Entidad externa con habilidades de deseo)", "Vivir libre y protegida de la familia Zoldyck", R.drawable.alluka),
        Character("Binolt", "Desconocido", "Desconocido", "Sentidos hipersensibles y técnicas de seguimiento", "Capturar presas para sobrevivir como asesino", R.drawable.binolt),
        Character("Chrollo Lucilfer", "26", "Ciudad Meteoro", "Skill Hunter (Robar habilidades Nen)", "Liderar al Ryodan y cumplir objetivos del grupo", R.drawable.chrollo),
        Character("Leol", "Desconocido", "NGL", "Rental Pod (Alquilar habilidades Nen)", "Ser reconocido como líder poderoso entre las Hormigas Quimera", R.drawable.leol),
        Character("Meleoron", "Desconocido", "NGL", "Perfect Plan (Invisibilidad total sin emitir Nen)", "Derrotar al Rey y vengar a su amigo Pegya", R.drawable.meleoron),
        Character("Meruem", "40 días", "NGL", "Fuerza extrema + Adaptación + Aura superior", "Entender la humanidad y proteger a Komugi", R.drawable.meruem),
        Character("Neferpitou", "Desconocido", "NGL", "Doctor Blythe / Terpsichora (Especialización)", "Servir al Rey Meruem", R.drawable.neferpitou),
        Character("Neon Nostrade", "16", "Ciudad Yorknew", "Lovely Ghostwriter (Predicciones exactas)", "Vivir libremente sin preocupaciones", R.drawable.neon),
        Character("Pakunoda", "Desconocido (20+)", "Ciudad Meteoro", "Lectura de recuerdos (Especialización)", "Proteger al Ryodan y transmitir información a Chrollo", R.drawable.pakunoda),
        Character("Kurapika (Ojos Escarlata)", "17", "Tribu Kurta", "Cadena Escarlata (Especialización con las emociones)", "Vengar a su clan y capturar al Ryodan", R.drawable.kurapikascarleteyes)

    )
}
