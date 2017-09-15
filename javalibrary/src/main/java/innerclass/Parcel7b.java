package innerclass;

/**
 *
 * 10.6 匿名内部类
 * Parcel7b经过简化后可以写成Parcel7 的形式， 两者都是内部类，只不过Parcel7是匿名的
 * 内部类也分为方法中的内部类（局部内部类）和类中的内部类
 * Created by root on 17-9-15.
 */

public class Parcel7b {

    private Contents contents() {
         class MyContents implements  Contents {

             private int i = 10;

             @Override
             public int value() {
                 return i;
             }
         }

        MyContents myContents = new MyContents();
        return  myContents;
    }

    public static void main(String[] args) {
        Parcel7b parcel7b = new Parcel7b();
        Contents contents = parcel7b.contents();
    }


}
