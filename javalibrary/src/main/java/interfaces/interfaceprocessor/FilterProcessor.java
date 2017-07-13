package interfaces.interfaceprocessor;

/**
 * @ClassName [interfaces.interfaceprocessor].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 0:26]
 * @Version [v1.0]
 */

import interfaces.filters.BrandPass;
import interfaces.filters.Filter;
import interfaces.filters.HighPass;
import interfaces.filters.LowPass;
import interfaces.filters.Waveform;

//不但使用了适配器模式，而且使用了代理的模式
class FilterAdapter implements   Processor {

    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.getClass().getSimpleName();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform)input);
    }
}

public class  FilterProcessor{

    public static void main(String[] args) {

        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(5.0)), w);
        Apply.process(new FilterAdapter(new BrandPass(2.0, 3.0)), w);
    }
}
