//Created and Edited by Calvin
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class dictRead{
	private String[] arrayOfWords;
	
	public dictRead(){	//Initializes the object.
		try {
			this.arrayOfWords = new String[82178];
			int NumOfWords = 0;
			File file = new File("ListOfWords.txt");
			Scanner myFile = new Scanner(file);
			while (myFile.hasNextLine()){
				this.arrayOfWords[NumOfWords] = myFile.nextLine();
				NumOfWords ++;
			}
			myFile.close();
			//System.out.println(NumOfWords);
		} catch (FileNotFoundException e){
			System.out.println("File Error Has Occured");
			e.printStackTrace();
		}
	}//constructor
	
	
	
	public String[] getWordArray(){	//Returns the dictionary as an array of words
		return this.arrayOfWords;
	}//getter
	
	
	
	public void addWord(String word){	//adds a word to the dictionary array
		word = word.toLowerCase();
		String[] temp = new String[this.arrayOfWords.length + 1];
		int cnt = 0;
		String temp1 = "";
		for (int i = 0; i < arrayOfWords.length;i++){
			temp1 = arrayOfWords[i];
			if (temp1.equals(word)){
				System.out.println("ERROR: Word Already Exists.");
				break;
			}
			if (cnt == 0 && temp1.compareTo(word) > 0){
				temp[i] = word;
				temp[i + 1] = this.arrayOfWords[i];
				cnt++;
			}else{
				temp[i + cnt] = this.arrayOfWords[i];
			}
		}
		if (cnt > 0){
			this.arrayOfWords = temp;
		}
	}// modifier
	
	
	public void removeWord(String word){	//removes the given word from the dictionary object.
		word = word.toLowerCase();
		String[] temp = new String[arrayOfWords.length-1];
		String temp1 = "";
		boolean test = true;
		int offSet = 0;
		for (int i = 0; i < this.arrayOfWords.length; i++){
			temp1 = arrayOfWords[i];
			if (!(temp1.equals(word))){
				temp[i-offSet] = this.arrayOfWords[i];
			}else{
				test = false;
				offSet++;
			}
		}
		if (test){
			System.out.println("ERROR: Word Not Found For Deleting");
			return;
		}
		this.arrayOfWords = temp;
		
	}//Modifier
	
	
	public Boolean ValidWord(String n, String[] lettersIn){	//checks to see if you can make the given word out of the given letters
		char[] lettersInArray = n.toCharArray();
		boolean wordGood = true;
		for (int j = 0; j < lettersInArray.length; j++){
			boolean foundLetter = false;
			for (int k = 0; k < lettersIn.length; k++){
				if (("" + lettersInArray[j]).equals(lettersIn[k])){
					foundLetter = true;
				}
			}//cycles though letters given
			if (!foundLetter){
				wordGood = false;
				break;
			}
		}//cycles through the letters in the current word from dict
		return wordGood;
		
	}//method
	
	
	public Boolean ValidRand(int min, String[] lettersIn){	//checks if you can make at least min number of words given an array of letters
		Boolean foundLetter = false, wordGood = false;
		int cnt = 0;
		
		for (int i = 0; i < this.arrayOfWords.length; i++){
			char[] lettersInArray = this.arrayOfWords[i].toCharArray();
			wordGood = true;
			for (int j = 0; j < lettersInArray.length; j++){
				foundLetter = false;
				for (int k = 0; k < lettersIn.length; k++){
					if (lettersInArray[j] == (lettersIn[k].toLowerCase()).charAt(0)){
						foundLetter = true;
					}
				}//cycles though letters given
				if (!foundLetter){
					wordGood = false;
					break;
				}
			}//cycles through the letters in the current word from dict
			if (wordGood){
				System.out.println(this.arrayOfWords[i]);
				cnt++;
			}
		}//cycles throught the words in dict
		
		if (cnt >= min){
			return true;
		}
		return false;
		
	}//method
	
	public Boolean checkInDict(String word){	//method that checks if a given word is in the dictionary.
		word = word.toLowerCase();
		int LB = 0, UB = (this.arrayOfWords.length)-1, Mb = 0, diff = 0;
		
		while (LB <= UB){
			Mb = (LB+UB)/2;
			if (word.equals(this.arrayOfWords[Mb])){
				//System.out.println("" + Mb + " " + this.arrayOfWords[Mb]);
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
