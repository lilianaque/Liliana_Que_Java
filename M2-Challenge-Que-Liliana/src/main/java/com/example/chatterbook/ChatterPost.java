package com.example.chatterbook;
/*
The ChatterPost model object should contain one string instance variable named text.
This variable will contain the text representing a post by a user.
 */

public class ChatterPost {
    private String text;
    public ChatterPost(String text){
        this.text=text;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text=text;
    }

}
