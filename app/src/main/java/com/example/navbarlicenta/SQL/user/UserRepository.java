package com.example.navbarlicenta.SQL.user;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.navbarlicenta.SQL.AppDatabase;

import java.util.List;

public class UserRepository {
    private UserDAO userDAO;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getDbInstance(application);
        userDAO = appDatabase.userDAO();
        allUsers = userDAO.getAllUsers();
    }

    public void insert(User user){
        new InsertUsersAsyncTask(userDAO).execute(user);
    }

    public void update(User user){
        new UpdateUsersAsyncTask(userDAO).execute(user);
    }

    public void delete(User user){
        new DeleteUsersAsyncTask(userDAO).execute(user);
    }

    public void deleteAll(){
        new DeleteAllUsersAsyncTask(userDAO).execute();
    }

    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    public static class InsertUsersAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDAO userDAO;

        private InsertUsersAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDAO.insertUser(users[0]);
            return null;
        }
    }

    public static class UpdateUsersAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDAO userDAO;

        private UpdateUsersAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDAO.updateUser(users[0]);
            return null;
        }
    }

    public static class DeleteUsersAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDAO userDAO;

        private DeleteUsersAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDAO.delete(users[0]);
            return null;
        }
    }

    public static class DeleteAllUsersAsyncTask extends AsyncTask<Void, Void, Void>{
        private UserDAO userDAO;
        private DeleteAllUsersAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDAO.deleteAll();
            return null;
        }
    }
}