package innerclass;

/**
 * 10.6 匿名内部类
 *
 * 需要带参数的构造其的内部类
 * Created by root on 17-9-15.
 */

public class Parcel8 {
    public Wrapping wrapping(int x) {

        // 返回一个匿名内部类对象 这个对象就是Wrapping类的具体实现，
        return new Wrapping(x) {
            public int value() {
                return super.value() * 4;
            }
        };//这个分号不是标识内部类的结束，而是返回值表达式的结束标记
    }


    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(8);
        int value = wrapping.value();
        System.out.println(value);
    }


}
