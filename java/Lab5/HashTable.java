package Lab5;

public class HashTable<T_> {
    public T_[] arrayList;
    public HashFunction HF;

    public HashTable(HashFunction hf){
        HF = hf;
    }

}

abstract class HashFunction<T>{
    public int size;
    public HashFunction(int size){
        this.size = size;
    }

    abstract int hash(T s);
}