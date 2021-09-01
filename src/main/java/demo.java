
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 2.给定一个java工程目录，统计源代码(.java文件)代码量；
 * 要求文件选择器选中工程，使用提示框显示代码总行数；
 */

public class demo {

    private static int n = 0;

    public static void main(String[] args) throws IOException {


        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser.showDialog(new JLabel(), "选择");
        File file = jFileChooser.getCurrentDirectory();
        System.out.println(file.getAbsolutePath());

        traverseFile(file);
        System.out.println(n);

    }


    public static void traverseFile(File file) throws IOException {



        if (file.isFile()) {
            //获取输入流
            BufferedReader br = null;

            if (file.getName().endsWith(".java")) {
                if (file.getAbsolutePath().indexOf("tomcat") != -1)return;
                //如果是java文件进行查询
                br = new BufferedReader(new FileReader(file));
                while (br.readLine() != null) {
                    n++;
                }
                br.close();

                System.out.println(file.getAbsolutePath());

            }

        } else {

            File[] fl = file.listFiles();
            if (fl != null && fl.length > 0) {
                for (File f : fl) {
                    traverseFile(f);
                }
            }
        }

    }

}
