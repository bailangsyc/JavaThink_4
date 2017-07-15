package interfaces;

/**
 * @ClassName [interfaces].
 * @Descriptione[9.4 java中的多重继承]
 * @Author [shao on 2017/7/15].
 * @Date [2017/7/15 23:25]
 * @Version [v1.0]
 *
 * 1.组合多个类的接口的行为称之为多重继承，java中的类只允许单继承，但是接口可以多继承
 * 2.当将一个具体类和多个接口组合在一起时，具体类必须放在接口前面
 * 3.使用接口的核心原因：为了能够向上转型为多个基类（为此可以带来很大的灵活性）
 *
 * 事实上，如果知道某事物应该成为一个积累，那么第一选择应该使他成为一个接口。
 */
public class Adventrue {

    public static void main(String[] args) {

        Hero h = new Hero();
        t(h);//向上转型
        u(h);
        v(h);
        m(h);

    }

    private static void m(ActionChracter h) {
        h.fight();
    }

    private static void v(CanFly h) {
        h.fly();
    }

    public static void t(CanFight x) {
        x.fight();
    }

    private static void u(CanSwim h) {
        h.swim();
    }

}

interface  CanSwim{
    void swim();
}

interface  CanFight{
    void fight();
}

interface CanFly{
    void fly();
}

class ActionChracter{
    public void fight(){
    }
}

//通过一个具体类和实现多个接口组成一个新的类
class Hero extends ActionChracter implements CanFight, CanFly, CanSwim{

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}

