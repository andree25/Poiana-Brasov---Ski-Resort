package com.example.navbarlicenta.SQL.user;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... users);

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("UPDATE user SET password=:user_pass WHERE email = :user_email")
    void updatePass(String user_pass, String user_email);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Query("SELECT id_user FROM user WHERE email LIKE :email")
    int findIDbyEmail(String email);


    @Query("SELECT * FROM user")
    public User[] loadAllUsers();

    @Query("DELETE FROM user")
    void deleteAll();

    @Query("SELECT * FROM user ORDER BY id_user ASC")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM user WHERE id_user IN (:userId)")
    User loadById(int userId);


    @Delete
    void deleteUser(User[] user);

    @Query("DELETE FROM user WHERE id_user = :userIds")
    void deleteById(int userIds);


}
