package com.example.myapplicationnd.io.response;

import com.example.myapplicationnd.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public class PostsResponse {
   ArrayList<Post> posts;

   public ArrayList<Post> getPosts(){
       return posts;
   }
}
