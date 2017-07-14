package interface2.classprocessor.filters;

import interfaces.filters.*;

/**
 * @ClassName [interface2.classprocessor.filters].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 10:28]
 * @Version [v1.0]
 */
public class Filters {
    String name() {
        return getClass().getSimpleName();
    }

    Waveform process(Waveform input) {
        return  input;
    }

}


