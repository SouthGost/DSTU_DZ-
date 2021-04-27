package Lab5;

public class Pair<T1,T2> {
    public T1 first;
    public T2 second;

    public Pair(){}

    public Pair(T1 first,T2 second){
        this.first = first;
        this.second = second;
    }

    public T1 getFirst(){
        return first;
    }

    public T2 getSecond(){
        return second;
    }

    public void setFirst(T1 first){
        this.first = first;
    }

    public void setSecon(T2 second){
        this.second = second;
    }

    @Override
    public String toString() {
        return first + " " + second;
    }

    public static void main(String[] args) {
        Pair hu = new Pair("Kiril",54);
        Pair babushka=make_pair(53.5,"Вова");
        System.out.println(babushka);
        System.out.println(hu);
    }

    public static Pair make_pair(Object first, Object second){
        return new Pair<>(first,second);
    }

}
