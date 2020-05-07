package cn.xq.festec.banxiaappuser.ui.mine;

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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import cn.xq.festec.banxiaappuser.R;

public class MineFragment extends Fragment {

    private MineViewModel mMineViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mMineViewModel = new ViewModelProvider(this).get(MineViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mine, container, false);

        mMineViewModel.getText().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = requireActivity().findViewById(R.id.view10);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                NavController controller = Navigation.findNavController(view);

                controller.navigate(R.id.action_navigation_notifications_to_recordFragment, bundle);
            }
        });
    }
}