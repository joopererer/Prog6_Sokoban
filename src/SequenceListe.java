package src;

public class SequenceListe <T> implements Sequence <T> {

    static class Node <T> {
        protected T value;
        protected Node<T> next;
    }

    Node<T> tete;

    public Iterateur<T> iterateur() {
        return new IterateurSequenceListe<>(this);
    }

    public void insereTete(T element) {
        if(tete==null){
            tete = new Node<>();
            tete.value = element;
            tete.next = null;
        }else{
            Node<T> new_node = new Node<>();
            new_node.value = element;
            new_node.next = tete;
            tete = new_node;
        }
    }

    public void insereQueue(T element) {
        if(tete==null){
            insereTete(element);
        }else{
            Node<T> node = tete;
            while(node.next!=null){
                node = node.next;
            }
            node.next = new Node<>();
            node.next.value = element;
            node.next.next = null;
        }
    }

    public T extraitTete() {
        if(estVide()){
            throw new RuntimeException("Séquence vide");
        }

        T value = tete.value;
        tete = tete.next;

        return value;
    }

    public boolean estVide(){
        return tete==null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if(!estVide()){
            Node<T> node = tete;
            while(node.next!=null){
                result.append(node.value);
                result.append(',');
                node = node.next;
            }
            result.append(node.value);
            result.append(',');
        }
        return result.toString();
    }

}
