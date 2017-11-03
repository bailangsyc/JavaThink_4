package innerclass;

/**
 * 10.8 为什么要使用内部类 （因为内部类可实现多重继承）
 *
 * 如果拥有的是抽象的类或者具体的类，而不是接口，那么只能使用内部类才可以实现多重继承
 *
 * 如果不需要使用多重继承，可以使用别的方式编码，但是使用内部类的同时还可以获得其它特性：
 *      1.内部类可以有多个实例，每个实例都有自己的状态信息，并且与外围类的信息相互独立
 *      2.在单个外围类中，可以让多个内部类实现同一个几口，或者继承同一个类。
 *      3.注意 创建内部类对象的时刻并不依赖与外围类对象的创建（也就是没有外围类的时候也可以创建内部类，例如嵌套类）
 *      4.内部类没有令人魅惑的 is-a 的关系，它就是一个独立的实体
 * Created by root on 17-9-17.
 */


class D {}
abstract class  E{}

//类Z就通过内部类实现了多重继承
class Z extends D{
    E makeE(){
        return new E(){};
    }
}

public class MultiImplemention {
    static void takeD(D d) {

    }

    static void takeE(E e) {

    }

    public static void main(String[] args) {
        Z z = new Z();
        takeD(z);
        takeE(z.makeE());
    }
}
