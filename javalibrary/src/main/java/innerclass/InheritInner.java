package innerclass;

/**
 * 10.9 内部类的继承
 * Created by root on 17-10-10.
 */
class WithInner{
    public WithInner() {
    }

    //内部类
    class Inner{

    }
}


public class InheritInner extends WithInner.Inner {
    //这样的构造器时不会被编译通过的 因为InheritInner只是继承了内部类Inner，并没有继承外部类，
    // 因为内部类必须要持有一个外部类的引用，所以要用内部类来调用外部类的构造器生成一个外部类对象的引用，也就是为内部类提供一个引用
    //所以要使用wi.super(); 这样的一句语法
//    InheritInner(){}
    InheritInner(WithInner wi) {
        wi.super();
    }
    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
