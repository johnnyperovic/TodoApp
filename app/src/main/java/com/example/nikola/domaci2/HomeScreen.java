package com.example.nikola.domaci2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {
    TextView title;
    String name;
    RecyclerView recyclerView;
    TodoAdapter adapter;
    ImageView img_trash;
    Helper helper;
    int importance;
    int code = -1;
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
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    public void setupListener() {
        img_trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = adapter.getItemCount();
                r = r - 1;
                while (r >= 0) {
                    if (helper.getModel().get(r).getFinished()) {
                        helper.delete(r);
                        adapter.notifyDataSetChanged();
                    }
                    r--;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            TodoModel newTaskModel = data.getParcelableExtra("task");
            fillList(newTaskModel);
        }
    }

    public void fillList(TodoModel td) {
        helper = new Helper(TodoModel.getModel());
        if (helper.addNew(td)) {
            adapter = new TodoAdapter(this, helper.getModel());
            recyclerView.setAdapter(adapter);
        }
    }


}
