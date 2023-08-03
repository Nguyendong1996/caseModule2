package impl;

import model.Category;
import service.Generate;
import service.ReadAndWire;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CategoryManage extends ReadAndWire implements Generate{
    Scanner scanner;
    private List<Category> categories;
    private final String fileCategory = "/Users/admin/IdeaProjects/CaseModule2/src/io/FileCategory";

    public CategoryManage() {
        this.scanner = new Scanner(System.in);
        categories = read(fileCategory,categories);
    }
    public List<Category> getCategories(){
        return categories ;
    }
    private Category getCategory(){
        System.out.println("Input nameCategory !");
       String nameCategory = scanner.nextLine();
       return new Category(nameCategory);
    }

    @Override
    public void add() {
        categories.add(getCategory());
        write(fileCategory,categories);
    }

    @Override
    public void upDate(){}
    public void upDate(ProductManage productManage) {
        disPlay();
        System.out.println("Enter a Category");
        int index =Integer.parseInt(scanner.nextLine());
        if (index<0||index>categories.size()){
            System.out.println("did you choose the wrong category? . please reselect !!");
        }{
            for (int i = 0; i < categories.size(); i++) {
                if ((index-1)==i){
                    System.out.println("Enter a new Category");
                    String name = scanner.nextLine();
                    if(name.equals("")){
                        categories.get(index-1).setNameCategory(categories.get(index-1).getNameCategory());
                    }else {
                    for (int j = 0; j < productManage.getProducts().size(); j++) {
                        if (productManage.getProducts().get(j).getCategory().getNameCategory().equals(categories.get(i).getNameCategory())){
                            productManage.getProducts().get(j).getCategory().setNameCategory(name);
                        }
                    }
                    categories.get(index-1).setNameCategory(name);
                }
                    }
            }
        }
        write(fileCategory,categories);
        write("/Users/admin/IdeaProjects/CaseModule2/src/io/FileProduct",productManage.getProducts());
    }

    @Override
    public void disPlay() {
        categories =read(fileCategory,categories);
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i+1) + " :"+categories.get(i) );
        }
    }

    @Override
    public void delete(){};
    public void deleteCategory(ProductManage productManage) {
        disPlay();
        System.out.println("input Category delete");
        int input =0;
        try {
        input = Integer.parseInt(scanner.nextLine());}
        catch (Exception e){
            e.printStackTrace();
        }
        if (!categories.isEmpty()){
        for (int i = 0; i < categories.size(); i++) {
            if ((input - 1) == i) {
                for (int j = 0; j < productManage.getProducts().size(); j++) {
                    if(productManage.getProducts().get(j).getCategory().getNameCategory().equals(categories.get(input-1).getNameCategory())){
                        productManage.getProducts().remove(j);
                }
            }
                categories.remove((input - 1));
        }
        }
        }else {
            System.out.println("No have Category!!!!!! ");
        }
        write(fileCategory,categories);
        write("/Users/admin/IdeaProjects/CaseModule2/src/io/FileProduct",productManage.getProducts());
    }
    @Override
    public Category checkId() {
        System.out.println("input Category by update");
        int index=0;
        try {index = Integer.parseInt(scanner.nextLine());}
        catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < categories.size(); i++) {
            if ((index-1)== i){
                return categories.get(i);
            }
        }

        return null;
    }
}
