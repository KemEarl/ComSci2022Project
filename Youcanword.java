import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Youcanword{

    /* public static int howMany(String word, String looking){
        int point = 0;
        String tempStr = word.replaceAll(looking, "");
        int times = (word.length()-tempStr.length())/looking.length();
        if (times > 3){
            point++;
        }
        return times;
} */

/* public static int specialLetters(String word){
    int point1 = 0;
    char [] arr = word.toCharArray();
        for (char ch : arr){
            if (ch == 'J' || ch == 'Q' || ch == 'X' || ch == 'Z' || ch == 'j' || ch == 'q' || ch == 'x' || ch == 'z'){
                point1 ++;
            } else {
                continue;
            }
        }
} */

    public static void main(String []args){
        String word = "Jacqueze";
        String l = "C";
        int point = 0;
        char [] arr = word.toCharArray();
        /* Pattern pattern = Pattern.compile("[C]");
        Matcher matcher = pattern.matcher(word);
        boolean matchF = matcher.find(); */
        //System.out.print(Arrays.toString(arr));
        System.out.println(point);
        
    }
}