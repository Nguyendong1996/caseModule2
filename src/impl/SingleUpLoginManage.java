package impl;

import service.ReadAndWire;
import model.SingleUpLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SingleUpLoginManage extends ReadAndWire {

    Scanner scanner;
    List<SingleUpLogin> listSingleUpLogins;
   private final String file = "/Users/admin/IdeaProjects/CaseModule2/src/io/FileAccountAndPassWork";

    public SingleUpLoginManage() {
        scanner = new Scanner(System.in);
        listSingleUpLogins = new ArrayList<>();
    }
    public void Register() {
        String account;
        boolean flag2;
        listSingleUpLogins = read(file, listSingleUpLogins);
        do {
            flag2 = true;
            System.out.println("Enter a Account");
            account = scanner.nextLine();
            if (!listSingleUpLogins.isEmpty()) {
                for (model.SingleUpLogin listSingleUpLogin : listSingleUpLogins) {
                    if (account.equals(listSingleUpLogin.getAccount())) {
                        System.out.println("account already exist");
                        flag2 = false;
                    }
                }
            }
        } while (!flag2);
        String email;
        boolean flag;
        do {
            flag = true;
            System.out.println("Enter a Email");
            email = scanner.nextLine();
            boolean check = checkValidate(email, "^[\\w-_\\.]+@[\\w]+\\.+(com|vn)$");
            if (check) {
                if (!listSingleUpLogins.isEmpty()) {
                    for (model.SingleUpLogin listSingleUpLogin : listSingleUpLogins) {
                        if (email.equals(listSingleUpLogin.getEmail())) {
                            System.out.println("email already exist !");
                            flag = false;
                        }
                    }
                }
            } else {
                System.out.println("Please enter correct email format");
                flag = false;
            }
        }while (!flag);
        System.out.println("Enter a passWork");
        String passWork =scanner.nextLine();
        String enterThePassWork;
        boolean flag1;
        do {
            System.out.println("Enter the PassWork");
            enterThePassWork =scanner.nextLine();
            if (enterThePassWork.equals(passWork)){
                flag1 =true;
            }else {
                System.out.println("Enter the passWork does not match passWork . Please enter passWork !");
                flag1 = false;
            }
        }while (!flag1);
        model.SingleUpLogin singleUpLogin = new SingleUpLogin(account,passWork,email);
        listSingleUpLogins.add(singleUpLogin);
        write(file,listSingleUpLogins);
    }
    public boolean Login(){
        boolean checkFlag = false;
        listSingleUpLogins = read(file,listSingleUpLogins);
        String account;
        String passWork;
        int count=3;
        int count1=0;
        boolean flag = true;
        while (count1<count){
            System.out.println("Enter a account ");
            account = scanner.nextLine();
            System.out.println("Enter a passWork");
            passWork =scanner.nextLine();
            if (listSingleUpLogins.isEmpty()){
                System.out.println("account  does not exits ! please Register ");
            }else {
                flag= false;
                for (model.SingleUpLogin listSingleUpLogin : listSingleUpLogins) {
                    if (account.equals(listSingleUpLogin.getAccount()) & passWork.equals(listSingleUpLogin.getPassWork())) {
                        System.out.println("Login success !");
                        flag =true;
                        checkFlag =true;
                        break;
                    }
                }
            }
            if (!flag){
                System.out.println("account or passWork incorrect ! please re-enter.");
                count1++;
            }else {
                break;
            }

            if (count1 ==count){
                System.out.println("Login failed too many times. Please try again later");
            }
            }
//        }while (!flag);
        return checkFlag;
    }
    public void changePassword(){
        listSingleUpLogins =read(file,listSingleUpLogins);
        System.out.println("Enter a Account ");
        String account = scanner.nextLine();
        System.out.println("Enter a Email");
        String email = scanner.nextLine();
        boolean check = checkValidate(email,"^[\\w-_\\.]+@[\\w]+\\.+(com|vn)$");
        System.out.println("enter a  PassWord");
        String passWord = scanner.nextLine();
        boolean check1 = false;
        if (check){
            for (SingleUpLogin listSingleUpLogin : listSingleUpLogins) {
                if (listSingleUpLogin.getAccount().equals(account) && listSingleUpLogin.getEmail().equals(email) &&
                        listSingleUpLogin.getPassWork().equals(passWord)) {
                    System.out.println("Enter  new PassWord");
                    String newPassWord = scanner.nextLine();
                    System.out.println("Enter the passWord");
                    String newPassWord1 = scanner.nextLine();
                    if (newPassWord1.equals(newPassWord)) {
                        listSingleUpLogin.setPassWork(newPassWord);
                        check1 = true;
                        System.out.println("Change password successfully");
                    } else {
                        System.out.println("re-enter the new password is not the same");
                    }
                }
            }
            if (!check1){
                System.out.println("Incorrect account or password");
            }
        }else {
            System.out.println("Email is incorrect ! Please re-enter");
        }
        write(file,listSingleUpLogins);

    }
    public boolean loginAdmin(){
        System.out.println("Enter a account");
        String account = scanner.nextLine();
        System.out.println("Enter a passWord");
        String passWord = scanner.nextLine();
        if (account.equals("admin")&& passWord.equals("123456")){
            System.out.println("Login success !");
            return true;
        }else {
            System.out.println("account or passWork incorrect ! please re-enter.");
            return false;
        }
    }
}
