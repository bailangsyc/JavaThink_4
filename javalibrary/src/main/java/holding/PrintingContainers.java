package holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by root on 17-12-16.
 * 11章 持有对象
 * 11.4 容器的打印
 *
 * 从输出的结果可以看出来，默认的打印行为（容器提供的toString（））打印出的结果具有良好的可读性。
 */

public class PrintingContainers {
    //打印Collection
    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    //打印map容器
    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Splot");
        return map;
    }

    public static void main(String[] args) {
        //List 以特定的顺序保存，可以重复，ArrayList和LinkedList不同之处在与插入时的性能，LinkedList的操作要多于ArrayList
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new LinkedList<String>()));
        //Set不允许重复，不同的set实现存储的方式也不同，
        //HashSet使用相当复杂的方式来存储元素，具体在第17章介绍
        //如果需要按照升序的方式保存对象，可以使用TreeSet
        //如果需要按照插入的顺序保存对象，可以使用LinkedHashSet
        System.out.println(fill(new HashSet<String>()));//HashSet具有去重的效果
        System.out.println(fill(new TreeSet<String>()));//TreeSet不仅可以去重，而且可以排序
        System.out.println(fill(new LinkedHashSet<String>()));

        //HashMap提供了最快的查找技术，也没有按照任何明显的顺序来保存键
        //TreeMap按照升序来保存键
        //LinkedHashMap则按照插入的顺序来保存键，同时保留了HashMap的查询速度
        System.out.println(fill(new HashMap<String, String>()));
        System.out.println(fill(new TreeMap<String, String>()));
        System.out.println(fill(new LinkedHashMap<String, String>()));

        /*
        *
        * 以下是打印的结果
[rat, cat, dog, dog]
[rat, cat, dog, dog]
[rat, cat, dog]
[cat, dog, rat]
[rat, cat, dog]
{rat=Fuzzy, cat=Rags, dog=Splot}
{cat=Rags, dog=Splot, rat=Fuzzy}
{rat=Fuzzy, cat=Rags, dog=Splot}

        * */

    }
}
