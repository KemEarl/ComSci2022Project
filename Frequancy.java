public class Frequancy{
	private int[] freq;
	private char[] word;//might not need this one
	private char[] letarray;
	
	public Frequancy(String words,char[] letarrays){
		this.letarray=letarrays;
		this.word=words.toCharArray();
	}//constructor
	
	public Frequancy(String[] dict){
		this.freq= new int[26];
		
		for (int i = 0; i < dict.length; i++){
			this.word=dict[i].toCharArray();
			for (int j = 0; j < this.word.length; j++){
				if ((this.word[j]>=97) && (this.word[j] <= 123)){
					this.freq[this.word[j] - 97]++;
				}
			}
		}
	}//constructor
	
	public int[] getArray(){
		return this.freq;
	}
	
	
	public void checkword() {
		int cnt=0;
		
		int[] count= Frequency();
		
		for (int k=0;k<count.length;k++){
			System.out.print(count[k]);
			if (count[k]==0){
				System.out.println("Not all letters used");
			}
			cnt=cnt+count[k];
		}
		if (cnt==0){
			System.out.println("None of the letters are used");
			}
		
	}//checks if all letters are present atleast once 
	
	public  int[] Frequency(){
		int[] Countarray=new int[this.letarray.length];
		for (int i=0;i< this.letarray.length;i++) {
			for(int j=0;j< this.word.length;j++)
			if (this.letarray[i]==this.word[j]){
				Countarray[i]=Countarray[i]+1;
			}

		}
		return Countarray;
	}//returns a int array with frequancy of letters in order of char list of the letters provided
	
	
	
}

