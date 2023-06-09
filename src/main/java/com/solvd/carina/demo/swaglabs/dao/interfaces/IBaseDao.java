package com.solvd.carina.demo.swaglabs.dao.interfaces;

public interface IBaseDao <T>{
    T getEntityById(Integer id);
}
