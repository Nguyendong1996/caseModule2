package service;

public interface Generate<E> {
    void add();
    void update();
    void display();
    void delete();
    E checkId();
}
