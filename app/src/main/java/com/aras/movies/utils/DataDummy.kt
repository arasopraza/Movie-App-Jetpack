//package com.aras.movies.utils
//
//import com.aras.movies.data.source.local.entity.MovieEntity
//import com.aras.movies.data.source.local.entity.TvshowEntity
//
//object DataDummy {
//
//    fun generateDummyMovies(): List<MovieEntity> {
//
//        val movies = ArrayList<MovieEntity>()
//
//        movies.add(
//            MovieEntity(
//                "405774",
//                "Bird Box",
//                "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
//                "2018-12-13",
//                "https://thedisplay.net/wp-content/uploads/2019/01/bb1.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                "545609",
//                "Extraction",
//                "Tyler Rake, a fearless mercenary who offers his services on the black market, embarks on a dangerous mission when he is hired to rescue the kidnapped son of a Mumbai crime lord.",
//                "2020-04-24",
//                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRELEr5bWH1Z9ZlYjofDbRoW0ToFJop6YlcJuVU8lAYt2peph_n")
//        )
//
//        movies.add(
//            MovieEntity(
//                "656690",
//                "The Social Dilemma",
//                "This documentary-drama hybrid explores the dangerous human impact of social networking, with tech experts sounding the alarm on their own creations.",
//                "2020-01-26",
//                "https://upload.wikimedia.org/wikipedia/en/2/27/Social_dilemma_xlg.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                "619264",
//                "The Platform",
//                "A mysterious place, an indescribable prison, a deep hole. An unknown number of levels. Two inmates living on each level. A descending platform containing food for all of them. An inhuman fight for survival, but also an opportunity for solidarity.",
//                "2019-11-08",
//                "https://upload.wikimedia.org/wikipedia/en/5/54/The_Platform_poster.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                "496243",
//                "Parasite",
//                "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident",
//                "2019-05-30",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                "475557",
//                "Joker",
//                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
//                "2019-10-02",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                "299534",
//                "Avengers: Endgame",
//                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
//                "2019-04-24",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                "399566",
//                "Godzilla vs. Kong",
//                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
//                "2021-03-24",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                "155",
//                "The Dark Knight",
//                "Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.",
//                "2008-07-16",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qJ2tW6WMUDux911r6m7haRef0WH.jpg")
//        )
//
//        movies.add(
//            MovieEntity(
//                "460465",
//                "Mortal Kombat",
//                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
//                "2021-04-07",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg")
//        )
//        return movies
//    }
//
//    fun generateDummyTvshows(): List<TvshowEntity> {
//
//        val tvshows = ArrayList<TvshowEntity>()
//
//        tvshows.add(
//            TvshowEntity(
//                "87739",
//                "The Queen's Gambit",
//                "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
//                "2020-10-23",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg")
//        )
//
//        tvshows.add(
//            TvshowEntity(
//                "74577",
//                "The End of the F***ing World",
//                "James is 17 and is pretty sure he is a psychopath. Alyssa, also 17, is the cool and moody new girl at school. The pair make a connection and she persuades him to embark on a darkly comedic road trip in search of her real father.",
//                "2017-10-24",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vZQKQcB5n91c6tBofAVXq88Uuti.jpg")
//        )
//
//        tvshows.add(
//            TvshowEntity(
//                "63351",
//                "Narcos",
//                "A gritty chronicle of the war against Colombia's infamously violent and powerful drug cartels.",
//                "2015-08-28",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rTmal9fDbwh5F0waol2hq35U4ah.jpg")
//        )
//
//        tvshows.add(
//            TvshowEntity(
//                "1396",
//                "Breaking Bad",
//                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
//                "2008-01-20",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ggFHVNu6YYI5L9pCfOacjizRGt.jpg")
//        )
//
//        tvshows.add(
//            TvshowEntity(
//                "2288",
//                "Prison Break",
//                "Due to a political conspiracy, an innocent man is sent to death row and his only hope is his brother, who makes it his mission to deliberately get himself sent to the same prison in order to break the both of them out, from the inside out.",
//                "2005-08-29",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/j7HFOunuAVpOdiBhXpjwRxIgK5y.jpg")
//        )
//
//        tvshows.add(
//            TvshowEntity(
//                "60574",
//                "Peaky Blinders",
//                "A gangster family epic set in 1919 Birmingham, England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby, who means to move up in the world.",
//                "2013-09-12",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/se86cWSwdSftjJH8OStW7Yu3ZPC.jpg")
//        )
//
//        tvshows.add(
//            TvshowEntity(
//                "76669",
//                "Elite",
//                "When three working class kids enroll in the most exclusive school in Spain, the clash between the wealthy and the poor students leads to tragedy.",
//                "2018-10-05",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3NTAbAiao4JLzFQw6YxP1YZppM8.jpg")
//        )
//
//        tvshows.add(
//            TvshowEntity(
//                "82516",
//                "Unauthorized Living",
//                "When a Galician shipper and drug lord hiding his Alzheimer's disease plans to retire, his second-in-command plots to steal the empire from the heir.",
//                "2018-09-24",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/86RpBvHY7kzZWoXOhmeaEGo7jGo.jpg")
//        )
//
//        tvshows.add(
//            TvshowEntity(
//                "96162",
//                "Itaewon Class",
//                "In a colorful Seoul neighborhood, an ex-con and his friends fight a mighty foe to make their ambitious dreams for their street bar a reality",
//                "2020-01-31",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uW91bKQhdkwPLAE2lJJkY5xdyJg.jpg")
//        )
//
//        tvshows.add(
//            TvshowEntity(
//                "80968",
//                "Narcos: Mexico",
//                "See the rise of the Guadalajara Cartel as an American DEA agent learns the danger of targeting narcos in 1980s Mexico.",
//                "2018-11-16",
//                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gQQGxVhdBvT2l7G1Zz6JYSCmL6q.jpg")
//        )
//
//        return tvshows
//    }
//}