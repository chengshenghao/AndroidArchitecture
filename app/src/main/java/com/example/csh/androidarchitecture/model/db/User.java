package com.example.csh.androidarchitecture.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

/*
 * 这个组件代表一个持有数据库的一个表的类。对每一个entity，都会创建一个表来持有这些item。
 * 你必须在Database类中的entities数组中引用这些entity类。
 * entity中的每一个field都将被持久化到数据库，除非使用了@Ignore注解。
 * */
@Entity(tableName = "users")//默认数据库名是类名，添加此注解可以重新设置类名称
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    // Getters and setters are ignored for brevity,
    // but they're required for Room to work.
    /*
    * 不会创建相应列
    * */
    @Ignore
    Bitmap picture;
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}