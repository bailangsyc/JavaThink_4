package innerclass.controller;

/**
 * 10.8.2 控制框架与内部类
 * 温室控制系统
 *
 * todo 这个类无法正常运行， 死循环了
 * Created by root on 17-9-21.
 */

public class GrennHouseController {
    public static void main(String[] args) {
        GreenHouseControls greenHouseControls = new GreenHouseControls();
        greenHouseControls.addEvent(greenHouseControls.new Bell(900));

        Event[] eventList= {
            greenHouseControls.new ThermostatNight(0),// 直接开启恒温调节器
            greenHouseControls.new LightOn(200),//当前时间延迟200 ms开灯
            greenHouseControls.new LightOff(400),

            greenHouseControls.new WaterOn(600),
            greenHouseControls.new WaterOff(800),
            greenHouseControls.new ThermostatDay(1400)
        };

        greenHouseControls.addEvent(greenHouseControls.new Restart(2000, eventList));

        // TODO: 17-9-21  这是什么意思
        if (args.length == 1) {
            greenHouseControls.addEvent(new GreenHouseControls.Teminate(
                    new Integer(args[0])
            ));
        }

        greenHouseControls.run();

    }
}
