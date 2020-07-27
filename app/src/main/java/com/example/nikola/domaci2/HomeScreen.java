package com.example.nikola.domaci2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity implements TodoAdapter.OnItemClickListener {
    TextView title;
    String name;
    RecyclerView recyclerView;
    TodoAdapter adapter;
    ImageView img_trash;
    Helper helper;
    int importance;
    int code = 1;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        final Toolbar toolbar = findViewById(R.id.app_tolbar);
        setSupportActionBar(toolbar);

        initData();
        setupListener();

        recyclerView.setLayoutManager(new LinearLayoutManager
                (this, LinearLayoutManager.VERTICAL, false));


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, Todo.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void initData() {
        title = findViewById(R.id.textTitle);
        img_trash = findViewById(R.id.trash);
        recyclerView = findViewById(R.id.rclist);
        fab= (FloatingActionButton) findViewById(R.id.fab);
    }

    public void setupListener() {
        img_trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name != null) {
                    TodoModel todoModel = new TodoModel();
                    boolean s = todoModel.getFinished();// UVJEK JE FALSE
                    //  String we=
                    Toast.makeText(HomeScreen.this, "" + s, Toast.LENGTH_SHORT).show();
                    int r = adapter.getItemCount();
                    while (r >= 0) {
                        helper.delete(r);
                        recyclerView.setAdapter(adapter);
                        r--;

                    }
                } else
                    Toast.makeText(HomeScreen.this, "Enter todo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == code) {
            TodoModel newTaskModel = data.getParcelableExtra("task");

            helper = new Helper(TodoModel.getModel());

            fillList(newTaskModel);
        }
    }

    public void fillList(TodoModel td) {
        TodoModel rt = new TodoModel();

        if (helper.addNew(rt)) {
            adapter = new TodoAdapter(this, helper.getModelBills());

            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onClickListener(int position) {

    }
}
