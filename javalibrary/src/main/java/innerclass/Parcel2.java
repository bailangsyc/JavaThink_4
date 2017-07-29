package innerclass;

/**
 * 10.1 创建内部类
 * Created by shao on 17-7-29.
 * 如果想从外部类的非静态方法之外的任意一个地方创建某个内部类对象，
 * 必须像下边格式一样指明内部类对象：OuterClassName.InnerClassName
 *
 * 例如：Parcel2。Contents（许多地方都需要这样声明）
 *
 */

public class Parcel2 {
    public Parcel2() {
    }

    //返回一个contents对象
    public Contents contents( ) {
        return new Contents();
    }

    //返回一个Destination引用
    public Destination to(String s) {
        return new Destination(s);
    }

    public void ship(String dest) {
        Contents c = this.contents();
        Destination t = this.to(dest);
        System.out.println(t.readLabel());
    }

    public static void main(String[] args) {
        //返回contents destination第一种方式
        new Parcel2().ship("马尔代夫");

        ////返回contents destination第二种方式
        Parcel2 q = new Parcel2();
        Contents c = q.contents();
        Destination d = q.to("北戴河");
    }

    class Contents {
        private int i = 11;

        public Contents() {

        }

        public int value() {
            return this.i;
        }

    }

    class Destination {
        public Destination(String whereTo) {
            this.label = whereTo;
        }

        private String label;

        String readLabel() {
            return this.label;
        }

    }
}



