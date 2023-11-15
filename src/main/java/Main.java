

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        try {
            String inputText = "How are you?Hello.Show must go on.I am.I`m okay today" ;
            Splitter splitter = new Splitter();

            // Виклик методу operationsWithText для обробки введеного тексту
            Text processedText = splitter.operationsWithText(inputText);
            //System.out.println(splitter.operationsWithText(inputText));

           // Виведення обробленого тексту
            System.out.println("Processed Text:");
            for (Sentence sentence : processedText.getSentence()) {
                System.out.println(Arrays.toString(sentence.getElements()));
            }

            // Виклик методу countWords для підрахунку кількості слів у тексті
            int wordCount = splitter.countWords(processedText);
            System.out.println("Total Word Count: " + wordCount);

            // Виклик методу sortByWordCount для сортування речень за кількістю слів
            Sentence[] sortedSentences = splitter.sortByWordCount(processedText);
            System.out.println("Sorted Sentences:");
            for (Sentence sentence : sortedSentences) {
                System.out.println(Arrays.toString(sentence.getElements()) + " - Word Count: " + sentence.getElements().length);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
