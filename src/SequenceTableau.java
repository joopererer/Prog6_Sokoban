package src;

public class SequenceTableau implements Sequence {

    int[] tableau;
    int size;

    public SequenceTableau(){
        tableau = new int[4];
        size = 0;
    }

    private void reallocation(){
        int[] new_tab = new int[size*2];
        System.arraycopy(tableau, 0, new_tab, 0, size);
        tableau = new_tab;
    }

    public void insereTete(int element) {
        if(size>=tableau.length){
            reallocation();
        }
        // deplacement à la fin
        for(int i=size; i>=1; i--){
            //System.out.println(i+":"+tableau[i]+","+tableau[i-1]);
            tableau[i] = tableau[i-1];
        }
        tableau[0] = element;
        size+=1;
    }

    public void insereQueue(int element) {
        if(size>=tableau.length){
            reallocation();
        }
        tableau[size] = element;
        size += 1;
    }

    public int extraitTete() {
        if(estVide()){
            throw new RuntimeException("Séquence vide");
        }

        int value = tableau[0];
        // deplacement à la tete
        for(int i=0; i<size-1; i++){
            tableau[i] = tableau[i+1];
        }
        size -= 1;

        return value;
    }

    public boolean estVide(){
        return size<=0;
    }

    @Override
    public Iterateur iterateur() {
        return new IterateurSequenceTableau(this);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if(!estVide()){
            for(int i=0; i<size; i++){
                result.append(tableau[i]);
                result.append(',');
            }
        }
        return result.toString();
    }

}
