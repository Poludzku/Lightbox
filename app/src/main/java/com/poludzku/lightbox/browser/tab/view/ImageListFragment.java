package com.poludzku.lightbox.browser.tab.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poludzku.lightbox.R;
import com.poludzku.lightbox.browser.tab.di.ImageListModule;
import com.poludzku.lightbox.browser.main.view.Browser;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class ImageListFragment extends Fragment {
    private static final String ARG_SORT_ORDER = "sort_order";

    @BindView(R.id.image_list)
    RecyclerView imageListView;

    @Inject
    ImageListAdapter imageListAdapter;

    int sortOrder;

    public ImageListFragment() {
    }

    public static ImageListFragment newInstance(int sortOrder) {
        ImageListFragment fragment = new ImageListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SORT_ORDER, sortOrder);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sortOrder = getArguments().getInt(ARG_SORT_ORDER);
        View rootView = inflater.inflate(R.layout.fragment_browser, container, false);
        //ButterKnife.bind(this,rootView);
        imageListView = (RecyclerView) rootView.findViewById(R.id.image_list);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((Browser) getActivity()).getBrowserComponent().plus(new ImageListModule()).inject(this);
        imageListView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        imageListView.setAdapter(imageListAdapter);
        imageListAdapter.setData(new ArrayList<>());
    }
}
