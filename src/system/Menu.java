package system;

import impl.CategoryManage;
import impl.ProductManage;
import impl.SingleUpLoginManage;

import java.util.Scanner;

public class Menu {
        Scanner scanner;
        CategoryManage categoryManage = new CategoryManage();
        ProductManage productManage = new ProductManage(categoryManage);
        public Menu() {
            this.scanner = new Scanner(System.in);
        }
        public void menuShop(SingleUpLoginManage singleUpLoginManage) {
            int choice =0;
            do {
                System.out.println("1 : home Page !");
                System.out.println("2 : Product !");
                System.out.println("3 : Introduce Shop !");
                System.out.println("4 : Search Product");
                System.out.println("5 : News !");
                System.out.println("6 : Register as an agent");
                System.out.println("7 : Login !");
                System.out.println("0 : Exits !!!!!!");
                System.out.println("Enter your choice");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                }catch (Exception e){
                    System.out.println("What's your choice? Please re-enter !");
                }
                if (choice<0|| choice>7){
                    System.out.println("What's your choice? Please re-enter !");
                }else {
                switch (choice) {
                    case 1: break;
                    case 2:productManage.disPlay();break;
                    case 3:
                    case 4:searchProduct();break;
                    case 5:
                    case 6:singleUpLoginManage.Register();break;
                    case 7: {
                            boolean check = singleUpLoginManage.Login();
                            if (check) {
                                ManageShop();
                                break;
                            } else {
                            System.out.println("Username or password incorrect . please try again or subscribe!");
                        }
                    }
                    break;
                }}
            } while (choice != 0);
        }

        public void ManageShop() {
            int choice= 0;
            do {
                System.out.println("1 : home Page ");
                System.out.println("2 : Product ");
                System.out.println("3 : Introduce Shop ");
                System.out.println("4 : Search Product by name ");
                System.out.println("5 : Sales Center  ");
                System.out.println("6 : home Category ");
                System.out.println("7 : home Product ");
                System.out.println("0 : Exits !!!");
                System.out.println("Enter your choice: ");
                try {
                choice = Integer.parseInt(scanner.nextLine());}
                catch (Exception e){
                    System.out.println("What's your choice? Please re-enter !");
                }
                if (choice<0||choice>7){
                    System.out.println("What's your choice? Please re-enter !");
                }else {
                    switch (choice) {
                        case 1:
                        case 2:
                            productManage.disPlay();
                            break;
                        case 3:
                        case 4:
                            searchProduct();
                            break;
                        case 5:
                            salesCenter(productManage);
                            break;
                        case 6:
                            MenuCategory(categoryManage);
                            break;
                        case 7:
                            menuProduct(productManage);
                            break;
                    }
                }
            } while (choice != 0);
        }
        public void MenuCategory(CategoryManage categoryManage){
            int choice=0;
            do {
            System.out.println("1 : Add Category ");
            System.out.println("2 : Update Category ");
            System.out.println("3 : Display Category ");
            System.out.println("4 : Delete Category ");
                System.out.println("0 : exits !!!");
            System.out.println("Enter your choice !");
            try {
            choice =Integer.parseInt(scanner.nextLine());}
            catch (Exception e){
                System.out.println("What's your choice? Please re-enter !");
            }
            if (choice<0||choice>4){
                System.out.println("What's your choice? Please re-enter !");
            }else {
                switch (choice) {
                    case 1:
                        categoryManage.add();
                        break;
                    case 2:
                        categoryManage.upDate(productManage);
                        break;
                    case 3:
                        categoryManage.disPlay();
                        break;
                    case 4:
                        categoryManage.deleteCategory(productManage);
                        break;
                }
            }
        }while (choice != 0);
        }
        public void menuProduct(ProductManage productManage){
            int choice = 0;
            do {
                System.out.println("1 : Add product ");
                System.out.println("2 : Update product ");
                System.out.println("3 : Display product ");
                System.out.println("4 : Delete product ");
                System.out.println("0 : exits !!!");
                System.out.println("Enter your choice");
                try {
                choice =Integer.parseInt(scanner.nextLine());}
                catch (Exception e){
                    System.out.println("What's your choice? Please re-enter !");
                }
                if (choice<0|| choice>4){
                    System.out.println("What's your choice? Please re-enter !");
                }else {
                switch (choice){
                    case 1:productManage.add();break;
                    case 2:productManage.upDate();break;
                    case 3:productManage.disPlay();break;
                    case 4:productManage.delete();break;
                }}
            }while (choice != 0);
        }
        public void salesCenter(ProductManage productManage){
            int choice = 0;
            do {
                System.out.println("1 :warehouse product");
                System.out.println("2 Sell product");
                System.out.println("Enter a select");
                System.out.println("0 : exits!!!");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                }catch (Exception e){
                    System.out.println("What's your choice? Please re-enter !");
                }
                if (choice < 0 || choice > 2) {
                    System.out.println("What's your choice? Please re-enter !");
                } else {
                    switch (choice) {
                        case 1:
                            productManage.warehouseProduct();
                            break;
                        case 2:
                            productManage.sellProduct();
                            break;
                    }
                }
            }
                while (choice != 0) ;

}
public void searchProduct(){
            int choice=0;
            do {
                System.out.println("1 : Search Product by nameProduct");
                System.out.println("2 : search Product by price range");
                System.out.println("0 : Exits!!!!!!!!");
                System.out.println("Enter your choice");
                try {
                choice = Integer.parseInt(scanner.nextLine());}
                catch (Exception e){
                    System.out.println("What's your choice? Please re-enter !");
                }
                if (choice<0|| choice >2){
                    System.out.println("What's your choice? Please re-enter !");
                }else {
                    switch (choice) {
                        case 1:
                            productManage.searchByName();
                            break;
                        case 2:
                            productManage.searchByPrice();
                            break;
                    }
                }
            }while (choice != 0);
}
}

