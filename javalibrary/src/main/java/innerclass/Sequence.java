package innerclass;

/**
 * 当生成一个内部类对象时,此对象与制造它的外围对象之间就有了一种联系,
 * 它能访问外围对象的所有成员,内部类还拥有外围类的所有元素的访问权
 *
 *
 * 本类中首次接触到迭代器模式
 * Created by shao on 17-8-2.
 */

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {

    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        this.items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    //内部类
    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;//内部类能够访问外围类的成员对象;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if ( i < items.length)
                i++;
        }
    }

    //此方法返回一个内部类对象
    public Selector selector() {
        return  new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);

        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }

        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }


}
