package cn.xq.festec.banxiaappuser.ui.index;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.xq.festec.banxiaappuser.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class IndexFragment extends Fragment {

    private IndexViewModel mIndexViewModel;

    private View mView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_index, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mIndexViewModel = new ViewModelProvider(this).get(IndexViewModel.class);

        mView = requireActivity().findViewById(R.id.view3);

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);

                controller.navigate(R.id.action_navigation_home_to_departFragment);
            }
        });
    }
}