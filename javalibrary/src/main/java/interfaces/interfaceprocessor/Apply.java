package interfaces.interfaceprocessor;

/**
 * @ClassName [interfaces.interfaceprocessor].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 0:23]
 * @Version [v1.0]
 */
public class Apply {

    public static void process(Processor p, Object o) {
        System.out.println("Using Processor" + p.name());
        System.out.println(p.process(o));
    }

}
