package impl;

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
        categoryManage.disPlay();
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
    public void upDate() {
        disPlay();
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
                if (checkValidate(quantity,"^\\d{1,5}")){
                    product.setQuantity(quantity);
                    flag1 = true;
                }else {
                    flag1 = false;
                }
            }while (!flag1);
            System.out.println("Enter new color");
            String color = scanner.nextLine();
            product.setColor(color);
            System.out.println("Enter new category");
            categoryManage.disPlay();
            Category category = categoryManage.checkId();
            product.setCategory(category);
        }else {
            System.out.println("The id product is no on list");
        }
        write(fileProduct,products);
    }

    @Override
    public void disPlay() {
        products =read(fileProduct,products);
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + " :" +products.get(i));
        }

    }
    @Override
    public void delete() {
        disPlay();
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
        System.out.println("Enter id Product ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
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
        disPlay();
        System.out.println("Choice product need more quantity");
        int choice = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < products.size(); i++) {
            if((choice-1)== i){
                System.out.println("name Product :"+ products.get(choice-1).getNameProduct() + "   Quantity : "+ products.get(choice-1).getQuantity());
                System.out.println("Enter quantity need more !!");
                String quantity = scanner.nextLine();
                int quantity1 =Integer.parseInt(quantity)+ Integer.parseInt(products.get(choice-1).getQuantity());
                products.get(choice-1).setQuantity(String.valueOf(quantity1));
        }
    }write(fileProduct,products);
    }
    public void sellProduct(){
        disPlay();
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
            }
        }
        write(fileProduct,products);
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
