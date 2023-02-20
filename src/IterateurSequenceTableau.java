package src;

import java.util.NoSuchElementException;

public class IterateurSequenceTableau <T> implements Iterateur<T> {

    private final SequenceTableau<T> seq;
    private int pos_prev, pos_cur;
    private boolean isValide;

    public IterateurSequenceTableau(SequenceTableau<T> seq){
        this.seq = seq;
        pos_cur = 0;
    }

    @Override
    public boolean aProchain() {
        return pos_cur<seq.size;
    }

    @Override
    public T prochain() {
        if(aProchain()){
            @SuppressWarnings("unchecked")
            T val = (T)seq.tableau[pos_cur];
            pos_prev = pos_cur;
            pos_cur++;
            isValide = true;
            return val;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void supprime() {
        if(isValide){
            isValide = false;
            for(int i=pos_prev; i<seq.size; i++){
                seq.tableau[i] = seq.tableau[i+1];
            }
            seq.size--;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
