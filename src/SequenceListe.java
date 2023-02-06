package src;

public class SequenceListe implements Sequence {

    static class Node {
        protected int value;
        protected Node next;
    }

    Node tete;

    public Iterateur iterateur() {
        return new IterateurSequenceListe(this);
    }

    public void insereTete(int element) {
        if(tete==null){
            tete = new Node();
            tete.value = element;
            tete.next = null;
        }else{
            Node new_node = new Node();
            new_node.value = element;
            new_node.next = tete;
            tete = new_node;
        }
    }

    public void insereQueue(int element) {
        if(tete==null){
            insereTete(element);
        }else{
            Node node = tete;
            while(node.next!=null){
                node = node.next;
            }
            node.next = new Node();
            node.next.value = element;
            node.next.next = null;
        }
    }

    public int extraitTete() {
        if(estVide()){
            throw new RuntimeException("Séquence vide");
        }

        int value = tete.value;
        tete = tete.next;

        return value;
    }

    public boolean estVide(){
        return tete==null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if(!estVide()){
            Node node = tete;
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
