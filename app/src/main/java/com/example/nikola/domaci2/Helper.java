package com.example.nikola.domaci2;

import java.util.ArrayList;

/**
 * Created by Nikola on 5/28/2018.
 */

public class Helper {
    ArrayList<TodoModel> modelBills;

    public Helper(ArrayList<TodoModel> modelBills) {
        this.modelBills = modelBills;
    }
    //ADD
    public boolean addNew(TodoModel modelBill)
    {
        try {
            modelBills.add(modelBill);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public  Helper()
    {

    }
    //retrive
    public  ArrayList<TodoModel>getModelBills()
    {
        return modelBills;
    }
    //UPDATE
    public  void update(int position,TodoModel td)
    {
        try {
            modelBills.remove(position);
            modelBills.add(position,td);

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    //DELETE
    public boolean delete(int pos)
    {
        try {
            modelBills.remove(pos);
            return true;
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
