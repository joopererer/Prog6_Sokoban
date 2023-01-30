package src;

public class Niveau {

    static final int WALL = 0x23; //#
    static final int PLAYER = 0x40; //@
    static final int PLAYER_ON_GOAL = 0x2b; //+
    static final int BOX = 0x24; //$
    static final int BOX_ON_GOAL = 0x2a; //*
    static final int GOAL_SQUARE = 0x2e; //.
    static final int FLOOR = 0x20; //(space)

    private String nom;
    private int[][] monTableau;
    private int lignes, colonnes;

    public Niveau(){
        monTableau = new int[1][1];
        lignes = 1;
        colonnes = 1;
    }

    void fixeNom(String s) {
        nom = s;
    }

    void videCase(int i, int j){
        modifierSize(i, j);
        monTableau[i][j] = FLOOR;
    }

    void ajouterMur(int i, int j){
        modifierSize(i, j);
        monTableau[i][j] = WALL;
    }

    void ajoutePousseur(int i, int j){
        modifierSize(i, j);
        if(monTableau[i][j]==GOAL_SQUARE){
            monTableau[i][j] = PLAYER_ON_GOAL;
        }else{
            monTableau[i][j] = PLAYER;
        }
    }

    void ajouteCaisse(int i, int j){
        modifierSize(i, j);
        if(monTableau[i][j]==GOAL_SQUARE){
            monTableau[i][j] = BOX_ON_GOAL;
        }else {
            monTableau[i][j] = BOX;
        }
    }

    void ajouteBut(int i, int j){
        modifierSize(i, j);
        if(monTableau[i][j]==BOX){
            monTableau[i][j] = BOX_ON_GOAL;
        }else
        if(monTableau[i][j]==PLAYER){
            monTableau[i][j] = PLAYER_ON_GOAL;
        }else{
            monTableau[i][j] = GOAL_SQUARE;
        }
    }

    int lignes() {
        return lignes;
    }

    int colonnes(){
        return colonnes;
    }

    String nom(){
        return nom;
    }

    boolean estVide(int l, int c){
        if(l<0 || l>=lignes || c<0 || c>=colonnes){
            return true;
        }
        return monTableau[l][c] == FLOOR;
    }

    boolean aMur(int l, int c){
        if(l<0 || l>=lignes || c<0 || c>=colonnes){
            return false;
        }
        return monTableau[l][c] == WALL;
    }

    boolean aBut(int l, int c){
        if(l<0 || l>=lignes || c<0 || c>=colonnes){
            return false;
        }
        return monTableau[l][c] == GOAL_SQUARE || monTableau[l][c] == BOX_ON_GOAL;
    }

    boolean aPousseur(int l, int c){
        if(l<0 || l>=lignes || c<0 || c>=colonnes){
            return false;
        }
        return monTableau[l][c] == PLAYER || monTableau[l][c] == PLAYER_ON_GOAL;
    }

    boolean aCaisse(int l, int c){
        if(l<0 || l>=lignes || c<0 || c>=colonnes){
            return false;
        }
        return monTableau[l][c] == BOX || monTableau[l][c] == BOX_ON_GOAL;
    }

    protected void modifierSize(int l, int c){
        boolean isChanged = false;
        if(l>=lignes){
            lignes = l+1;
            isChanged = true;
        }
        if(c>=colonnes){
            colonnes = c+1;
            isChanged = true;
        }
        if(isChanged){
            int[][] newTableau = new int[lignes][colonnes];
            for(int i=0; i<monTableau.length; i++){
                for(int j=0; j<monTableau[i].length; j++){
                    newTableau[i][j] = monTableau[i][j];
                }
            }
            monTableau = newTableau;
        }
    }

    public void print(){
        System.out.println(lignes+"*"+colonnes);
        for(int i=0; i<lignes; i++){
            for(int j=0; j<colonnes; j++){
                System.out.print(monTableau[i][j]+", ");
            }
            System.out.println();
        }
    }

}
