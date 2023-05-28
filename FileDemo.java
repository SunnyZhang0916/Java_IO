package filedemo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 演示File类的常用方法
 *
 * File类不是抽象类，所以可以直接实现对象
 * <a href="https://www.youtube.com/watch?v=NbyU4EJgmDs">...</a>
 */
public class FileDemo {
    /* 当前操作的文件路径常量 */
    //private static final String FilePath = ".";      比较专业的做法
    private static final String FilePath = "src/filedemo/test.txt";

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        File file = new File(FilePath);   //.的意思时当前project所在的root目录。其实就是一个文件夹

        System.out.println("文件/文件夹是否存在： " + file.exists());   //判断此File的实例对应的文件是否存在
        System.out.println("是不是一个文件: " + file.isFile());       //判断此File实例是否是一个标准的文件
        System.out.println("是不是一个文件夹: " + file.isDirectory());//判断此File实例是否是一个文件夹
        System.out.println("文件名/目录名： " + file.getName());     //获取此File实例对应的文件或文件夹的名称

        System.out.println("绝对路径： " + file.getAbsolutePath());     //获取此File实例对应文件或文件夹的绝对路径
        System.out.println("路径： " + file.getPath());                //获取此File实例对应文件或文件夹的绝对路径

        System.out.println("最后修改时间： " + file.lastModified());    //返回此File实例的最后修改时间
        System.out.println("最后修改时间： " + new Date(file.lastModified()).toLocaleString());    //进化一下

        System.out.println("是否隐藏： " + file.isHidden());
        System.out.println("是否可读： " + file.canRead());
        System.out.println("是否可写： " + file.canWrite());

        System.out.println("所占空间" + file.length());
        System.out.println(file.canExecute());   //for Linux

        /* 使用File类创建文件
        if (!file.exists()){         //如果文件/目录不存在，就创建
            if (file.createNewFile())
                    System.out.println("文件/文件夹创建成功。");
        }
        */

        /* 使用File类创建文件 和 文件夹 */
        if (!file.exists()) {
            if (file.isFile()) {
                file.createNewFile();
                System.out.println("创建文件");

            } else if (file.isDirectory()) {
                file.mkdir();                    //创建目录
                System.out.println("创建目录");
            }
        }

        //删除
        if (file.exists() && file.isFile()){
            file.delete();          //立即删除文件或目录
            file.deleteOnExit();    //在程序/进程结束的时候，将文件删除。也就是无法立刻写create file
        }

    }
}
