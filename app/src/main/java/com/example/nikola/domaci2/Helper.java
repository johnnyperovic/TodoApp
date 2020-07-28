package com.example.nikola.domaci2;

import java.util.ArrayList;

/**
 * Created by Nikola on 5/28/2018.
 */

public class Helper {
    ArrayList<TodoModel> model;

    public Helper(ArrayList<TodoModel> model) {
        this.model = model;
    }

    //ADD
    public boolean addNew(TodoModel modelBill) {
        try {
            model.add(modelBill);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Helper() {

    }

    //retrive
    public ArrayList<TodoModel> getModel() {
        return model;
    }

    //UPDATE
    public void update(int position, TodoModel td) {
        try {
            model.remove(position);
            model.add(position, td);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //DELETE
    public boolean delete(int pos) {
        try {
            model.remove(pos);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
