import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    private ArrayList<Paragraph> paragraphs; //changed to ArrayList of Paragraph objects
    public ArrayList<Paragraph> getParagraphs() { return paragraphs; }
    public Boolean doReadFile(String fname) {
        paragraphs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {
            String line;
            Paragraph currentParagraph = new Paragraph();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()){ //if nothing is written on the line
                    if (!currentParagraph.isEmpty()){ //if paragraph has words in it
                        paragraphs.add(currentParagraph);
                        currentParagraph = new Paragraph(); //starts a new paragraph
                    }
                } else {
                    String[] words = line.trim().split("\\s+"); //splits on any whitespace
                    currentParagraph.addWords(words);
                }
            }
            //adds last paragraph in file if file doesn't end with empty line
            if (!currentParagraph.isEmpty()){
                paragraphs.add(currentParagraph);
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return false;
    }
    private ReadFile() {}
    public ReadFile(String fname) throws FileNotFoundException {
        if (!doReadFile(fname)) { //!doReadFile(fname) calls doReadFile method and negates the resulting boolean
            throw new FileNotFoundException("Error reading file: " + fname);
        }
    }
}
