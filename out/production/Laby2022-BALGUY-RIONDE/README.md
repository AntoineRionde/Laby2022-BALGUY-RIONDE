# Laby2022-BALGUY-RIONDE

Membres du groupe : 
RIONDE, BALGUY

### Descriptif des difficultés rencontrées :
La méthode déplacerPersonnag ne fonctionne pas
malgré de nombreux tests et tentatives de corrections.
La méthode toString également ne fonctionne pas.
Mise à part ces deux méthodes, les autres méthodes
n'ont pas posé de problèmes.

### Explication de nos choix de programmation : 
Nous avons décidé de répartir équitablement les méthodes
à faire pour la classe Labyrinthe. J'ai fait la méthode
chargerLabyrinthe, etreFini, getChar. Et mon camarade
BALGUY a fait la méthode deplacerPersonnage, getSuivant
et toString.

### Descriptif expliquant comment lancer notre application :
Pour lancer notre application, il suffit de se placer
dans le repertoire src dans un terminal, de compiler
tous les fichiers (javac *.java)  et d'éxécuter la classe
MainLaby (java MainLaby).

### Résumé des résultats de nos tests :
Le test pour la methode toString ne fonctionne pas.
Celui pour la methode deplacerPerso échoue.
Le test pour la methode getChar fonctionne.
Les deux tests pour la methode etreFini
(test_etreFiniFalse et test_etreFiniTrue )
fonctionne et échoue respectivement, car le test pour 
tester quand le jeu est fini, nécessite la methode
deplacerPersonnage, qui échoue.
Celui pour la methode getSuivant() fonctionne.







