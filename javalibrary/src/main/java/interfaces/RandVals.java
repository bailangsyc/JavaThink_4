package interfaces;

import java.util.Random;

import sun.rmi.runtime.Log;

/**
 * @ClassName [interfaces].
 * @Descriptione[9.7 初始化接口中的域 ]
 * @Author [shao on 2017/7/16].
 * @Date [2017/7/16 14:46]
 * @Version [v1.0]
 */
interface RandVals {
    //接口中的域 不能是空的 final ,但是可以被非常量表达式进行初始化
    Random rand = new Random(47);
    // rand.nextInt(10)非常量表达式
    int RANDOM_INT = rand.nextInt(10);
    long RANDOM_LONG = rand.nextLong() * 10;
}
