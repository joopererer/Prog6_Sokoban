package src;

import java.io.OutputStream;

public class RedacteurNiveau {

    OutputStream output;

    public RedacteurNiveau(OutputStream output){
        this.output = output;
    }

    void ecrisNiveau(Niveau niveau){
        if(niveau==null){
            return;
        }
        print(niveau.nom()+"\n");
        for(int i=0; i<niveau.lignes(); i++){
            for(int j=0; j<niveau.colonnes(); j++){
                if(niveau.aBut(i, j)){
                    if(niveau.aCaisse(i, j)){
                        print("*");
                    }else
                    if(niveau.aPousseur(i, j)){
                        print("+");
                    }else{
                        print(".");
                    }
                }else
                if(niveau.aMur(i, j)){
                    print("#");
                }else
                if(niveau.aCaisse(i, j)){
                    print("$");
                }else
                if(niveau.aPousseur(i, j)){
                    print("@");
                }else
                if(niveau.estVide(i, j)){
                    print(" ");
                }
            }
            print("\n");
        }
    }

    void print(String str){
        System.out.print(str);
    }

}
