import java.util.*;

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
        //englishToMorse("a bc", ALPHA_MORSE);
        morseToEnglishCorrect("*-   -***   -*-*   -**       *   **-*", MORSE_ALPHA);
        //morseToEnglish("*-   -***   -*-*   -**       *   **-*", MORSE_ALPHA);
    }

    /**
     * printHashMap method prints a given hashmap in the format of key : value.
     * Purely for testing purposes. Remove when first final build is finished.
     * @param map is the HashMap to be printed.
     */
    public static void printHashMap(HashMap<String, String> map) {
        for(String key: map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
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

    /** ----------- WIP
     * morseToEnglish is the process in which a string is converted from Morse Code to English.
     * This is done by comparing a letter in morse code and fetching its matching english value
     * by using a hashmap.
     * @param str is the String that is being translated.
     */
    public static void morseToEnglish(String str, HashMap<String, String> map) {
        String result = "";
        str = str.trim();
        for(int i = 0; i < str.length(); i++) {
            System.out.println(i);
            if(i + 6 < str.length() && str.substring(i,i+6).equals("       ")) {
                result += " ";
                i += 6;
            }
            else if(i + 2 < str.length() && str.substring(i,i+2).equals("   ")) {
                i += 2;
            }
            else if(str.indexOf(" ", i) != -1) {
                result += map.get(str.substring(i,str.indexOf(" ", i))) + "   ";
                i = str.indexOf(" ");
            }
            else {
                result += map.get(str.substring(i));
                i = str.length();
            }
        }
        System.out.println("Your translated result is:\n" + result);
    }

    public static void morseToEnglishCorrect(String str, HashMap<String, String> map) {
        String result = "";
        String buf = "";
        int i = 0;
        for(i = 0; i < str.length(); i++) {
            buf += str.substring(i, i + 1);
            //System.out.println(buf);
            if(buf.endsWith(" ")) {
                //System.out.println("|"+buf+"|");
                buf = buf.trim();
                if(map.get(buf) != null) {
                    result += map.get(buf);
                    buf = "";
                    result += parseSpaces(str, i);
                    if(result.endsWith(" ")) {
                        i += 6;
                    }
                    else {
                        i += 2;
                    }
                }
            }
        }
        // Don't forget to check map
        // if buf contains text
        if (!(buf.equals(""))) {
            String s = map.get(buf);
            if (s != null) {
                result += s;
            }
        }
        System.out.println(result);
    }

    public static String parseSpaces(String str, int index) {
        if(index == str.length()) {
            return "";
        }
        //System.out.println(str.substring(index, index + 7));
        if(str.substring(index, index + 7).equals("       ")) {
            return " ";
        }
        else {
            return "";
        }
    }
}