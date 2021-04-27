package Lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class HashTable<T extends Person,K> {
    public List<T>[] arrayList;
    public HashFunction<K> HF;

    public HashTable(HashFunction<K> hf){
        HF = hf;
        arrayList = new List[HF.size];
        for(int i = 0; i< arrayList.length;++i){
            arrayList[i] = new ArrayList<>();
        }
    }

    public boolean contains(K value){
        if (value.toString().isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "arrayList=" + Arrays.toString(arrayList) +
                '}';
    }

    abstract void addAtHT(T value);

}