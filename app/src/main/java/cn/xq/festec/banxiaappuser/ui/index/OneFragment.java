package cn.xq.festec.banxiaappuser.ui.index;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class OneFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private String date;
    private int depId;

    public OneFragment(String date, int depId) {
        this.date = date;
        this.depId = depId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final DoctorAdapter doctorAdapter = new DoctorAdapter();
        String url = "http://182.92.175.234:8888/doctor/queryOnDuty?date=" + date + "&depId=" + depId;
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
                final DoctorList result = gson.fromJson(string, DoctorList.class);
                if (result.getStatus() == 200) {
                    requireActivity().runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    List<Doctor> doctors = result.getData();
                                    for (Doctor d:
                                         doctors) {
                                        d.setDate(date);
                                    }
                                    doctorAdapter.submitList(doctors);
                                }
                            }
                    );
                }
            }
        });

        mRecyclerView = requireActivity().findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mRecyclerView.setAdapter(doctorAdapter);
    }
}
