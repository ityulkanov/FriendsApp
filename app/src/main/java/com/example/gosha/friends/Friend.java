package com.example.gosha.friends;

/**
 * Created by GOSHA on 2/11/2016.
 */
public class Friend {
    private int _id;
    private String name;
    private String phone;
    private String email;

    public Friend(int _id, String email, String name, String phone) {
        this._id = _id;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
