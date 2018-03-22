package com.example.raymond.mvpdemo.tablayout.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raymond.mvpdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoicedFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static ChoicedFragment newInstance() {

//        Bundle args = new Bundle();
//        args.putInt(ARG_PAGE,page);

        ChoicedFragment choicedFragment = new ChoicedFragment();
//        choicedFragment.setArguments(args);
        return choicedFragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage = getArguments().getInt(ARG_PAGE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choiced, container, false);
        return view;
    }

}
