package com.example.androidpemula;


import android.os.Parcel;
import android.os.Parcelable;


public class Items implements Parcelable {
    private int Image;
    private String title;
    private String info;

    public Items(){

    }
    public Items(int mImage, String mTitle, String mInfo) {
        Image = mImage;
        title = mTitle;
        info = mInfo;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Image);
        dest.writeString(title);
        dest.writeString(info);
    }
    protected Items(Parcel in) {
        Image = in.readInt();
        title = in.readString();
        info = in.readString();
    }

    public static final Parcelable.Creator<Items> CREATOR = new Parcelable.Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };


}
