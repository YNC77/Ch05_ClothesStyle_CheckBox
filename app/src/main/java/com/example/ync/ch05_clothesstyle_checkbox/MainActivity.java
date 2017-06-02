package com.example.ync.ch05_clothesstyle_checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
                        implements CompoundButton.OnCheckedChangeListener{

    ArrayList<CompoundButton> selected = new ArrayList<>(); //把已選取的選項存在陣列LIST
    ArrayList<CompoundButton> unselected = new ArrayList<>(); //未選擇

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] chk_id = {R.id.style1, R.id.style2, R.id.style3, R.id.style4, R.id.style5, R.id.style6,
                R.id.style7, R.id.style8, R.id.style9}; //CheckBox全部的ID
        for(int id: chk_id){
            CheckBox chkBtn = (CheckBox) findViewById(id);
            unselected.add(chkBtn); //未選取的部分先全數存入
            chkBtn.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            selected.add(buttonView);
            unselected.remove(buttonView);
        } else {
            selected.remove(buttonView);
            unselected.add(buttonView);
        }
    }

    public void show(View v) {
        String msg="" , umsg = "";

        for(CompoundButton chk: selected) {
            msg = msg+chk.getText()+"\t";
        }
        for(CompoundButton unChk: unselected){
            umsg = umsg +"\n"+unChk.getText()+"\t";
        }
        if(msg.length()>0)
            msg = "You usually wear "+msg+"style.\n"+"You should try"+umsg+"style.";
        else
            msg = "Please Choose!";

        //msg
        ((TextView)findViewById(R.id.showAns)).setText(msg);

    }
}
