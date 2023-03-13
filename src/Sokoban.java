package src;

import javax.swing.*;
import java.io.*;

public class Sokoban {

    public static void main(String[] args){
        /*LecteurNiveaux lecture;
        RedacteurNiveau read;
        try {
            FileInputStream fis = new FileInputStream(new File("res/Original.txt"));
            lecture = new LecteurNiveaux(fis);
            Niveau niveau = lecture.lisProchainNiveau();
//            niveau.print();
            // print
            read = new RedacteurNiveau(System.out);
            while(niveau.nom()!=null){
                read.ecrisNiveau(niveau);
                niveau = lecture.lisProchainNiveau();
            }

            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        Jeu jeu = new Jeu("res/Original.txt");
        SwingUtilities.invokeLater(new InterfaceGraphique(jeu));
    }

}
