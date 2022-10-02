import java.util.Arrays;
public class TesterCode{
	public static void main(String[] args){
		dictRead dictOb = new dictRead();
		String[] Words = dictOb.getWordArray();
		Frequancy freak = new Frequancy(Words);
		System.out.println(Arrays.toString(freak.getArray()));
	}
}