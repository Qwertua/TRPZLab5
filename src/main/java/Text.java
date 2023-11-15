import java.util.Arrays;

public class Text {
    private Sentence[] sentences;
    public Text(Sentence[] sentences){
        this.sentences = sentences;
    }
    public Sentence[] getSentence(){
        return sentences;
    }
    public int getTextLength(){
        return sentences.length;
    }
    //створюємо рядок, який містить усі рядкові представлення речень у тексті, об'єднані в один рядок.
    @Override
    public String toString() {
        StringBuilder textBuilder = new StringBuilder();
        for (Sentence sentence : sentences) {
            textBuilder.append(sentence.toString());
        }
        return textBuilder.toString().trim();
    }
}
