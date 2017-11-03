package innerclass;

/**
 * 10.7.2 从多层嵌套类中访问外部类的成员
 * <p>
 * 一个内部类被嵌套多少层不重要，它能透明的访问所有它嵌入的外围类的所有成员
 * Created by root on 17-9-16.
 */

class MNA {
    private void f(){}

    //内部类A
    class A {
        private void g(){
            System.out.println("第一层中的方法");
        }

        //内部类中的内部类（第二层）
        class B {
          private void h(){
              System.out.println("第二层中的方法");
          }

            //内部类中的内部类中的内部类（第三层）
            class C {
                  void m(){
                    //它可以访问所有它索嵌入的外围类的成员
                    f();
                    g();//第一层中的方法
                    h();//第二层中的方法

                }
            }

        }
    }
}

public class MultiNestingAcess {

    public static void main(String[] argss) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        MNA.A.B.C mnaabc = mnaab.new C();
        mnaabc.m();// // TODO: 17-9-16  为什么 m（）必须要是private的

    }

}
