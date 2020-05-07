package cn.xq.festec.banxiaappuser.ui.index;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import cn.xq.festec.banxiaappuser.R;

public class DepartAdapter extends ListAdapter<Department, DepartAdapter.MyViewHolder> {

    protected DepartAdapter() {
        super(new DiffUtil.ItemCallback<Department>() {
            @Override
            public boolean areItemsTheSame(@NonNull Department oldItem, @NonNull Department newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Department oldItem, @NonNull Department newItem) {
                return oldItem.getDepId() == newItem.getDepId();
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.depart_cell, parent, false);
        final MyViewHolder mMyViewHolder = new MyViewHolder(inflater);


        return mMyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        Department photoItem = getItem(position);

        if (photoItem == null) return;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Department item = getItem(position);
                bundle.putInt("DEPARTMENT", item.getDepId());
                NavController controller = Navigation.findNavController(view);

                controller.navigate(R.id.action_departFragment_to_doctorFragment, bundle);
            }
        });


        holder.department.setText(photoItem.getDepName());
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView department;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            department = itemView.findViewById(R.id.textView16);
        }
    }

}
