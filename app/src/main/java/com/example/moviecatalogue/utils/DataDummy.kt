package com.example.moviecatalogue.utils

import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.Film

object DataDummy {
    private lateinit var movies: ArrayList<Film>
    private lateinit var shows: ArrayList<Film>

    fun generateDataMovies(): List<Film> {
        movies = ArrayList()

        movies.add(
            Film(
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2019",
                arrayListOf(
                    "Rosa Salazar",
                    "Christoph Waltz",
                    "Jennifer Connelly",
                    "Mahershala Ali",
                    "Ed Skrein"
                ),
                "Released",
                "English",
                R.drawable.poster_alita,
                0
            )
        )

        movies.add(
            Film(
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2018",
                arrayListOf(
                    "Jason Momoa",
                    "Amber Heard",
                    "Willem Dafoe",
                    "Patrick Wilson",
                    "Nicole Kidman"
                ),
                "Released",
                "English",
                R.drawable.poster_aquaman,
                0
            )
        )

        movies.add(
            Film(
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2018",
                arrayListOf(
                    "Rami Malek",
                    "Gwilym Lee",
                    "Ben Hardy",
                    "Joseph Mazzello",
                    "Lucy Boynton"
                ),
                "Released",
                "English",
                R.drawable.poster_bohemian,
                0
            )
        )

        movies.add(
            Film(
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "2019",
                arrayListOf(
                    "Liam Neeson",
                    "Laura Dern",
                    "Emmy Rossum",
                    "Michael Eklund",
                    "Micheál Richardson"
                ),
                "Released",
                "English",
                R.drawable.poster_cold_persuit,
                0
            )
        )

        movies.add(
            Film(
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018",
                arrayListOf(
                    "Eddie Redmayne",
                    "Katherine Waterston",
                    "Dan Fogler",
                    "Alison Sudol",
                    "Johnny Depp"
                ),
                "Released",
                "English",
                R.drawable.poster_crimes,
                0
            )
        )

        movies.add(
            Film(
                "How to Train Your Dragon",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father.",
                "2010",
                arrayListOf(
                    "Jay Baruchel",
                    "Gerard Butler",
                    "Craig Ferguson",
                    "America Ferrera",
                    "Jonah Hill"
                ),
                "Released",
                "English",
                R.drawable.poster_how_to_train,
                0
            )
        )

        movies.add(
            Film(
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018",
                arrayListOf(
                    "Robert Downey Jr.",
                    "Chris Hemsworth",
                    "Mark Ruffalo",
                    "Chris Evans",
                    "Scarlett Johansson"
                ),
                "Released",
                "English",
                R.drawable.poster_infinity_war,
                0
            )
        )

        movies.add(
            Film(
                "Wreck-It Ralph",
                "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
                "2012",
                arrayListOf(
                    "John C. Reilly",
                    "Sarah Silverman",
                    "Jack McBrayer",
                    "Jane Lynch",
                    "Ed O'Neill"
                ),
                "Released",
                "English",
                R.drawable.poster_ralph,
                0
            )
        )

        movies.add(
            Film(
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "2018",
                arrayListOf(
                    "Taron Egerton",
                    "Jamie Foxx",
                    "Ben Mendelsohn",
                    "Eve Hewson",
                    "Jamie Dornan"
                ),
                "Released",
                "English",
                R.drawable.poster_robin_hood,
                0
            )
        )

        movies.add(
            Film(
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "2018",
                arrayListOf(
                    "Shameik Moore",
                    "Jake Johnson",
                    "Hailee Steinfeld",
                    "Mahershala Ali",
                    "Brian Tyree Henry"
                ),
                "Released",
                "English",
                R.drawable.poster_spiderman,
                0
            )
        )

        return movies
    }

    fun generateDataShows(): List<Film> {
        shows = ArrayList()

        shows.add(
            Film(
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012",
                arrayListOf(
                    "Stephen Amell",
                    "David Ramsey",
                    "Emily Bett Rickards",
                    "Paul Blackthorne",
                    "Willa Holland"
                ),
                "Ended",
                "English",
                R.drawable.poster_arrow,
                1
            )
        )

        shows.add(
            Film(
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "1986",
                arrayListOf(
                    "Masako Nozawa",
                    "Mayumi Tanaka",
                    "Hiromi Tsuru",
                    "Toru Furuya",
                    "Naoki Tatsuta"
                ),
                "Ended",
                "Japanese",
                R.drawable.poster_dragon_ball,
                1
            )
        )

        shows.add(
            Film(
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "2009",
                arrayListOf(
                    "Yoshimitsu Shimoyama",
                    "Eiji Miyashita",
                    "Masafumi Kimura",
                    "Eri Kitamura",
                    "Ryoko Ono"
                ),
                "Ended",
                "Japanese",
                R.drawable.poster_fairytail,
                1
            )
        )

        shows.add(
            Film(
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999",
                arrayListOf(
                    "Seth MacFarlane",
                    "Alex Borstein",
                    "Seth Green",
                    "Mila Kunis",
                    "Mike Henry"
                ),
                "Returning Series",
                "English",
                R.drawable.poster_family_guy,
                1
            )
        )

        shows.add(
            Film(
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014",
                arrayListOf(
                    "Grant Gustin",
                    "Candice Patton",
                    "Danielle Panabaker",
                    "Jesse L. Martin",
                    "Carlos Valdes"
                ),
                "Returning Series",
                "English",
                R.drawable.poster_flash,
                1
            )
        )

        shows.add(
            Film(
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "2014",
                arrayListOf(
                    "Ben McKenzie",
                    "Donal Logue",
                    "David Mazouz",
                    "Sean Pertwee",
                    "Robin Lord Taylor"
                ),
                "Ended",
                "English",
                R.drawable.poster_gotham,
                1
            )
        )

        shows.add(
            Film(
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "2017",
                arrayListOf(
                    "Finn Jones",
                    "Jessica Henwick",
                    "Jessica Stroup",
                    "Tom Pelphrey",
                    "Sacha Dhawan"
                ),
                "Canceled",
                "English",
                R.drawable.poster_iron_fist,
                1
            )
        )

        shows.add(
            Film(
                "Naruto Shippuden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "2007",
                arrayListOf(
                    "Junko Takeuchi",
                    "Chie Nakamura",
                    "Noriaki Sugiyama",
                    "Kazuhiko Inoue",
                    "Satoshi Hino"
                ),
                "Ended",
                "Japanese",
                R.drawable.poster_naruto_shipudden,
                1
            )
        )

        shows.add(
            Film(
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "2015",
                arrayListOf(
                    "David Harewood",
                    "Melissa Benoist",
                    "Chyler Leigh",
                    "Katie McGrath",
                    "Mehcad Brooks"
                ),
                "Ended",
                "English",
                R.drawable.poster_supergirl,
                1
            )
        )

        shows.add(
            Film(
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "2010",
                arrayListOf(
                    "Norman Reedus",
                    "Melissa McBride",
                    "Lauren Cohan",
                    "Danai Gurira",
                    "Andrew Lincoln"
                ),
                "Returning Series",
                "English",
                R.drawable.poster_the_walking_dead,
                1
            )
        )

        return shows
    }

    fun getSelectedFilm(title: String) : Film? {
        for (movie in movies) {
            if (title == movie.title) {
                return movie
            }
        }

        for (show in shows) {
            if (title == show.title) {
                return show
            }
        }
        return null
    }

    fun generateDummyFavMovie(): List<Film> {
        val dummyFavMovie = ArrayList<Film>()
        val dummyMovie = generateDataMovies()[0]
        dummyMovie.isFavorite = 1
        dummyFavMovie.add(dummyMovie)
        return dummyFavMovie
    }

    fun generateDummyFavShow(): List<Film> {
        val dummyFavShow = ArrayList<Film>()
        val dummyShow = generateDataShows()[0]
        dummyShow.isFavorite = 1
        dummyFavShow.add(dummyShow)
        return dummyFavShow
    }

}