package com.hamdy.mvvm_mvp_mvc_databinding.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.hamdy.mvvm_mvp_mvc_databinding.model.NumberModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<Integer> result=new MutableLiveData<>();
    private NumberModel getData(){
        return new NumberModel(4,2);
    }
    public void getMultiply(){
        int x=getData().getFirstNum();
        int y=getData().getSecondNum();
        result.postValue(x*y);
    }
}
