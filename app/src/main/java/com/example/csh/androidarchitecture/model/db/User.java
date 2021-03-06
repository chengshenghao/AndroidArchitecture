package com.example.csh.androidarchitecture.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import com.example.csh.androidarchitecture.model.db.entity.Address;

/*
 * 这个组件代表一个持有数据库的一个表的类。对每一个entity，都会创建一个表来持有这些item。
 * 你必须在Database类中的entities数组中引用这些entity类。
 * entity中的每一个field都将被持久化到数据库，除非使用了@Ignore注解。
 * */


/*
 * 某个字段或者几个字段必须是唯一的。你可以通过把@Index注解的unique属性设置为true来实现唯一性。
 * 下面的代码防止了一个表中的两行数据出现firstName和lastName字段的值相同的情况：
 * indices = {@Index(value = {"firstName","last_name"},unique = true)}
 * */
@Entity(tableName = "users")//默认数据库名是类名，添加tableName注解可以重新设置类名称
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String firstName;

    @ColumnInfo(name = "last_name")//默认列名为此属性名，column可以通过添加name修改名称
    private String lastName;

    @Embedded
    public Address address;


    //不会创建相应列
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}