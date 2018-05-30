package com.example.nikola.domaci2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editName,editPasword;
String name,password,username,userpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=findViewById(R.id.editText);
        editPasword=findViewById(R.id.editText2);
        username="1";//gdgpodgorica
        userpassword="1";//anddev
   poz();
    }
public void poz()
{

    editName.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            //
            name=editName.getText().toString();
            password=editPasword.getText().toString();
            if(keyCode == event.KEYCODE_ENTER){
                loginMethod(name,password);
            }

            return false;
        }
    });
    editPasword.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            name=editName.getText().toString();
            password=editPasword.getText().toString();
            if(keyCode == event.KEYCODE_ENTER){

                loginMethod(name,password);
            }
            return false;
        }
    });
}
    public void loginMethod(String name, String password)
    {
        if(isEmpty(name))
        {
            editName.setError("Username is empty");
        }
        if(isEmpty(password))
        {
            editPasword.setError("Password is empty");
        }
        if(name.equals(username) && password.equals(userpassword))
        {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        if(!name.equals(username)&& name.length()>0) {
editName.setError("Username is incorrect");
        }
        if(!password.equals(userpassword) && password.length()>0) {
            editPasword.setError("Password is incorrect");
        }
    }

    boolean isEmpty(String text)
    {
        CharSequence ch=text;
        return TextUtils.isEmpty(ch);
    }

}
