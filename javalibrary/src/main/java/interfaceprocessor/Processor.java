package interfaceprocessor;

/**
 * Created by shao on 2017/7/5.
 */
public interface Processor {

    String name();

    /**
     * 接受一个输入的参数，修改它的值，并将其输出
     * @param input
     * @return
     */
    Object process(Object input);
}
