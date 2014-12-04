package com.example.diegofranco.materialbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by DiegoFranco on 12/3/14.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener{

    private BaseActivity baseActivity;

    public MyAdapter(BaseActivity context) {
        this.baseActivity = context;
    }

    @Override
    public void onClick(View v) {
        String s = (String) v.getTag();
        //ViewHolder holder = (ViewHolder) v.getTag();
        //if (v.getId() == holder.mImageView.getId()) {
        Toast.makeText(baseActivity.getBaseContext(), "Clicked: " + s , Toast.LENGTH_SHORT).show();
        DetailActivity.launch(baseActivity, v.findViewById(R.id.image_card), s);
        //}
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case


        private TextView mTextView;
        private ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
            mImageView = (ImageView) v.findViewById(R.id.image_card);
        }

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_card_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        holder.mImageView.setOnClickListener(MyAdapter.this);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText("Item " + String.valueOf(position + 1));
        String imageUrl = "http://lorempixel.com/800/600/abstract/" + String.valueOf(position + 1);
        holder.mImageView.setTag(imageUrl);
        Picasso.with(baseActivity.getBaseContext()).load(imageUrl).into(holder.mImageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 10;
    }


}
