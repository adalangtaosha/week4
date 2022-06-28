package week4.learncollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class UseSetAppMain {
    public static void main(String[] args) {
        printCollection(addElementsToCollection(new HashSet()));//不重复
        printCollection(addElementsToCollection(new ArrayList()));//可重复
    }

    public static Collection addElementsToCollection(Collection collection) {
        for (int i = 0; i < 10; i++) {
            collection.add("str" + (i % 5));
        }
        return collection;
    }

    public static void printCollection(Collection collection) {
        System.out.println();
        System.out.println("输出" + collection.getClass() + "中的元素，共" + collection.size() + "个");
        try {
            for (Object element : collection) {
                System.out.println(element);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
