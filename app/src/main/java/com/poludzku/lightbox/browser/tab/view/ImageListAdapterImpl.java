package com.poludzku.lightbox.browser.tab.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.poludzku.lightbox.R;
import com.poludzku.lightbox.app.model.Image;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ImageListAdapterImpl extends ImageListAdapter {

    private List<Image> imageList = new ArrayList<>();

    @Inject
    public ImageListAdapterImpl() {
    }

    @Override
    public void setData(List<Image> imageList) {
        this.imageList.clear();
        this.imageList.addAll(imageList);
        notifyDataSetChanged();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card,parent,false));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10; //imageList.size();
    }
}