public class Leveling {
    private static int pts_req;
    private static int tempts;
    private static int level;
    private static int [] att = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30}; 
    private static int [] pts = {200, 400, 600, 800, 1000, 1200, 1400, 1600, 1800, 2000};
    private static String [][] let_me = {{"N","T","A","R","I","G","C"},{"A","S","O","H","W","P","L"},{"M","E","L","S","R","U","D"},{"G","A","C","S","F","D","H"},{"I","T","D","F","A","O","E"},{"C","P","S","H","R","E","O"},{"M","S","Y","A","T","R","E"},{"K","N","I","S","E","F","G"},{"O","U","V","L","B","D","N"},{"L","B","F","E","S","A","P"}};
    private static RandomLetGen only = new RandomLetGen();
	private static String [] Letters;
    //double check this intialisation
	/**
	 * 
	 */
	public Leveling() {
        pts_req = 0;
        tempts = 0;
        level = 1;
    }
	
    public String [] FixedLeveling() {
		pts_req = pts[level -1];
		tempts = att[level - 1];
		Letters = let_me[level-1];
        return Letters;
    }

    public String [] RandLeveling() {
        pts_req += 200;
		tempts += 3;
        Letters = only.RanLetGen();
        return Letters;
    }

    public boolean CheckLeveling(int Lvl) {
        if (level < 10) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getAtt() {
        return tempts;
    }

    public int getPtsR() {
        return pts_req;
    }

    public static void incLvl() {
        level++;
    }

    public boolean CheckProgress (int Score) {
        if (Score >= pts_req) {
            incLvl();
            return true;
        }
        else {
            return false;
        }
    }
}
