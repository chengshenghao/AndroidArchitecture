package com.example.csh.androidarchitecture;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.csh.androidarchitecture.model.db.AppDatabase;
import com.example.csh.androidarchitecture.model.db.User;
import com.example.csh.androidarchitecture.model.db.entity.Address;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setLastName("s" + i);
            user.setFirstName("sss" + i);
            Address address = new Address();
            address.city = "天津";
            address.postCode = 10;
            address.state = "直辖市";
            address.street = "华苑";
            user.setAddress(address);
            db.userDao().insertAll(user);
            List<User> users =  db.userDao().getuid();
            List<User> userstwo =  db.userDao().getfirstName("sss0");
            db.userDao().update("新技术产业园区",2);
            for (User usera : users) {
                Log.i("sss", "onCreate: "+usera.getUid());
                db.userDao().delete(usera);
            }
            for (User usera : userstwo) {
                Log.i("sss", "onCreate: "+usera.getUid());
                db.userDao().delete(usera);
            }
        }
    }
}
