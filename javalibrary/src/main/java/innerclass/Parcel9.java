package innerclass;

import javax.sound.midi.Soundbank;

/**
 * 10.6 匿名内部类
 * <p>
 * 在匿名类中定义字段时，还能够对其进行初始化的操作
 * <p>
 * Created by root on 17-9-15.
 */

public class Parcel9 {

    public Destination destination(String dest) {
        
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
        
        
    }


    //main  方法
    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination destination = parcel9.destination("三亚");
        String label = destination.readLabel();
        System.out.println(label);
    }

}
