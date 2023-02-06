package src;

public class TestSequence {

    protected static int[] values = {20, 100, 200, 400, 500};

    public static void main(String[] args){
        SequenceTableau sqListe = new SequenceTableau();
        //sqListe.extraitTete();  // RunTimeException

        for(int val : values) {
            sqListe.insereQueue(val);
        }
        System.out.println(sqListe);

        int val_tete = sqListe.extraitTete();
        System.out.println("extrait tete : "+val_tete);
        System.out.println(sqListe);

        Iterateur it = sqListe.iterateur();
        while(it.aProchain()){
            int val = it.prochain();
            if(val==400)
                it.supprime();
        }
        System.out.println(sqListe);
    }

}
