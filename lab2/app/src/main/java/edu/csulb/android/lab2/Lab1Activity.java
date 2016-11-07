package edu.csulb.android.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Lab1Activity extends AppCompatActivity {
    android.widget.TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        t = (TextView) this.findViewById(R.id.textView2);
        Bundle myInput = this.getIntent().getExtras();
        t.setText("Hello "+(myInput.getString("uname")));

    }
}
