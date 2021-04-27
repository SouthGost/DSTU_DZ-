package Lab5;

public class Competition {
    public Bag<String> teams;
    public GPairBag<String,String> matchs;

    public Competition(int n) throws Exception {
        if( log2(n) == -1){
            n = 8;
        }
        teams = new Bag<String>(n);
        for (int i =1; i<=n; ++i){
            teams.addInBag("Команда " + i);
        }
    }

    protected void planingMatchs() throws Exception {
        matchs = new GPairBag<String, String>(teams.size/2);
        teams.shakeBag();
        for (int i = 0; i< matchs.size; ++i){
            Pair<String,String> match = new Pair<String, String>(teams.takeFromBag(),teams.takeFromBag());
            matchs.addInBag(match);
        }
        matchs.shakeBag();
    }

    public void nextStage() throws Exception {
        planingMatchs();
        matchs.showBag();
        teams = new Bag<String>(matchs.size);
        for (int i = 0; i< teams.size; ++i){
            String winnerMatch;
            if (Math.random()>0.5){
                winnerMatch = (String) matchs.takeFromBag().getSecond();
            } else {
                winnerMatch = (String) matchs.takeFromBag().getFirst();
            }
            teams.addInBag(winnerMatch);
        }
        teams.showBag();
    }

    public boolean isFinal(){
        if (teams.size == 2){
            return true;
        }
        return false;
    }

    public String startCompetition() throws Exception {
        while(!isFinal()){
            nextStage();
        }
        String winner = teams.takeFromBag();
        teams.takeFromBag();
        System.out.println("\uD83C\uDFC6Победила " + winner +"\uD83C\uDFC6");
        return winner;
    }


    public static void main(String[] args) throws Exception {
        Competition run = new Competition(16);
        run.startCompetition();
    }

    public static int log2(int x){
        int n = 1;
        int pow2 = 2;
        if(x == 1){
            return 0;
        }
        while ( pow2 < x ){
            pow2*=2;
            n++;
        }
        if (pow2 != x){
            return -1;
        }
        return n;
    }
}
