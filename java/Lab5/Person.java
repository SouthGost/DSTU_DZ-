package Lab5;

public class Person {
    String name;
    String sname;
    int age;

    public Person(String name, String sname, int age){
        this.name = name;
        this.sname = sname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
       HashTable<Person, String> myHT = new personHT( new familiaHF(12) );
       myHT.addAtHT(new Person("Maks","bespredel",25));
       myHT.addAtHT(new Person("Artem","wolf",25));
       myHT.addAtHT(new Person("boris","ivanov",25));
       myHT.addAtHT(new Person("Photo","hunter",25));
       myHT.addAtHT(new Person("Kandrat","speridon",54));
       System.out.println(myHT);
    }
}

class personHT extends HashTable<Person, String>{

    public personHT(HashFunction<String> hf) {
        super(hf);
    }

    public void addAtHT(Person value){
        arrayList[HF.hash(value.sname)].add(value);
    }

}

class familiaHF extends HashFunction<String>{


    public familiaHF(int size) {
        super(size);
    }

    @Override
    public int hash(String s){
        long p =  (s.charAt(0)-'A'+1);
        for (int i=1;i<s.length();i++){
            p= p * 37 + (s.charAt(i)-'A'+1);
        }
        System.out.println(p % size);
        return (int) (p % size);
    }

}
