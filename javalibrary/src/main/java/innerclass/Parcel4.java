package innerclass;

/**
 * 10.4 内部类与向上转型
 *
 * private内部类给类的设计者提供了一种途径,通过这种途径可以完全阻止任何依赖于
 * 类型的编码,并且完全隐藏了代码实现的细节.此外,从客户端程序员的角度来看,由于不能访问任何
 * 新增的,原本不属于公共接口的方法,所以扩展接口是没有价值的.这也给java编译器提供了生成更高效代码的机会.
 * Created by shao on 17-8-14.
 */

public class Parcel4 {
    public Parcel4() {
    }

    //私有内部类contents 只有Parcel4才可以访问
    private class Contents implements innerclass.Contents {
        private  int i = 10;

        @Override
        public int value() {
            return this.i;
        }
    }

    //protected 类型的内部类,只有Parcel4 和本包的才可以访问
    protected class PDestination implements Destination {

        private String label;

        public PDestination(String destination) {
            this.label = destination;
        }

        @Override
        public String readLabel() {
            return this.label;
        }
    }

    //返回一个destination实例
    public PDestination pDestination(){
        return new PDestination("拉萨");
    }

    //返回一个contents实例
    public Contents contents() {
        return new Contents();
    }

    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents contents = parcel4.contents();
        PDestination pDestination = parcel4.pDestination();

        // TODo 书中这里时不可以创建Contents实例的
        Contents contents1 = parcel4.new Contents();

////        Contents 是private,所以在别的类中时无法访问的
////        PDestination 时protected,所以只要是本包中的类就可以访问
////        测试的时候如果将下边这段代码放在Parcel3类中,pDestination就可以创建成功,而contents就不能创建成功
//        Parcel4 parcel4 = new Parcel4();
//        Parcel4.PDestination pDestination = parcel4.pDestination();
//        Parcel4.Contents contents = parcel4.contents();

    }

}
