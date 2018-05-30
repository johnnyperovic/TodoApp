package com.example.nikola.domaci2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements TodoAdapter.OnItemClickListener {
    TextView title;
    String name;
    RecyclerView rc;
    TodoAdapter adapter;
    ImageView img_trash;
    CheckBox checkBox;
    Helper helper;
    int importance;

    String sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Toolbar toolbar = findViewById(R.id.app_tolbar);
        setSupportActionBar(toolbar);

        title = findViewById(R.id.textTitle);
        checkBox = findViewById(R.id.checkBox);
        img_trash = findViewById(R.id.trash);
        delete();



        rc = findViewById(R.id.rclist);
        rc.setLayoutManager(new LinearLayoutManager
                (this, LinearLayoutManager.VERTICAL, false));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivityForResult(intent, 1);// BEZ OVOGA NIJE MOGLO????
            }
        });
    }

    public void delete() {
        img_trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name != null) {
                    TodoModel todoModel=new TodoModel();
                    boolean s = todoModel.getFinished();// UVJEK JE FALSE
                  //  String we=
                    Toast.makeText(Main2Activity.this, "" + s, Toast.LENGTH_SHORT).show();
                    int r = adapter.getItemCount();
                    while (r >= 0) {
                        // ovdje rtreba da se doda if(s==true)
                        helper.delete(r);
                        rc.setAdapter(adapter);
                        r--;
                    }
                } else
                    Toast.makeText(Main2Activity.this, "Enter todo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            TodoModel newTaskModel = data.getParcelableExtra("task");
            name = newTaskModel.getName();
            importance = newTaskModel.getImportance();
            helper = new Helper(TodoModel.getModel());

         adapter = new TodoAdapter(this, helper.getModelBills());
            fillList(name, importance);
        }
    }

    public void fillList(String a, int r) {
        TodoModel rt = new TodoModel();
        rt.setName(a);
        rt.setImportance(r);
        //   rt.setFinished(b);
        if (helper.addNew(rt)) {
            rc.setAdapter(adapter);
        }
    }

    @Override
    public void onClickListener(int position) {

    }
}
