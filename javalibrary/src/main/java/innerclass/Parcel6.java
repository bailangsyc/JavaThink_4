package innerclass;

/**
 * 10.5
 * 在任意的作用域内嵌入一个内部类
 *
 * 什么是作用域？
 *
 *  如：
 *      if（true）{
 *          //这里边就是一个作用域
 *      }
 *
 * TrackingSlip在if语句的作用域中，并能说明该类的创建是有条件的，它其实和别的类一模一样，它其实和别的类一样一起编译
 * 过了，但是定义TrackingSlip的作用域外，它是不可用的，除此之外，它与普通类一模一样。
 *
 *
 * Created by root on 17-9-14.
 */

public class Parcel6 {


    private void internalTracking(boolean b) {
        if (b) {
            //方法内的内部类 也就是局部内部类
            class  TrackingSlip{
                private  String id;

                TrackingSlip(String s) {
                    this.id = s;
                }


                String getSlip() {
                    return  id;
                }


            }

            //创建了一个局部内部类
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
            System.out.println(s);
        }

        //不能在此处使用
//       TrackingSlip ts = new TrackingSlip("slip");

    }


    //不能在方法的外部new 一个局部内部类
//    TrackingSlip ts = new TrackingSlip("slip");


    public void  track() {
        internalTracking(true);
    }


    public static void main(String[] args) {

        Parcel6 parcel6 = new Parcel6();
        parcel6.track();

    }

}
