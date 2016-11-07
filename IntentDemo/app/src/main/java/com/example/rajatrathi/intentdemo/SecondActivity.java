package com.example.rajatrathi.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClick(View view)
    {
        Intent data = new Intent();
        EditText text_username =(EditText) findViewById(R.id.editext2);

        data.setData(Uri.parse(text_username.getText().toString()));
        setResult(RESULT_OK,data);

        finish();

    }
}
