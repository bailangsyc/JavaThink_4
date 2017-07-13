package interfaces.filters;

public  class BrandPass extends Filter {

    double lowCutoff;
    double highCutoff;

    public BrandPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    public Waveform process(Waveform input) {
        return  input;
    }

}
