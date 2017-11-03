package holding;

import java.util.ArrayList;

/**
 * 11.1 使用泛型
 * Created by root on 17-10-31.
 */

public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        //添加3个苹果
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }

        //因为对ArrayList<Apple> 使用了预定义的泛型，所以编译的时候容器就会执行检查
//        apples.add(new Orange());


        //如果使用了预定义的泛型的时候，从容器中取出元素的时候也不用再进行类型转换了
        for (int i = 0; i < apples.size(); i++) {
            long id = apples.get(i).id();
            System.out.println(id);
        }

        //如果不需要索引的话，也可以 使用foreach语法
        for (Apple apple : apples) {
            long id = apple.id();
            System.out.println("foreache语法：：：" + id);
        }

    }
}
