package com.example.nikola.domaci2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private Context context;
    Helper helper;
    TodoModel td;
    private List<TodoModel> list = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    public TodoAdapter(Context context, List<TodoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        td = list.get(position);
        helper = new Helper();
        holder.todoName.setText(td.getName());
        String s = (td.getName().substring(0, 1));
        holder.todoTitle.setText(s);
        holder.todoTitle.setTextColor(Color.WHITE);
        int q = td.getImportance();
        if (q == 1) {
            holder.todoTitle.setBackgroundResource(R.drawable.text_view_circle);
        }
        if (q == 2) {
            holder.todoTitle.setBackgroundResource(R.drawable.text_view_circle2);
        }
        if (q == 3) {
            holder.todoTitle.setBackgroundResource(R.drawable.text_view_circle3);
        }


        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=position;
                boolean sq = holder.checkBox.isChecked();

                td.setFinished(sq);
                helper.update(a, td);
            }
        });
}


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView todoName, todoTitle;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            todoName = itemView.findViewById(R.id.textName);
            todoTitle = itemView.findViewById(R.id.textTitle);
            checkBox = itemView.findViewById(R.id.checkBox);


        }

        public void bind(TodoModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickListener(getLayoutPosition());

                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClickListener(int position);
    }

}
