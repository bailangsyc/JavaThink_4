package innerclass;

import javax.sound.midi.Soundbank;

/**
 * 10.6 匿名内部类
 *
 * 带实例初始化的匿名内类，
 *
 * 注意destination（）的参数必须时final的，因为他们在匿名内部类中直接使用了
 * Created by root on 17-9-15.
 */

public class Parcel10 {

    public Destination destination(String dest, float price) {
        return new Destination() {
            private String label = dest;
            private  int cost;
            //为每个对象实例化
            {
                 cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("超出预算");
                }

            }

            @Override
            public String readLabel() {
                return label;
            }
        };
    }


    /////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Destination destination = new Parcel10().destination("三亚", 101);
        String label = destination.readLabel();
        System.out.println(label);
    }


}
