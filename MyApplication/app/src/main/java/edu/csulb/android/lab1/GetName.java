package edu.csulb.android.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Rajat Rathi on 17-09-2016.
 */
public class GetName extends Activity implements android.view.View.OnClickListener
{
android.widget.EditText name;
android.widget.Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.name_getter);

        name =(EditText) this.findViewById(R.id.editText1);
        button =(Button)this.findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Intent myIntent = new Intent(this,Lab1Activity.class);
        myIntent.putExtra("uname",name.getText().toString());
    }
}
