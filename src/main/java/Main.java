import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ReadFile fileRes = new ReadFile("data/GettysburgAddress.txt");
            ArrayList<Paragraph> paragraphs = fileRes.getParagraphs();

            printParagraphs(paragraphs);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    public static void printParagraphs(ArrayList<Paragraph> paragraphs){
        int paragraphNum = 1;
        for (Paragraph paragraph : paragraphs){
            System.out.println("~~~Paragraph " + paragraphNum + " ~~~");

            int wordNum = 1;
            for(String word : paragraph.getWords()){
                System.out.println(" Word " + wordNum + ": " + word);
                wordNum++;
            }

            System.out.println("Full paragraph: " + paragraph); //print paragraph as a whole
            System.out.println();
            paragraphNum++;
        }
        System.out.println("Total paragraphs: " + paragraphs.size());
    }
}