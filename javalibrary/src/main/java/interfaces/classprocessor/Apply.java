package interfaces.classprocessor;

import java.util.Arrays;

/**
 * 本类就是一个简单的策略者模式 ：根据所传递的参数的不同具有不同行为的方法
 * @ClassName [interfaces.classprocessor].
 * @Descriptione[9.3 完全解耦]
 * @Author [shao on 2017/7/13].
 * @Date [2017/7/13 23:45]
 * @Version [v1.0]
 */
public class Apply {

    private static String s = "wo shi yi ge hao ren";

    public static void process(Processor p, Object s) {
        System.out.println("Using Processor" + p.name());
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        process(new DownCase(), s);
        process(new UpCase(), s);
        process(new Splittter(), s);
    }

}


class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    public Object process(Object input) {
        return input;
    }
}

//转成小写
class DownCase extends Processor {
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

//转换成大写
class UpCase extends Processor {
    public String process(Object input) {
        return  ((String)input).toUpperCase();
    }

}

//用空格将String字符串每个字符分割开
class Splittter extends Processor {

    public String process(Object input) {
        return Arrays.toString(((String) input).split(""));
    }

}

