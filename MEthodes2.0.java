
public class Methodes {
	
	/**
	 * 
	 * @param c
	 * @return l'indice de la colonne converti en int en utilisant le code ascii
	 */
	public static int indiceColonne(char c){
        int nb= c;
        if( nb>=72)
        	return 0;
        else 
        	return (nb-65);
    }
	/**
	 * 
	 * @param ligne
	 * @return l'indice de la ligne converti en int
	 */
    public static int indiceLigne(char ligne) {
    	return Integer.parseInt(String.valueOf(ligne))-1;
    }
    /**
     * 
     * @param dammier
     * @param colonne
     * @param ligne
     * @return True si une case est vide et 
     */
    public static boolean caseVide(char[][]dammier,int colonne,int ligne){
        return dammier[ligne][colonne]=='.';
    }
    public static boolean caseBlanche(char[][]dammier,int colonne,int ligne) {
    	return dammier[ligne][colonne]=='C';
    	
    }
    public static void main(String[] args) {
    	System.out.print(indiceColonne('A'));
    	
    	System.out.print(indiceColonne('H'));

    }
    public static boolean saisieCorrecte(String chaine) {
    	String lettre = "ABCDEFGH";
    	return (chaine.length() == 2 || lettre.indexOf(chaine.charAt(0)) != -1 || Integer.parseInt(String.valueOf(chaine.charAt(1))) >= 0|| Integer.parseInt(String.valueOf(chaine.charAt(1))) < 8);   	
    }
    public static boolean pionBlancSurCase(char c) {
    	return c=='B';
    	
    }
    
    

}
