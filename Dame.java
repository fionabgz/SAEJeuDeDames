import java.util.Scanner;

public class Dame {

    /**
     * retourne vraie si pour la case d'arrivée du pion blanc est à l'extrémité du plateau
     * soit i=0
     * @param indiceLigne
     * @param indiceColonne
     * @return
     */
    public static boolean blancEstAExtremite(int indiceLigne, int indiceColonne){
        if (indiceLigne==0)
            return true;
        return false;
    }

    public static boolean noirEstAExtremite(int indiceLigne, int indiceColonne){
        if (indiceLigne==7)
            return true;
        return false;
    }
    public static void blancDevientDame(char[][] damier, int ligne, int colonne, int ligneArrivee, int colonneArrivee ) {
        if (blancEstAExtremite(ligneArrivee, colonneArrivee)) {
            damier[ligneArrivee][colonneArrivee] = 'b'; // dame du blanc noté b
            damier[ligne][colonne] = '.';
        } else {
            damier[ligneArrivee][colonneArrivee] = 'B';
            damier[ligne][colonne] = '.';
        }
    }
    public static void deplacement(Scanner sc, char joueur) { // char pour verif case contient pion de ce char/joueur // jai pas utilisé
        String chaine;
        int colonne, ligne;
        int colonneArrivee, ligneArrivee;
        char[][] damier;
        damier = Damier.tableauDuPlateau();

        Damier.afficherPlateau(Damier.tableauDuPlateau());
        System.out.println("Joueur 1 c'est à votre tour");
        do {
            System.out.println("Sélectionner votre pion en saissisant la case :");
            chaine = sc.nextLine();
            colonne = Methodes.indiceColonne(chaine.charAt(0));
            ligne = Methodes.indiceLigne(chaine.charAt(1));
            System.out.println(colonne + "," + ligne); // pour moi pour voir
            System.out.println(damier[ligne][colonne]);

        } while (!Methodes.saisieCorrecte(chaine) || damier[ligne][colonne]!='B');

        do {
            System.out.println("Saissisez la case d'arrivée du pion");
            chaine = sc.nextLine();
            colonneArrivee = Methodes.indiceColonne(chaine.charAt(0));
            ligneArrivee = Methodes.indiceLigne(chaine.charAt(1));
            System.out.println(colonneArrivee + "," + ligneArrivee); // pour moi pour voir
            System.out.println(damier[ligneArrivee][colonneArrivee]);
        } while (!Methodes.saisieCorrecte(chaine) ||damier[ligne][colonne]!='B' ||!Methodes.DameDeplacementPossible(damier,ligne,colonne,ligneArrivee,colonneArrivee));
        // dame condition : saisieCOrrecte, pion présent, case en diagonale aka point présent


        if (blancEstAExtremite(ligneArrivee,colonneArrivee)) {
            blancDevientDame(damier,ligne,colonne,ligneArrivee,colonneArrivee); // inclut placement point
        }
        else {
            damier[ligneArrivee][colonneArrivee] = 'B';
            damier[ligne][colonne] = '.';
        }
    }


    public static void deplacementDame(char [][] damier, int ligne,int colonne,int ligneArrivee, int colonneArivee) {
        if (Methodes.deplacementPossible(damier,ligne,colonne,ligneArrivee,colonneArivee)) {
            damier[ligne][colonne] = '.';
            damier[ligneArrivee][colonneArivee] = 'b';
        }
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


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        deplacement(sc,'B');

    }
}
