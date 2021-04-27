package Lab5;

public abstract class HashFunction<T>{
    public int size;
    public HashFunction(int size){
        this.size = size;
    }

    abstract int hash(T s);
}
