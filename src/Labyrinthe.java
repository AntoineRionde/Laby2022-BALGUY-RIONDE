package src;
import java.io.*;
/**
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    private final static char MUR = 'X';
    private final static char PJ = 'P';
    private final static char SORTIE = 'S';
    private final static char VIDE = '.';

    private final static String HAUT = "haut";
    private final static String BAS = "bas";
    private final static String GAUCHE = "gauche";
    private final static String DROITE = "droite";

    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;


    char getChar(int x, int y) { // rionde
        char resp = ' ';
        if (x == this.personnage.getX() && y == this.personnage.getY())
        {
            resp = PJ;
        }
        else if (x == this.sortie.getX() && y == this.sortie.getY())
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


    static int[] getSuivant(int x, int y, String action)throws ActionInconnueException { // balguy
      int [] tab= new int[2];
        switch(action){
          case HAUT:
            tab[0] =x-1;
            tab[1] = y;
            break;

          case BAS :
            tab[0] =x+1;
            tab[1] = y;
            break;

          case GAUCHE :
            tab[1] =y-1;
            tab[0] = x;
            break;

          case DROITE :
            tab[1] =y+1;
            tab[0] = x;
            break;

          default:
            throw new ActionInconnueException("le mot :"+action +" ne fait pas partie des 4 actions connues(gauche,droite,haut,bas).");
        }
        return tab;
    }

   
    void deplacerPerso(String action) throws ActionInconnueException { // balguy
        int []res=new int[2];
        while (!this.murs[this.personnage.getX()][this.personnage.getY()]) {
          res =getSuivant(personnage.getX(),personnage.getY(),action);
        }
    }

    public String toString() { // balguy
      String res = "";
      for(int i=0;i<murs.length-1;i++){
        for(int j=0;j<murs[i].length-1;i++){
         // murs[i]= system.out.println();
         res += getChar(i, j);
        }
        res += "\n";
      }
      return res;
    }

    public boolean etreFini() { // rionde
        return (personnage.getX() == sortie.getX() && personnage.getY() == sortie.getY());
    }

    public static Labyrinthe chargerLabyrinthe(String nom) { // rionde
        throw new Error("TODO");
    }

}
