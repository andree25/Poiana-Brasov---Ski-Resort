package com.example.navbarlicenta.SQL.reservation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbarlicenta.R;
import com.example.navbarlicenta.SQL.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ReservationHolder> {

    private List<Reservation> reservationList = new ArrayList<>();

    @NonNull
    @Override
    public ReservationAdapter.ReservationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservations_list, parent, false);
        return new ReservationAdapter.ReservationHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationAdapter.ReservationHolder holder, int position) {
        Reservation currentReservation = reservationList.get(position);

        holder.ctype.setText(currentReservation.getCtype());
        holder.price.setText(Integer.toString(currentReservation.getAprice()));
        holder.kprice.setText(Integer.toString(currentReservation.getKprice()));
        holder.qty.setText(Integer.toString(currentReservation.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return reservationList.size();
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
        notifyDataSetChanged();
    }

    public Reservation getReservationAt(int position) {
        return reservationList.get(position);
    }

    class ReservationHolder extends RecyclerView.ViewHolder {
        private TextView ctype, price, kprice, qty;

        public ReservationHolder(View itemView) {
            super(itemView);
            ctype = itemView.findViewById(R.id.res_ctype);
            price = itemView.findViewById(R.id.res_aprice);
            kprice = itemView.findViewById(R.id.res_kprice);
            qty = itemView.findViewById(R.id.res_quant);
        }
    }
}
