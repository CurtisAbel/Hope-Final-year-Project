package com.example.curtislavaud.hope;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextAgentFootballer;
    EditText mTextPassword;
    EditText getTextcnfPassword;
    Button mButtonregister;
    TextView mTextViewLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password );
        getTextcnfPassword = (EditText)findViewById(R.id.edittext_cnf_password );
        mButtonregister = (Button) findViewById(R.id.button_register);
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent (RegisterActivity.this, MainActivity.class);
                startActivity(LoginIntent);
            }
        });
        mButtonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextUsername.getText().toString().trim();

                if(pwd.equals(cnf_pwd) ){
                    long val = db.addUser(user, pwd);
                    if(val> 0){
                        Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_LONG).show();
                        Intent MoveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(MoveToLogin);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Registration error, please try again", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


