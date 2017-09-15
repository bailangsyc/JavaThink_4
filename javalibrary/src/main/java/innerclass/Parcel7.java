package innerclass;

/**
 * 10.6匿名内部类
 * Created by root on 17-9-15.
 */

public class Parcel7 {
    //下边是一个方法 返回 一个Contents对象
    public Contents contents(){

        //返回一个匿名的内部类
        return  new Contents() {
            public int i = 10;

            @Override
            public int value() {
                return i;
            }
        };
    }


    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Contents contents = parcel7.contents();
    }


}
