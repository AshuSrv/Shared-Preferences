package com.journaldev.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    SharedPreferences sharedpreferences;
    EditText name;
    EditText email;
    public static final String mypreference = "dataBaseName";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);



        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, "Null"));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, "Null"));

        }




    }

    public void Save(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();
    }

    public void clear(View view) {
        name.setText("");
        email.setText("");

    }

    public void Get(View view) {


        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, "Null"));//agar koi or key se daalunga tab null milega lekin is app mai sirf ye Name wali key se hi le rha h/
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, "Null"));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
