import impl.SingleUpLoginManage;
import system.Menu;
import system.MyMenu;

import java.time.LocalDateTime;

public class MyMain {
    public static void main(String[] args) {
        SingleUpLoginManage singleUpLoginManage = new SingleUpLoginManage();
//        Menu menu = new Menu();
//        menu.menuShop(singleUpLoginManage);
        MyMenu myMenu = new MyMenu();
        myMenu.menu(singleUpLoginManage);

//        LocalDateTime currentTime = LocalDateTime.now();
//        System.out.println("Thời gian hiện tại: " + currentTime);
    }
}
