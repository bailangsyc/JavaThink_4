package holding;

import java.util.ArrayList;

/**
 * 11章 持有对象
 * java 通过容器类库来持有对象
 * <p>
 * 如果一个程序只包含固定数量，而且生命周期都是已知的对象，那么这是一个非常简单的程序
 * 通常，程序总是根据运行时才知道的某些条件去创建新对象。在此之前，不会知道所需对象的数量，甚至不知道确切的类型。
 * 为了解决这个普遍的编程问题，需要在任意时刻和任意未知创建任意数量的对象，所以不能依靠创建命名的引用来持有
 * 每一个对象： 类似这样的格式： Student zhangsan;(对象类型  对象名称;)
 * <p>
 * 11.1 泛型和类型安全的容器
 * <p>
 * javaSE5 之前的一个主要问题就是编译器允许向容器中插入不正确的类型。
 * Created by root on 17-10-30.
 */

//不带泛型
//在本例中，Apple和Orange都放在同一个容器中，
public class ApplesAndOrangesWithoutGenerics {
    @SuppressWarnings("unchecked")//正常情况下java编译器会报告警告信息，因为这个容器没有使用泛型
    //在这里使用javaSE5 所特有的注解来抑制警告信息
    public static void main(String[] args) {
        //创建一个不带泛型的容器
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());

        apples.add(new Orange());

        //取出容器中的苹果
        for (int i = 0; i < apples.size(); i++) {
            //从容器中取出 水果，但是此时容器中是有橘子的，这样类型强转在运行的时候会报异常
            //但是编译的时候不会报错，也就是类型检查只有在运行时才会进行，这样很不安全
            ((Apple)apples.get(i)).id();
        }



    }

}

class Apple {
    private static long counter;
    private final long id = counter++; // TODO: 17-10-30  为什么final修饰了 还可以++呢

    public long id() {
        return id;
    }
}

class Orange {

}
