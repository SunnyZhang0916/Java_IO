package filedemo;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件名过滤器
 */
public class FileDemoOne {
    //private static final String FilePath = "src/filedemo";

    public static void main(String[] args) {
        //String pathName = ".";   //当前Project下的root目录

        //应该使用与当前目录相关的文件名 —— 设置文件对话框打开时的根目录
        JFileChooser fileChooser = new JFileChooser(new File("."));   //JFileChooser是一个class。 在new里面设置根目录里面打开

        fileChooser.showOpenDialog(null);   //显示出选择文件的对话框

        //列出当前目录下的所有文件/文件夹
        File file = fileChooser.getSelectedFile(); //获得用户选择的文件夹，建议使用时判断file是否为Null.如果为Null,表示用户点了取消按钮

        String[] fileNames = file.list(new DirFilter());
        for(int i = 0; i < fileNames.length; i++){
            System.out.println(fileNames[i]);
        }

    }

    /**
     * 我们自定义的文件名过滤器，必须实现FilenameFilter接口
     */
    static class DirFilter implements FilenameFilter{   //改成static是因为用在main方法里面
        /**
         * Tests if a specified file should be included in a file list.
         *
         * @param dir  the directory in which the file was found.
         * @param name the name of the file.
         * @return {@code true} if and only if the name should be
         * included in the file list; {@code false} otherwise.
         */
        @Override
        public boolean accept(File dir, String name) {

            //假设我们要求只显示idea为后缀的文件，过滤其他后缀
            if(name.endsWith("idea") || name.endsWith("java"))
                return true;

            return false;
        }
    }
}
