package com.example.myapplicationnd.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.myapplicationnd.R;
import com.example.myapplicationnd.io.RestApiAdapter;
import com.example.myapplicationnd.model.Comment;
import com.example.myapplicationnd.ui.adapter.CommentAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity implements Callback<ArrayList<Comment>> {

    private CommentAdapter commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvComments);

        rv.setHasFixedSize(true);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        commentAdapter = new CommentAdapter();
        rv.setAdapter(commentAdapter);

        Intent intent = getIntent();
        final int post_id = intent.getIntExtra("post_id", 0);

        //String postId = "?postId=" + String.valueOf(post_id);

        Call<ArrayList<Comment>> call = RestApiAdapter.getAppiService().getCommentsByPostId(String.valueOf(post_id));
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
        if(response.isSuccessful()){
            ArrayList<Comment> comments = response.body();
            Log.d("onrsponse Comments", "size of comments => " + comments.size());
            commentAdapter.setDataSet(comments);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
