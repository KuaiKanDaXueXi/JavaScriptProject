
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 2.����һ��java����Ŀ¼��ͳ��Դ����(.java�ļ�)��������
 * Ҫ���ļ�ѡ����ѡ�й��̣�ʹ����ʾ����ʾ������������
 */

public class demo {

    private static int n = 0;

    public static void main(String[] args) throws IOException {


        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser.showDialog(new JLabel(), "ѡ��");
        File file = jFileChooser.getCurrentDirectory();
        System.out.println(file.getAbsolutePath());

        traverseFile(file);
        System.out.println(n);

    }


    public static void traverseFile(File file) throws IOException {



        if (file.isFile()) {
            //��ȡ������
            BufferedReader br = null;

            if (file.getName().endsWith(".java")) {
                if (file.getAbsolutePath().indexOf("tomcat") != -1)return;
                //�����java�ļ����в�ѯ
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
