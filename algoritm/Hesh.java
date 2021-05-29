import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hesh {
    public static void main(String[] args) {
        String[] str = new String[12];
        str[0] = "aaс";
        str[1] = "caa";
        str[2] = "aab";
        str[3] = "bab";
        str[4] = "bba";
        str[5] = "baaaa";
        str[6] = "aaaab";
        strHashTable myHT = new strHashTable( new strHashFunction(12) );
        myHT.addAtHT(str[0]);
        myHT.addAtHT(str[1]);
        myHT.addAtHT(str[2]);
        myHT.addAtHT(str[3]);
        myHT.addAtHT(str[4]);
        myHT.addAtHT(str[5]);
        myHT.addAtHT(str[6]);
        System.out.println(myHT);

    }
}

class strHashFunction{
    public int size;
    public strHashFunction(int size){
        this.size = size;
    }

    public int hash(String s){
        long p =  (s.charAt(0)-'A'+1);
        for (int i=1;i<s.length();i++){
            p= p * 26 + (s.charAt(i)-'A'+1);
        }
        System.out.println(p);
        return (int) (p % size);
    }
}

class strHashTable{
    public List<String>[] arrayList;
    public strHashFunction HF;

    public strHashTable(strHashFunction hf){
        HF = hf;
        arrayList = new List[HF.size];
        for(int i = 0; i< arrayList.length;++i){
            arrayList[i] = new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "arrayList=" + Arrays.toString(arrayList) +
                '}';
    }

    public void addAtHT(String value){
        arrayList[HF.hash(value)].add(value);
    }

}
