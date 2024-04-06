package fonts;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class FM {
    public static Font logofont;
    public static Font normal;
    public static Font normalTitle;
    public static Font normalBig;
    public static void initLogoFont(){
        Font.loadFont(FM.class.getResourceAsStream("/fonts/sn.ttf"), 14);
        logofont=Font.font("Screaming Neon", FontWeight.NORMAL, FontPosture.ITALIC,200);//sn.ttf锛屾枩浣擄紝30鍙�
    }
    public static void initNormalTitle(){
        Font.loadFont(FM.class.getResourceAsStream("/fonts/ops.ttf"), 14);
        normalTitle=Font.font("OPlusSans 3.0", FontWeight.BOLD, FontPosture.ITALIC,40);//sn.ttf锛屾枩浣擄紝30鍙�
        normalBig=Font.font("OPlusSans 3.0", FontWeight.BOLD, FontPosture.ITALIC,100);
    }
    public static void initNormal(){
        normal=Font.font("OPlusSans 3.0", FontWeight.NORMAL, FontPosture.ITALIC,24);//sn.ttf锛屾枩浣擄紝30鍙�
    }
}
