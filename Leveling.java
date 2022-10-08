public class Leveling {

    private static int pts_req;
    private static int tempts;
    private static String [] let_me;

    public Leveling() {
        pts_req = 0;
        tempts = 0;
    }
	
    public static void FixedLeveling(int Lvl) {
        if (Lvl == 1) {
            //
        }

        if (Lvl == 2) {
            //
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
