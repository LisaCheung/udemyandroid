package com.example.recyclerview17;

public class RecyclerViewModel {
    private String text;
    private int image;

    public RecyclerViewModel(String text, int image) {
        this.text = text;
        this.image = image;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
