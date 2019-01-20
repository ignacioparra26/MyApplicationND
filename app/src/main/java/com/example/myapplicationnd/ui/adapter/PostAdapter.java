package com.example.myapplicationnd.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplicationnd.R;
import com.example.myapplicationnd.model.Post;
import com.example.myapplicationnd.ui.activity.CommentsActivity;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private ArrayList<Post> mDataSet;
    private Context mContext;

    //to Get the references of TextView, EditText,Buttons
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvTitle;
        public TextView tvBody;

        public ViewHolder(View v){
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvBody = (TextView) v.findViewById(R.id.tvBody);
        }
    }

    public PostAdapter(Context context){
        mContext = context;
        mDataSet= new ArrayList<>();
    }

    public void setDataSet(ArrayList<Post> dataSet){
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final Post post = mDataSet.get(i);

        holder.tvTitle.setText(mDataSet.get(i).getTitle());
        holder.tvBody.setText(mDataSet.get(i).getBody());

       holder.tvBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CommentsActivity.class);
                intent.putExtra("post_id",post.getId());
                mContext.startActivity(intent);
            }
        });

        /*Intent intent = new Intent(mContext, CommentsActivity.class);
        intent.putExtra("postId", mDataSet.get(i).getId());
        mContext.startActivity(intent);*/
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}
