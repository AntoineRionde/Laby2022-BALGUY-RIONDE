import java.io.*;
public class MultiplesBin {

  /** le reel dont on veut les multiples */
  private double val;

  /** constructeur qui prend le reel en paramètre */
  public MultiplesBin(double v) {
    this.val=v;
  }

  /** methode en charge de creer et de remplir le fichier */
  public void remplirFichier(String fichier,int nb) throws IOException {
    DataOutputStream  d = new DataOutputStream (new FileOutputStream(fichier));
    for(int i=1;i<=nb;i++){
      d.writeInt(nb);
      d.writeDouble(nb *this.val);
    }
    d.close();
  }

  public void extraireFichier(String nom)throws IOException{
    DataInputStream d = new DataInputStream(new FileInputStream (nom));
    int nb =-1;
    double value;
    try{
      while(true){
        nb=d.readInt();
        value=d.readDouble();
      }
      printf("%d;%1.3\n",nb,value);
    }catch(EOFException e){}
      d.close();
  }

  /**
   * main permettant de tester votre méthode
   */
  public static void main(String[] args) {
    try {
      MultiplesBin m = new MultiplesBin(Double.parseDouble(args[0]));
      m.remplirFichier(args[2],Integer.parseInt(args[1]));
    }
    catch (NumberFormatException e) {
      System.out.println("Mauvais format des paramètres passés (reel, entier, String)");
    }
    catch (IOException e ) {
      System.out.println("probleme a l'ouverture du fichier");
    }
  }
}
