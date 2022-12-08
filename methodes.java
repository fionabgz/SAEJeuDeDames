
public class Methodes {
	public static int indiceLettreEnInt(char c){
        int nb=0;
        switch(c){
            case 'A':
                nb=1;
                break;
            case 'B':
                nb=2;
                break;
            case 'C':
                nb=3;
                break;
            case 'D':
                nb=4;
                break;
            case 'E':
                nb=5;
                break;
            case 'F':
                nb=6;
                break;
            case 'G':
                nb=7;
                break;
            case 'H':
                nb=8;
                break;
        }
        return nb;
    }
    public static int indiceColonne(char colonne) {
    	return Methodes.indiceLettreEnInt(colonne)-1;
    }
    public static int indiceLigne(char ligne) {
    	return Integer.parseInt(String.valueOf(ligne))-1;
    }
    public static boolean caseVide(char[][]dammier,int colonne,int ligne){
        return dammier[ligne][colonne]=='.';
    }
    public static boolean caseBlanche(char[][]dammier,int colonne,int ligne) {
    	return dammier[ligne][colonne]=='B';
    	
    }
    
    
    
