package src;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class NiveauGraphique extends JComponent {

    private final Jeu jeu;

    private Image[] imgs;

    private static final int CELL_SIZE = 40;
    private static final String[] IMG_STR
            = {"But.png", "Caisse.png", "Caisse_sur_but.png",
                "Mur.png", "Pousseur.png", "Sol.png"};
    private static final int ID_IMG_BUT = 0;
    private static final int ID_IMG_CAISSE = 1;
    private static final int ID_IMG_CAISSE_SUR_BUT = 2;
    private static final int ID_IMG_MUR = 3;
    private static final int ID_IMG_POUSSEUR = 4;
    private static final int ID_IMG_SOL = 5;

    public NiveauGraphique(Jeu jeu){
        this.jeu = jeu;
        init_images();
    }

    private void init_images() {
        imgs = new Image[IMG_STR.length];
        for(int i=0; i<IMG_STR.length; i++){
            try {
                InputStream in = new FileInputStream("res/Images/"+IMG_STR[i]);
                imgs[i] = ImageIO.read(in);
            } catch (FileNotFoundException e) {
                System.err.println("ERREUR : impossible de trouver le fichier : "+IMG_STR[i]);
                System.exit(2);
                //throw new RuntimeException(e);
            } catch (IOException e) {
                System.err.println("ERREUR : impossible de charger l'image");
                System.exit(3);
                //throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        int width = getSize().width;
        int height = getSize().height;

        drawable.clearRect(0, 0, width, height);

        // draw niveau
        Niveau niveau = jeu.niveau();
        draw_niveau(drawable, niveau);
    }

    private void draw_niveau(Graphics2D drawable, Niveau niveau) {
        int x, y;
        int spX = 0, spY = 0;
        for(int i=0; i<niveau.lignes(); i++){
            x = i*CELL_SIZE;
            for(int j=0; j<niveau.colonnes(); j++){
                y = j*CELL_SIZE;

                // toujour déssiner le sol
                drawable.drawImage(imgs[ID_IMG_SOL], x, y, CELL_SIZE, CELL_SIZE, null);

                int img_id = -1;
                if(niveau.aBut(i, j)){
                    img_id = ID_IMG_BUT;
                    if(niveau.aCaisse(i, j)){
                        //print("*");
                        img_id = ID_IMG_CAISSE_SUR_BUT;
                    }else
                    if(niveau.aPousseur(i, j)){
                        //print("+");
                        spX = x;
                        spY = y;
                    }
                }else
                if(niveau.aMur(i, j)){
                    //print("#");
                    img_id = ID_IMG_MUR;
                }else
                if(niveau.aCaisse(i, j)){
                    //print("$");
                    img_id = ID_IMG_CAISSE;
                }else
                if(niveau.aPousseur(i, j)){
                    //print("@");
                    spX = x;
                    spY = y;
                }/*else
                if(niveau.estVide(i, j)){
                    //print(" ");
                    img_id = ID_IMG_SOL;
                }*/
                if(img_id!=-1){
                    drawable.drawImage(imgs[img_id], x, y, CELL_SIZE, CELL_SIZE, null);
                }
            }
            //print("\n");
        }

        //
        draw_pousseur(drawable, spX, spY);
    }

    private void draw_pousseur(Graphics2D drawable, int x, int y) {
        drawable.drawImage(imgs[ID_IMG_POUSSEUR], x, y, CELL_SIZE, CELL_SIZE, null);
    }

}
