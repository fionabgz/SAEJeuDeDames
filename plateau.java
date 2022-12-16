public class Damier {
        public final static char BLANC='B';
        public final static char NOIR='N';
        public final static char VIDE='.';
        public static void main(String[] args) {
            afficherPlateau(tableauDuPlateau());

        }
        public static char[][] tableauDuPlateau(){
            char[][] damier=new char[8][8]; // pour passer à dim [10][10] > faisable + ajustement l.55 ajouter "IJ"

            //CAS REMPLIR DAMIER AVEC DES espaces SI CASE VIDE et non diagonale

            for (int i=0; i<damier.length;i++){
                for (int j=0; j<damier.length;j++)
                    damier[i][j]=' ';
            }
            // CAS AFFICHAGE CASES EN NOIR ET BLANC AVEC CHARACTERE ASCII
/*       for (int i=0; i<damier.length;i++) {
           for (int j=0; j<damier.length;j++){
              if(i%2==0 && j%2==0)
                   damier[i][j]=128; // CHARACTERE ASCII BLANC
               else
                   damier[i][j]=' '; // ESPACE PAS OU  DE CHAR
           }
       }*/
            // AFFICHAGE AVEC PION 12 PIONS NOIR ET 12 PIONS BLANCHE AU DÉMARRAGE
            for (int i=0; i<(damier.length/2)-1;i++) {
                for (int j = 0; j < damier.length; j++) {
                    if ((i % 2 == 0 && j % 2 != 0) || (j%2==0 && i%2!=0))
                        damier[i][j] = 'N';
                }
            }
            // affichage des cases en diagonale sans pion dessus au demarrrage
            for (int i =(damier.length-1)/2;i<(damier.length-(damier.length/2))+1;i++){
                for (int j = 0; j <damier.length; j++) {
                    if ((i%2 == 0 && j%2 != 0 ) || ( j%2==0 && i%2!=0 )) // remplir avec des point sau mileu
                        damier[i][j] = '.';
                }
            }

            for (int i= damier.length-1; i>damier.length/2;i--){
                for (int j = damier.length-1; j>=0; j--){
                    if ((i%2 == 0 && j%2 != 0 ) || ( j%2==0 && i%2!=0 ))
                        damier[i][j] = 'B';
                }


            }return damier;
        }

        public static void afficherPlateau(char[][] tableauDuPlateau){
            int numeroDeCaseLigne=0;

            System.out.println(" \tA\tB\tC\tD\tE\tF\tG\tH");

            for (int i = 0; i < tableauDuPlateau.length; i++) {
                System.out.print(numeroDeCaseLigne++);
                for (int j = 0; j < tableauDuPlateau[i].length; j++) {
                    System.out.print("\t"+tableauDuPlateau[i][j] );
                }
                System.out.println();
            }

        }






    }


