package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author Xian
 */
public class JsoupDemo01 {
    public static void main(String[] args) throws Exception {
        //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        String path =JsoupDemo01.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析student.xml文件，加载文档进内存，获取Dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //3.1获取第一个name的Element的值
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);
    }
}
