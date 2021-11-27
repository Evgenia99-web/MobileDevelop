/*
Film - порождающий паттерн с фабричним методом, который позволяет получить
информацию о фильме по жанру.
*/

/*
Film используется для выбора информации фильма по его жанру.
*/


import java.lang.IllegalArgumentException

interface Film{
    fun getInfo();
    fun director();
    fun actors():
}

enum class Genre{
    Horror, Drama, Comedy
}

class FilmFactory{
    companion object{
        fun createFilm(genre: Genre): Film = when (genre){
            Genre.Comedy -> object: Film{
                private val title = "Гарфилд"
                override fun director() { println( "Питер Хьюит") }
                override fun getInfo() { println("Хозяин кота Гарфилда Джон приносит домой милого щенка Оди, и с этого момента жизнь Гарфилда идёт наперекосяк. ") }
                override fun actors() { println("Билл Мюррей, Стивен Тоболовски") }
            }
            Genre.Drama -> object: Film{
                private val title = "Титаник"
                override fun director() { println( "Джеймс Кэмерон") }
                override fun getInfo() { println("В первом и последнем плавании шикарного «Титаника» встречаются двое.") }
                override fun actors() { println("Леонардо ДиКаприо, Кейт Уинслет") }
            }
            Genre.Horror -> object: Film{
                private val title = "Корабль-призрак"
                override fun director() { println("Стив Бек") }
                override fun getInfo() { println("В отдаленной части Берингова моря команда спасателей обнаруживает огромный пассажирский лайнер, который считается пропавшим уже 40 лет.") }
                override fun actors() { println("Джулианна Маргулис, Десмонд Хэррингтон") }
            }
        }
    }
}

fun main(args : Array<String>){

    val film = FilmFactory.createFilm(Genre.Drama)

    println("Director info: ")
    film.director()
    println("Actors info: ")
    film.actors()
    println("Film info: ")
    film.getInfo()
}
