package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainLaby {

    public static void main(String[] args) throws IOException {

        boolean jeuEnCours = true;
        boolean actionInconnue = false;
        boolean finJeu = false;

        while (!jeuEnCours || !finJeu) {
            System.out.println("Nom du labyrinthe a utiliser : ");
            Scanner sc = new Scanner(System.in);
            String nomFichier = sc.nextLine();
            Labyrinthe l = null;

            try
            {
                l = Labyrinthe.chargerLabyrinthe(nomFichier);
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Fichier introuvable");
            }
            catch (IOException e)
            {
                System.out.println("Fichier non valide");
            }

            System.out.println(l.toString());
            System.out.println("\n");
            System.out.println("Entrez une action (haut/bas/gauche/droite) a faire pour le personnage : ");

            String action = sc.nextLine();
            try
            {
                l.deplacerPerso(action);
                while (actionInconnue) {
                    action = sc.nextLine();
                }
            }
            catch (ActionInconnueException e)
            {
                System.out.println("Action inconnue, veuillez reessayer");
                actionInconnue = true;
            }

            if (action.equals("exit")) {
                jeuEnCours = false;
            }

            if (l.etreFini()) {
                finJeu = true;
            }

            System.out.println(l.toString());

        }




    }
}
