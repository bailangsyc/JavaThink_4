package holding;

/**
 * 11.2 基本概念
 *
 * 1. collection 一个独立元素的序列，这些元素都服从一条或者多条规则
 *      例如：list必须按照顺序插入 set不能有重复的元素 Queue按照排队的规则来确定对象产生的顺序（通常u与他们被插入的顺序相同）
 * 2. Map 存的都是“键值对对象”，允许根据建找值  键可以是对象，这样的一一对应关系，我们称为字典。
 *
 * Map是强大的编程工具
 *
 * 通常我们都创建一个具体的类的对象，将其转换为对应的接口，然后在其余的代码中使用这个接口，例如：
 * List<Apple> apples = new ArrayList<>();
 * 这种方法并非总能奏效，因为某些类具有额外的功能，但是接口没有。例如LInkedList类中就具有接口List
 * 所没有的方法，因此如果要使用这些特殊的方法，就不能把他们转换为通用的接口（如List）
 *
 *
 *
 * Created by root on 17-11-3.
 */

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection接口概括了序列的概念（一种存放一组对象的方式，该方式就是按照序列进行存放，而不是按照键值对的形式进行存放）
 * 下边这个示例 用Integer对象填充了一个Collection，然后打印容器中的对象
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            c.add(i);//此处会发生自动装箱 也就是 int类型自动转换为Integer对象
        }

        //取出集合中的对象 并打印
        for (Integer i : c) {
            System.out.println(i + "");
        }

    }

}
