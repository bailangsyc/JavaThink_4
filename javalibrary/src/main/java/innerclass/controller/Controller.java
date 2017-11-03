package innerclass.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * 10.8.2 这是一个用来管理并触发事件的实际控制框架
 *
 * 包含：
 *      1. 存储event事件的容器list
 *      2. foreach（） 来连续获得list中的事件
 *      3.remove（） 从容器中移除事件
 *
 *  在这个框架中，我们并不知道event具体做了什么，这正式设计的关键所在。使得不变的事物与变化的事物分离
 *  所谓的变化向量（变化的部分）就是各种不同的Event对象所具有的行为，他们通过创建不同的子类来实现不同的行为。
 *
 *  这正式内部类要做的事情:
 *      1. 控制框架的完整实现是由单个的类创建的，从而使得实现的的细节被封装起来。内部类有嗯来表示解决问题所必需的各种不同action（）
 *      2. 内部类可以轻而易举的访问外部类的任意成员，所以可以避免这种实现变得笨拙。
 *
 * Created by root on 17-9-20.
 */

public class Controller {
    private List<Event> eventList = new ArrayList<>();

    //添加事件
    public void addEvent(Event event) {
        eventList.add(event);
    }


    /**
     * 遍历循环容器中的事件，找出就绪的事件，并执行
     */
    public void run() {
        while (eventList.size() > 0) {
//            for (Event event : eventList) { //todo 为什么这里不能这样写呢，难道list集合是无法用foreach语法迭代的吗
            for (Event event : new ArrayList<Event>(eventList)) {
                if (event.ready()) {
                    System.out.println(event.toString());
                    event.action();
                    //执行完成后从容器中移除
                    eventList.remove(event);
                }
            }
        }
    }
}
