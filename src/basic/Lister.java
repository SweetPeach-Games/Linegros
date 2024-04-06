package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lister {
    public static String[] reader() {
    	String[] folderNames = null;
        String dirPath = "songs/";
        File dir = new File(dirPath);
        
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            
            // 过滤文件夹
            int count = 0;
            for (File file : files) {
                if (file.isDirectory()) {
                    count++;
                }
            }
            
            // 创建保存文件夹名称的数组
            folderNames = new String[count];
            
            // 保存文件夹名称到数组
            int index = 0;
            for (File file : files) {
                if (file.isDirectory()) {
                    folderNames[index] = file.getName();
                    index++;
                }
            }
        }
		return folderNames;
    }
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void initSongs() {
    	File file =new File("songs/");    
    	//如果文件夹不存在则创建    
    	if  (!file .exists()  && !file .isDirectory())      
    	{       
    	    Log.log("songs/ 目录不存在，请下载songs文件夹");  
    	    Root.stage.close();
    	    //try {
				//Log.copyDirectory("/songs/", "songs/");
			//} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}  
    	} else   
    	{  
    	    Log.log("songs/ 目录存在");  
    	}
    }
    
}

        

