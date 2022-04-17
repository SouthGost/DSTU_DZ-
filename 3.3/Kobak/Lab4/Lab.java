package Lab4;

import java.util.Random;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) throws Exception {
        Random rnd = new Random();
        Computer comp = new Computer(4,11);
        System.out.println(comp.metod() + " время выполнения заданий на каждом из процессоров было бы минимальным");
    }
}

class Computer{
    private static Scanner in = new Scanner(System.in);
    private int[][] potoks;
    private int[] raspisanie;

    public Computer(int n, int m) throws Exception {
        if(n < 1 || m< 1){
            throw new Exception("Не правильные параметры");
        }
        potoks = new int[n][m];
        for(int i = 0; i<potoks.length; i++){
            for(int j = 0; j<potoks[i].length; j++){
                potoks[i][j] = (int)(Math.random()*5) + 10;//(int)(Math.random()*30) + 5; //in.nextInt();
            }
        }
        raspisanie = new int[potoks.length];
        for(int i = 0; i < raspisanie.length; i++){
            raspisanie[i] = 0;
        }
    }

    private void swapStrok(int a, int b){
        for(int i = 0; i<potoks.length; i++){
            int temp =  potoks[i][a];
            potoks[i][a] = potoks[i][b];
            potoks[i][b] = temp;
        }
    }

    public int[] getIdsMinStrok(){
        int[] mins = new int[potoks[0].length];

        for(int i = 0; i < mins.length; i++){
            mins[i] = 0;
            for (int j = 1; j < potoks.length; j++){
                if(potoks[j][i] < potoks[mins[i]][i]){
                    mins[i] = j;
                }
            }
        }
        return mins;
    }

    public int[] getMinsStrok(){
        int[] mins = new int[potoks[0].length];

        for(int i = 0; i < mins.length; i++){
            mins[i] = potoks[0][i];
            for (int j = 1; j < potoks.length; j++){
                if(potoks[j][i] < mins[i]){
                    mins[i] = potoks[j][i];
                }
            }
        }
        return mins;
    }

    public int[] getMaxsStrok(){
        int[] maxs = new int[potoks[0].length];

        for(int i = 0; i < maxs.length; i++){
            maxs[i] = potoks[0][i];
            for (int j = 1; j > potoks.length; j++){
                if(potoks[j][i] < maxs[i]){
                    maxs[i] = potoks[j][i];
                }
            }
        }
        return maxs;
    }


    public int[] getSumStrok(){
        int[] sums = new int[potoks[0].length];
        for(int i = 0; i < sums.length; i++){
            sums[i] = 0;
            for (int j = 0; j < potoks.length; j++){
                sums[i] += potoks[j][i];
            }
        }
        return sums;
    }

    public void sortBy(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int maxj = i;
            for(int j = i+1; j< arr.length; j++){
                if(arr[maxj] < arr[j]){
                    maxj = j;
                }
            }
            if(maxj != i){
                int temp = arr[i];
                arr[i] = arr[maxj];
                arr[maxj] = temp;
                swapStrok(i,maxj);
            }
        }
    }

    public void showMatr(int[] dop) throws Exception {
        if(dop != null && dop.length != potoks[0].length){
            throw new Exception("Неверная длинна доп информации");
        }
        for(int i = 0; i < potoks[0].length; i++){
            for (int j = 0; j < potoks.length; j++){
                System.out.printf("%5d|",potoks[j][i]);
            }
            if(dop != null){
                try{
                    System.out.print(dop[i]);
                }catch (Exception ignored){}
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public int metodPlotnikovZverev(int strok){
        System.out.println("Начало " + strok);
        for(int i = strok; i < potoks[0].length; i++){
            int minj = 0;
            for(int j = 1; j < raspisanie.length; j++){
                if( raspisanie[minj] + potoks[minj][i] > raspisanie[j] + potoks[j][i] ){
                    minj = j;
                }
            }
            raspisanie[minj] += potoks[minj][i];
            for(int j = 0; j < raspisanie.length; j++){
                System.out.printf("%5d|",raspisanie[j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------");
        int max = raspisanie[0];
        for(int i = 1; i < raspisanie.length; i++){
            if(raspisanie[i] > max){
                max = raspisanie[i];
            }
        }
        return max;
    }

    public int metodPlotnikovZverevKvadrat(int strok){
        System.out.println("Начало " + strok);
        for(int i = strok; i < potoks[0].length; i++){
            int minj = 0;
            System.out.println("Расчет");
            System.out.println("("+potoks[minj][i]+"+"+raspisanie[minj]+")^2="+(int)Math.pow((raspisanie[minj] + potoks[minj][i]),2));
            for(int j = 1; j < raspisanie.length; j++){
                System.out.println("("+potoks[j][i]+"+"+raspisanie[j]+")^2="+(int)Math.pow((raspisanie[j] + potoks[j][i]),2));
                if( Math.pow((raspisanie[minj] + potoks[minj][i]),2) > Math.pow((raspisanie[j] + potoks[j][i]),2) ){
                    minj = j;
                }
            }
            System.out.println("Результат");
            raspisanie[minj] += potoks[minj][i];
            for(int j = 0; j < raspisanie.length; j++){
                System.out.printf("%5d|",raspisanie[j]);
            }
            System.out.println();
            System.out.println();
        }
        int max = raspisanie[0];
        for(int i = 1; i < raspisanie.length; i++){
            if(raspisanie[i] > max){
                max = raspisanie[i];
            }
        }
        return max;
    }

    public void showArr(int[] arr){
        for(var elem: arr){
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public int metodMinElem(int strok){
        int i = strok;
        int[] mins = getMinsStrok();
        showArr(mins);
        int[] minsIds = getIdsMinStrok();
        showArr(minsIds);
        int border = 0;
        for (var min_: mins){
            border += min_;
        }
        border = (int)Math.ceil((double)border/potoks.length);
        System.out.println("Барьер "+ border);
        for(; i < potoks[0].length; i++){
            if(raspisanie[minsIds[i]] + mins[i] <= border){
                raspisanie[minsIds[i]] += mins[i];
            } else {
                return i;
            }
            for(int j = 0; j < raspisanie.length; j++){
                System.out.printf("%5d|",raspisanie[j]);
            }
            System.out.println();
        }
        return i;
    }

    public int metod() throws Exception {
        showMatr(null);
        ; // getSumStrok()  // getMinsStrok()

        raspisanie = new int[potoks.length];
        for(int i = 0; i < raspisanie.length; i++){
            raspisanie[i] = 0;
        }
        System.out.println("загруженность:");

        int max = metodPlotnikovZverev(metodMinElem(0));

        System.out.println("----------------------------");

        sortBy(getMinsStrok());
        int[] sorter = getMinsStrok(); //getMaxsStrok
        showMatr(sorter);

        raspisanie = new int[potoks.length];
        for(int i = 0; i < raspisanie.length; i++){
            raspisanie[i] = 0;
        }
        System.out.println("загруженность:");

        metodPlotnikovZverev(metodMinElem(0));

        System.out.println("----------------------------");

        sortBy(getMaxsStrok());
        sorter = getMaxsStrok(); //getMaxsStrok
        showMatr(sorter);

        raspisanie = new int[potoks.length];
        for(int i = 0; i < raspisanie.length; i++){
            raspisanie[i] = 0;
        }
        System.out.println("загруженность:");

        metodPlotnikovZverev(metodMinElem(0));
        return max;
    }
}