package innerclass;

import sun.applet.Main;

/**
 * 10.7.1 接口中的内部类
 *
 * 如果想要创建某些公共的代码，使得他们可以被某个接口的所有实现所共用，那么使用接口中的内部类就会很方便
 *
 * Created by root on 17-9-16.
 */

public class TestBed {
    public void f() {
        System.out.println("f()");
    }

    //使用嵌套类进行测试，好处
    // 使用这个类来测试，在编译后会形成一个Tester.class 文件，如果将main（）写在TestBed类中进行测试，
    //那么产品上线后TestBed中就携带了main（） 这样的额外的代码
    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }

}
