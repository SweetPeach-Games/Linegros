package menu;

import basic.INFO;
import basic.Root;
import fonts.FM;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.Show;

public class Menu{
	public static Scene menu;
	public static void initScene() {
		ImageView logo = new ImageView(new Image(INFO.sp+"qulogo.png"));
		logo.setFitWidth(250);
		logo.setFitHeight(150);
		
		ImageView start = new ImageView(new Image(INFO.sp+"start.png"));
		int stW= 250;
		int stH= 100;
		start.setFitWidth(stW);
		start.setFitHeight(stH);
		start.setY(175);
		start.setX(100);
		start.setOnMouseClicked(event -> {
            switchView();
        });
		
		HBox hbox =new HBox();
		hbox.getChildren().add(logo);
		
		Group root = new Group();
		root.getChildren().addAll(hbox,start);
		
        start.setOnMouseEntered(e -> {
            // 放大动画
        	start.setScaleX(1.2);
        	start.setScaleY(1.2);
        });
 
        start.setOnMouseExited(e -> {
            // 缩小到原始大小
        	start.setScaleX(1);
        	start.setScaleY(1);
        });
		
        ImageView about = new ImageView(new Image(INFO.sp+"about.png"));
        about.setFitWidth(150);
        about.setFitHeight(150);
        about.setY(720-250);
        about.setX(100);
		
		root.getChildren().add(about);
		
        about.setOnMouseEntered(e -> {
            // 放大动画
        	about.setScaleX(1.2);
        	about.setScaleY(1.2);
        });
 
        about.setOnMouseExited(e -> {
            // 缩小到原始大小
        	about.setScaleX(1);
        	about.setScaleY(1);
        });
        
        about.setOnMouseClicked(event -> {
            clickAbout();
        });
        
        Image image = new Image(INFO.sp+"lines2.png"); // 替换为你的图片路径
        ImageView imageView = new ImageView(image);
        imageView.setX(1280-720);
        root.getChildren().add(imageView);
        
		menu=new Scene(root);
		menu.setFill(Color.BLACK);
	}
	
	public static void switchView() {
		Show.sm();
	}

	public static void clickAbout() {
		/*HBox root=new HBox();
		Stage about=new Stage();
		Scene s=new Scene(root,INFO.w,INFO.h,Color.WHITE);
		about.setTitle(INFO.gamename+" 关于");
		Label title=new Label("关于");
		title.setFont(FM.normal);
		
		root.getChildren().addAll(title);
		about.setScene(s);
		about.initOwner(Root.stage);
		//Root.stage.show();
		about.show();*/
		
		//Stage s1 = new Stage();
        //s1.setTitle("s1");

        Stage s2 = new Stage();
        s2.setTitle(INFO.gamename+" 关于");
        VBox root=new VBox();
        Label title=new Label("关于 与 版权信息\n");
        title.setTextFill(Color.WHITE);
        title.setFont(FM.normalTitle);
        Text text=new Text();
        text.setText("Copyright (c) SweetPeach.版权所有.\n"+
        			 "logo设计、绘图 ：XiaoYv、upbingun、覃一轩、苏富明.\n"+
        			 "开发者：XiaoYv、upbingun.\n"+
        			 "原作（TubroWarp）：Linegros (by XiaoYv).\n"+
        			 "客服：txy1145141919@outlook.com  .\n"+
        			 "bug反馈：upbingun@163.com   .\n"+
        			 "引擎：JavaFX8 (Oracle OpenJDK8).\n"+
        			 "字体：OPlusSans 3.0&Streaming Neon，包含在/fonts中.\n"+
        			 "（由于OPPO公司并没有OPlusSans的信息，所以该字体随时可能更换掉）\n"+
        			 "其中：\n"+
        			 "XiaoYv提供了Logo设计，upbingun同样提供。使用的是由XiaoYv设计的.\n"+
        			 "Liner（莱恩）主要由XiaoYv设计.\n"+
        			 "请尊重他们的劳动成果，即使我们开源了.\n"+
        			 "项目Github地址：https://github.com/upbingun233/Linegros\n"+
        			 "感谢他们的贡献！\n\n"+
        			 "和你.");
        text.setFont(FM.normal);
        text.setFill(Color.WHITE);
        root.setStyle("-fx-background-color:black");
        root.getChildren().addAll(title,text);
        Scene s=new Scene(root,INFO.w,INFO.h);
        // s1有s2;
        s2.initOwner(Root.stage);
        s2.setScene(s);
        s2.show();
	}
}

