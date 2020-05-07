package cn.xq.festec.banxiaappuser.ui.index;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.xq.festec.banxiaappuser.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FiveFragment extends Fragment {


    private String date;
    private int depId;

    public FiveFragment(String date, int depId) {
        this.date = date;
        this.depId = depId;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_five, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
