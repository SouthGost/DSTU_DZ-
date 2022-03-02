package ZashLab2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab  {
    public static void main(String[] args) {

    }
}

abstract class Action{
    public final String name;

    public Action(String name){
        this.name = name;
    }

    abstract public int make();
}

class Menu extends Action{
    private static Scanner in = new Scanner(System.in);
    private final ArrayList<Action> actions;
    private final boolean isRepeat;

    public Menu(ArrayList<Action> actions, String name, boolean isRepeat){
        super(name);
        this.actions = actions;
        this.isRepeat = isRepeat;
    }

    @Override
    public int make(){
        int i = 1;

        for(var action: actions){
            System.out.println(i + ") " + action.name);
            i++;
        }
        int actionNumber = in.nextInt();

        if(actionNumber>0 && actionNumber <i-1){
            actions.get(actionNumber).make();
        } else if(actionNumber == 0){

            return 0;
        } else {
            System.out.println("Непонятное действие");
            this.make();

            return 0;
        }

        if(isRepeat){
            this.make();
        }

        return 0;
    }
}

class CompSystem{
    private String[] users;
    private int[] datas;
    int[][] permissions;
    Menu compMenu;

    public CompSystem(String[] users){
        this.users = users;
        Random rand = new Random();
        datas = new int[(rand.nextInt()%10)+5];//длинна данных

        for(int i = 0; i < datas.length; i++){
            datas[i] = rand.nextInt();
        }


    }
}
