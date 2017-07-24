package interfaces.nesting;


/**
 * @ClassName [interfaces.nesting].
 * @Descriptione[ 9.8 接口的嵌套]
 * @Author [shao on 2017/7/16].
 * @Date [2017/7/16 14:56]
 * @Version [v1.0]
 */
public class NestingInterface {
}

class A{

    interface B{
     void f();
    }

    //类是public
    public class BImp implements B {
        @Override
        public void f() {
        }
    }

    //该类是 private
    private class BImp2 implements B {
        @Override
        public void f() {
        }
    }

    //接口是public
    public interface C {
        void  f();
    }

    //默认的包访问权限
    class CImp implements C {
        @Override
        public void f() {
        }
    }

    //此类是private
    private class CImp2 implements C {
        @Override
        public void f() {
        }
    }

    private interface D{
        void f();
    }




























}
