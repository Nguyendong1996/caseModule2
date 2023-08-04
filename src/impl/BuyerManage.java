package impl;

import model.Address;
import model.Buyer;
import model.Product;
import service.ReadAndWire;
import java.util.List;
import java.util.Scanner;

public class BuyerManage extends ReadAndWire {
    Scanner scanner = new Scanner(System.in);
   private List<Buyer> buyerList ;
    private final String fileBuyer ="/Users/admin/IdeaProjects/CaseModule2/src/io/FileBuyer";

    public BuyerManage() {
        buyerList = read(fileBuyer,buyerList);
    }
    public List<Buyer> getBuyerList(){
        return buyerList;
    }
    public void purchase(String nameProduct, String price, List<Product> productManages, int i){
        System.out.println("Enter a fullName");
        String name  = scanner.nextLine();
        String numberPhone ;
        boolean flag1 = false;
        do {
            System.out.println("Enter a numberPhone");
            numberPhone = scanner.nextLine();
            if (checkValidate(numberPhone,"^[03|09|08|+843|+848|+849]{2,4}\\d{8}$")){
                flag1 = true;
            }
        }while (!flag1);
        System.out.println("Enter a city");
        String city = scanner.nextLine();
        System.out.println("Enter a District");
        String district = scanner.nextLine();
        System.out.println("Enter a ward");
        String ward = scanner.nextLine();
        System.out.println("Enter a detail");
        String detail = scanner.nextLine();
        boolean flag = false;
        String quantity;
        do {
        System.out.println("Enter a Quantity ");
        quantity = scanner.nextLine();
        if (checkValidate(quantity,"^\\d{1,6}")){
            flag =true;
            if (Integer.parseInt(quantity)>Integer.parseInt(productManages.get(i).getQuantity())){
                System.out.println("inventory quantity is not enough");
                flag =false;
            }
        }
        }while (!flag);
        Address address = new Address(city,district,ward,detail);
        Buyer buyer = new Buyer(name,numberPhone,address,nameProduct,quantity,price);
        buyerList.add(buyer);
        write(fileBuyer,buyerList);
    }
}
