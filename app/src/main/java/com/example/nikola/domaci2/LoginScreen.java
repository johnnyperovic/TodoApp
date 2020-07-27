package com.example.nikola.domaci2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {
    EditText editName, editPasword;
    String name, password;
    public static final String SUCCESSFUL_USERNAME = "user";
    public static final String SUCCESSFUL_USERPASWORD = "qwerty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initValue();
        setupOnKeyListeners();
    }

    private void initValue()
    {
        editName = findViewById(R.id.userName);
        editPasword = findViewById(R.id.userPassword);
    }
    public void setupOnKeyListeners() {
        editName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                name = editName.getText().toString();
                password = editPasword.getText().toString();
                if (keyCode == event.KEYCODE_ENTER) {
                    login(name, password);
                }

                return false;
            }
        });
        editPasword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                name = editName.getText().toString();
                password = editPasword.getText().toString();
                if (keyCode == event.KEYCODE_ENTER) {
                    login(name, password);
                }
                return false;
            }
        });
    }

    public void login(String name, String password) {
        if (isEmpty(name)) {
            editName.setError("Username is empty");
            return;
        }
        if (isEmpty(password)) {
            editPasword.setError("Password is empty");
            return;
        }
        if (!name.equals(SUCCESSFUL_USERNAME)) {
            editName.setError("Username is incorrect");
            return;
        }
        if (!password.equals(SUCCESSFUL_USERPASWORD)) {
            editPasword.setError("Password is incorrect");
            return;
        }
        Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    boolean isEmpty(String text) {
        CharSequence ch = text;
        return TextUtils.isEmpty(ch);
    }

}
