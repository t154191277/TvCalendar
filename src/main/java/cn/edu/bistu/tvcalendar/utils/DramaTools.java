package cn.edu.bistu.tvcalendar.utils;

import java.util.ArrayList;
import java.util.List;

import cn.edu.bistu.tvcalendar.model.Drama;

/**
 * Created by Administrator on 2015/3/14.
 */
public class DramaTools {
    public static List<Drama> Dramas = null;
    public static List<Drama> myDramas = null;
    static{
        Dramas = new ArrayList<Drama>();
        myDramas = new ArrayList<Drama>();
        String[] s1 = {"黄晓明","sdf"};
        String[] s2 = {"黄晓明","sdf"};
        String[] s3 = {"黄晓明","sdf"};
        Drama d1 = new Drama("The Walking Dead", 10, 0, "李旭波",s1,false);
        Drama d2 = new Drama("The Arrow", 50, 3, "黄钦阳",s2,false);
        Drama d3 = new Drama("Pretty Little Liars", 90, 9, "和展",s3,false);
        Drama d4 = new Drama("Eye Candy", 20, 9, "发林",s3,false);
        Drama d5 = new Drama("Once Upon a time", 90, 9, "老狗",s3,false);
        Drama d6 = new Drama("The Originals", 90, 9, "臻臻",s3,false);
        Drama d7 = new Drama("New Girl", 90, 9, "晟钦",s3,false);
        Drama d8 = new Drama("The 100", 90, 9, "苏聪",s3,false);
        Drama d9 = new Drama("Better Call Saul", 90, 9, "胖子",s3,false);
        Drama d10 = new Drama("Bates Motel", 90, 9, "三川",s3,false);
        Dramas.add(d1);
        Dramas.add(d2);
        Dramas.add(d3);
        Dramas.add(d4);
        Dramas.add(d5);
        Dramas.add(d6);
        Dramas.add(d7);
        Dramas.add(d8);
        Dramas.add(d9);
        Dramas.add(d10);

        myDramas.add(d2);
        myDramas.add(d5);
    }

// 	public static List<Drama> getFavoriteDrama(){
// 		XmlCtrl = new XmlCtrl();
// 		for(int i=0;i<XmlCtrl.getfavoriteDramaName().size();i++){
// 			String favoriteDramaName = XmlCtrl.getfavoriteDramaName().get(i);
// 			for(Drama Drama :Dramas){
// 				if(Drama.getName().equals(favoriteDramaName)){
// 					myDramas.add(Drama);
// 					Drama.setIsfavorite(true);
// 				}
// 			}
// 		}
// 			
// 		return myDramas;
// 	}

    public static void addmyDrama(Drama Drama){
        myDramas.add(Drama);
    }

    public static void removeDrama(Drama Drama){

        myDramas.remove(Drama);
    }
}
