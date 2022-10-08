import java.util.*;
/////////////////////////////////////////////////////////////////////////////
public class RandomLetGen {
    private static String [] RanLetArr;
  /////////////////////////////////////////////////////////////////////////////
    public RandomLetGen() {
        RanLetArr = new String[1];
    
  } //Instatiates Random Object
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
  public  String [] RanLetGen(int LetNum) {

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

    if (VowelCheck(LetOut, LetVow) == false) {
      LetOut[Rando(LetNum)] = LetVow[Rando(5)];
    } 

    RanLetArr = new String [LetNum];
    RanLetArr = LetOut;
    return RanLetArr;
  }
  /////////////////////////////////////////////////////////////////////////////
  public static boolean VowelCheck(String sub [], String Vows []) {
    int far = sub.length;
    int vow_far = sub.length;
    int confNum = 0;
    for (int k = 0; k < far; k++) {
      for (int l = 0; l < vow_far; l++) {
        if (sub[k] == Vows[l]) {
          confNum++;
        }
      }
    }
    if (confNum == far) {
      return false;
    } else {
      return true;
    }
  }
}
