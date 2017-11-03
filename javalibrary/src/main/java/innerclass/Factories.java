package innerclass;

/**
 Implementation2.factory返回一个ServiceFactory，ServiceFactory又可以通过getService（）在Implementation2类中
 返回一个Implementation2，随意Implementation2的构造器可以是private的。

 另外，经常需要一个单一的工厂对象，因此在本例中该单一的工厂对象被创建为Sevice接口实现中（Implementation1）的一个静态域，
 ，这样的语法更具实际意义。因为域是静态的，而静态在整个过程中只有一个，所以该工厂对象就只有一个。

 */

//接口service
interface Service {
    void method1();
    void method2();
}

//service 工厂 接口
interface ServiceFactory {
    Service getService();
}

////////////////////////////////////////////////////////////////

class Implementation1 implements Service {
    @Override
    public void method1() {
        System.out.println("Implementation1 method1()");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2()");
    }

    //静态的内部类
    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {

            return new Implementation1();//向上转型为Service
        }
    };
}


class Implementation2 implements Service {
    @Override
    public void method1() {
        System.out.println("Implementation2 method1()");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2()");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return  new Implementation2();
        }
    };

}

////////////////////////////////////////////////////////////////
public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);

    }


}