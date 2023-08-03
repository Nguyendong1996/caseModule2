package service;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ReadAndWire {
    Pattern pattern;
    Matcher matcher;
    public <E> List<E> read(String linkFile, List<E> obj){
        File file = new File(linkFile);
        try {

            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            obj = (List<E>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return obj;
    }
    public <E> void write(String newFile , List<E> obj){
        File file = new File(newFile);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(obj);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public boolean checkValidate(String regex,String Email_Regex){
        pattern = Pattern.compile(Email_Regex);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
