package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 11.3 添加一组元素
 * <p>
 *
 * Arrays.asList()方法的限制是它对所产生的List的类型做出最理想的假设，
 * 而并没有注意到开发者对它赋予什么样的类型。这回引发一些问题。
 * Created by root on 17-11-3.
 */

class Snow {
}


class Powder extends Snow{}

class Crusty extends Snow{}

class Slush extends Snow{}

class Light extends Powder{}

class Heavy extends Powder{}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 =
                Arrays.asList(new Crusty(), new Slush(), new Powder());

        //创建snow2时， Arrays.asList（）返回的List中只有Powder类型，
        //因此它会创建List<Powder>，而不是List<Snow>
        //尽Collections.addAll() 做的很好，因为它从第一个参数中就了解到了目标类型是什么
        List<Snow> snow2 =
                Arrays.asList(new Light(), new Heavy());

        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3, new Light(), new Heavy());

        //Arrays.<Snow>asList 中间加入<Snow> 告诉百纳一起对于Arrays.asList()产生的List的类型
        //这称为显示类型参数说明
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());


    }
}
