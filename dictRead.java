//Created and Edited by Calvin
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class dictRead{
	private String[] arrayOfWords;
	
	public dictRead(){
		try {
			this.arrayOfWords = new String[82178];
			int NumOfWords = 0;
			File file = new File("ListOfWords2.txt");
			Scanner myFile = new Scanner(file);
			while (myFile.hasNextLine()){
				this.arrayOfWords[NumOfWords] = myFile.nextLine();
				NumOfWords ++;
			}
			myFile.close();
			System.out.println(NumOfWords);
		} catch (FileNotFoundException e){
			System.out.println("File Error Has Occured");
			e.printStackTrace();
		}
	}//constructor
	
	public String[] getWordArray(){
		return this.arrayOfWords;
	}//getter
	
	
	public Boolean checkInDict(String word){
		int index = (this.arrayOfWords.length)/2, LB = 0, UB = (this.arrayOfWords.length)-1, Mb = 0, diff = 0;
		
		while (LB <= UB){
			Mb = (LB+UB)/2;
			if (word.equals(this.arrayOfWords[Mb])){
				System.out.println("" + Mb + " " + this.arrayOfWords[Mb]);
				return true;
			}
			
			diff = this.arrayOfWords[Mb].compareTo(word);
			if (diff < 0){
				LB = Mb + 1;
			}else{
				UB = Mb -1;
			}
		}
		
		return false;
	}//method
}
