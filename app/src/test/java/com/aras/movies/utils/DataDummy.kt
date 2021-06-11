package com.aras.movies.utils

import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                405774,
                "Bird Box",
                "Bird Box",
                "en",
                "2018-12-13",
                "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
                "https://thedisplay.net/wp-content/uploads/2019/01/bb1.jpg",
                34.439,
                6.9,
                7558
            )
        )

        movies.add(
            MovieEntity(
                545609,
                "Extraction",
                "Extraction",
                "en",
                "2020-04-24",
                "Tyler Rake, a fearless mercenary who offers his services on the black market, embarks on a dangerous mission when he is hired to rescue the kidnapped son of a Mumbai crime lord.",
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRELEr5bWH1Z9ZlYjofDbRoW0ToFJop6YlcJuVU8lAYt2peph_n",
                361.132,
                7.4,
                3822
            )
        )

        movies.add(
            MovieEntity(
                656690,
                "The Social Dilemma",
                "The Social Dilemma",
                "en",
                "2020-01-26",
                "This documentary-drama hybrid explores the dangerous human impact of social networking, with tech experts sounding the alarm on their own creations.",
                "https://upload.wikimedia.org/wikipedia/en/2/27/Social_dilemma_xlg.jpg",
                19.626,
                7.6,
                950
            )
        )

        movies.add(
            MovieEntity(
                619264,
                "The Platform",
                "El hoyo",
                "es",
                "https://upload.wikimedia.org/wikipedia/en/5/54/The_Platform_poster.jpg",
                "A mysterious place, an indescribable prison, a deep hole. An unknown number of levels. Two inmates living on each level. A descending platform containing food for all of them. An inhuman fight for survival, but also an opportunity for solidarity.",
                "2019-11-08",
                37.309,
                7.0,
                4568
            )
        )

        movies.add(
            MovieEntity(
                496243,
                "Parasite",
                "Parasite",
                "ko",
                "2019-05-30",
                "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
                102.478,
                8.5,
                11316
            )
        )

        movies.add(
            MovieEntity(
                475557,
                "Joker",
                "Joker",
                "en",
                "2019-10-02",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                397.979,
                8.2,
                17528
            )
        )

        movies.add(
            MovieEntity(
                299534,
                "Avengers: Endgame",
                "Avengers: Endgame",
                "en",
                "2019-04-24",
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg",
                213.118,
                8.3,
                18064
            )
        )

        movies.add(
            MovieEntity(
                399566,
                "Godzilla vs. Kong",
                "Godzilla vs. Kong",
                "en",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "2021-03-24",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                4015.861,
                8.1,
                5392
            )
        )

        movies.add(
            MovieEntity(
                155,
                "The Dark Knight",
                "The Dark Knight",
                "en",
                "2008-07-16",
                "Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qJ2tW6WMUDux911r6m7haRef0WH.jpg",
                45.821,
                8.5,
                25037
            )
        )

        movies.add(
            MovieEntity(
                460465,
                "Mortal Kombat",
                "Mortal Kombat",
                "en",
                "2021-04-07",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                5911.934,
                7.7,
                2295
            )
        )
        return movies
    }

    fun generateDummyTvshows(): List<TvshowEntity> {

        val tvshows = ArrayList<TvshowEntity>()

        tvshows.add(
            TvshowEntity(
                87739,
                "The Queen's Gambit",
                "The Queen's Gambit",
                "en",
                "2020-10-23",
                "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
                97.943,
                8.7,
                1875
            )
        )

        tvshows.add(
            TvshowEntity(
                74577,
                "The End of the F***ing World",
                "The End of the F***ing World",
                "en",
                "2017-10-24",
                "James is 17 and is pretty sure he is a psychopath. Alyssa, also 17, is the cool and moody new girl at school. The pair make a connection and she persuades him to embark on a darkly comedic road trip in search of her real father.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vZQKQcB5n91c6tBofAVXq88Uuti.jpg",
                50.609,
                8.3,
                1678
            )
        )

        tvshows.add(
            TvshowEntity(
                63351,
                "Narcos",
                "Narcos",
                "en",
                "2015-08-28",
                "A gritty chronicle of the war against Colombia's infamously violent and powerful drug cartels.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rTmal9fDbwh5F0waol2hq35U4ah.jpg",
                48.6,
                8.0,
                1607
            )
        )

        tvshows.add(
            TvshowEntity(
                1396,
                "Breaking Bad",
                "Breaking Bad",
                "en",
                "2008-01-20",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ggFHVNu6YYI5L9pCfOacjizRGt.jpg",
                272.747,
                8.7,
                6980
            )
        )

        tvshows.add(
            TvshowEntity(
                2288,
                "Prison Break",
                "Prison Break",
                "en",
                "2005-08-29",
                "Due to a political conspiracy, an innocent man is sent to death row and his only hope is his brother, who makes it his mission to deliberately get himself sent to the same prison in order to break the both of them out, from the inside out.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/j7HFOunuAVpOdiBhXpjwRxIgK5y.jpg",
                117.366,
                8.1,
                3046
            )
        )

        tvshows.add(
            TvshowEntity(
                60574,
                "Peaky Blinders",
                "Peaky Blinders",
                "en",
                "2013-09-12",
                "A gangster family epic set in 1919 Birmingham, England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby, who means to move up in the world.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/se86cWSwdSftjJH8OStW7Yu3ZPC.jpg",
                271.775,
                8.6,
                2544
            )
        )

        tvshows.add(
            TvshowEntity(
                76669,
                "Elite",
                "Elite",
                "es",
                "2018-10-05",
                "When three working class kids enroll in the most exclusive school in Spain, the clash between the wealthy and the poor students leads to tragedy.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3NTAbAiao4JLzFQw6YxP1YZppM8.jpg",
                241.203,
                8.2,
                6380
            )
        )

        tvshows.add(
            TvshowEntity(
                82516,
                "Unauthorized Living",
                "Unauthorized Living",
                "es",
                "2018-09-24",
                "When a Galician shipper and drug lord hiding his Alzheimer's disease plans to retire, his second-in-command plots to steal the empire from the heir.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/86RpBvHY7kzZWoXOhmeaEGo7jGo.jpg",
                19.98,
                7.8,
                22
            )
        )

        tvshows.add(
            TvshowEntity(
                96162,
                "Itaewon Class",
                "이태원 클라쓰",
                "ko",
                "2020-01-31",
                "In a colorful Seoul neighborhood, an ex-con and his friends fight a mighty foe to make their ambitious dreams for their street bar a reality",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uW91bKQhdkwPLAE2lJJkY5xdyJg.jpg",
                17.151,
                8.4,
                47
            )
        )

        tvshows.add(
            TvshowEntity(
                80968,
                "Narcos: Mexico",
                "Narcos: Mexico",
                "en",
                "2018-11-16",
                "See the rise of the Guadalajara Cartel as an American DEA agent learns the danger of targeting narcos in 1980s Mexico.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gQQGxVhdBvT2l7G1Zz6JYSCmL6q.jpg",
                47.056,
                7.9,
                628
            )
        )

        return tvshows
    }

    fun generateMovieById(movieId: Int): MovieEntity {
        return MovieEntity(
            movieId,
            "Bird Box",
            "Bird Box",
            "en",
            "2018-12-13",
            "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
            "https://thedisplay.net/wp-content/uploads/2019/01/bb1.jpg",
            34.439,
            6.9,
            7558
        )
    }

    fun generateTvshowById(tvshowId: Int): TvshowEntity {
        return TvshowEntity(
            tvshowId,
            "The Queen's Gambit",
            "The Queen's Gambit",
            "en",
            "2020-10-23",
            "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
            97.943,
            8.7,
            1875
        )
    }
}