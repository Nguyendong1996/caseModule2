package impl;

import model.ProductSold;
import service.ReadAndWire;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ProductSoldManage extends ReadAndWire {
    Scanner scanner;
    private List<ProductSold> listProductSold;
    private final String fileProductSold = "/Users/admin/IdeaProjects/CaseModule2/src/io/FileProductSold";

    public ProductSoldManage() {
        this.scanner = new Scanner(System.in);
        this.listProductSold = read(fileProductSold,listProductSold);
    }
    public void add(String nameProduct, String priceProduct, String quantityProduct){
        String name = nameProduct;
        String price = priceProduct;
        String quantity = quantityProduct;
        LocalDateTime localDateTimes = LocalDateTime.now();
        ProductSold productSold = new ProductSold(name,price,quantity,localDateTimes);
        listProductSold.add(productSold);
        write(fileProductSold,listProductSold);
    }
    public List<ProductSold> getListProductSold(){
        return listProductSold;
    }
    public void searchByTime(){
        int total =0 ;
        boolean check = false;
        boolean check1 = false;
        boolean flag = false;
        String month;
        do {
            System.out.println("enter a month");
            month = scanner.nextLine();
            if (checkValidate(month,"^\\d{1,2}")){
                flag = true;
                if (Integer.parseInt(month)>12||Integer.parseInt(month)<1){
                    System.out.println("you entered the wrong month format");
                    flag =false;
                }
            }
        }while (!flag);
        String day;
        boolean flag1 = false ;
        do {
            System.out.println("enter a day");
            day = scanner.nextLine();
            if (checkValidate(day,"^\\d{1,2}")){
                flag1 = true;
                if (Integer.parseInt(day)>31||Integer.parseInt(day)<1){
                    System.out.println("you entered the wrong day format");
                    flag1 =false;
                }
            }
        }while (!flag1);
        String timeStar;
        boolean flag2 = false;
        do {
            System.out.println("enter time star");
            timeStar = scanner.nextLine();
            if (checkValidate(timeStar,"^\\d{1,2}")){
                flag2 = true;
                if (Integer.parseInt(timeStar)<0||Integer.parseInt(month)>24){
                    System.out.println("you entered the wrong month format");
                    flag2 =false;
                }
            }
        }while (!flag2);
        String timeAnd;
        boolean flag3 = false;
        do {
            System.out.println("enter time Date");
            timeAnd= scanner.nextLine();
            if (checkValidate(timeAnd,"^\\d{1,2}")){
                flag3 = true;
                if (Integer.parseInt(timeAnd)<Integer.parseInt(timeStar)||Integer.parseInt(month)>24){
                    System.out.println("you entered the wrong month format");
                    flag3 =false;
                }
            }
        }while (!flag3);
        for (ProductSold productSold : listProductSold) {
            if (Integer.parseInt(month) == productSold.getLocalDateTime().getMonthValue() && productSold.getLocalDateTime().getDayOfMonth() == Integer.parseInt(day)) {
                check = true;
                if (Integer.parseInt(timeStar) <= productSold.getLocalDateTime().getHour() && Integer.parseInt(timeAnd) >= productSold.getLocalDateTime().getHour()) {
                    System.out.println(productSold);
                    check1 = true;
                    total += (Integer.parseInt(productSold.getQuantity()) * Integer.parseInt(productSold.getPrice()));
                }
            }
        }
        if (!check){
            System.out.println(day +"/" +month + " The store doesn't sell any products");
        }else if(!check1){
            System.out.println(timeStar+"h /"+day+"/"+ month + " arrive "+ timeAnd +"h /"+day +"/"+month+ " The store doesn't sell any products");
        }
        System.out.println("total sales : " + total);
    }
    public void searchByMouth(){
        int total=0;
        boolean check = false;
        boolean flag = false;
        String monthStar;
        do {
            System.out.println("enter month star");
            monthStar = scanner.nextLine();
            if (checkValidate(monthStar,"^\\d{1,2}")){
                flag = true;
                if (Integer.parseInt(monthStar)>12||Integer.parseInt(monthStar)<1){
                    System.out.println("you entered the wrong month format");
                    flag =false;
                }
            }
        }while (!flag);
        boolean flag1 = false;
        String monthAnd;
        do {
            System.out.println("enter  month and");
            monthAnd = scanner.nextLine();
            if (checkValidate(monthAnd,"^\\d{1,2}")){
                flag1 = true;
                if (Integer.parseInt(monthAnd)<Integer.parseInt(monthStar)||Integer.parseInt(monthAnd)<1){
                    System.out.println("you entered the wrong month format");
                    flag1 =false;
                }
            }
        }while (!flag1);
        for (ProductSold productSold : listProductSold) {
            if (productSold.getLocalDateTime().getMonthValue() >= Integer.parseInt(monthStar) && productSold.getLocalDateTime().getMonthValue() <= Integer.parseInt(monthAnd)) {
                System.out.println(productSold);
                check = true;
                total += (Integer.parseInt(productSold.getQuantity()) * Integer.parseInt(productSold.getPrice()));
            }
        }
        if (!check){
            System.out.println(monthStar + " arrive "+ monthAnd+ " The store doesn't sell any products");
        }
        System.out.println("total sales : " + total);

    }
    public void searchByYear(){
        int total =0 ;
        boolean check = false;
        boolean flag;
        String year;
        do {
            System.out.println("enter a year");
            year = scanner.nextLine();
            if (checkValidate(year,"^\\d{4}")){
                flag = true;
                }else {
                flag =false;
            }
        }while (!flag);
        for (ProductSold productSold : listProductSold) {
            if (Integer.parseInt(year) == productSold.getLocalDateTime().getYear()) {
                System.out.println(productSold);
                check = true ;
                total += (Integer.parseInt(productSold.getQuantity()) * Integer.parseInt(productSold.getPrice()));
            }
        }
        if (!check){
            System.out.println("year : "+  year + "The store doesn't sell any products\"" );
        }
        System.out.println("total sales : " + total);
        }
}
