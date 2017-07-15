/**
 * @ClassName [PACKAGE_NAME].
 * @Descriptione[9.5.1 组合接口时名字冲突]
 * @Author [shao on 2017/7/16].
 * @Date [2017/7/16 0:09]
 * @Version [v1.0]
 * <p/>
 * Collision :冲突
 *
 * 在打算组合不同接口中使用相同方法名通常会造成代码可读性混乱，尽量避免这种情况
 */
public class InterfaceCollision {

}

interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {

    @Override
    public void f() {

    }

    @Override
    public int f(int i) {
        return 0;
    }
}

/**
 * C 无参 有返回值
 * I2 有参 有返回值
 * 没有冲突
 */
class C3 extends C implements I2 {

    @Override
    public int f(int i) {
        return 0;
    }


}

/**
 * C 无参 有返回值 只是定义了有返回值，
 * I3 无参 有返回值 返回值为1
 * 也没有什么问题
 */
class C4 extends C implements I3 {
    //    C 无参 有返回值 只是定义了有返回值， 所以此处没有问题
    public int f() {
        return 1;
    }


}

/**
 * C 无参 有返回值 只是定义了有返回值，
 * I1 无参 无返回值
 * <p/>
 * 因为extents C类，所以它也具有 int f()
 * 接口 I1 定义的必须实现的方法 f()
 * 很显然 这两个方法是有冲突的，会造成奇异，因为区分方法的重载 是通过参数来进行区分的
 */
//class C5 extends C implements I1 {
//    /**
//
//     * @return
//     */
////    public int f() {
////        return 1;
////    }
////
////    void f();
//
//}





