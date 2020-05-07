package cn.xq.festec.banxiaappuser.ui.index;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class DepartViewModel extends ViewModel {

    private LiveData<List<Department>> mLiveData = null;

    public LiveData<List<Department>> getLiveData() {

        return this.mLiveData;

    }
}
