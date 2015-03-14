package cn.edu.bistu.tvcalendar.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/14.
 */
public class XmlCtrl {
    private static SAXReader reader;
    private static Document document;
    private static Element root;


    public XmlCtrl() {
        super();
        try {
            reader = new SAXReader();
            document = reader.read("favoritedrama.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /*
     * 从xml中得到favoriteDrama
     */
    public List<String> getfavoriteDramaName(){
        System.out.print("?");
        root = document.getRootElement();
        List elements = root.elements("drama");
        List<String> favoriteDramas = new ArrayList<String>();
        for(int i=0;i<elements.size();i++){
            Element element = (Element) elements.get(i);
            String name = element.getText();
            favoriteDramas.add(name);
        }
        return favoriteDramas;
    }

    /*
     * 移除Drama
     */
    public void removeDrama(String dramaName){
        root = document.getRootElement();
        root.elements("drama").remove(dramaName);
    }

    /*
     *添加drama
     */
    public void addDrama(String dramaName){
        root = document.getRootElement();
        root.addElement(dramaName);
    }
}
