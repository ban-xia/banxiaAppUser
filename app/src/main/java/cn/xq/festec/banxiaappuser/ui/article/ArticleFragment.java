package cn.xq.festec.banxiaappuser.ui.article;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.Arrays;
import java.util.List;

import cn.xq.festec.banxiaappuser.R;

public class ArticleFragment extends Fragment {

    private List<Integer> images = Arrays.asList(R.drawable.lunbo1, R.drawable.lunbo2, R.drawable.lunbo3);

    private ArticleViewModel mArticleViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mArticleViewModel = new ViewModelProvider(this).get(ArticleViewModel.class);
        Banner banner = requireActivity().findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置轮播时间
        banner.setDelayTime(2000);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
}