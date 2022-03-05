package ZashLab2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab  {
    public static void main(String[] args) {
        CompSystem cs = new CompSystem(new String[]{"Vasya","Petya","Ura"});
        cs.start();
    }
}

class CompSystem{
    private static Scanner in = new Scanner(System.in);
    private String[] users;
    private int[] datas;
    private int[][] permissions;
    private int currentUser = -1;



    public CompSystem(String[] users){
        this.users = users;
        Random rand = new Random();
        datas = new int[Math.abs(rand.nextInt()%10)+5];//длинна данных

        for(int i = 0; i < datas.length; i++){
            datas[i] = rand.nextInt()%100;
        }

        permissions = new int [users.length][];
        permissions[0] = new int[datas.length];
        for (int i = 0;i<datas.length;i++){
            permissions[0][i] = 7;
        }

        for (int i = 1;i<users.length;i++){
            permissions[i] = new int[datas.length];
            for (int j = 0;j<datas.length;j++){
                permissions[i][j] = Math.abs(rand.nextInt()%8);
            }
        }

    }

    private boolean checkAccess(int dataId,int pos){
        if( (permissions[currentUser][dataId]/(int)Math.pow(2,pos-1)) % 2  == 1){
            return true;
        }
        return false;
    }

    private void menu(){
        System.out.println("Жду ваших указаний:");
        String action = in.nextLine();

        int dataId;
        switch (action){
            case "read":
                System.out.println("Над каким объектом произвести операцию:");
                dataId = in.nextInt();
                in.nextLine();
                if(checkAccess(dataId,3)){
                    System.out.println(datas[dataId]);
                } else {
                    System.out.println("Нет доступа");
                }

                break;
            case "write":
                System.out.println("Над каким объектом произвести операцию:");
                dataId = in.nextInt();
                in.nextLine();
                if(checkAccess(dataId,2)){
                    System.out.println("Введите новое значение:");
                    int newVal = in.nextInt();
                    in.nextLine();
                    datas[dataId] = newVal;
                } else {
                    System.out.println("Нет доступа");
                }

                break;
            case "grant":
                System.out.println("Право на какой объект передается:");
                dataId = in.nextInt();
                in.nextLine();
                if(checkAccess(dataId,1)){
                    System.out.println("Какое право передается:");
                    action = in.nextLine();
                    int changePos = 0;
                    switch (action){
                        case "read":
                            changePos = 3;
                            break;
                        case "write":
                            changePos = 2;
                            break;
                        case "grant":
                            changePos = 1;
                            break;
                    }
                    if(changePos != 0){
                        System.out.println("Какому пользователю передается право:");
                        String whatUser = in.nextLine();
                        boolean isFind = false;
                        int userId = 0;
                        for(var u:users){
                            if(u.equals(whatUser)){
                                isFind = true;
                                break;
                            }
                            userId++;
                        }
                        if(isFind){
                            if((permissions[userId][dataId]/(int)Math.pow(2,changePos-1)) % 2  != 1){
                                permissions[userId][dataId] += Math.pow(2,changePos-1);
                            }
                        } else {
                            System.out.println("Неизвестный пользователь");
                        }
                    } else{
                        System.out.println("Неизвестное право");
                    }

                } else {
                    System.out.println("Нет доступа");
                }

                break;
            case "quit":

                return;
            default:
                System.out.println("Непонятное действие");
        }

        this.menu();

        return;
    }

    public void start(){
        System.out.println("Введите имя пользователя:");
        String userName = in.nextLine();
        boolean isFind = false;
        int i = 0;
        for(var u:users){
            if(u.equals(userName)){
                isFind = true;
                break;
            }
            i++;
        }
        if(isFind){
            currentUser = i;
            for(int j = 0; j< datas.length; j++){
                System.out.print("Объект " + j + ": ");
                if(checkAccess(j,3)){
                    System.out.print("Чтение ");
                }
                if(checkAccess(j,2)){
                    System.out.print("Запись ");
                }
                if(checkAccess(j,1)){
                    System.out.print("Передача прав ");
                }
                System.out.println();
            }
            menu();
            currentUser = -1;
        } else {
            System.out.println("Нет такого пользователя");
        }

        start();
    }
}
