package com.example.rajatrathi.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    int request_Code =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view)
    {
        startActivity(new Intent("com.example.rajatrathi.intentdemo.SecondActivity"));

    }
//callback functionality to get results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    if(requestCode == request_Code){
        if(resultCode == RESULT_OK)
        {
            Toast.makeText(this,data.getData().toString(),Toast.LENGTH_SHORT).show();
        }

    }

    }
}
