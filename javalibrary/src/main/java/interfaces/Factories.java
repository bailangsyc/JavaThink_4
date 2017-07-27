package interfaces;

/**
 *9.9 接口与工厂
 *
 * 接口是实现多重继承的途径，而生成遵循某个接口的对象的经典方式就是使用工厂方法
 *
 * 这与直接调用构造其不同，在工厂对象上调用的是创建的方法，该工厂对象将生成接口的某个实现
 * 的对象。理论上通过这种方式，我们的代码将完全与接口的实现分离，这就使得我们可以
 * 透明地将某个实现替换为另一个实现
 * Created by shao on 17-7-27.
 */

interface  Service{
    void method1();
    void  method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    public Implementation1() {
        //无参构造
    }

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }
}


class Implementation1Factoty implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {
    public Implementation2() {
        //无参构造
    }

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }
}

class Implementation2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation2();
    }
}


public class Factories {
    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factoty());
        serviceConsumer(new Implementation2Factory());
    }

    private static void serviceConsumer(ServiceFactory fac) {
        Service service = fac.getService();//其实返回的是Implementation1 或者Implementation2
        service.method1();
        service.method2();
    }


}
