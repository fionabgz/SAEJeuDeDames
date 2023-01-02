import java.util.Scanner;
public class JoueurBlanc {

//  public static void tourBlanc(Scanner sc,char[][]damier ) {
//      String chaine;
//      int indiceColonne,indiceLigne;
//      int indLigneArrivee ,indColonneArrivee;
//
//      /*String menuTour="C'est à votre tour \n" +
//              "taper 1 pour entrer/modifier les coordonnées de la case du pion que vous voulez changer \n" +
//              "taper 2  pour entrer/modifier les coordonées de la case sur laquelle vous voulez aller" +
//              "taper 3 pour valider ";
//      */
//              System.out.println("Joueur 1 c'est à votre tour");
//              do {
//                  System.out.println("Quelle est la case du pion que vous voulez bouger?");
//                  chaine = sc.nextLine();
//                  indiceColonne = Methodes.indiceColonne(chaine.charAt(0));
//                  indiceLigne = Methodes.indiceLigne(chaine.charAt(1));
//              } while (!Methodes.saisieCorrecte(chaine) || damier[indiceLigne][indiceColonne]!='B');
//
//              do {
//                  System.out.println("Sur quelle case voulez vous aller ?");
//                  chaine = sc.nextLine();
//                  indColonneArrivee = Methodes.indiceColonne(chaine.charAt(0));
//                  indLigneArrivee = Methodes.indiceLigne(chaine.charAt(1));
//              } while (!Methodes.saisieCorrecte(chaine)||!Methodes.deplacementBlancPossible(damier,indiceLigne,indiceColonne,indLigneArrivee,indColonneArrivee)||damier[indLigneArrivee][indColonneArrivee]!='.');
//              Methodes.deplacementBlanc(damier,indiceLigne,indiceColonne,indLigneArrivee,indColonneArrivee);
//
//  }
//
//  public static void tourNoir(Scanner sc,char[][]damier ) {
//      String chaine;
//      int indiceColonne,indiceLigne;
//      int indLigneArrivee ,indColonneArrivee;
//
//      System.out.println("Joueur 2 c'est à votre tour");
//      do {
//          System.out.println("Quelle est la case du pion que vous voulez bouger?");
//          chaine = sc.nextLine();
//          indiceColonne = Methodes.indiceColonne(chaine.charAt(0));
//          indiceLigne = Methodes.indiceLigne(chaine.charAt(1));
//      } while (!Methodes.saisieCorrecte(chaine) || damier[indiceLigne][indiceColonne]!='N');
//
//      do {
//          System.out.println("Sur quelle case voulez vous aller ?");
//          chaine = sc.nextLine();
//          indColonneArrivee = Methodes.indiceColonne(chaine.charAt(0));
//          indLigneArrivee = Methodes.indiceLigne(chaine.charAt(1));
//      } while (!Methodes.saisieCorrecte(chaine) ||!Methodes.deplacementNoirPossible(damier,indiceLigne,indiceColonne,indLigneArrivee,indColonneArrivee)||damier[indLigneArrivee][indColonneArrivee]!='.');
//      Methodes.deplacementNoir(damier,indiceLigne,indiceColonne,indLigneArrivee,indColonneArrivee);
//
//  }
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      char[][] damier;
      damier = AfficherDamier.tableauDuPlateau();
      int cpt = 0;
      do {
          AfficherDamier.afficherPlateau(damier);
          tour(sc,damier,AfficherDamier.BLANC);
          AfficherDamier.afficherPlateau(damier);
          tour(sc,damier,AfficherDamier.NOIR);
          System.out.println();
          cpt++;
      } while (cpt < 100);

  }


  public static void tour(Scanner sc,char[][]damier,char couleur) {
      String chaine;
      int indiceColonne,indiceLigne;
      int indLigneArrivee ,indColonneArrivee;

      /*String menuTour="C'est à votre tour \n" +
              "taper 1 pour entrer/modifier les coordonnées de la case du pion que vous voulez changer \n" +
              "taper 2  pour entrer/modifier les coordonées de la case sur laquelle vous voulez aller" +
              "taper 3 pour valider ";
      */
      System.out.println( couleur +", c'est à votre tour");
         do {
              System.out.println("Quelle est la case du pion que vous voulez bouger?");
              chaine = sc.nextLine();
              indiceColonne = Methodes.indiceColonne(chaine.charAt(0));
              indiceLigne = Methodes.indiceLigne(chaine.charAt(1));
          } while (!Methodes.saisieCorrecte(chaine) || damier[indiceLigne][indiceColonne] != couleur);
          do {
              System.out.println("Sur quelle case voulez vous aller ?");
              chaine = sc.nextLine();
              indColonneArrivee = Methodes.indiceColonne(chaine.charAt(0));
              indLigneArrivee = Methodes.indiceLigne(chaine.charAt(1));
          } while (!Methodes.saisieCorrecte(chaine) ||(( !Methodes.deplacementPossible(damier, indiceLigne, indiceColonne, indLigneArrivee, indColonneArrivee) || damier[indLigneArrivee][indColonneArrivee] != AfficherDamier.VIDE)&&!Methodes.priseMultiPossible(damier, indiceLigne, indiceColonne, indLigneArrivee, indColonneArrivee)));
          
          if(Methodes.priseMultiPossible(damier, indiceLigne, indiceColonne, indLigneArrivee, indColonneArrivee)) {
        	  System.out.println("cas prem");
        	  System.out.println(Methodes.priseMultiPossible(damier, indiceLigne, indiceColonne, indLigneArrivee, indColonneArrivee));
        	  Methodes.priseMultiple(damier, indiceLigne, indiceColonne, indLigneArrivee, indColonneArrivee);
          }else {
        	  Methodes.deplacement(damier, indiceLigne, indiceColonne, indLigneArrivee, indColonneArrivee);
          	System.out.println("cas deux");}
  }
  

}

/* 	A	B	C	D	E	F	G	H
0	 	N	 	N	 	N	 	N
1	N	 	N	 	N	 	N
2	 	N	 	N	 	N	 	N
3	.	 	.	 	.	 	.
4	 	.	 	.	 	.	 	.
5	B	 	B	 	B	 	B
6	 	B	 	B	 	B	 	B
7	B	 	B	 	B	 	B
*/
