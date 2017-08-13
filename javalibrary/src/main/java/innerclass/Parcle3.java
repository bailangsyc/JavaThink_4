package innerclass;

/**
 * 10.3 使用.this 和 .new
 *
 * 如果创建的是静态内部类,就不需要持有外部类的引用了,
 * 但是不能在静态的方法中创建中内部类,因为此时还没有外部类的实例
 *
 * 要想在静态方法中创建内部类必须使用.new语法给内部类提供一个外部类实例 {@link DotNew#main(String[])}
 * 本例就是示范如何使用.new语法
 *
 * Created by shao on 17-8-12.
 */

public class Parcle3 {
    public Parcle3() {
    }


    //内部类1
      class Content{
        private  int i = 11;

        public int value(){
            return this.i;
        }

    }

    //内部类2
    class Destination {
        private String lable;

        public Destination(String destination) {
            this.lable = destination;
        }

        //暴露一个对外的方法
        public String readLable() {
            return this.lable;
        }
    }


    public static void main(String[] args) {
        //首先创建一个外部类实例
        Parcle3 parcle3 = new Parcle3();
        //使用.new语法创建一个内部类实例
        Content content = parcle3.new Content();
        Destination destination = parcle3.new Destination("三亚");

        Parcel2 parcel2 = new Parcel2();



    }

}
