package interfaces;

import java.util.Random;

/**
 * TODO 这个类有问题，会报错
 * @ClassName [interfaces].
 * @Descriptione[]
 * @Author [shao on 2017/7/16].
 * @Date [2017/7/16 13:58]
 * @Version [v1.0]
 */

    public class RandomDoubles {

        private static Random rand = new Random(47);

        public double next(){
            return rand.nextDouble();
        }

        public static void main(String[] args) {

            RandomDoubles rd = new RandomDoubles();

            for (int i = 0; i < 7; i++) {
                System.out.println(rd.next() + " ");
            }
        }
    }

