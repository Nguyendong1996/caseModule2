import impl.SingleUpLoginManage;
import system.MyMenu;
public class MyMain {
    public static void main(String[] args) {
        SingleUpLoginManage singleUpLoginManage = new SingleUpLoginManage();
//        menu.menuShop(singleUpLoginManage);
        MyMenu myMenu = new MyMenu();
        myMenu.menu(singleUpLoginManage);
    }
}
