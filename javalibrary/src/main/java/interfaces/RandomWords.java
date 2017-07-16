package interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName [interfaces].
 * @Descriptione[9.6 适配接口]
 * @Author [shao on 2017/7/16].
 * @Date [2017/7/16 12:25]
 * @Version [v1.0]
 */
public class RandomWords implements Readable{

    private static Random rand = new Random(47);
    private static final char[] capitals = "ABCDEFGH".toCharArray();
    private static final char[] low = "abcdefgh".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();//vowels元音
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }


    @Override
    public int read(CharBuffer cb) throws IOException {

        if (count-- == 0) {
            return -1;//结束的标记
        }

        cb.append(capitals[rand.nextInt(capitals.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(low[rand.nextInt(low.length)]);
        }

        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}
