package com.poludzku.lightbox.browser.tab.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.poludzku.lightbox.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageView)
    ImageView imageView;

    public ImageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
