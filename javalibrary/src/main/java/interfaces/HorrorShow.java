package interfaces;

/**
 * @ClassName [interfaces].
 * @Descriptione[9.5 java中通过继承来扩展接口]
 * @Author [shao on 2017/7/15].
 * @Date [2017/7/15 23:45]
 * @Version [v1.0]
 */
public class HorrorShow {

    public static void main(String[] args) {
        //barney 矿车
        DangerousMonster barney = new DragonZilla();
        u(barney);//此处发生了向上转型 DangerousMonster --> Monster
        v(barney);

        Vampire vlad = new VeryBadVampire() ;
        u(vlad);
        v(vlad);
        m(vlad);

    }

    private static void m(Lethal vlad) {
        vlad.kill();
    }

    private static void v(DangerousMonster barney) {
        barney.destory();
        barney.menace();
    }

    private static void u(Monster barney) {
        barney.menace();
    }


}

//Monster 巨大
interface Monster {
    //威胁
    void menace();
}

//接口也可以继承
interface DangerousMonster extends Monster {
    void destory();
}

//Lethal致命的
interface Lethal {
    void kill();
}

//zilla 专区
class DragonZilla implements DangerousMonster {

    @Override
    public void destory() {

    }

    @Override
    public void menace() {

    }
}

//vampire 吸血鬼
interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();//吸血
}

class VeryBadVampire implements Vampire {

    @Override
    public void drinkBlood() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void menace() {

    }
}

