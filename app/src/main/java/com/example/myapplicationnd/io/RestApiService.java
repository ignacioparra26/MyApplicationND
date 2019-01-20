package com.example.myapplicationnd.io;

import android.net.Uri;

import com.example.myapplicationnd.io.response.PostsResponse;
import com.example.myapplicationnd.model.Comment;
import com.example.myapplicationnd.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApiService {
    @GET("posts")
    Call<ArrayList<Post>> getPosts();

    @GET("comments")
    Call<ArrayList<Comment>> getComments();

    //@GET("comments/?postId=5")
    //Call<ArrayList<Comment>> getCommentsByPostId();

     //?postId=1
    //@GET("comments/{postId}")
    //Call<ArrayList<Comment>> getCommentsByPostId(@Path("postId") String postId);

    @GET("comments")
    Call<ArrayList<Comment>> getCommentsByPostId(@Query("postId") String postId);
}
