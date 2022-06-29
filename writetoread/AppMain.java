package week4.writetoread;
import java.io.*;

import static week4.writetoread.WriteToRead.*;


public class AppMain {

    public static void main(String[] args) throws IOException {
        //写
        File targetFile = createFile();


        writeToFile(targetFile);

        System.out.println("写入程序执行结束");

        // TODO 猜猜 System.in是个啥，其实和output那边的套路是一样的，System.in只能读取标准的输入里的byte
        // TODO 而Scanner可以将这个byte读取出来，转换成String，进而转换成不同的数据类型，比如int，boolean

        classicWay(targetFile);//经典
        coolerWay(targetFile);//便捷

    }


}
