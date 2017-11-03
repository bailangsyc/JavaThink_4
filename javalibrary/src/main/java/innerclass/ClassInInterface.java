package innerclass;

/**
 * 10.7.1  接口内部中的类
 *
 * 接口中所有的元素都是public static的，所以放到接口中的类也默认时public static的
 *
 * 因为类是static的，所以只是将嵌套类置于接口的命名空间内，并不违反接口的规则。
 * 甚至可以在内部类中实现它的外围接口。
 *
 * * Created by root on 17-9-16.
 */

public interface ClassInInterface {
    void howdy();

    //接口中的类默认static的  并且还可以实现它的外部接口
    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("howdy()");
        }
    }

    public static void main(String[] args) {
        new Test().howdy();
    }

}
