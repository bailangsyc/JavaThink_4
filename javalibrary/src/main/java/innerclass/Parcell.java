package innerclass;

/**
 * 10.1 创建内部类
 * Created by shao on 17-7-29.
 */

public class Parcell {

    public Parcell() {

    }


    /**
     * 坐油轮度假
     *
     * @param dest 目地地
     */
    public void ship(String dest) {
        new Parcell.Contents();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        new Parcell().ship("马尔代夫");
    }


    /**
     * 内部类
     */
    class Contents {
        private int i = 11;//直接在声明变量的地方初始化

        public Contents() {

        }

        public int value() {
            return this.i;
        }

    }

    /**
     * 内部类
     */
    class Destination {
        //通过构造来初始化
        public Destination(String label) {
            this.label = label;
        }

        private String label;

        String readLabel() {
            return this.label;
        }

    }


}
