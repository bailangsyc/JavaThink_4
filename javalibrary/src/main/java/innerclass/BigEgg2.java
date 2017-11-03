package innerclass;

/**
 * 10.10
 * 内部类可以覆盖吗 示例2
 * Created by root on 17-10-10.
 */
class Egg2 {

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg2.Yolk()");

        }

        //内部类中的一个方法
        public void f() {
            System.out.println("Egg2.Yolk.f()");
        }
    }

    private Yolk y = new Yolk();

    public Egg2() {
        System.out.println("new Egg2()");
    }

    public void g() {
        y.f();
    }

    public void insertYolk(Yolk yy) {
        y = yy;
    }

}


public class BigEgg2 extends Egg2 {

    //明确指定继承某个内部类
    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("BigEgg2 Yolk()");
        }

        //内部类中的一个方法
        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }

    }


    public BigEgg2() {
        insertYolk(new Yolk());//此处发生了向上的类型转换
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }


}
