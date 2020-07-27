package com.example.nikola.domaci2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Todo extends AppCompatActivity implements View.OnClickListener {
    TextView tvOne, tvTwo, tvThree;
    EditText task;
    Button btnStart;
    int color;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_activity);
        initData();
        setClickListener();
    }

    public void addTask() {
        TodoModel td = new TodoModel();
        String taskT = task.getText().toString();
        if (taskT.length() < 9) {
            task.setError("Add more chars");
        } else {
            td.setName(taskT);
            td.setImportance(color);
            intent.putExtra("task", td);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void initData() {
        tvOne = findViewById(R.id.circleOne);
        tvTwo = findViewById(R.id.circleTwo);
        tvThree = findViewById(R.id.circleThree);
        task = findViewById(R.id.etTask);
        btnStart = findViewById(R.id.button);
        intent = new Intent();

    }

    public void setClickListener() {
        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        tvThree.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circleOne:
                color = 1;
                Toast.makeText(Todo.this, "You chose first color", Toast.LENGTH_SHORT).show();
                break;
            case R.id.circleTwo:
                color = 2;
                Toast.makeText(Todo.this, "You chose second color", Toast.LENGTH_SHORT).show();
                break;
            case R.id.circleThree:
                color = 3;
                Toast.makeText(Todo.this, "You chose third color", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                addTask();
                break;
        }
    }
}
