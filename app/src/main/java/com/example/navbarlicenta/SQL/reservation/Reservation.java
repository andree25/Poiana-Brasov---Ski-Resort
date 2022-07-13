package com.example.navbarlicenta.SQL.reservation;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.navbarlicenta.SQL.user.User;

@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id_user", childColumns = "id_user", onDelete = ForeignKey.CASCADE))
public class Reservation {

    @PrimaryKey(autoGenerate = true)
    int id_reservation;

    @ColumnInfo(name = "id_user")
    public int idUser;

    @ColumnInfo(name = "card_type")
    public String ctype;

    @ColumnInfo(name = "adult_price")
    public int aprice;

    @ColumnInfo(name = "kids_price")
    public int kprice;

    @ColumnInfo(name = "quantity")
    public int quantity;

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public int getAprice() {
        return aprice;
    }

    public void setAprice(int aprice) {
        this.aprice = aprice;
    }

    public int getKprice() {
        return kprice;
    }

    public void setKprice(int kprice) {
        this.kprice = kprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
