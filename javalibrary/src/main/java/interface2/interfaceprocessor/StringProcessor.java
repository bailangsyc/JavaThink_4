package interface2.interfaceprocessor;

import java.util.Arrays;

/**
 * @ClassName [interface2.interfaceprocessor].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 10:42]
 * @Version [v1.0]
 */
public abstract class StringProcessor implements  Processor{

    private static String s = "woshihaoren";

    public static void main(String[] args) {
        Apply.process(new UpcaseProcessor(), s);
        Apply.process(new DownProcessor(), s);
        Apply.process(new SplitterProcessor(), s);
    }
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public abstract Object process(Object input) ;
}

class UpcaseProcessor extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class DownProcessor extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class SplitterProcessor extends StringProcessor {
    @Override
    public String process(Object input) {
        return (Arrays.toString(((String)input).split(" ")));
    }
}



