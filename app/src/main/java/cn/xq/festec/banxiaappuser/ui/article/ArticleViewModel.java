package cn.xq.festec.banxiaappuser.ui.article;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArticleViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ArticleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}