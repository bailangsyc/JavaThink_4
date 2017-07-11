package interfaceprocessor;

import interfaces.music4.filters.BandPass;
import interfaces.music4.filters.Filter;
import interfaces.music4.filters.HightPass;
import interfaces.music4.filters.LowerPass;
import interfaces.music4.filters.Waveform;

/**
 * TODO 这个案例需要好好理解理解
 *看似简单，代码没有几行，  但是理解起来比较困难
 * FilterAdapter中同时也使用了代理模式
 * Created by shao  on 2017/7/8.
 */

class FilterAdapter implements Processor {
    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    Filter filter;

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}

public class FilterProcessor {

    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowerPass(1.0)), w);
        Apply.process(new FilterAdapter(new HightPass(2.0)), w);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);

    }

}


