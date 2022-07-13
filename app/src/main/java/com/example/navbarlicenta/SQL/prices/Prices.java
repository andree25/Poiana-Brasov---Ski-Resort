package com.example.navbarlicenta.SQL.prices;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Prices {

    @PrimaryKey(autoGenerate = true)
    int id_price;

    @ColumnInfo(name = "card_type")
    public String card_type;

    @ColumnInfo(name = "price")
    public int price;

    @ColumnInfo(name = "kids_price")
    public int kids_price;

    public Prices(String card_type, int price, int kids_price) {
        this.card_type = card_type;
        this.price = price;
        this.kids_price = kids_price;
    }

    public Prices() {
    }

    public int getId_price() {
        return id_price;
    }

    public void setId_price(int id_price) {
        this.id_price = id_price;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKids_price() {
        return kids_price;
    }

    public void setKids_price(int kids_price) {
        this.kids_price = kids_price;
    }
}
