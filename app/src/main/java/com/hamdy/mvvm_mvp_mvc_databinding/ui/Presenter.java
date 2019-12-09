package com.hamdy.mvvm_mvp_mvc_databinding.ui;


import com.hamdy.mvvm_mvp_mvc_databinding.model.NumberModel;

public class Presenter {
    public Presenter(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    private ViewInterface viewInterface;
    private NumberModel getData(){
        return new NumberModel(4,2);
    }
    public void getDivide(){
        double x=getData().getFirstNum();
        double y=getData().getSecondNum();
        viewInterface.getResult(x/y);
    }

}
