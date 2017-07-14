package interface2.interfaceprocessor;

/**
 * @ClassName [interface2.interfaceprocessor].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 10:39]
 * @Version [v1.0]
 */
public class Apply {

    public static void process(Processor p, Object input) {
        System.out.println("using processor" + p.name());
        System.out.println(p.process(input));
    }

}
