package Lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        //OFMT
        int n = 3;
        int pow2 = 1;
        while(pow2<n){
            pow2*=2;
        }
        while( pow2!=n ){
            System.out.println("Введите количество процессоров(2 в степени): ");
            n = reader.nextInt();
            pow2 = 1;
            while(pow2<n){
                pow2*=2;
            }
        }

        computingSystem CS = new computingSystem(n);

        System.out.println("Введите количество задач: ");
        int m = reader.nextInt();

        Task[] tasks = new Task[m];
        for (int i = 0; i < m; i++){
            tasks[i] = new Task((int)(Math.round(Math.random() * 13 + 10))); //диапазон 8
            System.out.print(tasks[i].time + " ");
        }
        System.out.println();
        CS.set(tasks);
        CS.show();
    }
}

class Task{
    public final int time;

    public Task(int t){
        time = t;
    }
}

class CPU{
    private final ArrayList<Task> queue = new ArrayList<Task>();

    public void add(Task task){
        queue.add(task);
    }

    public static int summ(ArrayList<Task> tasks){
        int summ = 0;

        for(var task: tasks){
            summ += task.time;
        }

        return summ;
    }

    public int summ(){
        return CPU.summ(queue);
    }

    public int size(){
        return queue.size();
    }

    public int getTimeByIndex(int index) throws Exception {
        if (index > -1 && index < queue.size()) {
            return queue.get(index).time;
        } else {
            throw new Exception("empty");
        }
    }

}

class computingSystem{
    private final CPU[] cpus;

    public computingSystem(int n){
        cpus = new CPU[n];
        for (int i = 0; i < n; i++){
            cpus[i] = new CPU();
        }
    }

    private void OFMT(ArrayList<Task> tasks, int step) throws Exception {
        ArrayList<Task>[] tasksSplit = new ArrayList[2];
        tasksSplit[0] = new ArrayList<Task>();
        tasksSplit[1] = new ArrayList<Task>();

        for (var task: tasks){
            if(CPU.summ(tasksSplit[0]) > CPU.summ(tasksSplit[1])){
                tasksSplit[1].add(task);
            } else {
                tasksSplit[0].add(task);
            }
        }


        if(step * 2 == cpus.length){
            for(int i=0;i<cpus.length;i+=2){
                if(cpus[i].size() == 0 && cpus[i+1].size() == 0){
                    for (var task: tasksSplit[0]){
                        cpus[i].add(task);
                    }
                    for (var task: tasksSplit[1]){
                        cpus[i+1].add(task);
                    }
                    break;
                }
                if(i==cpus.length-1){
                    System.out.println("Ошибка размещения составленного разбиения");
                    throw new Exception();
                }
            }
        } else {
            OFMT(tasksSplit[0],step*2);
            OFMT(tasksSplit[1],step*2);
        }

    }

    public void set(Task[] tasks){
        ArrayList<Task> taskArrayList = new ArrayList<Task>(Arrays.asList(tasks));

        taskArrayList.sort(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {

                return Integer.compare(o2.time, o1.time);
            }
        });
        for(var task: taskArrayList)
            System.out.print("" + task.time + " ");
        System.out.println();

        //OFMT
        try{
            this.OFMT(taskArrayList,1);
        } catch (Exception e) {

        }

    }

    public void show(){
        int maxLenght = 0;
        for (var cpu:cpus){
            if(cpu.size()> maxLenght){
                maxLenght =  cpu.size();
            }
        }
        for(int i = 0 ; i < maxLenght; i++){
            for(int j = 0;j<cpus.length;j++){
                try{
                    System.out.printf("%5d|",cpus[j].getTimeByIndex(i));
                }catch (Exception e){
                    if(e.getMessage().equals("empty")){
                        System.out.printf("     |");
                    } else {
                        System.out.println("Ошибка вывода");
                    }
                }
            }
            System.out.println();
        }
        for(int i = 0;i<cpus.length;i++){
            System.out.print("-----");
        }
        System.out.println();
        for(int i = 0;i<cpus.length;i++){
            System.out.printf("%5d|",cpus[i].summ());
        }
    }
}
