package impl;

import model.Buyer;
import model.Category;
import model.Product;
import service.Generate;
import service.ReadAndWire;
import java.util.List;
import java.util.Scanner;

public class ProductManage extends ReadAndWire implements Generate{
    public final String fileProduct = "/Users/admin/IdeaProjects/CaseModule2/src/io/FileProduct";
     Scanner scanner;
    private List<Product> products;
    private final CategoryManage categoryManage;
    BuyerManage buyerManage = new BuyerManage();
    public ProductManage(CategoryManage categoryManages) {
        scanner = new Scanner(System.in);
        this.categoryManage = categoryManages;
        products = read(fileProduct,products);
    }
    public List<Product> getProducts() {
        return products;
    }
    public Product getProduct(){
        setIndex();
        System.out.println("Enter a nameProduct");
        String nameProduct = scanner.nextLine();
        boolean flag;
        String price;
        do {
        System.out.println("Enter a price");
        price = scanner.nextLine();
        if (checkValidate(price,"^\\d{1,12}")){
            flag = true;
        }else {
            flag =false;
        }
        }
        while (!flag);
        boolean flag1;
        String quantity;
        do {
            System.out.println("Enter a quantity");
            quantity = scanner.nextLine();
            if (checkValidate(quantity,"^\\d{1,6}")){
                flag1 =true;
            }else {
                flag1= false;
            }
        }while (!flag1);
        System.out.println("Enter a color");
        String color = scanner.nextLine();
        categoryManage.display();
        List<Category> category = categoryManage.getCategories();
        System.out.println("Enter a Category");
        int index = 0;
        try {
            index = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            e.printStackTrace();
        }
        Category category1 = null;
        for (int i = 0; i < category.size(); i++) {
            if ((index-1)==i){
                category1 = category.get(index-1);
            }
        }
        return new Product(nameProduct,price,quantity,color,category1);
    }

    @Override
    public void add() {
            products.add(getProduct());
        write(fileProduct,products);
    }

    @Override
    public void update() {
        display();
        Product product = checkId();
        if (product != null){
            System.out.println("Enter new nameProduct");
            String nameProduct = scanner.nextLine();
            if (nameProduct.equals("")){
                product.setNameProduct(product.getNameProduct());
            }else {
            product.setNameProduct(nameProduct);}
            String price;
            boolean flag = false;
            do {
                System.out.println("Enter new price");
                price = scanner.nextLine();
                if (price.equals("")){
                    product.setPrice(product.getPrice());
                    flag = true;
                }else {
                    if (checkValidate(price, "^\\d{1,12}")){
                        product.setPrice(price);
                        flag = true;}
                    else {
                        System.out.println("Please enter correct");
                    }
                }
            }while (!flag);
            String quantity;
            boolean flag1;
            do {
                System.out.println("Enter new Quantity");
                quantity = scanner.nextLine();
                if (quantity.isEmpty()) {
                    product.setQuantity(product.getQuantity());
                    flag1 = true;
                }else{
                    flag1 = true;
                    if (checkValidate(quantity, "^\\d{1,5}")) {
                        product.setQuantity(quantity);
                    }else {
                        System.out.println("you entered wrong . Please re-enter");
                        flag1 = false;
                    }
                }
            }while (!flag1);
            System.out.println("Enter new color");
            String color = scanner.nextLine();
            if (!color.isEmpty()) {
                product.setColor(color);
            }
            System.out.println("Enter new category");
            categoryManage.display();
            Category category = categoryManage.checkId();
            if(category != null){
            product.setCategory(category);}
        }else {
            System.out.println("The id product is no on list");
        }
        write(fileProduct,products);
    }

    @Override
    public void display() {
        products =read(fileProduct,products);
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + " :" +products.get(i));
        }

    }
    @Override
    public void delete() {
        display();
        Product product = checkId();
        if (product != null){
            products.remove(product);
        }else {
            System.out.println("The id product is no on list");
        }
        write(fileProduct,products);

    }

    @Override
    public Product checkId() {
        System.out.println("Enter your choice ");
        int id =0 ;
        try {
            id = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("choosing the wrong");
        }

        for (int i = 0; i < products.size(); i++) {
            if ((id-1)==i){
                return products.get((id-1));
            }
        }
        return null;
    }
    public void searchByName(){
        boolean check =false;
        System.out.println("Enter the name of the product you want to search");
        String search = scanner.nextLine();
        for (Product product : products) {
            if (product.getNameProduct().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(product);
                check = true;
            }
        }if (!check){
            System.out.println("Not exist product have name contains this word!");
        }
    }
    public void searchByPrice(){
        System.out.println("Enter a price products Min!");
        String priceMin = scanner.nextLine();
        System.out.println("Enter a price products Max!");
        String priceMax = scanner.nextLine();
        if (Integer.parseInt(priceMin)<Integer.parseInt(priceMax)){
            for (Product product : products) {
                if (Integer.parseInt(product.getPrice()) >= Integer.parseInt(priceMin) &
                        Integer.parseInt(product.getPrice()) <= Integer.parseInt(priceMax)) {
                    System.out.println(product);
                }
            }
        }else {
            System.out.println("Price min and price max Invalid input ! please retype");
        }
    }
    public void warehouseProduct(){
        display();
        System.out.println("Choice product need more quantity");
        int choice = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < products.size(); i++) {
            if((choice-1)== i){
                System.out.println("name Product :"+ products.get(choice-1).getNameProduct() + "   Quantity : "+ products.get(choice-1).getQuantity());
                System.out.println("Enter quantity need more !!");
                String quantity = scanner.nextLine();
                int quantity1 =Integer.parseInt(quantity)+ Integer.parseInt(products.get(choice-1).getQuantity());
                products.get(choice-1).setQuantity(String.valueOf(quantity1));
                System.out.println("more success");
        }
    }write(fileProduct,products);
    }
    public void sellProduct(ProductSoldManage productSoldManage){
        display();
        System.out.println("choice product need sell");
        int choice = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < products.size(); i++) {
            if ((choice-1)==i){
                System.out.println("Enter quantity need sell");
                String quantity = scanner.nextLine();
                int quantity1 = Integer.parseInt(products.get(choice-1).getQuantity()) - Integer.parseInt(quantity);
                products.get(choice-1).setQuantity(String.valueOf(quantity1));
                int total = Integer.parseInt(quantity)*Integer.parseInt(products.get(choice-1).getPrice());
                System.out.println("Order :" + products.get(choice-1).getNameProduct());
                System.out.println("Quantity : "+ quantity);
                System.out.println("Total money : " + total);
                productSoldManage.add(products.get(choice-1).getNameProduct(),products.get(choice-1).getPrice(),quantity);

            }
        }
        write(fileProduct,products);
    }
    public void inventoryByCategory(){
        int total;
        for (int i = 0; i < categoryManage.getCategories().size(); i++) {
            total =0;
            for (int j = 0; j < products.size(); j++) {
                if (categoryManage.getCategories().get(i).getNameCategory().equals(products.get(j).getCategory().getNameCategory())){
                    total += Integer.parseInt(products.get(j).getQuantity());
                }
            }
            System.out.println((i+1)+" :" +categoryManage.getCategories().get(i).getNameCategory() + " Quantity :" + total);
        }
    }
    public void displayProductWithSmallerQuantityByQuantityInput(){
        System.out.println("Enter the quantity");
        String quantity = scanner.nextLine();
        boolean check = categoryManage.checkValidate(quantity,"^\\d{1,6}");
        if (check){
            for (Product product : products) {
                if (Integer.parseInt(quantity) >= Integer.parseInt(product.getQuantity())) {
                    System.out.println(product);
                }
            }
        }else {
            System.out.println("you entered it wrong, please re-enter it");
        }
    }
    public void totalMoneyAmount(){
        int total =0 ;
        for (Product product : products) {
            total += Integer.parseInt(product.getPrice()) * Integer.parseInt(product.getQuantity());
        }
        String string = String.valueOf(total);
        System.out.println("Total money amount : " + string + " Vnd");
    }
    public void salesHistoryByDay(ProductSoldManage productSoldManage){
        int total=0;
        String month;
        boolean flag = false;
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
        String dayStart;
        boolean flag1 = false ;
        do {
            System.out.println("enter day star");
            dayStart = scanner.nextLine();
            if (checkValidate(dayStart,"^\\d{1,2}")){
                flag1 = true;
                if (Integer.parseInt(dayStart)>31||Integer.parseInt(dayStart)<1){
                    System.out.println("you entered the wrong day format");
                    flag1 =false;
                }
            }
        }while (!flag1);
        String dayAnd;
        boolean flag2 = false ;
        do {
            System.out.println("enter day And");
            dayAnd = scanner.nextLine();
            if (checkValidate(dayAnd,"^\\d{1,2}")){
                flag2 = true;
                if (Integer.parseInt(dayAnd)<Integer.parseInt(dayStart)||Integer.parseInt(dayAnd)<1){
                    System.out.println("you entered the wrong day format");
                    flag2 =false;
                }
            }
        }while (!flag2);
        boolean check = false;
        boolean check1 = false;
        for (int i = 0; i < productSoldManage.getListProductSold().size(); i++) {
            if (Integer.parseInt(month) == productSoldManage.getListProductSold().get(i).getLocalDateTime().getMonthValue()){
                check = true;
            if (Integer.parseInt(dayStart)<=productSoldManage.getListProductSold().get(i).getLocalDateTime().getDayOfMonth()&&
            Integer.parseInt(dayAnd)>=productSoldManage.getListProductSold().get(i).getLocalDateTime().getDayOfMonth()){
                check1 = true;
                System.out.println(productSoldManage.getListProductSold().get(i));
                total += (Integer.parseInt(productSoldManage.getListProductSold().get(i).getQuantity())*Integer.parseInt(productSoldManage.getListProductSold().get(i).getPrice()));
            }
        }
        }
        if (!check){
            System.out.println("month " + month +" : The store doesn't sell any products");
        }else {
        if (!check1){
            System.out.println("from " + dayStart + " arrive " + dayAnd + "The store doesn't sell any products" );
        }}
        System.out.println("total sales : " + total);
    }
    public void oder(){
        display();
        System.out.println("Enter your choice");
        int choice=0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("What's your choice? Please re-enter !");
        }
        if(1>choice||choice>products.size()){
            System.out.println("What's your choice? Please re-enter !");
        }else {
        for (int i = 0; i < products.size(); i++) {
            if ((choice-1)==i){
                buyerManage.purchase(products.get(choice-1).getNameProduct(),products.get(choice-1).getPrice(),products,(choice-1));
            }
        }
        System.out.println("Order Success");
    }
    }
    public void singleCheck(){
        for (int i = 0; i < buyerManage.getBuyerList().size(); i++) {
            System.out.println((i+1) +" :" +buyerManage.getBuyerList().get(i));
        }
    }
    public void orderConfirmation(ProductSoldManage productSoldManage){
        int choice = 0;
        singleCheck();
        System.out.println("select the order to confirm");
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("What's your choice? Please re-enter !");
        }
        int total =0 ;
        for (int i = 0; i < buyerManage.getBuyerList().size(); i++) {
            if ((choice-1)== i){
                for (Product product : products) {
                    if (product.getNameProduct().equals(buyerManage.getBuyerList().get(i).getNameProduct())) {
                        total = Integer.parseInt(product.getQuantity()) - Integer.parseInt(buyerManage.getBuyerList().get(i).getQuantity());
                        product.setQuantity(String.valueOf(total));
                        productSoldManage.add(product.getNameProduct(),product.getPrice(),buyerManage.getBuyerList().get(i).getQuantity());
                    }
                }
                buyerManage.getBuyerList().remove((choice-1));
            }

        }
        write(fileProduct,products);
        write("/Users/admin/IdeaProjects/CaseModule2/src/io/FileBuyer",buyerManage.getBuyerList());
    }
    private void setIndex() {
        if (!products.isEmpty()) {
            int index = products.get(0).getId();
            for (Product category : products) {
                if (category.getId() > index) {
                    index = category.getId();
                }
            }
            Product.INDEX = index;
        } else {
            Product.INDEX = 0;
        }
    }
}
