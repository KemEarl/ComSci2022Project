import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class dictRead{
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
			System.out.println(NumOfWords);
			return arrayOfWords;
		} catch (FileNotFoundException e){
			System.out.println("File Error Has Occured");
			e.printStackTrace();
		}
		return new String[1];
	}
	
	
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
	
	
	public static void main(String[] Args){
		String[] mainDict = arrayCreate();
		System.out.println(checkInDict(mainDict, Args[0]));
		
	}
}