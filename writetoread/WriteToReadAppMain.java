package week4.writetoread;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WriteToReadAppMain {
    private static final Scanner in = new Scanner(System.in);
//    private static final String SOURCE_FILE_NAME = "demo.txt";

    public static void main(String[] args) throws IOException {
        //写
        File targetFile = createFile();


        writeToFile(targetFile);

        System.out.println("写入程序执行结束");

//        File sourceFile = new File("src/week4/learntowrite/" + File.separator + SOURCE_FILE_NAME);
        // 读
        // TODO 猜猜 System.in是个啥，其实和output那边的套路是一样的，System.in只能读取标准的输入里的byte
        // TODO 而Scanner可以将这个byte读取出来，转换成String，进而转换成不同的数据类型，比如int，boolean

        classicWay(targetFile);//经典
        coolerWay(targetFile);//便捷

    }

    private static void writeToFile(File targetFile) throws IOException {
        // TODO try with resource，帮我们搞定close
        try (
                // TODO 创建一个outputstream，建立一个从文件到程序的byte数据传输流
                FileOutputStream fos = new FileOutputStream(targetFile);
                // TODO 建立一个可以消费outputstream的writer，并指定字符集，这样就可以一个个的写入字符了
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                // TODO 使用PrintWriter，可以方便的写入一行字符
                PrintWriter pw = new PrintWriter(osw);
        ) {
            // TODO 猜猜System.out是个啥？
            System.out.println("输入的内容会实时写入文件，如果输入空行则结束");
            while (true) {
                String lineToWrite = in.nextLine().trim();
                System.out.println("输入内容为" + lineToWrite);
                if (lineToWrite.trim().isBlank()) {
                    System.out.println("输入结束");
                    break;
                } else {
                    pw.println(lineToWrite);
                    pw.flush();//把缓存写入文件
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static File createFile() throws IOException {
        System.out.println("请输入文件名：");
        String fileName = in.nextLine().trim();
//        File f = new File("." + File.separator + fileName + ".txt");
        File f = new File("src/week4/writetoread/" + File.separator + fileName + ".txt");
        if (f.isFile()) {
            System.out.println("目标文件存在，删除：" + f.delete());
        }
        System.out.println(f.createNewFile());
        return f;
    }
    private static void classicWay(File sourceFile) {
        System.out.println("---------经典的处理方式-----------");
        try (
                // TODO 建立从文件到程序的数据输入（input）流
                FileInputStream fis = new FileInputStream(sourceFile);
                // TODO 用 InputStreamReader 将这个byte 流套一下，装饰一下，并指定字符编码，让它能够将读出的byte转为字符
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                // TODO 增加缓存功能，输入输出效率更高，并且可以一次读取一行
                BufferedReader reader = new BufferedReader(isr);
        ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
//                System.out.println(line.trim().toUpperCase());//大写字母
                System.out.println(line.trim());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static void coolerWay(File sourceFile) {
        System.out.println("---------666的处理方式-----------");
        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr);
        ) {
//            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);//大写字母
            reader.lines().map(String::trim).forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
