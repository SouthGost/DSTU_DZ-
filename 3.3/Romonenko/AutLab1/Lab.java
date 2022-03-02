package AutLab1;

import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Language language = new Language();
        while (true){
            try {
                System.out.println("1) Полчучить число по слову;");
                System.out.println("2) Полчучить слово по числу;");
                System.out.println("0) Заверщить работу;");
                int action = in.nextInt();
                in.nextLine();
                switch (action){
                    case 1:
                        System.out.println("Введите слово;");
                        String word = in.nextLine();
                        System.out.println(language.getCode(word));
                        break;
                    case 2:
                        System.out.println("Введите число;");
                        int code = in.nextInt();
                        in.nextLine();
                        System.out.println(language.getWord(code));
                        break;
                    case 0:
                        return;
                    default:
                        throw new Exception("Не существующее действие");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

class Language{
    static int[] russian = new int[]{1072,1103};//(int)а,(int)я
    static int[] english = new int[]{97,122};//(int)a,(int)z
    private char[] alphabet;
    private String mainLang;

    public int indexOf(char simbol){
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] == simbol){

                return i;
            }
        }

        return -1;
    }

    public Language(){
        Scanner in = new Scanner(System.in);
        int length = 0;
        while (length == 0){
            try {
                System.out.print("Введите длину алфавита: ");
                length = in.nextInt();
                in.nextLine();
                if(length<2 /* || length > 33*/){
                    throw new Exception("Вы не правильно ввели длину");
                }

                break;
            }catch (Exception e){
                length = 0;
                System.out.println(e.getMessage());
            }
        }
        alphabet = new char[length];
        int currentLength = 0;
        String buffer = "";
        while(currentLength != alphabet.length){

            if(buffer.equals("")){
                System.out.println("Введите буквы алфавита");
                buffer = in.nextLine();
                if(buffer.equals("")){
                    continue;
                }
//                in.nextLine();
            }
            try {
                if (mainLang != null) {
                    if(indexOf(buffer.charAt(0)) != -1){

                        throw new Exception("Символ " + buffer.charAt(0) + " введен повторно");
                    }
                    switch (mainLang) {
                        case "ru":
                            if (buffer.charAt(0) >= russian[0] && buffer.charAt(0) <= russian[1]) {
                                alphabet[currentLength++] = buffer.charAt(0);
                            } else{

                                throw new Exception("Символ " + buffer.charAt(0) + " не входит в Русский алфавит");
                            }

                            break;
                        case "en":
                            if (buffer.charAt(0) >= english[0] && buffer.charAt(0) <= english[1]) {
                                alphabet[currentLength++] = buffer.charAt(0);
                            } else{

                                throw new Exception("Символ " + buffer.charAt(0) + " не входит в Английский алфавит");
                            }

                            break;
                        default:

                            throw new Exception("Ошибка в выборе основания языка");
                    }
                } else {
                    if (buffer.charAt(0) >= russian[0] && buffer.charAt(0) <= russian[1]) {
                        mainLang = "ru";
                    } else if (buffer.charAt(0) >= english[0] && buffer.charAt(0) <= english[1]) {
                        mainLang = "en";
                    } else {

                        throw new Exception("Не распознано основание алфавита");
                    }
                    alphabet[currentLength++] = buffer.charAt(0);
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            if(buffer.length() <2){
                buffer = "";
            }else{
                buffer = buffer.substring(1);
            }
            System.out.print(currentLength + "/" + alphabet.length + " [");
            for (var simbol: alphabet){
                System.out.print(simbol);
            }
            System.out.println("]");
        }
    }

    public int getCode(String word) throws Exception {
        int summ = 0;
        for(int i = 0; i < word.length(); i++){
            int currentCharIndex =  indexOf(word.charAt(i));
            if(currentCharIndex == -1){
                throw new Exception("Символ " + word.charAt(i) + " не входмт в алфавит");
            }
            summ += Math.pow(alphabet.length,word.length()-i-1)*(currentCharIndex+1);
        }

        return summ;
    }

    public String getWord(int number){
        if(number < 1){
            return "";
        }
        if(number<= alphabet.length){

            return "" + alphabet[number-1];
        } else {
            int mod = number % alphabet.length;
            number = number / alphabet.length;
            if(mod == 0){
                return  getWord(number-1) + alphabet[alphabet.length-1];
            } else {
                return getWord(number) + alphabet[mod-1];
            }
        }
    }
}
