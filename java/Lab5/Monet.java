package Lab5;

import java.util.ArrayList;

public class Monet {
    private int[] naminals;
    private ArrayList<Integer> coinsUsed;
    private ArrayList<Integer> minCoins;

    public Monet(){
        this(1,2,5,10);
    }

    public Monet(int ...naminals){
        this.naminals = naminals;
        coinsUsed = new ArrayList<>();
        minCoins = new ArrayList<>();
    }

    private void addToFindMin(int end){
        for (int i=coinsUsed.size();i<=end;++i){
            int coinCount = i;
            int newCoin = 1;
            ArrayList<Integer> c = new ArrayList<>();
            for (int x: naminals){
                if (x <= i){
                    c.add(x);
                }
            }
            for ( int j: c ){
                if(minCoins.get(i-j) + 1 < coinCount){
                    coinCount = minCoins.get( i - j ) + 1;
                    newCoin = j;
                }
            }
            minCoins.add(coinCount);
            coinsUsed.add(newCoin);
        }
    }

    public DList getDLCoin(int summ){
        addToFindMin(summ);
        DList<Integer,Integer> coinsDL = new DList<>();
        for (int i =1; i<=summ;++i){
            ArrayList<Integer> coinList =new ArrayList<>();
            int coin = i;
            while (coin >0){
                coinList.add(coinsUsed.get(coin));
                coin = coin - coinsUsed.get(coin);
            }
            coinsDL.addInDList(i,coinList);
        }
        return coinsDL;
    }

    public ArrayList<Integer> getCoinsUsed() {
        return coinsUsed;
    }

    public ArrayList<Integer> getMinCoins() {
        return minCoins;
    }

    public int[] getNaminals() {
        return naminals;
    }

    public static void main(String[] args) {
        Monet rubls = new Monet(1,2,3);
        rubls.getDLCoin(5).printDList();
    }

}
