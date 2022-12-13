
        else if (ligne-ligneArrivee==2){
            if ((colonne-colonneArivee==2)&&damier[ligne-1][colonne-1]=='N') {
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = 'B';
                damier[ligne - 1][colonne - 1] = '.';
            }
            else if ((colonne-colonneArivee==-2)&&damier[ligne+1][colonne+1]=='N'){
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = 'B';
                damier[ligne +1][colonne +1] = '.';
            }
        }

    }
    public static boolean deplacementNoirPossible(char[][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
        if (ligne - ligneArrivee == -1 && (colonne - colonneArivee == 1 || colonne - colonneArivee == -1)) {
            return true;
        } else if (ligne - ligneArrivee == -2) {
            if ((colonne - colonneArivee == 2) && damier[ligne - 1][colonne - 1] == 'B') {
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
            if ((colonne - colonneArivee == 2) && damier[ligne - 1][colonne - 1] == 'B') {
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = 'N';
                damier[ligne - 1][colonne - 1] = '.';
            } else if ((colonne - colonneArivee == -2) && damier[ligne + 1][colonne + 1] == 'B') {
                damier[ligne][colonne] = '.';
                damier[ligneArrivee][colonneArivee] = 'N';
                damier[ligne + 1][colonne + 1] = '.';
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
