package interfaceprocessor;

import java.util.Arrays;

/**
 *
 * 9.3 完全解耦
 * Created by shao on 2017/7/5.
 */
public abstract class StringProcessor implements Processor {
    public static String s = "wo shi yi ge hao nan ren ";

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    //由子类来实现  这个方法是实现了接口中的方法，但是它并没有具体实现，而是交给子类来实现
    @Override
    public abstract Object process(Object input);

    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(), s);
        Apply.process(new Split(), s);
    }


}

class Upcase extends StringProcessor {

    @Override
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Downcase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Split extends StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}

