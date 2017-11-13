package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 11.3 添加一组元素
 * Collections、Arrays 是java的utils包中的两个工具类，他们中有很多使用的方法
 * Arrays.asList() Collections.addAll() 都可以添加一组元素
 * Arrays.asList() 该方法接受一个数组或者使用逗号分割的元素列表（可变参数），将其转换为一个List对象
 * Collections.addAll() 接受一个Collection对象，一个数组或者使用逗号分割的元素列表（可变参数），将
 * 其添加到Collection中
 *
 * Created by root on 17-11-3.
 */

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));//asList（）接受一个可变参数

        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));//asList（） 接受一个数组

        //将11, 12, 13, 14, 15加入到collection
        Collections.addAll(collection, 11, 12, 13, 14, 15);

        //将moreInts加入到collection
        Collections.addAll(collection, moreInts);

        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); //将索引为1的元素修改为99
        list.add(21);//运行的时候会报错  因为List的底层时数组，大小不可变，


    }

}
