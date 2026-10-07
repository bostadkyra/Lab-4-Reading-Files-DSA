import java.util.ArrayList;

public class Paragraph {
    private ArrayList<String> words;

    public Paragraph(){
        words = new ArrayList<>();
    }

    public void addWords(String[] newWords){
        for (String word : newWords){
            if (!word.isEmpty()){
                words.add(word);
            }
        }
    }

    public boolean isEmpty(){
        return words.isEmpty();
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public String toString(){
        return String.join(" ", words); //joins words with spaces
    }
}
