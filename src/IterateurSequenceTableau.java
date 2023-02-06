package src;

import java.util.NoSuchElementException;

public class IterateurSequenceTableau implements Iterateur{

    private final SequenceTableau seq;
    private int pos_prev, pos_cur;
    private boolean isValide;

    public IterateurSequenceTableau(SequenceTableau seq){
        this.seq = seq;
        pos_cur = 0;
    }

    @Override
    public boolean aProchain() {
        return pos_cur<seq.size;
    }

    @Override
    public int prochain() {
        if(aProchain()){
            int val = seq.tableau[pos_cur];
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
