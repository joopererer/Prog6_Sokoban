package src;

import java.util.NoSuchElementException;

public class IterateurSequenceListe <T> implements Iterateur <T> {

    private final SequenceListe<T> seq;
    private SequenceListe.Node<T> prev, pprev;
    private SequenceListe.Node<T> courant;
    private boolean isValide;


    public IterateurSequenceListe(SequenceListe<T> seq){
        this.seq = seq;
        courant = seq.tete;
    }

    @Override
    public boolean aProchain() {
        return courant!=null;
    }

    @Override
    public T prochain() {
        if(aProchain()) {
            pprev = prev;
            prev = courant;
            courant = courant.next;
            isValide = true;
            return prev.value;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void supprime() {
        if(isValide){
            isValide = false;
            if(pprev==null){
                seq.tete = courant;
            } else {
                pprev.next = courant;
            }
            prev = pprev;
        }  else {
            throw new IllegalArgumentException();
        }
    }


}
