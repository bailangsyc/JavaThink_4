package holding;

import java.util.ArrayList;

/**
 * 11.1 泛型和类型安全的容器
 * <p>
 * 如果指定了某个类型作为泛型，那么不仅限于只能将该确切类型的对象放置到容器中，
 * 向上转型也可以像作用于其它类型一样，作用于泛型。也就是可以放置该泛型的子类
 * <p>
 * 例如:泛型是apple的时候， 容器中也是可以放置apple的子类的
 * Created by root on 17-10-31.
 */

class GrannySimth extends Apple {

}

class Gala extends Apple {

}

class FuJi extends Apple {

}



public class GenericsAndUpCasting {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new GrannySimth());
        apples.add(new Gala());
        apples.add(new FuJi());

        for (Apple apple : apples)
            System.out.println(apple);

        for (Apple apple :apples)
            System.out.println(apple.toString());
    }

}
