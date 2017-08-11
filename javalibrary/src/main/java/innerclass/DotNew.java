package innerclass;

/**
 *  10.3 使用.this 和 .new
 *
 *  使用.new语法
 *
 * Created by shao on 17-8-12.
 */

public class DotNew {
    public class  Inner{
        public Inner() {
            System.out.println("Inner()");
        }
    }


    public static void main(String[] args) {
        //要想创建内部类,必须先创建外部类的实例,
        DotNew dotNew = new DotNew();
        Inner inner = dotNew.new Inner();//dotNew.new中的.new语法就是为了提供外部类对象的引用给内部类
    }
}
