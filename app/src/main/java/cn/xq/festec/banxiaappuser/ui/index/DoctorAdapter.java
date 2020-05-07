package cn.xq.festec.banxiaappuser.ui.index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import cn.xq.festec.banxiaappuser.R;

public class DoctorAdapter extends ListAdapter<Doctor, DoctorAdapter.MyViewHolder> {

    protected DoctorAdapter() {
        super(new DiffUtil.ItemCallback<Doctor>() {
            @Override
            public boolean areItemsTheSame(@NonNull Doctor oldItem, @NonNull Doctor newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Doctor oldItem, @NonNull Doctor newItem) {
                return oldItem.getDocId() == newItem.getDocId();
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_cell, parent, false);
        final MyViewHolder mMyViewHolder = new MyViewHolder(inflater);


        return mMyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Doctor doctor = getItem(position);

        if (doctor == null) return;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Doctor item = getItem(position);
                bundle.putInt("DEPID", item.getDepId());
                bundle.putInt("DOCID", item.getDocId());
                bundle.putString("DOCNAME", item.getDocName());
                bundle.putString("DEPNAME", item.getDepName());
                bundle.putString("DEPNAME", item.getDepName());
                bundle.putString("DATE", item.getDate());
                NavController controller = Navigation.findNavController(view);

                controller.navigate(R.id.action_doctorFragment_to_treatFragment, bundle);
            }
        });


        holder.textdoctorname.setText(doctor.getDocName());
        holder.textgender.setText(doctor.getDocGender() == 0 ? "女" : "男");
        holder.onduty.setText("可预约");
        holder.textdepname.setText(doctor.getDepName());
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textdoctorname;
        private TextView textgender;
        private TextView onduty;
        private TextView textdepname;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textdoctorname = itemView.findViewById(R.id.textdoctorname);
            textgender = itemView.findViewById(R.id.textgender);
            onduty = itemView.findViewById(R.id.onduty);
            textdepname = itemView.findViewById(R.id.textdepname);
        }
    }
}
