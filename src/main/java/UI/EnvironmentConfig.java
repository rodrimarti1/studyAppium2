package UI;

//Create this file in the UI Package titled "EnvironmentConfig"
//the Environment Config File is set to GitIgnore so your environment shouldn't change when you update the project
public class EnvironmentConfig {

    //Appium Port
    public static String theAppiumPort = "4723";

    //Android Device UDID
    public static String theUDID = "emulator-5554";

    //Android version number
    public static int AndroidVersion = 13;

    //Org Name
    public static String Org = "org.lds.";

    //Android Name
    public static String AndroidName = "android";

    //Build Name of Just Serve
    public static String BuildName = "gospel-for-kids-";

    //App Element Name of Just Serve
    public static String AppName = "gospelforkids";

    //Build of Just Serve
    public static String BuildType = "alpha";
    //    public static String GospelForKids = "preview";

    //WebView Constructor
    public static String WebView = "WEBVIEW_" + Org + AppName + "." + BuildType + "";

    //millisecond standards
    //for slower devices use 4600, for faster devices use 1600
    public static int milliseconds_1 = 1600;
//    public static int milliseconds_1 = 2600;
//    public static int milliseconds_1 = 8600;

    public static int milliseconds_2 = milliseconds_1 * 2;
    public static int milliseconds_3 = milliseconds_1 * 3;
    public static int milliseconds_4 = milliseconds_1 * 4;
    public static int milliseconds_5 = milliseconds_1 * 5;

}
