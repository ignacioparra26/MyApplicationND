package com.example.myapplicationnd.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplicationnd.R;
import com.example.myapplicationnd.io.RestApiAdapter;
import com.example.myapplicationnd.model.Post;
import com.example.myapplicationnd.ui.adapter.PostAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Post>>, View.OnClickListener {

    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv =(RecyclerView)findViewById((R.id.rvPosts));

        rv.setHasFixedSize(true); //same size for all elements in the Recycler View

        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        postAdapter = new PostAdapter(this);
        rv.setAdapter(postAdapter);

        Call<ArrayList<Post>> call = RestApiAdapter.getAppiService().getPosts();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
        if(response.isSuccessful()){
            ArrayList<Post> posts = response.body();
            Log.d("onResponse Posts", "size of Posts => " + posts.size());
            postAdapter.setDataSet(posts);

        }
    }

    @Override
    public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

    }

    @Override
    public void onClick(View view) {

    }


}
