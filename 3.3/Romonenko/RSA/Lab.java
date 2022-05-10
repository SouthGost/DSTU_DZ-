package RSA;

public class Lab {


    public static void main(String[] args) throws Exception {
        Rsa rrr = new Rsa(Rsa.getNextSimple(Rsa.random(100,1000)),Rsa.getNextSimple(Rsa.random(100,1000)));
    }
}

class Rsa{
    private int p;
    private int q;
    private int n;
    private int fn;

    public Rsa(int p, int q) throws Exception {
        n = p*q;
        fn = (p-1)*(q-1);
        int sekretKey = 3;//getNextSimple(random(1,fn/100));
//        int openKey = random(100,fn);
//        openKey += -((openKey * sekretKey) % fn)*sekretKey;
        int k = 2;
        double openKey = (k*fn +1)*1.0/sekretKey;
        while(openKey % 1 != 0){
            k++;
            openKey = (k*fn +1)*1.0/sekretKey;
        }
        System.out.println("p " + p);
        System.out.println("q " + q);
        System.out.println("Звакрытый ключ " + sekretKey);
        System.out.println("Отырытый ключ " + openKey);
        System.out.println("fN " + fn);
//        System.out.println("Eiler " + Eiler(n));
        System.out.println("N " + n);
        System.out.println("mod " + ((openKey * sekretKey)%fn));
    }

    public int nod(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return nod(n2, n1 % n2);
    }

    public static boolean isSimple(int number){
        int sqrt = (int) Math.sqrt(number);
        for (int j = 2; j <= sqrt; j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static int getNextSimple(int i) {
        if(i<1){
            return 1;
        }
        i = i + 1;
        while (true) {
            if(isSimple(i)){
                return i;
            }
            i++;
        }
    }

    public static int getPreviousSimple(int i) throws Exception {
        if(i<2){
            throw new Exception("нету простых чисел после 1");
        }
        i = i - 1;
        while (true) {
            if(isSimple(i)){
                return i;
            }
            i--;
        }
    }

    public int Eiler(int n){
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(nod(i,n) == 1){
                count++;
            }
        }
        return count;
    }

    public static int random(int min, int max) throws Exception {
        if(min == max){
            return min;
        }
        if(min > max){
            throw new Exception("не правильные параметры");
        }
        return (int)Math.round(Math.random()*(max-min))+min;
    }
}
