package innerclass.controller;

/**
 * 10.8.2 内部类与控制框架
 *
 * 要了解以下两个概念：
 *      1. 应用程序框架： 应用程序框架就是被设计用来解决某些特定问题的一个类或者一组类。要运用应用程序框架通常是继承一个类或者多个类
 *      并覆盖某些方法，在覆盖的方法中编写代码，定制应用程序提供的通用解决方案，以解决问题。
 *
 *      2. 控制框架：是一类特殊的应用程序框架，用来解决响应事件的需求。Java Swing库就是一个控制框架，它优雅的解决了GUI的问题，并大量使用了内部类。
 *============================================================================================================================
 * 想要重复某个事件可以在action中调用start，就会重新开始计时
 *
 * 可以通过覆盖ready（） 使得event事件可以基于时间意外的因素来触发
 *
 * Created by root on 17-9-20.
 */

public abstract  class Event {
    //事件将要执行的时间  如：十点钟开始执行事件 那么eventTime = 10：00
    private long eventTime;
    //延迟执行的时间
    protected  final long delayTime;

    protected Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    /**
     * start（） 允许重新开始计时
     *  System.nanoTime() 当前时间
     */
    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    /**
     * 如果当前时间大于等于时间开始执行的时间点，就返回true，表示事件准备就绪
     * @return
     */
    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    /**
     * 具体的执行动作，由子类完成
     */
    public abstract void  action();
}
