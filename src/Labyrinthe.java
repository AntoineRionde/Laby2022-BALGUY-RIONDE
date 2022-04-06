package src;
import java.io.*;

/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe {

    public final static char MUR = 'X';
    public final static char PJ = 'P';
    public final static char SORTIE = 'S';
    public final static char VIDE = '.';

    public final static String HAUT = "haut";
    public final static String BAS = "bas";
    public final static String GAUCHE = "gauche";
    public final static String DROITE = "droite";

    public static boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;

    public Labyrinthe(boolean[][] m, Personnage p, Sortie s)
    {
      this.murs = m;
      this.personnage = p;
      this.sortie = s;
    }


    public char getChar(int x, int y) {
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


    public static int[] getSuivant(int x, int y, String action)throws ActionInconnueException {
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

   
    public void deplacerPerso(String action) throws ActionInconnueException {

        try {
            int[] res = new int[2];
            res = getSuivant(personnage.getX(),personnage.getY(),action);
            while (!(this.murs[res[0]][res[1]])) {
                this.personnage.setX(res[0]);
                this.personnage.setY(res[1]);
                res = getSuivant(personnage.getX(),personnage.getY(),action);
            }
        }
        catch (ActionInconnueException e) {
            throw new ActionInconnueException("le mot :"+action +" ne fait pas partie des 4 actions connues(gauche,droite,haut,bas).");
        }

    }

    public String toString() {
      String res = "";
      int nbLignes = murs[0].length;
      for(int i = 0; i < murs.length - 1; i++){
        for(int j = 0; j < nbLignes; i++){
         res += getChar(i, j);
        }
        res += "\n";
      }
      return res;
    }

    public boolean etreFini() {
        return (personnage.getX() == sortie.getX() && personnage.getY() == sortie.getY());
    }

    public static Labyrinthe chargerLabyrinthe(String nom) throws FileNotFoundException, IOException {
        BufferedReader fich = new BufferedReader (new FileReader(nom));

        int nbLignes = Integer.parseInt(fich.readLine());
        int nbColonnes = Integer.parseInt(fich.readLine());

        Personnage personnage = null;
        Sortie sortie = null;
        boolean[][] murs = new boolean[nbLignes][nbColonnes];

        String ligne = fich.readLine();

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++)
            {
                if (ligne.charAt(j) == 'P') {
                    personnage = new Personnage(i, j);
                }
                if (ligne.charAt(j) == 'S') {
                    sortie = new Sortie(i, j);
                }
                if (ligne.charAt(j) == 'X') {
                    murs[i][j] = true;
                }
                if (ligne.charAt(j) == '.') {
                    murs[i][j] = false;
                }
            }
            ligne = fich.readLine();
        }

        Labyrinthe l = new Labyrinthe(murs, personnage, sortie);
        return l;
    }
}
