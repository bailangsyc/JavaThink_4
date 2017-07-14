package interface2.classprocessor;

import java.awt.Point;
import java.util.Arrays;

/**
 * @ClassName [interface2.classprocessor].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 9:51]
 * @Version [v1.0]
 */
public class Apply {

    public static void process(Processor p, Object o) {
        System.out.println("using Processor" + p.name());
        System.out.println(p.process(o));
    }

    private  static String s = "woshiyigehaoren";

    public static void main(String[] args) {

        process(new Upcase(), s);
        process(new DownCase(), s);
        process(new Splitter(), s);

    }

}

 class Processor{

    String name(){
        return getClass().getSimpleName();
    }

   Object process(Object input) {
        return  input;
    }

}

class Upcase extends  Processor{

    String process(Object input) {
        return ((String )input).toUpperCase();
    }

}

class DownCase extends Processor {
    String process(Object input) {
        return ((String )input).toLowerCase();
    }
}

class Splitter extends Processor {

    String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }

}