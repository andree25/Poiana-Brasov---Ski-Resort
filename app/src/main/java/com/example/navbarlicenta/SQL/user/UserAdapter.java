package com.example.navbarlicenta.SQL.user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbarlicenta.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<User> userList = new ArrayList<>();

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_list, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User currentUser = userList.get(position);
        holder.textViewID.setText(Integer.toString(currentUser.getId_user()));
        holder.textViewLName.setText(currentUser.getlName());
        holder.textViewFname.setText(currentUser.getfName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    public User getUserAt(int position) {
        return userList.get(position);
    }

    class UserHolder extends RecyclerView.ViewHolder {
        private TextView textViewID, textViewFname, textViewLName;

        public UserHolder(View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.admin_text_id);
            textViewFname = itemView.findViewById(R.id.admin_text_fname);
            textViewLName = itemView.findViewById(R.id.admin_text_lname);
        }
    }
}
