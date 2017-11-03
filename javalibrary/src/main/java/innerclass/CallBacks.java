package innerclass;

import javax.sound.midi.Soundbank;

/**
 * 10.8.1 闭包与回调（此类还不太理解）
 * 本类展示了外部类实现接口 与 内部类实现接口的区别
 * <p>
 * Created by root on 17-9-19.
 */

interface Incrementable {
    void increment();
}

//外部类实现接口
class Calleel implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("其它操作");
    }

    static void f(MyIncrement myIncrement) {
        myIncrement.increment();
    }
}

//内部类实现接口
class Callee2 extends MyIncrement {
    private int i = 0;

    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallBackReference() {
        return new Closure();
    }


}

class Caller {
    private Incrementable callBackReference;

    Caller(Incrementable cbh) {
        callBackReference = cbh;
    }

    void go() {
        callBackReference.increment();
    }
}


public class CallBacks {
    public static void main(String[] args) {
        Calleel calleel = new Calleel();
        Callee2 callee2 = new Callee2();
        MyIncrement.f(callee2);

        Caller caller1 = new Caller(calleel);
        Caller caller2 = new Caller(callee2.getCallBackReference());
        caller1.go();
        caller1.go();
        caller2.go();

    }
}
