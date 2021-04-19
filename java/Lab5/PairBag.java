package Lab5;

import java.util.ArrayList;

public class PairBag extends Bag<Pair> {

    public PairBag(int size) {
        super(size);
    }

    public static void main(String[] args) throws Exception {
        PairBag pb = new PairBag(4);
        pb.addInBag(new Pair(12,"wow"));
        pb.addInBag(new Pair(0.05,32));
        pb.addInBag(new Pair("qwe","zxc"));
        pb.addInBag(new Pair(67,15.3));
        pb.showBag();
        pb.shakeBag();
        pb.showBag();
        System.out.println(pb.takeFromBag());
        System.out.println(pb.takeFromBag());
        pb.addInBag(new Pair("odin","dva"));
        pb.addInBag(new Pair(33,"33"));
        pb.showBag();
    }
}
