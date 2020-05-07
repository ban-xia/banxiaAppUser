package cn.xq.festec.banxiaappuser.ui.index;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import cn.xq.festec.banxiaappuser.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TreatFragment extends Fragment {


    public TreatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_treat, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final int depId = getArguments().getInt("DEPID");
        final int docId = getArguments().getInt("DOCID");
        final String docName = getArguments().getString("DOCNAME");
        final String depName = getArguments().getString("DEPNAME");
        final String date = getArguments().getString("DATE");


        TextView textdepartment = requireActivity().findViewById(R.id.textdepartment);
        TextView textdoctor = requireActivity().findViewById(R.id.textdoctor);
        TextView textdate = requireActivity().findViewById(R.id.textdate);
        TextView textuser = requireActivity().findViewById(R.id.textuser);

        textdepartment.setText(depName);
        textdoctor.setText(docName);
        textdate.setText(date);
        textuser.setText("张三");

        final Button button = requireActivity().findViewById(R.id.applybutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String url = "http://182.92.175.234:8888/treat/save?date=" + date + "&depId=" + depId;
//                OkHttpClient okHttpClient = new OkHttpClient();
//
//                RequestBody body = new FormBody.Builder()
//                        .add("treatDepId", String.valueOf(depId))
//                        .add("treatDocId", String.valueOf(docId))
//                        .add("treatPrice", "50")
//                        .add("treatUserId", "2")
//                        .build();
//
//                final Request request = new Request.Builder()
//                        .url(url)
//                        .post(body)
//                        .build();
//                Call call = okHttpClient.newCall(request);
//                call.enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        Log.d("treat", e.getMessage());
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        String string = response.body().string();
//                        Gson gson = new Gson();
//                        final DoctorList result = gson.fromJson(string, DoctorList.class);
//                        if (result.getStatus() == 200) {
//                            requireActivity().runOnUiThread(
//                                    new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            Toast.makeText(requireContext(), "预约成功", Toast.LENGTH_SHORT);
//                                            button.setEnabled(false);
//                                        }
//                                    }
//                            );
//                        }
//                    }
//                });

                Toast.makeText(requireContext(), "预约成功", Toast.LENGTH_SHORT);
                button.setEnabled(false);
            }
        });



    }
}
