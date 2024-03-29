import org.junit.jupiter.api.Test;
import src.Labyrinthe;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe de test verifiant les fonctions de la classe Labyrinthe
 */
public class TestLaby {

    @Test
    public void test_toString() throws Exception{ // ne marche pas
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // toString
        String s = l.toString();

        assertEquals("5\n7\nXXXXXXX\nXS....X\nX..P..X\nX.....X\nXXXXXXX", s, "erreur");
    }

    @Test
    public void test_etreFiniFalse() throws Exception {
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // etrefini
        boolean b = l.etreFini();

        assertEquals(false, b, "erreur");
    }

    @Test
    public void test_getSuivant() throws Exception {
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // getsuivant et constantes action
        int[] resHaut = new int[2];
        int[] resBas = new int[2];
        int[] resDroite = new int[2];
        int[] resGauche = new int[2];
        resHaut = Labyrinthe.getSuivant(1,1,Labyrinthe.HAUT);
        resBas = Labyrinthe.getSuivant(1,1,Labyrinthe.BAS);
        resDroite = Labyrinthe.getSuivant(1,1,Labyrinthe.DROITE);
        resGauche = Labyrinthe.getSuivant(1,1,Labyrinthe.GAUCHE);

        int[] resAttGauche = new int[] {1, 0}; // gauche
        int[] resAttHaut = {0, 1}; // haut
        int[] resAttDroite = {1, 2}; // droite
        int[] resAttBas = {2, 1}; // bas

        assertEquals(resAttGauche[0], resGauche[0], "erreur");
        assertEquals(resAttHaut[0], resHaut[0], "erreur");
        assertEquals(resAttDroite[0], resDroite[0], "erreur");
        assertEquals(resAttHaut[0], resHaut[0], "erreur");

    }

    @Test
    public void test_deplacerPerso() throws Exception {
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // deplacerPerso
        l.deplacerPerso(Labyrinthe.HAUT);
        l.deplacerPerso(Labyrinthe.DROITE);
        l.deplacerPerso(Labyrinthe.DROITE);

        char ch = l.getChar(1, 5);

        assertEquals(Labyrinthe.PJ, ch,"erreur");
    }

    @Test
    public void test_getChar() throws Exception {
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        char cPerso = l.getChar(2, 3);
        char cMur = l.getChar(0, 0);
        char cSortie = l.getChar(1, 1);

        assertEquals(Labyrinthe.PJ, cPerso,"erreur");
        assertEquals(Labyrinthe.MUR, cMur,"erreur");
        assertEquals(Labyrinthe.SORTIE, cSortie,"erreur");
    }

    @Test
    public void test_etreFiniTrue() throws Exception {
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // deplacerPerso
        l.deplacerPerso(Labyrinthe.HAUT);
        l.deplacerPerso(Labyrinthe.GAUCHE);
        l.deplacerPerso(Labyrinthe.GAUCHE);

        // etrefini
        boolean b = l.etreFini();

        assertEquals(true, b, "erreur");
    }
}
