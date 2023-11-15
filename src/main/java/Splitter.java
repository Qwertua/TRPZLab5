import java.util.Arrays;
import java.util.Comparator;

public class Splitter {
    public Text operationsWithText (String text){
        if (text == null) {
            throw new IllegalArgumentException("You entered null");
        } else if (text.isEmpty()) {
            throw new IllegalArgumentException("Your text is Empty");
        }

        String[] sentences = text.split("[.!?;]");//розділення тексту на речення за ". ! ? ;
        Sentence[] sentenceObjects = new Sentence[sentences.length];
        //System.out.println(Arrays.toString(sentences));


        for (int i =0 ;i<sentences.length; i++){//розділення речень на слова
            String[] words = sentences[i].split("\\s+");;
            // використовуємо пробіл як роздільник
            Object[] wordObject = new Object[words.length];
            //System.out.println(Arrays.toString(words));


            for (int j=0 ; j< words.length;j++){
                String word = words[j];
                Letter[] letters = new Letter[word.length()];//Створення масиву letters довжиною, рівною кількості символів у поточному слові word


                for (int k = 0; k < word.length(); k++) {//для кожної букив у слові створюємо об'єкт типу Letter і присвоюємо його нашій змінній
                    letters[k] = new Letter(word.charAt(k));//створення масив об'єктів типу Letter, де кожен об'єкт представляє один символ слова.
                    //System.out.println(Arrays.toString(letters));
                }
                wordObject[j] = new Word(letters);//створюємо нови об'єкт Word який приймає в себе параметр letters
            }//letters масив об'ктів типу Letter -->створюємо  об'єкт Word, який представляє собою слово із заданим набором літер.
            sentenceObjects[i] = new Sentence(wordObject);//створюємо об'єкт Sentence, який представляє собою речення із заданим набором слів.

        }
        return new Text(sentenceObjects);
    }
   //метод для підрахунку кілкості слів у об'єкті Text

    public int countWords(Text text) {
        int wordCount = 0;
        for (Sentence sentence : text.getSentence()) {//ітерація через всі речення тексту
            for (Object element : sentence.getElements()) {
                if (element instanceof Word) {//якщо поточний елемент є словом --> збільшуємо лічильник на 1
                    wordCount++;
                }
            }
        }
        return wordCount;//в результаті повертаємо загальну кількість слів у кожному реченні
    }

    public Sentence[] sortByWordCount(Text text) {
        Sentence[] sentences = Arrays.copyOf(text.getSentence(), text.getSentence().length);

        Arrays.sort(sentences, Comparator.comparingInt(sentence ->//порівнюємо за допомогою компаратора кількість слів у реченні
                countWords(new Text(new Sentence[]{sentence}))));//лямбда вираз приймає об'єкт sentence і повертає кількість слів у реченні
//Arrays.sort сортуэ речення в тексті в залежності від кількості слів у них -->речення сортуються в зростаючому порядку
        return sentences;
    }


}



