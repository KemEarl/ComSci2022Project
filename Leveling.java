public class Leveling {

    private static int pts_req=0;
    private static int tempts=0;
private static String [] let_me ;
    private static Array [] let_mes = {{"N","T","A","R","I","G","C"},{"A","S","O","H","W","P","L"},{"M","E","L","S","R","U","D"},{"G","A","C","S","F","D","H"),{"I","T","D","F","A","O","E"}{"C","P","S","H","R","E","O"},{"M","S","Y",,"A","T","R","E"},{"K","N","I","S","E","F","G"},{"O","U","V","L","B","D","N"},{"L","B","F","E","S","A","P"}};
    //double check this intialisation
    public Leveling() {
        pts_req = 0;
        tempts = 0;
	    
    }
	
    public void FixedLeveling(int Lvl) {
        if (Lvl <= 10) {
		this.pts_req+=100;
		this.tempts+=3;
		this.let_me=let_mes[Lvl-1];
        }
    }

    public static void RandLeveling(int Lvl) {
        //
    }

    public static boolean CheckLeveling(int Lvl) {
        if (Lvl < 11) {
            return true;
        }
        else {
            return false;
        }
    }
}
