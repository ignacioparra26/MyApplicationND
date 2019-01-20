package com.example.myapplicationnd.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplicationnd.R;
import com.example.myapplicationnd.model.Comment;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private ArrayList<Comment> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvEmail;
        TextView tvBody;

        public ViewHolder(View v){
           super(v);
           tvName = (TextView) v.findViewById(R.id.tvComName);
           tvEmail = (TextView) v.findViewById(R.id.tvComEmail);
           tvBody = (TextView)v.findViewById(R.id.tvComBody);
        }
    }

    public CommentAdapter(){
        mDataSet = new ArrayList<>();
    }

    public void setDataSet(ArrayList<Comment> dataSet){
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.comment_view, parent, false);

                ViewHolder vh = new ViewHolder(v);
                return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int i) {
        holder.tvName.setText(mDataSet.get(i).getName());
        holder.tvEmail.setText((mDataSet.get(i).getEmail()));
        holder.tvBody.setText(mDataSet.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
