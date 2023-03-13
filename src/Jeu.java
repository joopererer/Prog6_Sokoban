package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Jeu {

    private final LecteurNiveaux lecteur;
    private Niveau cur_niveau;

    public Jeu(String map_file){
        try {
            FileInputStream fis = new FileInputStream(map_file);
            lecteur = new LecteurNiveaux(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        cur_niveau = lecteur.lisProchainNiveau();
    }

    public Niveau niveau(){
        return cur_niveau;
    }

    public boolean prochainNiveau(){
        Niveau next_niveau = lecteur.lisProchainNiveau();
        if(next_niveau==null){
            return false;
        }
        cur_niveau = next_niveau;
        return true;
    }

}
