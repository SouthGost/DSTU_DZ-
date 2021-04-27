package Lab5;

public class GPairBag<T1,T2> extends Bag<Pair<T1,T2>>{
    public GPairBag(int size) {
        super(size);
    }

    public void addInBag(Pair<T1,T2> element) throws Exception {
        if(insides.size() == size){
            throw new Exception("Мешок заполнен!");
        }
        insides.add((int)  (Math.random() * ( insides.size() )), element);
    }

    public static void main(String[] args) throws Exception {
        GPairBag<Double, Integer> gpb = new GPairBag<Double, Integer>(4);
        gpb.addInBag(new Pair<Double, Integer>(0.01,32));
        gpb.addInBag(new Pair<Double, Integer>(0.02,32));
        gpb.addInBag(new Pair<Double, Integer>(0.03,32));
        gpb.addInBag(new Pair<Double, Integer>(0.04,32));
        gpb.showBag();
    }
}
