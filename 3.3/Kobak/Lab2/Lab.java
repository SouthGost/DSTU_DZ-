package Lab2;

import java.util.Random;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) throws Exception {
        Computer comp = new Computer(3,5);
        System.out.println(comp.metod() + " время выполнения заданий на каждом из процессоров было бы минимальным");
    }
}


//17 9 15 13 11
//        14 5 7 10 16
//        12 11 12 8 14

class Computer{
    private static Scanner in = new Scanner(System.in);
    private int[][] potoks;

    public Computer(int n, int m) throws Exception {
        if(n < 1 || m< 1){
            throw new Exception("не правильные параметры");
        }
        potoks = new int[n][m];
        for(int i = 0; i<potoks.length; i++){
            for(int j = 0; j<potoks[i].length; j++){
                potoks[i][j] = (int)(Math.random()*30) + 5;//(int)(Math.random()*30) + 5; //in.nextInt();
            }
        }
    }

    private void swapStrok(int a, int b){
        for(int i = 0; i<potoks.length; i++){
            int temp =  potoks[i][a];
            potoks[i][a] = potoks[i][b];
            potoks[i][b] = temp;
        }
    }

    public int metod(){
        int[] sums = new int[potoks[0].length];
        for(int i = 0; i < sums.length; i++){
            sums[i] = 0;
            for (int j = 0; j < potoks.length; j++){
                sums[i] += potoks[j][i];
            }
        }
        System.out.println("Изначальняа матрица");
        for(int i = 0; i < potoks[0].length; i++){
            for (int j = 0; j < potoks.length; j++){
                System.out.printf("%5d|",potoks[j][i]);
            }
            System.out.print(sums[i]);
            System.out.println();
        }
        System.out.println("----------------------------");
        for(int i = 0; i < sums.length-1; i++){
            int maxj = i;
            for(int j = i+1; j< sums.length; j++){
                if(sums[maxj] < sums[j]){
                    maxj = j;
                }
            }
            if(maxj != i){
                int temp = sums[i];
                sums[i] = sums[maxj];
                sums[maxj] = temp;
                swapStrok(i,maxj);
            }
        }
        System.out.println("Отсортированная матрица");
        for(int i = 0; i < potoks[0].length; i++){
            for (int j = 0; j < potoks.length; j++){
                System.out.printf("%5d|",potoks[j][i]);
            }
            System.out.print(sums[i]);
            System.out.println();
        }
        System.out.println("----------------------------");
        int[] raspisanie = new int[potoks.length];
        for(int i = 0; i < raspisanie.length; i++){
            raspisanie[i] = 0;
        }
        System.out.println("Расписание матрицы");
        for(int i = 0; i < potoks[0].length; i++){
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
}