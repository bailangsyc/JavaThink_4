package interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @ClassName [interfaces].
 * @Descriptione[]
 * @Author [shao on 2017/7/16].
 * @Date [2017/7/16 13:54]
 * @Version [v1.0]
 *
 * 在这种方式中，我们可以在任何现有类之上添加新的接口，所以这意味着让方法接口接口类型，是一种让任何类可以对该方法进行适配的方式，
 * 这就是使用接口而不是使用类的强大之处。
 */
public class AdapterRandomDoubles extends RandomDoubles implements Readable{

    public AdapterRandomDoubles(int count) {
        this.count = count;
    }

    private int count;

    @Override
    public int read(CharBuffer cb) throws IOException {

        if (count-- == 0) {
            return -1;
        }

        String result = Double.toString(next()) + " ";
        cb.append(result);

        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdapterRandomDoubles(10));
        while (s.hasNext()) {
            System.out.println(s.nextDouble() +" " );
        }
    }

}
