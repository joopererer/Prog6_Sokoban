import java.io.*;

public class Sokoban {

    public static void main(String[] args){
        LecteurNiveaux lecture;
        try {
            FileInputStream fis = new FileInputStream(new File("Original.txt"));
            lecture = new LecteurNiveaux(fis);
            Niveau niveau = lecture.lisProchainNiveau();
            // print
            afficherNiveau(niveau);
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void afficherNiveau(Niveau niveau){

    }

}
