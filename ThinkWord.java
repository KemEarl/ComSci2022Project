public class ThinkWord{
	
	//--------------Start Calvin Section---------------//
	//Start of creation of dictionary array (Returns a dictionary in a string array, takes nothing in.)
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;
	import java.util.Arrays;
	public static String[] arrayCreate(){
		try {
			String[] arrayOfWords = new String[82216];
			int NumOfWords = 0;
			File file = new File("ListOfWords2.txt");
			Scanner myFile = new Scanner(file);
			while (myFile.hasNextLine()){
				arrayOfWords[NumOfWords] = myFile.nextLine();
				NumOfWords ++;
			}
			myFile.close();
			return arrayOfWords;
		} catch (FileNotFoundException e){
			System.out.println("File Error Has Occured");
			e.printStackTrace();
		}
		return new String[1];
	}
	//End of dictionary creation
	//Start of Calvin's dictionary check (In dictionary or not)
	
	public static Boolean checkInDict(String[] dict, String word){
		int index = (dict.length)/2, LB = 0, UB = (dict.length)-1, Mb = 0, diff = 0;
		
		while (LB <= UB){
			Mb = (LB+UB)/2;
			if (word.equals(dict[Mb])){
				System.out.println("" + Mb + " " + dict[Mb]);
				return true;
			}
			
			diff = dict[Mb].compareTo(word);
			if (diff < 0){
				LB = Mb + 1;
			}else{
				UB = Mb -1;
			}
		}
		
		return false;
	}
	
	
	//End Of Calvin's dictionary check//
	//----------------End Calvin Section--------------------//
	
	/////////////////////////////////////////////////////////////////////////////
	//Kem's Random Letter Generation
	/////////////////////////////////////////////////////////////////////////////
	import java.util.*;
	public static int Rando(int Lim) {
		Random ro = new Random();
		int blue = ro.nextInt(Lim);
		return blue;
	}
  
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
  //End of Kem's Code
  /////////////////////////////////////////////////////////////////////////////

	
	
	
	
	
	
	
	public static void main(String[] args){
		//Call metods here. (main game here)
	}
}