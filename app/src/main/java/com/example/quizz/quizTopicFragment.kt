package com.example.quizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizz.databinding.FragmentQuizTopicBinding
import java.util.ArrayList

class quizTopicFragment : Fragment() {

    private lateinit var topicList : ArrayList<Question>
    private var _binding: FragmentQuizTopicBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizTopicBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topic_1 = Question(
            "Football",
            R.drawable.ball,
            arrayListOf(
                "Who is the best football player of all time?",
                "Which country won the 2022 World Cup?",
                "When was the last time Fenerbahce won the championship?",
                "Which footballer is known for famously biting an opponent during a World Cup match?",
                "Which team won the Champions League in 2023?",
                "Who won the Ballon d'Or in 2022?"
            ),
            arrayListOf(3, 2, 3, 3, 2, 1),
            arrayListOf(
                arrayListOf("Messi", "Ronaldo", "Zlatan (goat)"),
                arrayListOf("France", "Argentina", "Brazil"),
                arrayListOf("1000 B.C.", "1934", "2014"),
                arrayListOf("Diego Costa", "Quaresma", "Luis Suarez"),
                arrayListOf("Liverpool", "Real Madrid", "Bayern Munich"),
                arrayListOf("Karim Benzema", "Robert Lewandowski", "Lionel Messi")
            )
        )

        val topic_2 = Question(
            "Basketball",
            R.drawable.basketball,
            arrayListOf(
                "Who won the NBA MVP award in 2023?",
                "Which team won the NBA Finals in 2023?",
                "Who holds the record for the most points scored in a single NBA game?",
                "Which country won the gold medal in basketball at the 2021 Olympics?",
                "Who is known as 'The King' in basketball?",
                "Which player has the most career assists in NBA history?"
            ),
            arrayListOf(1, 1, 2, 1, 3, 3),
            arrayListOf(
                arrayListOf("Joel Embiid", "Giannis Antetokounmpo", "Nikola Jokic"),
                arrayListOf("Denver Nuggets", "Golden State Warriors", "Milwaukee Bucks"),
                arrayListOf("Kobe Bryant", "Wilt Chamberlain", "Michael Jordan"),
                arrayListOf("USA", "France", "Australia"),
                arrayListOf("Stephen Curry", "Kevin Durant", "LeBron James"),
                arrayListOf("John Stockton", "Magic Johnson", "Chris Paul")
            )
        )
        val topic_3 = Question(
            "Movies",
            R.drawable.movie,
            arrayListOf(
                "Who won the Best Actor award at the 2023 Oscars?",
                "Which movie won the Best Picture award at the 2023 Oscars?",
                "Who directed the movie 'Godfather'?",
                "Which film features the character 'Jack Sparrow'?",
                "Who played 'Wolverine' in the X-Men series?",
                "Which movie series is known for the quote 'You take the blue pill - the story ends.'?"
            ),
            arrayListOf(2, 1, 3, 1, 1, 2),
            arrayListOf(
                arrayListOf("Austin Butler", "Brendan Fraser", "Paul Mescal"),
                arrayListOf("Everything Everywhere All at Once", "The Banshees of Inisherin", "Top Gun: Maverick"),
                arrayListOf("Marlon Brando", "Steven Spielberg", "Francis Ford Coppola"),
                arrayListOf("Pirates of the Caribbean", "The Lord of the Rings", "Harry Potter"),
                arrayListOf("Hugh Jackman", "Ryan Reynolds", "Chris Hemsworth"),
                arrayListOf("Star Wars", "The Matrix", "The Hunger Games")
            )
        )

        val topic_4 = Question(
            "TV Series",
            R.drawable.tv,
            arrayListOf(
                "Which TV series features the character 'Walter White'?",
                "Who played 'Jon Snow' in 'Game of Thrones'?",
                "What is the name of the fictional town in 'Stranger Things'?",
                "Which TV show is known for the phrase 'D'oh!'?",
                "In which TV series would you find the character 'Sherlock Holmes'?",
                "What is the name of the coffee shop in 'Friends'?"
            ),
            arrayListOf(1, 1, 1, 3, 1, 1),
            arrayListOf(
                arrayListOf("Better Call Saul", "Breaking Bad", "Narcos"),
                arrayListOf("Kit Harington", "Richard Madden", "Emilia Clarke"),
                arrayListOf("Hawkins", "Rivendell", "Sunnydale"),
                arrayListOf("South Park", "Family Guy", "The Simpsons"),
                arrayListOf("Sherlock", "Elementary", "Midsomer Murders"),
                arrayListOf("Central Perk", "Café Nervosa", "Monk's Café")
            )
        )

        val topic_5 = Question(
            "Music",
            R.drawable.music,
            arrayListOf(
                "Which artist released the album 'Thriller'?",
                "What year did The Beatles release their album 'Sgt. Pepper's Lonely Hearts Club Band'?",
                "Which song is known for the lyric 'Is this the real life? Is this just fantasy?'?",
                "Who is the lead vocalist of the band Metallica?",
                "Which composer is famous for the 'Moonlight Sonata'?",
                "Which artist cloned himself and joined MTV awards with the clones? "
            ),
            arrayListOf(1, 1, 3, 2, 1, 3),
            arrayListOf(
                arrayListOf("Michael Jackson", "Prince", "Madonna"),
                arrayListOf("1967", "1965", "1970"),
                arrayListOf("Imagine", "Like a Rolling Stone","Bohemian Rhapsody"),
                arrayListOf("Robert Plant","James Hetfield", "Mick Jagger"),
                arrayListOf("Ludwig van Beethoven", "Wolfgang Amadeus Mozart", "Johann Sebastian Bach"),
                arrayListOf("Kanye West", "Drake", "Eminem")
            )
        )


        binding.setNameButton.setOnClickListener {
            val action = quizTopicFragmentDirections.actionQuizTopicFragmentToMainMenuFragment()
            Navigation.findNavController(view).navigate(action)
        }
        topicList = arrayListOf(topic_1,topic_2,topic_3,topic_4,topic_5)
        val adapter  = TopicAdapter(topicList)
        binding.quizTopicRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.quizTopicRecyclerView.adapter = adapter

    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

}