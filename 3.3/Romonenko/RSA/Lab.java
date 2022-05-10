package RSA;

import java.math.*;
import java.util.Scanner;

public class Lab {


    public static void main(String[] args) throws Exception {
        Rsa rrr = new Rsa(Rsa.getNextSimple(Rsa.random(50,500)),Rsa.getNextSimple(Rsa.random(50,500)));
    }
}

class Rsa{
    private int p;
    private int q;
    private int n;
    private int fn;
    private BigInteger sekretKey;
    private BigInteger openKey;

    public Rsa(int p, int q) throws Exception {
        n = p*q;
        fn = (p-1)*(q-1);
        int k = 2;
        sekretKey = BigInteger.valueOf(Rsa.getNextSimple(Rsa.random(10000,100000)));

        System.out.println("p " + p);
        System.out.println("q " + q);
        System.out.println("N " + n);
        System.out.println("fN " + fn);
        System.out.println("Звакрытый ключ " + sekretKey);

        openKey = BigInteger.valueOf(Rsa.getPreviousSimple(Rsa.random((int)Math.sqrt(fn),fn)));
        int i = 0;
        while( sekretKey.multiply(openKey).mod(BigInteger.valueOf(fn)).compareTo(BigInteger.valueOf(1)) != 0 ){
            openKey = BigInteger.valueOf(Rsa.getPreviousSimple(Rsa.random((int)Math.sqrt(fn),fn)));
            if(i > 100000){
                throw new Exception("Черезмерное количество итераций");
            }
            i++;
        }
        System.out.println("Отырытый ключ " + openKey);
        System.out.println("mod " + (sekretKey.multiply(openKey).mod(BigInteger.valueOf(fn))));
        menu();
    }

    public void menu(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("1)Закодировать");
            System.out.println("2)Разкодировать");
            System.out.println("\n0)Выход");
            String line = in.nextLine();
            switch (line){
                case "1":
                    String str = in.nextLine();
                    code(str);
                    break;
                case "2":
                    String str2 = in.nextLine();
                    decode(str2);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Не понятная команда");
                    break;
            }
        }
    }

    public void code(String str){
        for (int i = 0; i < str.length(); i++) {
            System.out.print(BigInteger.valueOf(str.charAt(i)).pow(openKey.intValue()).mod(BigInteger.valueOf(n)) + " ");
        }
        System.out.println("закончил");
    }

    public void decode(String str){
        String[] splitStr = str.split(" ");
        for(var word: splitStr){
            System.out.print((char)BigInteger.valueOf(Integer.parseInt(word)).pow(sekretKey.intValue()).mod(BigInteger.valueOf(n)).intValue());
        }
        System.out.println();
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
