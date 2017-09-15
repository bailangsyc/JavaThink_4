package innerclass;

import sun.swing.plaf.synth.DefaultSynthStyle;

/**在方法和作用域内的内部类
 * 10.5
 * 在方法的作用域内（而不是其他类的作用域内）创建一个完整的类，被称作局部内部类
 * PDestination是方法destination(String s)中的一个类，相当于时一个局部变量，所以在方法外时无法访问的
 * Created by root on 17-9-14.
 */

public class Parcel5 {
    public static void main(String[] args) {

        Parcel5 parcel5 = new Parcel5();
        Destination destination = parcel5.destination("三亚");

    }

    //Destination是一个接口
    public Destination destination(String s) {

         class PDestination implements Destination {
             private String lable;

             public PDestination(String s) {
                 lable = s;
            }

             @Override
             public String readLabel() {
                 return lable;
             }
         }

        return new PDestination(s);//向上转型为Destination
    }

}
