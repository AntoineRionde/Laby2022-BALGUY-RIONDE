package src;

/**
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    private final static char MUR = 'X';
    private final static char PJ = 'P';
    private final static char SORTIE = 'S';
    private final static char VIDE = '.';

    private final static String haut = "HAUT";
    private final static String bas = "BAS";
    private final static String gauche = "GAUCHE";
    private final static String droite = "DROITE";

    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;



    char getChar(int x, int y) { // balguy
        throw new Error("TODO");
    }


    static int[] getSuivant(int x, int y, String action) { // balguy
        int[]res;
        switch(action){
          case haut:
            
        }
    }


    void deplacerPerso(String action) throws ActionInconnueException { // balguy
        throw new Error("TODO");
    }


    public String toString() { // rionde
        throw new Error("TODO");
    }


    public boolean etreFini() { // rionde
        throw new Error("TODO");
    }

    public static Labyrinthe chargerLabyrinthe(String nom) { // rionde
        throw new Error("TODO");
    }

}
