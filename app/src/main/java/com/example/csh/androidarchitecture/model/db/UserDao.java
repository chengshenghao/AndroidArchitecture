package com.example.csh.androidarchitecture.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

/*
* 这个组件代表一个作为Data Access Objec的类或者接口。DAO是Room的主要组件，
* 负责定义查询（添加或者删除等）数据库的方法。使用@Database注解的类必须包含一个0参数的，
* 返回类型为@Dao注解过的类的抽象方法。Room会在编译时生成这个类的实现。
* */

@Dao
    public interface UserDao {
        @Query("SELECT * FROM users")
        List<User> getAll();
     
        @Query("SELECT * FROM users WHERE uid IN (:userIds)")
        List<User> loadAllByIds(int[] userIds);
     
        @Query("SELECT * FROM users WHERE firstname LIKE :first AND "
               + "last_name LIKE :last LIMIT 1")
        User findByName(String first, String last);
     
        @Insert
        void insertAll(User... users);
     
        @Delete
        void delete(User user);
    }