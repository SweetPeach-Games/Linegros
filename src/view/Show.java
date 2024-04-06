package view;

import basic.Func;
import basic.INFO;
import fonts.FM;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import menu.Menu;

public class Show {
	public static int at=0;
	public static Label name;
	public static Label singer;
	public static ImageView surface;
	/**
	 * scene manager
	 */
	public static void sm() {
		System.out.print("songs/"+Numbering.folder[0]+"/surface.png");
		Group group =new Group();
		Scene s=new Scene(group,INFO.w,INFO.h,Color.BLACK);
		
		//首先进行at号歌曲展示
		surface=new ImageView(new Image("file:songs/"+Numbering.folder[at]+"/surface.png"));
		
		VBox vbox=new VBox();
		name=new Label(Numbering.name[at]);
		name.setFont(FM.normalBig);
		singer=new Label(Numbering.singer[at]);
		singer.setFont(FM.normalTitle);

		vbox.getChildren().addAll(name,singer);
		//s.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
        	//if (event.getCode() == KeyCode.ESCAPE) {
        	//	Func.setScene(Menu.menu);
        	//}
        //});
		
        s.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            //System.out.println(Numbering.folder[3]);
            //if (event.getCode() == KeyCode.D) {
                // 调用方法
        	if (event.getCode() == KeyCode.ESCAPE) {
        		Func.setScene(Menu.menu);
        	}else {
        	if(at<Numbering.folder.length-1){
            	//System.out.println("1");
            	at+=1;
            	//System.out.println("file:songs/"+Numbering.folder[at]+"/surface.png");
            	surface.setImage(new Image("file:songs/"+Numbering.folder[at]+"/surface.png"));
            	name.setText(Numbering.name[at]);
            	singer.setText(Numbering.singer[at]);
            	event.consume(); // 防止事件进一步传播
            //}
            }
            else {
            	//System.out.println("1");
            	at=0;
            	//System.out.println("file:songs/"+Numbering.folder[at]+"/surface.png");
            	surface.setImage(new Image("file:songs/"+Numbering.folder[at]+"/surface.png"));
            	name.setText(Numbering.name[at]);
            	singer.setText(Numbering.singer[at]);
            	event.consume(); // 防止事件进一步传播
            }
        	}  
        });
        
		
		group.getChildren().addAll(surface,vbox);
		Func.setScene(s);
	}
}
