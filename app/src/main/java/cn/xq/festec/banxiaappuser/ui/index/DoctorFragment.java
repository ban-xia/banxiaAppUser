package cn.xq.festec.banxiaappuser.ui.index;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.xq.festec.banxiaappuser.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorFragment extends Fragment {

    private ViewPager2 mViewPager2;
    private TabLayout mTabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doctor, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final int depId = getArguments().getInt("DEPARTMENT");
        mTabLayout = requireActivity().findViewById(R.id.tablayout);

        final List<String> date = new ArrayList<>();

        String url = "http://182.92.175.234:8888/time";
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
                final TimeResult result = gson.fromJson(string, TimeResult.class);
                final Map<String, String> time = result.getData();
                if (result.getStatus() == 200) {
                    requireActivity().runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    date.add(time.get("one"));
                                    date.add(time.get("two"));
                                    date.add(time.get("three"));
                                    date.add(time.get("four"));
                                    date.add(time.get("five"));
                                    date.add(time.get("six"));
                                    date.add(time.get("seven"));

                                    mViewPager2 = requireActivity().findViewById(R.id.viewpager2);

                                    mViewPager2.setAdapter(new FragmentStateAdapter(requireActivity()) {
                                        @NonNull
                                        @Override
                                        public Fragment createFragment(int position) {

                                            Fragment fragment = null;
                                            switch (position) {
                                                case 0:
                                                    fragment = new OneFragment(time.get("one"), depId);
                                                    break;

                                                case 1:
                                                    fragment = new TwoFragment(time.get("two"), depId);
                                                    break;
                                                case 2:
                                                    fragment = new ThreeFragment(time.get("three"), depId);
                                                    break;
                                                case 3:
                                                    fragment = new FourFragment(time.get("four"), depId);
                                                    break;
                                                case 4:
                                                    fragment = new FiveFragment(time.get("five"), depId);
                                                    break;
                                                case 5:
                                                    fragment = new SixFragment(time.get("six"), depId);
                                                    break;
                                                case 6:
                                                    fragment = new SevenFragment(time.get("seven"), depId);
                                                    break;
                                            }

                                            return fragment;
                                        }

                                        @Override
                                        public int getItemCount() {
                                            return 7;
                                        }
                                    });

                                    mViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);



                                    new TabLayoutMediator(mTabLayout, mViewPager2, true,
                                            new TabLayoutMediator.TabConfigurationStrategy() {
                                                @Override
                                                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                                                    tab.setText(date.get(position));
                                                }
                                            }).attach();

                                }
                            }
                    );
                }
            }
        });


    }
}