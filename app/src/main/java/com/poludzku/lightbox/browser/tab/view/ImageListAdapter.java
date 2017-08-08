package com.poludzku.lightbox.browser.tab.view;

import android.support.v7.widget.RecyclerView;

import com.poludzku.lightbox.app.model.Image;

import java.util.List;


public abstract class ImageListAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    abstract void setData(List<Image> imageList);
}
