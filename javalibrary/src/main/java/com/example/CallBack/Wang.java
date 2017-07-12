package callback;

import com.example.CallBack.CallBack;
import com.example.CallBack.Li;

/**
 * 本案例用来学习java的回调
 * 所谓回调：就是A类中调用B类中的某个方法C，然后B类中反过来调用A类中的方法D，D这个方法就叫回调方法，
 * 具体参照博客：http://blog.csdn.net/c_z_w/article/details/52040811
 * <p>
 * 经典的场景：
 * 有一天小王遇到一个很难的问题，问题是“1 + 1 = ?”，就打电话问小李，小李一下子也不知道，就跟小王说，等我办完手上的事情，就去想想答案，
 * 小王也不会傻傻的拿着电话去等小李的答案吧，于是小王就对小李说，我还要去逛街，你知道了答案就打我电话告诉我，于是挂了电话，自己办自己的事情，
 * 过了一个小时，小李打了小王的电话，告诉他答案是2
 *
 * @author shao
 */

public class Wang implements CallBack {
    private Li li;

    //持有对小李的引用
    public Wang(Li li) {
        this.li = li;
    }

    /**
     * 通过这个方法问小李问题
     *
     * @param question
     */
    public void askQesution(final String question) {
        //开启一个子线程 问小王问题
        new Thread(new Runnable() {

            @Override
            public void run() {
                //调用小李中的方法
                li.excuteMessage(Wang.this, question);

            }
        }).start();

        //在小李解决问题的过程中 小王可以干别的事  如逛街
        play();

    }

    private void play() {
        System.out.println("小李正在解决问题，我要去逛街");
    }

    /**
     * 小王知道答案后调用此方法 通知小李
     * 这个方法就是所谓的回调方法
     */
    @Override
    public void sovle(String result) {
        // TODO Auto-generated method stub
        System.out.println("小李告诉小王的答案是" + result);
    }


    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);

        //小王问小李问题
        System.out.println("小王问小李问题 1 + 1 = ？");
        wang.askQesution("1 + 1 = ?");
    }

}
