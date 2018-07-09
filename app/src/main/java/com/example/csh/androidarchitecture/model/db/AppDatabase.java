package com.example.csh.androidarchitecture.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
/*
*
* 你可以用这个组件来创建一个database holder。注解定义实体的列表，类的内容定义从数据库中获取数据的对象（DAO）。
* 它也是底层连接的主要入口。
* */
@Database(entities = {User.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract UserDao userDao();
    }