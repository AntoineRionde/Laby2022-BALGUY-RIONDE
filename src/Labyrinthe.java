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



    char getChar(int x, int y) { // rionde
        char resp = ' ';
        if (x == personnage.getX() && y == personnage.getY())
        {
            resp = PJ;
        }
        else if (x == sortie.getX() && y == sortie.getY())
        {
            resp = SORTIE;
        }
        else if (murs[x][y])
        {
            resp = MUR;
        }
        else if (!murs[x][y])
        {
            resp = VIDE;
        }
        return resp;
    }


    static int[] getSuivant(int x, int y, String action) { // balguy
        throw new Error("TODO");
    }


    void deplacerPerso(String action) throws ActionInconnueException { // balguy
        throw new Error("TODO");
    }


    public String toString() { // rionde
        throw new Error("TODO");
    }


    public boolean etreFini() { // rionde
        boolean estFini;
        if (personnage.getX() == sortie.getX() && personnage.getY() == sortie.getY())
        {
            estFini = true;
        }
        else
        {
            estFini = false;
        }
        return estFini;
    }

    public static Labyrinthe chargerLabyrinthe(String nom) { // rionde
        throw new Error("TODO");
    }

}
