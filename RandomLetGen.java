import java.util.*;
/////////////////////////////////////////////////////////////////////////////
public class RandomLetGen {
  /////////////////////////////////////////////////////////////////////////////
  public static int Rando(int Lim) {
    Random ro = new Random();
    int blue = ro.nextInt(Lim);
    return blue;
  }
  /////////////////////////////////////////////////////////////////////////////
  public static boolean RepTest(int sub []) {
    int far = sub.length;
    int confNum = 0;
    for (int k = 0; k < far; k++) {
      for (int l = 0; l < far; l++) {
        if (sub[k] == sub[l]) {
          confNum++;
        }
      }
    }
    if (confNum == far) {
      return true;
    } else {
      return false;
    }
  }
  /////////////////////////////////////////////////////////////////////////////
  public static String [] RanLetGen(int LetNum) {

    String [] Let = {"A" ,"B" ,"C" ,"D" ,"E" ,"F" ,"G" ,"H" ,"I" ,"J" ,"K" ,"L"
    ,"M" ,"N" ,"O" ,"P" ,"Q" ,"R" ,"S" ,"T" ,"U" ,"V" ,"W" ,"X" ,"Y" ,"Z"};

    String [] LetVow = {"A", "E", "I", "O", "U"};

    int [] LetIn = new int [LetNum];
    String [] LetOut = new String [LetNum];

    while (RepTest(LetIn) == false) {
      for (int i = 0; i < LetNum; i++) {
        LetIn[i] = Rando(26);
      }
    }

    for (int j = 0; j < LetNum; j++) {
      LetOut[j] = Let[LetIn[j]];
    }


    return LetOut;
  }
  /////////////////////////////////////////////////////////////////////////////
  public static void main (String [] args) {
    String [] Last = RanLetGen(Integer.parseInt(args[0]));
    System.out.println(Arrays.toString(Last));

  }
}
