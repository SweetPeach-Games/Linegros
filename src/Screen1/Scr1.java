package Screen1;
import basic.Func;
import basic.INFO;
import basic.Lister;
import basic.Log;
import basic.Root;
import fonts.FM;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import menu.Menu;
import view.Numbering;

public class Scr1 extends Application{
	public static Scene scr1;
	public static void initScene() {
		
        Image image = new Image(INFO.sp+"logo.png"); 
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setOnMouseClicked(event -> {
            switchMenu();
        });
        HBox root= new HBox();
        root.getChildren().add(imageView);
        root.setAlignment(Pos.CENTER); 
        scr1=new Scene(root,INFO.w,INFO.h,Color.BLACK);
	};
	public void init() {
		FM.initLogoFont();
		FM.initNormalTitle();
		FM.initNormal();
		
		
	}
	@Override
	public void start(Stage stage) throws Exception {
		Root.stage.setResizable(false);
		Root.stage.setTitle(INFO.title);
		Root.stage.setWidth(INFO.w);
		Root.stage.setHeight(INFO.h);
		initScene();
		Root.stage.setScene(scr1);
		
		Root.stage.show();
	}
	static void switchMenu() {
		Menu.initScene();
		Lister.initSongs();
		Numbering.make();
		Log.log("读取到了"+Numbering.names);
		Func.setScene(Menu.menu);
		
	}
}
