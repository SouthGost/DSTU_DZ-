package Lab5;

import java.util.ArrayList;

public class DList<T1,T2> {
    public ArrayList<T1> first;
    public ArrayList<ArrayList<T2>> second;

    public DList(){
        first = new ArrayList<T1>();
        second = new ArrayList<ArrayList<T2>>();
    }

    public void addInDList(T1 elem, ArrayList<T2> elist){
        first.add(elem);
        ArrayList<T2> newElist = new ArrayList<T2>(elist);
        second.add(newElist);
    }

    public Pair<T1,ArrayList<T2>> getByIndex(int index) throws Exception {
        if (index >= first.size()){
            throw new Exception("Такого индекса нет!");
        }
        Pair<T1,ArrayList<T2>>  pair = new Pair(first.get(index),second.get(index));
        return pair;
    }

    public Pair<T1,ArrayList<T2>> getByFirst(T1 elem) throws Exception {
        int index = first.indexOf(elem);
        if (index == -1){
            throw new Exception("Такого элемента нет!");
        }
        Pair<T1,ArrayList<T2>>  pair = new Pair( elem ,second.get(index));
        return pair;
    }

    public void deletByIndex(int index) throws Exception {
        if (index >= first.size()){
            throw new Exception("Такого индекса нет!");
        }
        first.remove(index);
        second.remove(index);
    }

    public void deletByFirst(T1 elem) throws Exception {
        int index = first.indexOf(elem);
        if (index == -1){
            throw new Exception("Такого элемента нет!");
        }
        first.remove(index);
        second.remove(index);
    }

    public void printDList(){
        System.out.println(first);
        System.out.println(second);
    }

    public static void main(String[] args) throws Exception {
        DList a = new DList<Integer, Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(1);
        a.addInDList(1, b);
        b.add(1);
        a.addInDList(2, b);
        b.set(1,2);
        a.addInDList(3, b);
        b.set(1,3);
        ArrayList<Integer> c = new ArrayList<Integer>();
        c.add(2);
        c.add(2);
        a.addInDList(4, c);
        c.set(1, 3);
        a.addInDList(5, c);
        a.printDList();
        System.out.println(a.getByFirst(4));
        System.out.println(a.getByIndex(1));
        a.deletByFirst(4);
        a.deletByIndex(1);
        a.printDList();
    }
}
