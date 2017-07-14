package interface2.interfaceprocessor;

import interface2.classprocessor.filters.Waveform;
import interfaces.filters.BrandPass;
import interfaces.filters.Filter;
import interfaces.filters.HighPass;
import interfaces.filters.LowPass;

/**
 * @ClassName [interface2.interfaceprocessor].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 10:53]
 * @Version [v1.0]
 */
public class FilterProcessor   {
    public static void main(String[] args) {

        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),  w);
        Apply.process(new FilterAdapter(new HighPass(5.0)),  w);
        Apply.process(new FilterAdapter(new BrandPass(2.0, 4.0)),  w);
    }

}

class FilterAdapter implements Processor {

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    private  Filter filter;

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((interfaces.filters.Waveform) input);
    }
}

