package com.example.nikola.domaci2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    TextView tvOne, tvTwo, tvThree;
    EditText edTodo;
    Button btnStart;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tvOne = findViewById(R.id.textView3);
        tvTwo = findViewById(R.id.textView4);
        tvThree = findViewById(R.id.textView5);
        edTodo = findViewById(R.id.editText3);
        btnStart = findViewById(R.id.button);
        final Intent intent = new Intent();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoModel td = new TodoModel();
                String s = edTodo.getText().toString();
                if (s.length() < 9) {
                    edTodo.setError("Add more chars");
                } else {
                    td.setName(s);
                    td.setImportance(i);

                    intent.putExtra("task", td);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        tvOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 1;
                Toast.makeText(Main3Activity.this, "You chose first color" , Toast.LENGTH_SHORT).show();

            }
        });
        tvTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 2;
                Toast.makeText(Main3Activity.this, "You chose second color" , Toast.LENGTH_SHORT).show();

            }
        });
        tvThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 3;
                Toast.makeText(Main3Activity.this, "You chose third color" , Toast.LENGTH_SHORT).show();
            }
        });


    }

}
