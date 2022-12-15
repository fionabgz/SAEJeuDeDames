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
        char [][] damier=Damier.tableauDuPlateau();
    }

    public static boolean saisieCorrecte(String chaine) {
        return (chaine.length() == 2 ||( chaine.charAt(0)>=65&&chaine.charAt(0)<=72)|| chaine.charAt(1) >= 0 || chaine.charAt(1) <= 7);
    }

    public static boolean deplacementBlancPossible(char[][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee){
        if (ligne-ligneArrivee==1&& (colonne-colonneArivee==1||colonne-colonneArivee==-1))
            return true;
        else if (ligne-ligneArrivee==2){
            if ((colonne-colonneArivee==2)&&damier[ligne-1][colonne-1]=='N')
                return true;
            else if ((colonne-colonneArivee==-2)&&damier[ligne-1][colonne+1]=='N')
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public static void deplacementBlanc(char [][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
        if (ligne-ligneArrivee==1&& (colonne-colonneArivee==1||colonne-colonneArivee==-1)) {
            damier[ligne][colonne] = '.';
            damier[ligneArrivee][colonneArivee] = 'B';
        }
        else if (ligne-ligneArrivee==2){
            if ((colonne-colonneArivee==2)&&damier[ligne-1][colonne-1]=='N') {
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = 'B';
                damier[ligne - 1][colonne - 1] = '.';
            }
            else if ((colonne-colonneArivee==-2)&&damier[ligne-1][colonne+1]=='N'){
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = 'B';
                damier[ligne -1][colonne +1] = '.';
            }
        }
    }
    public static boolean deplacementNoirPossible(char[][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
        if (ligne - ligneArrivee == -1 && (colonne - colonneArivee == 1 || colonne - colonneArivee == -1)) {
            return true;
        } else if (ligne - ligneArrivee == -2) {
            if ((colonne - colonneArivee == 2) && damier[ligne + 1][colonne - 1] == 'B') {
                return true;
            } else if ((colonne - colonneArivee == -2) && damier[ligne + 1][colonne + 1] == 'B') {
                return true;
            } else
                return false;

        } else
            return false;
    }
    public static void deplacementNoir(char [][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
        if (ligne - ligneArrivee == -1 && (colonne - colonneArivee == 1 || colonne - colonneArivee == -1)) {
            damier[ligne][colonne] = '.';
            damier[ligneArrivee][colonneArivee] = 'N';
        } else if (ligne - ligneArrivee == -2) {
            if ((colonne - colonneArivee == 2) && damier[ligne + 1][colonne - 1] == 'B') {
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = 'N';
                damier[ligne + 1][colonne - 1] = '.';
            } else if ((colonne - colonneArivee == -2) && damier[ligne + 1][colonne + 1] == 'B') {
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = 'N';
                damier[ligne + 1][colonne + 1] = '.';
            }
        }

    }
    public static boolean deplacementPossible(char[][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
        int epsilon;
        char couleurAdverse;
        if (damier[ligne][colonne] == Damier.NOIR){
            epsilon = -1;
            couleurAdverse= Damier.BLANC;
        } else {
            epsilon = 1;
            couleurAdverse = Damier.NOIR;
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
        if (damier[ligne][colonne] == Damier.NOIR) {
            epsilon = -1;
            couleur = Damier.NOIR;
            couleurAdverse= Damier.BLANC;
        } else {
            epsilon = 1;
            couleur = Damier.BLANC;
            couleurAdverse = Damier.NOIR;
        }
        if (ligne - ligneArrivee == epsilon && (colonne - colonneArivee == 1 || colonne - colonneArivee == -1)) {
            damier[ligne][colonne] = '.';
            damier[ligneArrivee][colonneArivee] = couleur;
        } else if (ligne - ligneArrivee == epsilon*2) {
            if ((colonne - colonneArivee == 2) && damier[ligne - epsilon][colonne - 1] == couleurAdverse) {
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = couleur;
                damier[ligne - epsilon ][colonne - 1] = '.';
            } else if ((colonne - colonneArivee == -2) && damier[ligne - epsilon][colonne + 1] == couleurAdverse) {
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = couleur;
                damier[ligne -epsilon][colonne + 1] = '.';
            }
        }

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
