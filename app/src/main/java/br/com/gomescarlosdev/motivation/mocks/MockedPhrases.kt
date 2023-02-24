package br.com.gomescarlosdev.motivation.mocks

import br.com.gomescarlosdev.motivation.util.MotivationConstants.FILTER.HAPPY
import br.com.gomescarlosdev.motivation.util.MotivationConstants.FILTER.SUNNY
import br.com.gomescarlosdev.motivation.util.MotivationConstants.FILTER.ALL
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val listOfPhrases = listOf(
        Phrase(description = "Não sabendo que era impossível, foi lá e fez.", categoryId = HAPPY),
        Phrase(
            description = "Você não é derrotado quando perde, você é derrotado quando desiste!",
            categoryId = HAPPY
        ),
        Phrase(description = "Quando está mais escuro, vemos mais estrelas.", categoryId = HAPPY),
        Phrase(
            description = "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            categoryId = HAPPY
        ),
        Phrase(
            description = "Não pare quando estiver cansado, pare quando tiver terminado",
            categoryId = HAPPY
        ),
        Phrase(
            description = "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            categoryId = HAPPY
        ),
        Phrase(
            description = "A melhor maneira de prever o futuro é inventá-lo.",
            categoryId = SUNNY
        ),
        Phrase(
            description = "Você perde todas as chances que você não aproveita",
            categoryId = SUNNY
        ),
        Phrase(
            description = "Fracasso é o condimento que dá sabor ao sucesso.",
            categoryId = SUNNY
        ),
        Phrase(
            description = "Enquanto não estivermos comprometidos, haverá hesitação!",
            categoryId = SUNNY
        ),
        Phrase(
            description = "Se você não sabe onde quer ir, qualquer caminho serve.",
            categoryId = SUNNY
        ),
        Phrase(description = "Se você acredita, faz toda a diferença", categoryId = SUNNY)
    )

    fun getPhrase(categoryId: Int): String {
        val listFiltered = listOfPhrases.filter { it.categoryId == categoryId || categoryId == ALL }
        return listFiltered[Random.nextInt(listFiltered.size)].description
    }

}