public class Letter {
    private char value;
    public Letter(char value){
        this.value=value;
    }
    char getValue(){
        return value;
    }
    //Так як метод toString за замовчуванням виводить хеш-код об'єкта необхідно його перезаписати.
    @Override
    public String toString() {
        return String.valueOf(value);// метод  поверертає  рядкове представлення об'єкта.
    }


}
