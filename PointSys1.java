import java.util.*;

public class PointSys1 {
	private int point;
	public PointSys1(String word){
		this.point = 0;
	}

	public int Check_Vowel(String word){
    	//int point = 0;
    	char [] arr = word.toCharArray();
        for (char ch : arr){
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u'){
                this.point ++;
            } else if (ch == 'J' || ch == 'Q' || ch == 'X' || ch == 'Z' || ch == 'j' || ch == 'q' || ch == 'x' || ch == 'z') {
                this.point ++;
            } else {
				this.point += 2;
			}
        } return this.point;
}
	public int Check_Feq(String word){
		int point = 0;
		int cnt[] = new int[256];
		int strl = word.length();
		int match = 0;
		for (int i = 0; i < strl; i++){
			cnt[word.charAt(i)]++;
		}
		char arr[] = new char[strl];
		for (int i = 0; i < strl; i++){
			arr[i] = word.charAt(i);
			
			for (int j = 0; j < i; j++){
				if (word.charAt(i) == arr[j]){
					match++;
				}
			} 
		} if (match >= 3){
			this.point++;
		}  
		return this.point;
		}

	public int wordLength(String word){
		//getting length of word
		int word_length = word.length();
		int attempts = 15;
		//int points = 0;
		int level = 1;
	
		//checking length
		if (word_length < 3) {
			System.out.println("Word too short");
			attempts = attempts - 1;
			System.out.println("You now have " + attempts + " attempts left.");
			}
		
			else {
				if (word_length >= 7) {
					this.point = this.point + 1;
					//System.out.println("Word greater than 6 letters, you get a point!");
					}
		
			//proceed to methods
			//Check_Vowel(word);
			//Check_Feq(word);
			//Check_Uncommon(word);
			} return this.point;
	}
}

	
