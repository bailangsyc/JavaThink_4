package interface2.classprocessor.filters;

/**
 * @ClassName [interface2.classprocessor.filters].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 10:34]
 * @Version [v1.0]
 */
public class BandPass {

    private double lowCutoff;

    public BandPass(double lowCutoff, double hightCutoff) {
        this.lowCutoff = lowCutoff;
        this.hightCutoff = hightCutoff;
    }

    private double hightCutoff;

    public Waveform process(Waveform input) {
        return  input;
    }

}
