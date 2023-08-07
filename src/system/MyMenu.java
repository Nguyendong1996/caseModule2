package system;

import impl.*;

import java.util.Scanner;

public class MyMenu {
    Scanner scanner;
    CategoryManage categoryManage = new CategoryManage();
    ProductManage productManage = new ProductManage(categoryManage);
    ProductSoldManage productSoldManage = new ProductSoldManage();
    public MyMenu() {
        this.scanner = new Scanner(System.in);
}public void menu(SingleUpLoginManage singleUpLoginManage
                  ) {
        int choice = 0;
        boolean flag;
        do {
            System.out.println("-----------------------------");
            System.out.println("Menu");
            System.out.println("1 : customer role");
            System.out.println("2 :Log in as the owner");
            System.out.println("Enter your choice ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                flag = true;
            } catch (Exception e) {
                System.out.println("What's your choice? Please re-enter !");
                flag = false;
            }
            if (choice < 0 || choice > 3) {
                System.out.println("What's your choice? Please re-enter !");
            } else {
                switch (choice) {
                    case 1:
                        menuCustomer();
                        break;
                    case 2:menuLogin(singleUpLoginManage);break;
                }
            }
        } while (choice != 0 || !flag ) ;
        }
        public void menuCustomer(){
        int choice =0 ;
        boolean flag;
        do {
            System.out.println("----------------------");
            System.out.println("Menu");
            System.out.println("1 :display Product !");
            System.out.println("2 : Search Product");
            System.out.println("3 : oder");
            System.out.println("0 : exits !!!!");
            System.out.println("Enter your choice");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                flag = true;
            }catch (Exception e){
                System.out.println("What's your choice? Please re-enter !");
                flag =false;
            }
            if (choice<0|| choice>3){
                System.out.println("What's your choice? Please re-enter !");
            }else {
                switch (choice){
                    case 1:productManage.display();break;
                    case 2:searchProduct();break;
                    case 3:productManage.oder(); break;
                }
            }
        }while (choice !=0|| !flag);
        }
        public void menuLogin(SingleUpLoginManage singleUpLoginManage){
        int choice =0 ;
        boolean flag;
        do {
            System.out.println("---------------------------------");
            System.out.println("Menu");
            System.out.println("1 : Login with the position of staff");
            System.out.println("2 : Login with the position of store owner");
            System.out.println("3 : change Password");
            System.out.println("0: exits");
            System.out.println("Enter your choice");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                flag =true;
            }catch (Exception e){
                System.out.println("What's your choice? Please re-enter !");
                flag =false;
            }
            if (choice<0||choice>3){
                System.out.println("What's your choice? Please re-enter !");
            }else {
                switch (choice){
                    case 1:{
                        boolean check = singleUpLoginManage.loginAdmin();
                        if (check){
                            menuStaff();
                        }else {
                            System.out.println("tk mk sai");
                        }
                    }break;
                    case 2:{
                        boolean check = singleUpLoginManage.Login();
                        if (check) {
                            menuManage(singleUpLoginManage);
                            break;
                        } else {
                            System.out.println("Username or password incorrect . please try again or subscribe!");
                        }
                    }break;
                    case 3 : singleUpLoginManage.changePassword();break;
                }
            }
            }while (choice !=0|| !flag);
        }
        public void menuStaff(){
        int choice =0 ;
        boolean flag;
        do {
            System.out.println("---------------------");
            System.out.println("Menu");
            System.out.println("1 : display Product ");
            System.out.println("2 : Sales Center  ");
            System.out.println("3 : search sales");
            System.out.println("4 : single check and order confirmation");
            System.out.println("0 : Exits !");
            System.out.println("Enter your choice");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                flag = true;
            } catch (Exception e) {
                System.out.println("What's your choice? Please re-enter !");
                flag = false ;
            }
            if (choice < 0 || choice > 4) {
                System.out.println("What's your choice? Please re-enter !");
            } else {
                switch (choice) {
                    case 1:productManage.display();break;
                    case 2:productManage.sellProduct(productSoldManage);break;
                    case 3:searchTotalSales(); break;
                    case 4:menuCheck();break;
                }
            }
        }
                while (choice != 0 ||!flag) ;

            }
            public void menuCheck(){
                int choice =0 ;
                boolean flag;
                do {
                    System.out.println("---------------------");
                    System.out.println("Menu");
                    System.out.println("1 : single check ");
                    System.out.println("2 : order confirmation  ");
                    System.out.println("0 : Exits !!!!");
                    System.out.println("Enter your choice");
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        flag =true;
                    } catch (Exception e) {
                        System.out.println("What's your choice? Please re-enter !");
                        flag =false;
                    }
                    if (choice < 0 || choice > 2) {
                        System.out.println("What's your choice? Please re-enter !");
                    } else {
                        switch (choice) {
                            case 1:productManage.singleCheck();break;
                            case 2:productManage.orderConfirmation(productSoldManage);break;
            }
                    }
                }while (choice != 0 ||!flag);
    }
            public void searchTotalSales(){
                int choice =0 ;
                boolean flag;
                do {
                    System.out.println("---------------------");
                    System.out.println("Menu");
                    System.out.println("1 : search by time");
                    System.out.println("2 : search by day ");
                    System.out.println("3 : search by month  ");
                    System.out.println("4 : search by year");
                    System.out.println("0 : Exits !!");
                    System.out.println("Enter your choice");
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("What's your choice? Please re-enter !");
                        flag = false;
                    }
                    if (choice < 0 || choice > 4) {
                        System.out.println("What's your choice? Please re-enter !");
                    } else {
                        switch (choice) {
                            case 1:productSoldManage.searchByTime();break;
                            case 2:productManage.salesHistoryByDay(productSoldManage);break;
                            case 3:productSoldManage.searchByMouth();break;
                            case 4:productSoldManage.searchByYear();break;
                        }
                    }
                }
                while (choice != 0 || !flag) ;

            }
            public void menuManage(SingleUpLoginManage singleUpLoginManage) {
        boolean flag;
                int choice = 0;
                do {

                    System.out.println("1 : warehouse ");
                    System.out.println("2 : Sales Center  ");
                    System.out.println("3 : home Category ");
                    System.out.println("4 : home Product ");
                    System.out.println("5 : Register more account store owner ");
                    System.out.println("0 : Exits !!!");
                    System.out.println("Enter your choice");
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("What's your choice? Please re-enter !");
                        flag = false;
                    }
                    if (choice < 0 || choice > 5) {
                        System.out.println("What's your choice? Please re-enter !");
                    } else {
                        switch (choice) {
                            case 1:menuWarehouse();break;
                            case 2:productManage.warehouseProduct();break;
                            case 3:menuCategory(categoryManage);break;
                            case 4:menuProduct(productManage);break;
                            case 5: singleUpLoginManage.Register();break;
                        }
                    }

                } while (choice != 0 || !flag);
            }
    public void menuCategory(CategoryManage categoryManage){
        int choice=0;
        boolean flag;
        do {
            System.out.println("1 : Add Category ");
            System.out.println("2 : Update Category ");
            System.out.println("3 : Display Category ");
            System.out.println("4 : Delete Category ");
            System.out.println("0 : exits !!!");
            System.out.println("Enter your choice !");
            try {
                choice =Integer.parseInt(scanner.nextLine());
            flag = true;}
            catch (Exception e){
                System.out.println("What's your choice? Please re-enter !");
                flag = false;
            }
            if (choice < 0||choice > 4){
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
                        categoryManage.display();
                        break;
                    case 4:
                        categoryManage.deleteCategory(productManage);
                        break;
                }
            }
        }while (choice != 0 || !flag );
    }
    public void menuProduct(ProductManage productManage){
        int choice = 0;
        boolean flag;
        do {
            System.out.println("1 : Add product ");
            System.out.println("2 : Update product ");
            System.out.println("3 : Display product ");
            System.out.println("4 : Delete product ");
            System.out.println("0 : exits !!!");
            System.out.println("Enter your choice");
            try {
                choice =Integer.parseInt(scanner.nextLine());
            flag =true;}
            catch (Exception e){
                System.out.println("What's your choice? Please re-enter !");
                flag =false;
            }
            if (choice<0|| choice>4){
                System.out.println("What's your choice? Please re-enter !");
            }else {
                switch (choice){
                    case 1:productManage.add();break;
                    case 2:productManage.update();break;
                    case 3:productManage.display();break;
                    case 4:productManage.delete();break;
                }}
        }while (choice != 0||!flag);
    }
    public void menuWarehouse(){
        int choice = 0;
        boolean flag;
        do {
            System.out.println("--------------------------------------------");
            System.out.println("Menu");
            System.out.println("1 : inventory  by category");
            System.out.println("2 : display product with smaller quantity by quantity input");
            System.out.println("3 :  total money amount");
            System.out.println("0 : Exits !!!");
            System.out.println("Enter your choice ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                flag = true;
            }catch (Exception e){
                System.out.println("What's your choice? Please re-enter !");
                flag = false ;
            }
            if (choice<0|| choice>3){
                System.out.println("What's your choice? Please re-enter !");
            }else {
                switch (choice){
                    case 1:productManage.inventoryByCategory();break;
                    case 2:productManage.displayProductWithSmallerQuantityByQuantityInput();break;
                    case 3:productManage.totalMoneyAmount();break;
                }
            }
        }while (choice != 0 ||!flag);
    }
    public void searchProduct(){
        int choice=0;
        boolean flag ;
        do {
            System.out.println("1 : Search Product by nameProduct");
            System.out.println("2 : search Product by price range");
            System.out.println("3 : Display Product min to max prices");
            System.out.println("4 : Display Product max to min prices");
            System.out.println("0 : Exits!!!!!!!!");
            System.out.println("Enter your choice");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            flag =true;}
            catch (Exception e){
                System.out.println("What's your choice? Please re-enter !");
                flag =false;
            }
            if (choice<0|| choice >4){
                System.out.println("What's your choice? Please re-enter !");
            }else {
                switch (choice) {
                    case 1:
                        productManage.searchByName();
                        break;
                    case 2:
                        productManage.searchByPrice();
                        break;
                    case 3: productManage.displayMinMax();
                    break;
                    case 4: productManage.displayMaxMin();
                    break;
                }
            }
        }while (choice != 0||!flag);
    }
}
