public class Sentence {
    private Object[] elements;
    public Sentence(Object[] elements){
        this.elements = elements;

    }

    public Object[] getElements() {
        return elements;
    }

    public int getSentenceLength(){
        return elements.length;
    }
    //створення рядка, який складається з усіх елементів речення
    @Override
    public String toString() {
        StringBuilder sentenceBuilder = new StringBuilder();
        for (Object element : elements) {
            sentenceBuilder.append(element.toString());
        }
        return sentenceBuilder.toString();
    }

}
