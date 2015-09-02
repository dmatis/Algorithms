/* Developed in part from the work of Manish Bhojasia at Sanfoundry */

public class GaleShapley {

    private int N, engagedCount;
    private String[][] menPref;
    private String[][] womenPref;
    private String[] men;
    private String[] women;
    private String[] womenPartner;
    private boolean[] menEngaged;

    public GaleShapley(String[] m, String[] w, String[][] mp, String[][] wp) {
        N = mp.length; // total number of pairs to match
        engagedCount = 0;
        men = m;
        women = w;
        menPref = mp;
        womenPref = wp;
        menEngaged = new boolean[N];
        womenPartner = new String[N];
        calcMatches();
    }

    private void calcMatches() {

        while (engagedCount < N) {
            /* Iterates to find a free man that can be engaged */
            int free;
            for (free = 0; free < N; free++)
                if (!menEngaged[free])
                    break;

            for (int i = 0; i < N && !menEngaged[free]; i++) {
                int index = womenIndexOf(menPref[free][i]);
                if (womenPartner[index] == null) {
                    womenPartner[index] = men[free];
                    menEngaged[free] = true;
                    engagedCount++;
                }
                else {
                    String currentPartner = womenPartner[index];
                    if (morePreference(currentPartner, men[free], index)) {
                        womenPartner[index] = men[free];
                        menEngaged[free] = true;
                        menEngaged[menIndexOf(currentPartner)] = false;
                    }
                }
            }
        }
        printCouples();
    }
    /** determines if person has higher preference over new partner **/
    private boolean morePreference(String curPartner, String newPartner, int index) {
        for (int i = 0; i < N; i++) {
            if (womenPref[index][i].equals(newPartner))
                return true;
            if (womenPref[index][i].equals(curPartner))
                return false;
        }
        return false;
    }
    /** get men index **/
    private int menIndexOf(String str) {
        for (int i = 0; i < N; i++)
            if (men[i].equals(str))
                return i;
        return -1;
    }
    /** get women index **/
    private int womenIndexOf(String str) {
        for (int i = 0; i < N; i++)
            if (women[i].equals(str))
                return i;
        return -1;
    }
    /** print couples **/
    public void printCouples() {
        System.out.println("The paired couples are : ");
        for (int i = 0; i < N; i++)
        {
            System.out.println("(" + womenPartner[i] +", "+ women[i] + ")");
        }
    }
    public static void main(String[] args) {

        System.out.println("The Gale Shapley Marriage Algorithm\n");
        System.out.println("Enter the array of men, women, followed by a double array of their preferences\n");
        /** list of men **/
        String[] m = {"M1", "M2"};
        /** list of women **/
        String[] w = {"W1", "W2"};

        /** men preference **/
        String[][] mp = {{"W2", "W1"}, {"W1", "W2"}};
        /** women preference **/
        String[][] wp = {{"M1", "M2"}, {"M2", "M1"}};

        GaleShapley gs = new GaleShapley(m, w, mp, wp);
    }
}
