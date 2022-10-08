import java.util.*;

public class PointSys {
	private int point;
	
	public PointSys(String word){
		this.point = 0;
	}

	public void Check_Vowel(String word){
    	//int point = 0;
    	char [] arr = word.toCharArray();
        for (char ch : arr){
            if ( ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u'){
                this.point += 50;
            } else if (ch == 'j' || ch == 'q' || ch == 'x' || ch == 'z') {
                this.point += 50;
            } else {
				this.point += 25;
			}
        }
}
	public void Check_Feq(String word){
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
			this.point+= 25;
			}  
		}

	public void wordLength(String word){
		//getting length of word
		int word_length = word.length();
	
		//checking length
		if (word_length < 3) {
			System.out.println("Word too short");
			attempts = attempts - 1;
			System.out.println("You now have " + attempts + " attempts left.");
			}
		
			else {
				if (word_length >= 7) {
					this.point = this.point + 25;
					}
			} 
	}
	
	public int fullAssPts (String woord) {
		this.point = 0;
		Check_Vowel(woord);
		Check_Feq(woord);
		wordLength(woord);
		
		return this.point;
	}
}

	
