package edu.csulb.android.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Lab1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Bundle myInput = this.getIntent().getExtras();
        TextView t=new TextView(this);
        t=(TextView)findViewById(R.id.textView2);
        t.setText("Hello " + (myInput.getString("uname")));
    }
}
