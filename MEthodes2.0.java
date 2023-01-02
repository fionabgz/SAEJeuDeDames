package jeuDeDame;

public class Methodes {

    /**
     * @param c
     * @return l'indice de la colonne converti en int en utilisant le code ascii
     */
    public static int indiceColonne(char c) {
        int nb = c;
        if (nb >= 72)
            return 0;
        else
            return (nb - 65);
    }

    /**
     * @param ligne
     * @return l'indice de la ligne converti en int
     */
    public static int indiceLigne(char ligne) {
        return Integer.parseInt(String.valueOf(ligne)) ;
    }
    
    public static void main(String[] args) {
        char [][] damcier={{' ','N',' ','N',' ','N',' ','N'},{'0',' ','2',' ','4',' ','6',' '},{' ','1',' ','3',' ','5',' ','7'},{'B',' ','.',' ','.',' ','.',' '},{' ','1',' ','N',' ','N',' ','7'},{'0',' ','2',' ','.',' ','6',' '},{' ','1',' ','3',' ','N',' ','7'},{'B',' ','B',' ','B',' ','B',' '}};
        char [][] damcieior={{' ','N',' ','N',' ','N',' ','N'},{'0',' ','2',' ','4',' ','6',' '},{' ','1',' ','3',' ','5',' ','7'},{'B',' ','.',' ','.',' ','.',' '},{' ','B',' ','N',' ','N',' ','7'},{'0',' ','2',' ','.',' ','6',' '},{' ','1',' ','3',' ','N',' ','7'},{'B',' ','B',' ','B',' ','B',' '}};
        AfficherDamier.afficherPlateau(damcieior);
        System.out.print(Methodes.priseMultiPossible(damcieior,4,1,3,2));
 /*       Methodes.priseMultiple(damcier,7,6,3,2);
        AfficherDamier.afficherPlateau(damcier);*/
    }

    public static boolean saisieCorrecte(String chaine) {
        return (chaine.length() == 2 ||( chaine.charAt(0)>=65&&chaine.charAt(0)<=72)|| chaine.charAt(1) >= 0 || chaine.charAt(1) <= 7);
    }

//    public static boolean deplacementBlancPossible(char[][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee){
//        if (ligne-ligneArrivee==1&& (colonne-colonneArivee==1||colonne-colonneArivee==-1))
//            return true;
//        else if (ligne-ligneArrivee==2){
//            if ((colonne-colonneArivee==2)&&damier[ligne-1][colonne-1]=='N')
//                return true;
//            else if ((colonne-colonneArivee==-2)&&damier[ligne-1][colonne+1]=='N')
//                return true;
//            else
//                return false;
//        }
//        else
//            return false;
//    }
//
//    public static void deplacementBlanc(char [][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
//        if (ligne-ligneArrivee==1&& (colonne-colonneArivee==1||colonne-colonneArivee==-1)) {
//            damier[ligne][colonne] = '.';
//            damier[ligneArrivee][colonneArivee] = 'B';
//        }
//        else if (ligne-ligneArrivee==2){
//            if ((colonne-colonneArivee==2)&&damier[ligne-1][colonne-1]=='N') {
//                damier[ligne][colonne] = '.';
//                damier[ligneArrivee][colonneArivee] = 'B';
//                damier[ligne - 1][colonne - 1] = '.';
//            }
//            else if ((colonne-colonneArivee==-2)&&damier[ligne-1][colonne+1]=='N'){
//                damier[ligne][colonne] = '.';
//                damier[ligneArrivee][colonneArivee] = 'B';
//                damier[ligne -1][colonne +1] = '.';
//            }
//        }
//    }
//    public static boolean deplacementNoirPossible(char[][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
//        if (ligne - ligneArrivee == -1 && (colonne - colonneArivee == 1 || colonne - colonneArivee == -1)) {
//            return true;
//        } else if (ligne - ligneArrivee == -2) {
//            if ((colonne - colonneArivee == 2) && damier[ligne + 1][colonne - 1] == 'B') {
//                return true;
//            } else if ((colonne - colonneArivee == -2) && damier[ligne + 1][colonne + 1] == 'B') {
//                return true;
//            } else
//                return false;
//
//        } else
//            return false;
//    }
//    public static void deplacementNoir(char [][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
//        if (ligne - ligneArrivee == -1 && (colonne - colonneArivee == 1 || colonne - colonneArivee == -1)) {
//            damier[ligne][colonne] = '.';
//            damier[ligneArrivee][colonneArivee] = 'N';
//        } else if (ligne - ligneArrivee == -2) {
//            if ((colonne - colonneArivee == 2) && damier[ligne + 1][colonne - 1] == 'B') {
//                damier[ligne][colonne] = '.';
//                damier[ligneArrivee][colonneArivee] = 'N';
//                damier[ligne + 1][colonne - 1] = '.';
//            } else if ((colonne - colonneArivee == -2) && damier[ligne + 1][colonne + 1] == 'B') {
//                damier[ligne][colonne] = '.';
//                damier[ligneArrivee][colonneArivee] = 'N';
//                damier[ligne + 1][colonne + 1] = '.';
//            }
//        }
//
//    }
    public static boolean deplacementPossible(char[][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
        int epsilon;
        char couleurAdverse;
        if (damier[ligne][colonne] == AfficherDamier.NOIR){
            epsilon = -1;
            couleurAdverse= AfficherDamier.BLANC;
        } else {
            epsilon = 1;
            couleurAdverse = AfficherDamier.NOIR;
        }

        if (ligne - ligneArrivee == epsilon && (colonne - colonneArivee == 1 || colonne - colonneArivee == -1)) {
                return true;
            } else if (ligne - ligneArrivee == epsilon * 2) {
                if ((colonne - colonneArivee == 2) && damier[ligne -epsilon][colonne - 1] == couleurAdverse) {
                    return true;
                } else if ((colonne - colonneArivee == -2) && damier[ligne - epsilon][colonne + 1] == couleurAdverse) {
                    return true;
                } else
                    return false;

            } else
                return false;

    }
    public static void deplacement(char [][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
        int epsilon ;
        char couleur;
        char couleurAdverse;
        if (damier[ligne][colonne] == AfficherDamier.NOIR) {
            epsilon = -1;
            couleur = AfficherDamier.NOIR;
            couleurAdverse= AfficherDamier.BLANC;
        } else {
            epsilon = 1;
            couleur = AfficherDamier.BLANC;
            couleurAdverse = AfficherDamier.NOIR;
        }
        if (ligne - ligneArrivee == epsilon && (colonne - colonneArivee == 1 || colonne - colonneArivee == -1)) {
            damier[ligne][colonne] = AfficherDamier.VIDE;
            damier[ligneArrivee][colonneArivee] = couleur;
        } else if (ligne - ligneArrivee == epsilon*2) {
            if ((colonne - colonneArivee == 2) && damier[ligne - epsilon][colonne - 1] == couleurAdverse) {
                damier[ligne][colonne] = AfficherDamier.VIDE;
                damier[ligneArrivee][colonneArivee] = couleur;
                damier[ligne - epsilon ][colonne - 1] = AfficherDamier.VIDE;
            } else if ((colonne - colonneArivee == -2) && damier[ligne - epsilon][colonne + 1] == couleurAdverse) {
                damier[ligne][colonne] = AfficherDamier.VIDE;
                damier[ligneArrivee][colonneArivee] = couleur;
                damier[ligne -epsilon][colonne + 1] = AfficherDamier.VIDE;
            }
        }
    }
//    public static boolean priseMultiplePossible(char[][]damier,int ligne,int colonne,int ligneArrivee,int colonneArrivee){
//        int epsilon ;
//        char couleurAdverse;
//        if (damier[ligne][colonne] == Damier.NOIR){
//            epsilon = -1;
//            couleurAdverse= Damier.BLANC;
//        } else {
//            epsilon = 1;
//            couleurAdverse = Damier.NOIR;
//        }
//        if (ligne-ligneArrivee==epsilon*4){
//            if
//        }
    public static boolean prisePossible(char[][]damier , int ligne, int colonne){
        int epsilon ;
        char couleurAdverse;
        if (damier[ligne][colonne] == AfficherDamier.NOIR){
            epsilon = -1;
            couleurAdverse= AfficherDamier.BLANC;
        } else {
            epsilon = 1;
            couleurAdverse = AfficherDamier.NOIR;
        }
        if (colonne==0)
            return(damier[ligne-epsilon][colonne+1]==couleurAdverse && damier[ligne-epsilon*2][colonne+2]==AfficherDamier.VIDE);
        else if (colonne==7)
            return (damier[ligne-epsilon][colonne-1]==couleurAdverse && damier[ligne-epsilon*2][colonne-2]==AfficherDamier.VIDE);
        else
            return((damier[ligne-epsilon][colonne+1]==couleurAdverse && damier[ligne-epsilon*2][colonne+2]==AfficherDamier.VIDE)||(damier[ligne-epsilon][colonne-1]==couleurAdverse && damier[ligne-epsilon*2][colonne-2]==AfficherDamier.VIDE));
    }
    public static boolean prisePossibleDroite(char[][]damier , int ligne,int colonne) {
    	 int epsilon ;
         char couleurAdverse;
         if (damier[ligne][colonne] == AfficherDamier.NOIR){
             epsilon = -1;
             couleurAdverse= AfficherDamier.BLANC;
         } else {
             epsilon = 1;
             couleurAdverse = AfficherDamier.NOIR;
         }
         if(colonne<=5)
        	 return(damier[ligne-epsilon][colonne+1]==couleurAdverse && damier[ligne-epsilon*2][colonne+2]==AfficherDamier.VIDE);
         else 
        	 return false ;
    }
    public static boolean prisePossibleGauche(char [][] damier , int ligne,int colonne) {
    	int epsilon ;
        char couleurAdverse;
        if (damier[ligne][colonne] == AfficherDamier.NOIR){
            epsilon = -1;
            couleurAdverse= AfficherDamier.BLANC;
        } else {
            epsilon = 1;
            couleurAdverse = AfficherDamier.NOIR;
        }
        if (colonne>=3)
        	return (damier[ligne-epsilon][colonne-1]==couleurAdverse && damier[ligne-epsilon*2][colonne-2]==AfficherDamier.VIDE);
        else 
        	return false; 
    }

    public static void priseAutomatiqueDroite(char [][]damier, int ligne,int colonne){
    	int epsilon ;
        char couleur;
        
        if (damier[ligne][colonne] == AfficherDamier.NOIR) {
            epsilon = -1;
            couleur = AfficherDamier.NOIR;
        } else {
            epsilon = 1;
            couleur = AfficherDamier.BLANC;
       
        }
    	damier[ligne][colonne] = AfficherDamier.VIDE;
    	damier[ligne-epsilon*2][colonne+2]=couleur;
        damier[ligne - epsilon ][colonne + 1] = AfficherDamier.VIDE;
    }
    public static void priseAutomatiqueGauche(char [][]damier, int ligne,int colonne){
    	int epsilon ;
        char couleur;
        if (damier[ligne][colonne] == AfficherDamier.NOIR) {
            epsilon = -1;
            couleur = AfficherDamier.NOIR;
        } else {
            epsilon = 1;
            couleur = AfficherDamier.BLANC;
        }
    	if (Methodes.prisePossibleGauche(damier, ligne, colonne)){
    		damier[ligne][colonne] = AfficherDamier.VIDE;
    		damier[ligne-epsilon*2][colonne-2]=couleur;
            damier[ligne - epsilon ][colonne -1] = AfficherDamier.VIDE;
    	}
    }
    /*
	public static boolean PriseMultiplePossible(char[][]damier ,int ligne,int colonne,int ligneArrivee,int colonneArrivee) {
    	int lignePivot=ligne;
    	int colonnePivot=colonne; 
    	boolean possible=true;
		int epsilon ;
        if (damier[ligne][colonne] == AfficherDamier.NOIR) {
            epsilon = -1;
        } else {
            epsilon = 1;
        } 
        
        while((lignePivot<=ligneArrivee&&possible)) {
        if (Methodes.prisePossibleDroite(damier, lignePivot, colonnePivot)) {
        	lignePivot=lignePivot -epsilon*2;
        	colonnePivot=colonnePivot+2;
        }
        else if (Methodes.prisePossibleGauche(damier, lignePivot, colonnePivot)) {
        	lignePivot=lignePivot -epsilon*2;
        	colonnePivot=colonnePivot-2;
        }
        else if (lignePivot==ligneArrivee&&colonnePivot==colonneArrivee)
        	lignePivot=lignePivot-epsilon;
        else 
        	possible=false;
        }
        return possible;
	}*/
	
	public static void priseMultiple(char[][]damier,int ligne , int colonne,int ligneArrivee,int colonneArrivee) {
    	int lignePivot=ligne;
    	int colonnePivot=colonne; 
		int epsilon ;
        if (damier[ligne][colonne] == AfficherDamier.NOIR) {
            epsilon = -1;
            while(lignePivot<=ligneArrivee+epsilon*2) {
    	        if (Methodes.prisePossibleDroite(damier, lignePivot, colonnePivot)) {
    	        	Methodes.priseAutomatiqueDroite(damier, lignePivot, colonnePivot);
    	        	lignePivot=lignePivot -epsilon*2;
    	        	colonnePivot=colonnePivot+2;
    	        }
    	        else {
    	        	Methodes.priseAutomatiqueGauche(damier, lignePivot, colonnePivot);
    	        	lignePivot=lignePivot -epsilon*2;
    	        	colonnePivot=colonnePivot-2;
    	        }
            }
    	     
        } else {
            epsilon = 1;
			while(lignePivot>=ligneArrivee+epsilon*2) {
		        if (Methodes.prisePossibleDroite(damier, lignePivot, colonnePivot)) {
		        	Methodes.priseAutomatiqueDroite(damier, lignePivot, colonnePivot);
		        	lignePivot=lignePivot -epsilon*2;
		        	colonnePivot=colonnePivot+2;
		        }
		        else{
		        	Methodes.priseAutomatiqueGauche(damier, lignePivot, colonnePivot);
		        	lignePivot=lignePivot -epsilon*2;
		        	colonnePivot=colonnePivot-2;
		        }

		       
			}
        }
	}
	public static boolean  priseMultiPossible(char[][]damier,int l,int c,int la,int ca) { 	
		int epsilon ;
		boolean possible=true;
		int ligne = l;
		int colonne=c;
        if (damier[l][c] == AfficherDamier.NOIR) {
        	System.out.println("noir");
            epsilon = -1;
            if (l==la+epsilon)
            	return false;
            else {
	        while (possible||ligne<=(la+epsilon*2)) {
	        	if (Methodes.prisePossibleDroite(damier, ligne, colonne)) {
	        		ligne= ligne-epsilon*2;
	        		colonne=colonne+2;
	        		System.out.println("cas1");
		        }
		        else if (Methodes.prisePossibleGauche(damier, ligne, colonne)) {
		        	ligne= ligne-epsilon*2;
		        	colonne=colonne-2;
		        	System.out.println("cas2");
		        }
		        else {
		        	System.out.println("cas3");
		        	return false;
	        	
		        }
	        	}
	        }
        }
      
        else {
            epsilon = 1;
            System.out.println("blanc");
            if (l==la+epsilon)
            	return false;
            else {
	        while (possible&&ligne>=(la+epsilon*2)) {
	        	System.out.println("boucle");
	        	if (Methodes.prisePossibleDroite(damier, ligne, colonne)) {
	        		ligne= ligne-epsilon*2;
	        		colonne=colonne+2;
	        		System.out.println("cas1");
		        }
		        else if (Methodes.prisePossibleGauche(damier, ligne, colonne)) {
		        	ligne= ligne-epsilon*2;
		        	colonne=colonne-2;
		        	System.out.println("cas2");
		        }
		        else {
		        	System.out.println("cas3");
		        	return false;}
	        		
	        	System.out.println (ligne+" "+colonne);
	        	
			}
            }
        }
     return possible; 
	}
	
	
}

//  0   1   2   3   4   5   6   7
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
