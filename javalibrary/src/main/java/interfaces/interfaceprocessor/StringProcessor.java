package interfaces.interfaceprocessor;

import java.util.Arrays;

/**
 * @ClassName [interfaces.interfaceprocessor].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 0:28]
 * @Version [v1.0]
 */
public abstract class StringProcessor implements  Processor {
    public String name() {
        return getClass().getSimpleName();
    }

//    让子类去实现
    @Override
    public abstract Object process(Object input);

    public  static String s = "wo shi yi ge hao ren ";

    public static void main(String[] args) {
    Apply.process(new Upcase(), s);
    Apply.process(new DownCase(), s);
    Apply.process(new Spliter(), s);
    }


}

class Upcase extends StringProcessor {
     @Override
     public String process(Object input) {
         return ((String)input).toUpperCase();
     }
 }

class DownCase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Spliter extends StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}



