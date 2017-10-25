package com.palvision.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView show;
    EditText uname,pword;
    Button save,showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

    }

    public void findView() {
        show = (TextView) findViewById(R.id.show);
        uname = (EditText) findViewById(R.id.username);
        pword = (EditText) findViewById(R.id.passwords);
        save = (Button) findViewById(R.id.save);
        showText = (Button) findViewById(R.id.showtext);
    }

    public void saveInfo(View view) {
        SharedPreferences sharedPer = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor  = sharedPer.edit();

        editor.putString("username",uname.getText().toString());
        editor.putString("password",pword.getText().toString());

        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void displayData(View view) {
        SharedPreferences sharedPer = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String userName = sharedPer.getString("username","");
        String password = sharedPer.getString("password","");

        show.setText("User Name " + userName + " Password " + password );
    }
}
