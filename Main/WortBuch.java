import java.util.ArrayList;

public class WortBuch{
    public static void main(String[] args) {
        Buch.einfugen("Wasser");
        Buch.einfugen("Brot");

        System.out.println(Buch.sucheNachPrafix(""));
    }
}

class Buch {
    private static ArrayList<String> buch = new ArrayList<>();

    public static void einfugen(String str){
        if(str.contains(" ")){
            System.out.println("FEHLER");
            System.exit(1);
        }

        buch.add(str);
    }

    public static boolean suchen(String str){
        for(String wort : buch){
            if(wort.equals(str)){
                return true;
            }
        }

        return false;
    }

    public static boolean sucheNachPrafix(String prafix){
        ArrayList<String> matchingWords = new ArrayList<>();
        for (String wort : buch) {
            if (wort.startsWith(prafix)) {
                matchingWords.add(wort);
            }
        }

        if (matchingWords.isEmpty()) {
            return false;
        }

        printTrie(matchingWords);
        return true;
    }

    private static void printTrie(ArrayList<String> worts) {
        for (String wort : worts) {
            StringBuilder indentation = new StringBuilder();
            for (int i = 0; i < wort.length(); i++) {
                if (i == 0) { 
                    System.out.println("   " + wort.charAt(i)); // Apenas imprime a letra
                } else { 
                    System.out.println(indentation.toString() + "└── " + wort.charAt(i)); // Adiciona "└── " a partir do segundo caractere
                }
                indentation.append("   ");
            }
        }
    }

    public static void entfernen(String str){
        boolean check = false;

        for(int i = 0; i < buch.size(); i++){
            if(str.equals(buch.get(i))){
                buch.remove(i);
                check = true;
            }
        }

        if(!check){
            System.out.println("FEHLER");
            System.exit(1);
        }
    }
}