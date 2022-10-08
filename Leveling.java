public class Leveling {

    private static int pts_req=0;
    private static int tempts=0;
    private static String [] let_me;

    public Leveling() {
        pts_req = 0;
        tempts = 0;
    }
	
    public void FixedLeveling(int Lvl) {
        if (Lvl <= 10) {
		this.pts_req+=100;
		this.tempts+=3;
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
