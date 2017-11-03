package innerclass;

/**
 * 10.11 局部内部类
 * 局部内部类：在方法体内创建的内部类称为局部内部类。
 * 特点：不能有访问说明符，因为它不是外围类的一部分，但是它可以当前方法体内常量以及外围类的所有成员。
 *
 * 局部类和匿名内部类具有相同的行为和能力，
 * 既然局部内部类的名字在方法外是不可见的，那么为什么仍然推荐使用局部内部类而不是匿名内部类呢？
 * 唯一的理由就是，我们需要一个已经命名的构造器，或者需要重载构造器，而匿名内部类只能用于实例初始化。
 * 所以使用局部内部类而不使用匿名内部类的另一个理由就是，需要不止一个该内部类对象。
 *
 * 10.12 内部类标识符
 *java虚拟机在编译的时候每个类都会产生一个.class 文件，其中包含了如何创建该类型对象的全部信息（此信息产生了一个“meta-class”,叫做Class对象）
 * 同样内部类也必须产生一个.calss文件以包含他们Class对象信息，这些类文件的命名有严格规定：外围类的名字，加上“$”， 再加上内部类的名字。
 * 例如,LocalInnerClass.java生成的.class 文件
 *      Counter.class
 *      LocalInner$1.class（匿名内部类产生的.class）
 *      LocaInnerClass$LocalCounter.class(局部内部类产生的.class)
 *      LocalInnerClass.class
 *
 *10.13  内部类总结
 *   比起面向对象编程的其它概念而言，接口和内部类相对比较复杂和深奥，比如C++就没有这些。
 *   将两者结合起来，同样能够解决C++中的用多重继承来解决的问题。
 *   然而，多重继承在C++中被证明是相当难用的，相比较而言，java的接口和内部类就更容易理解。
 *
 *
 * <p>
 * 内部类可以创建的地方有：
 * 1.外围类中
 * 2.外围类的方法体中
 * <p>
 * 下边这个例子就对局部内部类和匿名类进行比较
 * Created by root on 17-10-18.
 */

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(String name) {
        //局部内部类
        class LocalCounter implements Counter {

            public LocalCounter() {
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        }

        return new LocalCounter();
    }

    //匿名内部类
    Counter getCounter2(String name) {
        return new Counter() {
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        Counter counter1 = localInnerClass.getCounter("局部内部类"),
                counter2 = localInnerClass.getCounter2("匿名内部类");

        for (int i = 0; i < 5; i++)
            System.out.println(counter1.next());

        for (int i = 0; i < 5; i++)
            System.out.println(counter2.next());
    }


}
