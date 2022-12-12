import java.util.Scanner;
public class JoueurBlanc {
	
	public static void tour(Scanner sc) {
		String chaine;
		int indiceColonne,indiceLigne;
		char [][] damier;
		damier = AfficherDamier.tableauDuPlateau();
	
		
		System.out.println("Joueur 1 c'est à votre tour");
		do {
		System.out.println("Quelle est la case du pion que vous voulez bouger?");
		chaine =sc.nextLine();
		indiceColonne=Methodes.indiceColonne(chaine.charAt(0));
		indiceLigne=Methodes.indiceLigne(chaine.charAt(1));
		System.out.println(indiceColonne+","+ indiceLigne);
		System.out.print(damier[indiceLigne][indiceColonne]);

		}while(!Methodes.saisieCorrecte(chaine)||!Methodes.pionBlancSurCase(damier[indiceLigne][indiceColonne]));

		
		
	}
	 public static void main(String[] args) {
	      Scanner sc =new Scanner(System.in);
	      tour(sc);
	 }
	 
	

}

/* 	A	B	C	D	E	F	G	H
0	.	N	.	N	.	N	.	N
1	N	.	N	.	N	.	N	.
2	.	N	.	N	.	N	.	N
3	.	.	.	.	.	.	.	.
4	.	.	.	.	.	.	.	.
5	B	.	B	.	B	.	B	.
6	.	B	.	B	.	B	.	B
7	B	.	B	.	B	.	B	.*/
