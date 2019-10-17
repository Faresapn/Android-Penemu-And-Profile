package com.example.androidpemula;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Items> mList;
    private OnItemClickListener mListener;

    public Adapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setMovieItems(ArrayList<Items> clubItems) {
        this.mList = clubItems;
    }



    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;


        public CategoryViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img_club);
                mTextView1 = itemView.findViewById(R.id.name_club);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public Adapter(ArrayList<Items> exampleList) {
        mList = exampleList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_item, parent, false);
        CategoryViewHolder evh = new CategoryViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Items currentItem = mList.get(position);

        holder.mImageView.setImageResource(currentItem.getImage());
        holder.mTextView1.setText(currentItem.getTitle());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
