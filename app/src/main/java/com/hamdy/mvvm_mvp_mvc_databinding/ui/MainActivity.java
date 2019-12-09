package com.hamdy.mvvm_mvp_mvc_databinding.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.hamdy.mvvm_mvp_mvc_databinding.R;
import com.hamdy.mvvm_mvp_mvc_databinding.databinding.ActivityMainBinding;
import com.hamdy.mvvm_mvp_mvc_databinding.model.NumberModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    NumberModel numberModel;
    ActivityMainBinding binding;
    Presenter presenter;
    MyViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.plusButton.setOnClickListener(this);
        binding.divButton.setOnClickListener(this);
        binding.mulButton.setOnClickListener(this);
        numberModel=new NumberModel(4,2);
        presenter=new Presenter(new ViewInterface() {
            @Override
            public void getResult(double x) {
                binding.divResultTextView.setText(x+"");
            }
        });
        model= ViewModelProviders.of(this).get(MyViewModel.class);
        model.result.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.mulResultTextView.setText(integer+"");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.plus_button:
                binding.plusResultTextView.setText(String.valueOf(numberModel.getFirstNum()+numberModel.getSecondNum()));
                break;
            case R.id.div_button:
                presenter.getDivide();
                break;
            case R.id.mul_button:
                model.getMultiply();
        }
    }
}
