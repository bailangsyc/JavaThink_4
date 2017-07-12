package callback;

import com.example.CallBack.CallBack;
import com.example.CallBack.Li;

/**
 * ����������ѧϰjava�Ļص�
 * ��ν�ص�������A���е���B���е�ĳ������C��Ȼ��B���з���������A���еķ���D��D��������ͽлص�������
 * ������ղ��ͣ�http://blog.csdn.net/c_z_w/article/details/52040811
 * <p>
 * ����ĳ�����
 * ��һ��С������һ�����ѵ����⣬�����ǡ�1 + 1 = ?�����ʹ�绰��С�С��һ����Ҳ��֪�����͸�С��˵�����Ұ������ϵ����飬��ȥ����𰸣�
 * С��Ҳ����ɵɵ�����ŵ绰ȥ��С��Ĵ𰸰ɣ�����С���Ͷ�С��˵���һ�Ҫȥ��֣���֪���˴𰸾ʹ��ҵ绰�����ң����ǹ��˵绰���Լ����Լ������飬
 * ����һ��Сʱ��С�����С���ĵ绰������������2
 *
 * @author shao
 */

public class Wang implements CallBack {
    private Li li;

    //���ж�С�������
    public Wang(Li li) {
        this.li = li;
    }

    /**
     * ͨ�����������С������
     *
     * @param question
     */
    public void askQesution(final String question) {
        //����һ�����߳� ��С������
        new Thread(new Runnable() {

            @Override
            public void run() {
                //����С���еķ���
                li.excuteMessage(Wang.this, question);

            }
        }).start();

        //��С��������Ĺ����� С�����Ըɱ����  ����
        play();

    }

    private void play() {
        System.out.println("С�����ڽ�����⣬��Ҫȥ���");
    }

    /**
     * С��֪���𰸺���ô˷��� ֪ͨС��
     * �������������ν�Ļص�����
     */
    @Override
    public void sovle(String result) {
        // TODO Auto-generated method stub
        System.out.println("С�����С���Ĵ���" + result);
    }


    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);

        //С����С������
        System.out.println("С����С������ 1 + 1 = ��");
        wang.askQesution("1 + 1 = ?");
    }

}
