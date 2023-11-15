public class Word {
    private Letter[] letters;
    public Word(Letter[] letters){
        this.letters=letters;
    }
    public Letter[] getLetters(){
        return letters;
    }
    public int getWordLength(){
        return letters.length;
    }
    @Override
    //метод toString в даному випадку збирає ліери у рядок
    public String toString() {
        StringBuilder wordBuilder = new StringBuilder();
        for (Letter letter : letters) {//проходимося по через всі об'єкти типу Letter у масиві letters
            wordBuilder.append(letter);//за допомогою методу append додаємо їх до wordBuilder
        }
        return wordBuilder.toString();
    }
}
