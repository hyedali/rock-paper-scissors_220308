package com.example.rock_paper_scissors_220308;

import android.os.Parcel;
import android.os.Parcelable;

public class DataSave implements Parcelable {
    int number;
    String message;

    public DataSave(int num, String msg){
        number = num;
        message = msg;
    }

    public DataSave(Parcel src){
        number = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public DataSave createFromParcel(Parcel in) {
            return new DataSave(in);
        }

        @Override
        public DataSave[] newArray(int size) {
            return new DataSave[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
