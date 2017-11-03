package innerclass;

/**
 * 10.7 嵌套类
 *================================================================================================
 * 什么是嵌套类：
 *      普通的内部类与外部类有联系，如果将内部类声明为static，这通常就被称为嵌套类
 *
 * 要想类解static应用于内部类时的含义就必须记住：
 *      普通的内部类对象隐式的保存了一个外部类对象的引用，当内部类时static时，就不是这样类。
 * 所以这就意味着：
 *      1. 创建嵌套类，并不需要其外围类对象
 *      2.不能从嵌套类中访问外部类的对象，因为此时有可能外部类对象还没有创建
 *
 * 嵌套类与普通内部类的另一个区别：
 *          普通内部类的字段和方法，只能放在类的外部层次上，所以普通内部类是不可以有static数据和字段的
 *      但是嵌套类却可以。
 *==============================================================================================
 * 注意：在普通的内部类中，通过一个特殊的this就可以链接到外部类对象，嵌套类没有这个特殊的this引用，所以
 * 它看起来更像一个静态的方法。
 *
 * Created by root on 17-9-16.
 */

public class Parcel11 {
    //嵌套类 ParcelContent
    private static class ParcelContent implements Contents {

        private int i = 10;

        @Override
        public int value() {
            return i;
        }
    }

    //这是一个嵌套类（也就是静态内部类）
    protected static class ParcelDestination implements Destination {
        private String label ;
        public ParcelDestination(String label) {
            this.label = label;
        }


        @Override
        public String readLabel() {
            return label;
        }

        //嵌套类可以包含静态的元素
        public static void f() {

        }

        static  int x = 100;

        //嵌套类中也可以嵌套嵌套类
        static class AnotherLevel {
            static int x = 10;
        }

        //但是嵌套类中也可以嵌套普通的内部类
        class AnotherLevel2 {
        }


    }

    //这是一个内部类
    protected class PracelDestination2 implements Destination {
        private String label ;
        public PracelDestination2(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

        //普通的内部类中不可以包含静态的数据（类 方法  字段）

        //嵌套类可以包含静态的元素
//        public static void f() {
//
//        }

//        static  int x = 100;
//

//        static class AnotherLevel {
//            static int x = 10;
//        }

        //但是普通的内部类中可以嵌套普通的内部类
        class AnotherLevel2 {
        }

    }

    ////////////////////////////////////////////////////////////////////////
    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return  new ParcelContent();
    }
    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("三亚");

    }



}
