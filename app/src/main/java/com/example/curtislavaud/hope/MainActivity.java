package com.example.curtislavaud.hope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewResgister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this) ;
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password );
        mButtonLogin = (Button) findViewById(R.id.button_login);
       /* mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent (MainActivity.this, ProfileActivity.class);
                startActivity(loginIntent);
                Toast.makeText(MainActivity.this, "Login successful",Toast.LENGTH_SHORT).show();
            }
        });*/
        mTextViewResgister = (TextView) findViewById(R.id.textview_register);
        mTextViewResgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);

            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                boolean res = db.checkUser(user, pwd);
                if (res == true) {
                    Intent MoveToProfile = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(MoveToProfile);
                    Toast.makeText(MainActivity.this, "Login successful",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Log in fail, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
            });
    }
}




