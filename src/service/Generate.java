package service;

import impl.ProductManage;

public interface Generate<E> {
    void add();
    void upDate();
    void disPlay();
    void delete();
    E checkId();
}
