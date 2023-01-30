package src;

import java.io.*;
import java.util.Scanner;

public class LecteurNiveaux {

    Scanner scanner;

    public LecteurNiveaux(InputStream input){
        scanner = new Scanner(input);
    }

    Niveau lisProchainNiveau(){
        Niveau niveau = new Niveau();
        int l = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if(line.length()==0){
                continue;
            }
            int indexPV = line.indexOf(';');
            if(indexPV!=-1){
                String nom = line.substring(indexPV+1).trim();
                niveau.fixeNom(nom);
                print(nom);
                l = 0;
                break;
            }
            for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {
                    case '#':
                        niveau.ajouterMur(l, i);
                        print("#");
                        break;
                    case '@':
                        niveau.ajoutePousseur(l, i);
                        print("@");
                        break;
                    case '+':
                        niveau.ajoutePousseur(l, i);
                        niveau.ajouteBut(l, i);
                        print("+");
                        break;
                    case '$':
                        niveau.ajouteCaisse(l, i);
                        print("$");
                        break;
                    case '*':
                        niveau.ajouteCaisse(l, i);
                        niveau.ajouteBut(l, i);
                        print("*");
                        break;
                    case '.':
                        niveau.ajouteBut(l, i);
                        print(".");
                        break;
                    case ' ':
                        niveau.videCase(l, i);
                        print(" ");
                        break;
                }
            }
            print("\n");
            l += 1;
        }
        return niveau;
    }

    void print(String str){
//        System.out.print(str);
    }

}
