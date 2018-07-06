package com.example.csh.androidarchitecture;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.csh.androidarchitecture.model.db.AppDatabase;
import com.example.csh.androidarchitecture.model.db.User;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        User user = new User();
        user.setLastName("ss");
        user.setFirstName("sss");
        db.userDao().insertAll(user);
    }
}
