import java.util.Scanner;
import java.util.HashMap;

/**
 * MorseCodeTranslator Translates a users string from either morse code to
 * english or vice versa.
 * 
 * @author Jake Smithson
 */
public class MorseCodeTranslator {


    public static final String[] ALPHA = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ");
    public static final String[] MORSE = "*- -*** -*-* -** * **-* --* **** ** *--- -*- *-** -- -* --- *--* --*- *-* *** - **- ***- *-- -**- -*-- --**".split(" ");
    public static Scanner in = new Scanner(System.in);

    /**
     * Main method for the MorseCodeTranslator class, asks the user what language they want to translate,
     * then asks for a string to be translated. Prints the translated string in the opposite language.
     * @param args command line args (not used)
     */
    public static void main(String[] args) {
        HashMap<String, String> ALPHA_MORSE = new HashMap<String, String>();
        for(int i = 0; i < ALPHA.length; i++) {
            ALPHA_MORSE.put(ALPHA[i], MORSE[i]);
        }
        HashMap<String, String> MORSE_ALPHA = new HashMap<String, String>();
        for(int i = 0; i < MORSE.length; i++) {
            MORSE_ALPHA.put(MORSE[i], ALPHA[i]);
        }
        englishToMorse("abcd ef", ALPHA_MORSE);
        morseToEnglish("*-   -***   -*-*   -**       *   **-*", MORSE_ALPHA);

    }

    /**
     * englishToMorse is the process in which a string is converted from English to Morse code.
     * This is done by comparing a letter in english and fetching its matching morse code value
     * by using a hashmap.
     * @param str is the String that is being translated.
     */
    public static void englishToMorse(String str, HashMap<String, String> map) {
        String result = "";
        str = str.trim();
        for(int i = 0; i < str.length(); i++) {
            if(str.substring(i,i+1).equals(" ")) {
                result += "    ";
            }
            else {
                result += map.get(str.substring(i,i+1).toLowerCase()) + "   ";
            }
        }
        System.out.println("Your translated result is:\n" + result);
    }

    /**
     * morseToEnglish is the process in which a string is converted from Morse Code to English.
     * This is done by comparing a letter in morse code and fetching its matching english value
     * by using a hashmap.
     * @param str is the String that is being translated.
     */
    public static void morseToEnglish(String str, HashMap<String, String> map) {
        String result = "";
        Scanner line = new Scanner(str);
        line.useDelimiter("       ");
        while(line.hasNext()) {
            Scanner word = new Scanner(line.next());
            word.useDelimiter("   ");
            while(word.hasNext()) {
                result += map.get(word.next());
            }
            result += " ";
            word.close();
        }
        line.close();
        System.out.println(result);
    }

}