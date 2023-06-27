package com.example.chatterbook.controller;
import com.example.chatterbook.ChatterPost;
import com.example.chatterbook.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
//@RequestMapping("/api")
public class ChatterbookController {
    private List<User> userList;

    public ChatterbookController() {
        User luis = new User("Luis");
        User sue = new User("Sue");
        User timothy = new User("Timothy");
        User george = new User("George");
        User arturo = new User("Arturo");
        User mariella = new User("Mariella");
        User paolo = new User("Paolo");
        User tri = new User("Tri");
        User jane = new User("Jane");
        User carol = new User("Carol");
        User carl = new User("Carl");

        luis.setChatterPosts(Arrays.asList(new ChatterPost("Hey! This is my first post!"), new ChatterPost("Anybody want to be friends?")));
        sue.setChatterPosts(Arrays.asList(new ChatterPost("I'm bored"), new ChatterPost("Who wants to hang?")));
        timothy.setChatterPosts(Arrays.asList(new ChatterPost("My life is awesome!"), new ChatterPost("Click here to buy my vegan shakes!")));
        george.setChatterPosts(Arrays.asList(new ChatterPost("I like pigs."), new ChatterPost("I love lamp.")));
        arturo.setChatterPosts(Arrays.asList(new ChatterPost("My cat is so cute"), new ChatterPost("My kitten is purr-fect.")));
        mariella.setChatterPosts(Arrays.asList(new ChatterPost("I'll never post again")));
        paolo.setChatterPosts(Arrays.asList(new ChatterPost("Have you ever heard of the band Nirvana?"), new ChatterPost("Pearl Jam 4 Life")));
        tri.setChatterPosts(Arrays.asList(new ChatterPost("You definitely grew up in the 90s if you get these 10 references."), new ChatterPost("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setChatterPosts(Arrays.asList(new ChatterPost("I just wrecked my dad's car. He's going to kill me!"), new ChatterPost("Grounded.... for 5 months :( ")));
        carol.setChatterPosts(Arrays.asList(new ChatterPost("Does anyone have some imodium?")));
        carl.setChatterPosts(Arrays.asList(new ChatterPost("My roommate is awful!!!!"), new ChatterPost("Anyone know a room for rent in Hyde Park?")));

        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);
    }

    // route that returns list of all users
    // http method: get
    // uri: /users
    @GetMapping("/users")
    public List<User> getUsers() {
        return userList;
    }

//    @RequestMapping(value = "/users", method=RequestMethod.GET)
//        public List<User> getUsers() {
//            return userList;
//        }

//    @RequestMapping(value = "/users/{index}", method=RequestMethod.GET)
//    public User getUserByIndex(@PathVariable int index){
//        return userList.get(index);
//    }

    // route that returns a single user by user name
    // http method: get
    // uri: /users/{username}
    @GetMapping("/users/{username}")
        public List<User> getSingleUser(@PathVariable String username){
        List<User> singleUser=new ArrayList<>();
            for (User user: userList){
                if(user.getName().equals(username)){
                    singleUser.add(user);
                }
            }
            return singleUser;
        }

    // route that returns a list of chatterPosts for a user by user name
    // http method: get
    // uri: /users/{username}/chatterPosts

    @GetMapping("/users/{username}/chatterPosts")
    public List<ChatterPost> getChatterPostsByUsername(@PathVariable("username") String username) {
        List<ChatterPost> chatterPosts = new ArrayList<>();
        for (User user : userList) {
            if (user.getName().equals(username)) {
                chatterPosts = user.getChatterPosts();
                break;
            }
        }
        return chatterPosts;
    }
}
