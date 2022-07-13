package com.example.navbarlicenta.SQL.prices;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbarlicenta.R;
import com.example.navbarlicenta.SQL.AppDatabase;
import com.example.navbarlicenta.SQL.reservation.Reservation;
import com.example.navbarlicenta.modal.SingletonEnum;

import java.util.ArrayList;
import java.util.List;

public class PricesAdapter extends RecyclerView.Adapter<PricesAdapter.PricesHolder> {

    private List<Prices> pricesList = new ArrayList<>();
    private int quantity = 0;
    private int val = 0;
    private String card_type;
    private int adults_price, kids_price, quant_db;

    @NonNull
    @Override
    public PricesAdapter.PricesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.points_list, parent, false);
        return new PricesAdapter.PricesHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull PricesHolder holder, int position) {
        Prices currentPrice = pricesList.get(position);
        holder.ctype.setText(currentPrice.getCard_type());
        holder.price.setText(Integer.toString(currentPrice.getPrice()));
        holder.kprice.setText(Integer.toString(currentPrice.getKids_price()));
        holder.qty.setText(Integer.toString(quantity));

        holder.button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    val = Integer.parseInt(holder.qty.getText().toString());
                } catch (Exception e) {
                    val = 0;
                }
                if (val < 10) val++;
                holder.qty.setText(String.valueOf(val));
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    val = Integer.parseInt(holder.qty.getText().toString());
                } catch (Exception e) {
                    val = 0;
                }
                if (val > 0) val--;
                holder.qty.setText(String.valueOf(val));
            }
        });



        holder.button_addall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = AppDatabase.getDbInstance(view.getContext());
                int actualUser = SingletonEnum.INSTANCE.getValue();

                int i = Integer.parseInt(holder.qty.getText().toString());
                if (i > 0) {
                    try {
                    card_type = holder.ctype.getText().toString();
                    adults_price = Integer.parseInt(holder.price.getText().toString());
                    kids_price = Integer.parseInt(holder.kprice.getText().toString());
                    quant_db = Integer.parseInt(holder.qty.getText().toString());

                    Reservation reservation = new Reservation();
                    reservation.ctype = card_type;
                    reservation.aprice = adults_price;
                    reservation.kprice = kids_price;
                    reservation.quantity = quant_db;
                    reservation.idUser = actualUser;

                    db.reservationDAO().insertAll(reservation);

                    Toast.makeText(view.getContext(), card_type + " " + adults_price + " " +
                            kids_price + " " + quant_db, Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        Toast.makeText(view.getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pricesList.size();
    }

    public void setPricesList(List<Prices> pricesList) {
        this.pricesList = pricesList;
        notifyDataSetChanged();
    }

    public Prices getPricesAt(int position) {
        return pricesList.get(position);
    }

    class PricesHolder extends RecyclerView.ViewHolder {
        private TextView ctype, price, kprice, qty;
        private Button button_add, button_delete, button_addall;

        public PricesHolder(View itemView) {
            super(itemView);
            ctype = itemView.findViewById(R.id.subs_text_cardType);
            price = itemView.findViewById(R.id.subs_text_price);
            kprice = itemView.findViewById(R.id.subs_text_kprice);
            qty = itemView.findViewById(R.id.list_item_count);
            button_add = itemView.findViewById(R.id.add_btn);
            button_delete = itemView.findViewById(R.id.delete_btn);
            button_addall = itemView.findViewById(R.id.list_prices_buttonadd);
        }
    }

}
