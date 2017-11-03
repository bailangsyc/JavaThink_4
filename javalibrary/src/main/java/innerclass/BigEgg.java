package innerclass;

/**
 * 10.10 内部类可以被覆盖吗
 * 如果创建了一个内部类，然后继承外围类时重新定义了内部类，这就称作内部类的覆盖，
 * 看起来被“覆盖的内部类”好像它是外围类的一个方法，然后并没有什么作用
 * Created by root on 17-10-10.
 */
//外围类
class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg Yolk()");
        }
    }

    public Egg() {
        System.out.println("new Egg()");
        y = new Yolk();
    }

}


//继承外部类Egg的同时又重新定义了内部类，并没有什么卵用，相当多此一举
public class BigEgg extends Egg {
    //重新定义了内部类 你可能认为既然创建了BigEgg对象，那么所使用的也是“覆盖后“的Yolk版本，但从实际情况来看并不是这样
    //这个例子说明当继承了某个外围类的时候，内部类并没有发生什么神奇的变化，他们完全是两个独立的实体，各自在各自的命名空间中，当然明确的继承某个内部类也是可以的 例如Egg2
    public class Yolk{
        public Yolk(){
            System.out.println("BigEgg Yolk()");
        }
    }
    public static void main(String[] args) {
        new BigEgg();
    }
}
