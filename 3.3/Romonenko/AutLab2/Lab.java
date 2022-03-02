package AutLab2;

import java.util.Scanner;

public class Lab {
    public static String getFirstAlf(int code) throws Exception {
        char[] alf = {'0','1'};
        String word = "";
        if(code < 0){
            throw new Exception("Нельзя вводить отрицательный номер");
        }
        int kordonnik = 0;
        int pow4 = 0;
        int length = 0;
        while(code >= Math.pow(4,pow4)+kordonnik){//=?
            length += 2;
            kordonnik += Math.pow(4,pow4);
            pow4++;
        }
        code -= kordonnik;
        for(int i = 0; i < length; i++){
            int mod = (int)(code/Math.pow(2,length - i -1));
            word += alf[mod % 2];
        }
        return word;
    }

    public static String getSecondAlf(int code) throws Exception {
        char[] alf = {'0','1','2'};
        String word = "";
        if(code < 0){
            throw new Exception("Нельзя вводить отрицательный номер");
        }
        int kordonnik = 0;
        int pow3 = 0;
        int length = 0;
        while(code >= Math.pow(3,pow3)+kordonnik){//=?
            length++;
            kordonnik += Math.pow(3,pow3);
            pow3++;
        }
        code -= kordonnik;
        for(int i = 0; i < length; i++){
            int mod = (int)(code/Math.pow(3,length - i -1));
//            System.out.print(mod+ " ");
            word += alf[mod % 3];
            if(word.charAt(word.length()-1) == '1'){
                word += '.';
            }
        }
//        System.out.println();
        return word;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                int max = in.nextInt();
                for (int code = 0; code <= max; code++){
                    System.out.println(getSecondAlf(code));
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
