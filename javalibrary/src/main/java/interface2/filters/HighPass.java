package interface2.classprocessor.filters;

/**
 * @ClassName [interface2.classprocessor.filters].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 10:33]
 * @Version [v1.0]
 */
public class HighPass {

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    private double cutoff;

    public Waveform process(Waveform input) {
        return input;
    }

}
