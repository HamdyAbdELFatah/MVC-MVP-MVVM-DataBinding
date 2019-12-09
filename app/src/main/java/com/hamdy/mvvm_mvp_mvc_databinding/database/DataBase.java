package com.hamdy.mvvm_mvp_mvc_databinding.database;


import com.hamdy.mvvm_mvp_mvc_databinding.model.NumberModel;

public class DataBase {

    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}
