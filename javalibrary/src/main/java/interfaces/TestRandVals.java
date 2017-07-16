package interfaces;

/**
 * @ClassName [interfaces].
 * @Descriptione[]
 * @Author [shao on 2017/7/16].
 * @Date [2017/7/16 14:51]
 * @Version [v1.0]
 *
 * 接口中的域 不但是final的 而且是static
 * 它们可以在类第一次被加载的时候初始化，这发生在任何域首次被访问时
 *
 * 接口中的域不是接口的一部分，但是他们的值被存储在该接口中的静态存储区域内
 */
public class TestRandVals {

    public static void main(String[] args) {
        System.out.println(RandVals.RANDOM_INT);
        System.out.println(RandVals.RANDOM_LONG);
    }

}
