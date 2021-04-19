package Lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Bag<T> {
    public final ArrayList<T> insides= new ArrayList<T>();
    public final int size;

    public Bag(int size) {
        this.size = size;
    }

    public void addInBag(T element) throws Exception {
        if(insides.size() == size){
            throw new Exception("Мешок заполнен!");
        }
        insides.add((int)  (Math.random() * ( insides.size() )), element);
    }

    public T takeFromBag() throws Exception {
        if(insides.size()==0){
            throw new Exception("Мешок пустой!");
        }
        return insides.remove((int) (Math.random() * insides.size()));
    }

    public void showBag(){
        System.out.println("--Bag--");
        System.out.println("Size: "+ size);
        System.out.println("Fullness: "+ insides.size());
        for(int i = 0; i<insides.size();++i){
            System.out.println((i+1) +") "+ insides.get(i));
        }
        System.out.println();
    }

    public void shakeBag(){
        Collections.shuffle(insides);
    }

    public int getSize() {
        return size;
    }

    public int getFullness() {
        return insides.size();
    }

    public static void main(String[] args) throws Exception {
        Bag<Integer> bag = new Bag<>(4);
        bag.addInBag(1);
        bag.addInBag(2);
        bag.addInBag(3);
        bag.addInBag(4);
        bag.showBag();
        bag.shakeBag();
        bag.showBag();
    }
}
