package cn.xq.festec.banxiaappuser.ui.index;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import cn.xq.festec.banxiaappuser.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DepartFragment extends Fragment {

    private DepartViewModel mDepartViewModel;
    private RecyclerView mRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_depart, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDepartViewModel = new ViewModelProvider(this).get(DepartViewModel.class);

        LiveData<List<Department>> listLiveData = mDepartViewModel.getLiveData();

        final DepartAdapter departAdapter = new DepartAdapter();
        String url = "http://182.92.175.234:8888/department/list";

        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final DepartmentResult result = gson.fromJson(string, DepartmentResult.class);
                if (result.getStatus() == 200) {
                    requireActivity().runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    departAdapter.submitList(result.getData());
                                }
                            }
                    );
                }
            }
        });

        mRecyclerView = requireActivity().findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 4));
        mRecyclerView.setAdapter(departAdapter);



    }
}
