package innerclass.controller;

/**
 * 10.8.2 控制框架与内部类
 *
 * 使用内部类，可以在单一的类中产生对同一个基类Event的多种导出版本
 * 对于温室系统的每一种行为，都继承了一个信的Event内部类，并在要实现的action（）中编写控制代码。
 * Created by root on 17-9-20.
 */

public class GreenHouseControls extends Controller {
    //灯光
    private boolean light = false;//默认是关

    //控制灯的开的事件
    public class LightOn extends Event {

        protected LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        /**
         * 将灯打开
         */
        public void action() {
            light = true;//可以很轻松的访问外围类的成员
        }

        @Override
        public String toString() {
            return "灯已经打开了";
        }
    }

    //关灯的事件
    public class LightOff extends Event {
        protected LightOff(long delayTime) {
            super(delayTime);
        }

        //关灯
        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "灯关了";
        }
    }


    //水
    private boolean water = false;

    /**
     * 打开水的事件
     */
    public class WaterOn extends Event {

        protected WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "温室中的水打开了";
        }
    }

    /**
     * 关闭水的开关
     */
    public class WaterOff extends Event {

        protected WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "温室中的水关了";
        }
    }

    //恒温调节器
    private String thermostat = "Day";//默认是白天

    public class ThermostatNight extends Event {

        protected ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "晚间恒温调节器的设置";
        }
    }

    public class ThermostatDay extends Event {
        protected ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "恒温调节器在白天的设置";
        }
    }

    //一个响玲的事件事件
    public class Bell extends Event {

        protected Bell(long delayTime) {
            super(delayTime);
        }

        //调用这个方法，就会添加一个响玲的事件
        @Override
        public void action() {
            //delayTime 使用的时基类的成员变量，
            // 但是基类的成员变量delayTime怎么初始化呢？它是在Bell类的构造中调用基类的构造器赋值的
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "玲响了";
        }
    }

    //重新启动系统的事件 todo 这里的不太懂
    public class Restart extends Event {

        private final Event[] eventList;

        protected Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            // TODO: 17-9-20 eventList中不是已经存在各个事件了为什么还要遍历添加呢
            for (Event event : eventList) {
                addEvent(event);
            }
        }

        @Override
        public void action() {
            for (Event event : eventList) {
                event.start();
                addEvent(event);
            }
            // TODO: 17-9-20 为什么又调用了这一个方法呢
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "重启控制系统";
        }
    }

//    todo 也是看的不太懂Teminate 结束
    public static class Teminate extends Event {
        protected Teminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "终止";
        }
    }

}