package interfaceprocessor;

/**
 * Created by shao on 2017/7/5.
 */
public class Apply {

    public static void process(Processor p, Object s) {
        System.out.println(p.name());
        System.out.println(p.process(s));
    }
}
