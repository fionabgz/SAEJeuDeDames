public class Damier {

    public static void main(String[] args) {
        afficherPlateau(tableauDuPlateau());

    }
    public static char[][] tableauDuPlateau(){
        char[][] damier=new char[8][8];

        //CAS REMPLIR DAMIER AVEC DES POINT SI CASE VIDE

       for (int i=0; i<damier.length;i++){
           for (int j=0; j<damier.length;j++)
               damier[i][j]='.';
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


