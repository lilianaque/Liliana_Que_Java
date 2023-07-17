package com.example.chatterbook;
/*
The User model object should contain the following two instance variables:
name (string)
chatterPosts (list of ChatterPost objects)
 */
import java.util.List;
public class User {
    private String name;
    private List<ChatterPost> chatterPosts;
    //constructor
    public User(String name) {
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public List<ChatterPost> getChatterPosts(){
        return chatterPosts;
    }

    //this is the list of ChatterPost objects
    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }

}
