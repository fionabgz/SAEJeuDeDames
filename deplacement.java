import java.util.Scanner;

public class Deplacement {


    /*public static void main(String[] args) {
        System.out.println(Integer.parseInt(String.valueOf('3'))+Integer.parseInt(String.valueOf('3')));
    }*/



     static void DepacementClassique(char[][] dammier , Scanner sc) {
         String colonneInit, colonneDirection;
         int ligneInit, ligneDirection;
         String lettre = "ABCDEFGH";
         do {
             System.out.println("quelle est la colonne du pion que vous voulez bouger?");
             colonneInit = sc.nextLine();
         } while (colonneInit.length() != 2 || lettre.indexOf(colonneInit.charAt(0)) == -1 || Integer.parseInt(String.valueOf(colonneInit.charAt(1))) <= 0 || Integer.parseInt(String.valueOf(colonneInit.charAt(1))) > 8);
     }
}
