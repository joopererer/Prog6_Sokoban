package src;

public class SequenceTableau <T> implements Sequence <T> {

    Object[] tableau;
    int size;

    public SequenceTableau(){
        tableau = new Object[4];
        size = 0;
    }

    private void reallocation(){
        Object[] new_tab = new Object[size*2];
        System.arraycopy(tableau, 0, new_tab, 0, size);
        tableau = new_tab;
    }

    public void insereTete(T element) {
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

    public void insereQueue(T element) {
        if(size>=tableau.length){
            reallocation();
        }
        tableau[size] = element;
        size += 1;
    }

    public T extraitTete() {
        if(estVide()){
            throw new RuntimeException("Séquence vide");
        }
        @SuppressWarnings("unchecked")
        T value = (T)tableau[0];
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
    public Iterateur<T> iterateur() {
        return new IterateurSequenceTableau<>(this);
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
