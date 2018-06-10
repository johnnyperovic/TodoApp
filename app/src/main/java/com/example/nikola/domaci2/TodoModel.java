package com.example.nikola.domaci2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TodoModel implements Parcelable {

    private boolean isFinished;
    private String name;
    private int importance;

    protected TodoModel(Parcel in) {
        isFinished = in.readByte() != 0;
        name = in.readString();
        importance = in.readInt();
    }

    public TodoModel() {
    }


    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<TodoModel> model = new ArrayList<>();

    public static ArrayList<TodoModel> getModel() {
        return model;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isFinished ? 1 : 0));
        dest.writeString(name);
        dest.writeInt(importance);
    }

    public static final Creator<TodoModel> CREATOR = new Creator<TodoModel>() {
        @Override
        public TodoModel createFromParcel(Parcel in) {
            return new TodoModel(in);
        }

        @Override
        public TodoModel[] newArray(int size) {
            return new TodoModel[size];
        }
    };

}