import impl.CategoryManage;
import impl.SingleUpLoginManage;
import system.Menu;

public class main {
    public static void main(String[] args) {
        SingleUpLoginManage singleUpLoginManage = new SingleUpLoginManage();
        Menu menu = new Menu();
        menu.menuShop(singleUpLoginManage);
    }
}
