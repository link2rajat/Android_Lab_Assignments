package edu.csulb.android.lab2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetName extends Activity implements android.view.View.OnClickListener

{
    android.widget.EditText name;
    android.widget.Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);
        name = (EditText) this.findViewById(R.id.editText1);
        button = (Button) this.findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent myIntent = new Intent(this,Lab1Activity.class);
        Log.i("text",name.getText().toString());
        myIntent.putExtra("uname",name.getText().toString());
        this.startActivity(myIntent);

    }
}
