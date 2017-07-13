package interfaces.filters;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 滤波器案例
 *
 * @ClassName [interfaces.filters].
 * @Descriptione[]
 * @Author [shao on 2017/7/14].
 * @Date [2017/7/14 0:02]
 * @Version [v1.0]
 */
public class Waveform {
    private static long counter;
    private static final long id = counter++;

    public String toString() {
        return "Waveform" + id;
    }


}



