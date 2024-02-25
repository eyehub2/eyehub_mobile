package com.android.example.eyehub_proto.pojo;

import java.util.Date;

public class UserData {
    DataClass data;
    SupportClass support;

    public DataClass getData() {
        return data;
    }

    public void setData(DataClass data) {
        this.data = data;
    }

    public SupportClass getSupport() {
        return support;
    }

    public void setSupport(SupportClass support) {
        this.support = support;
    }

    public static class DataClass{
        String _id,username,password,email,gender,location;
        Date subscription_start_date,birthday,subscription_end_date;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Date getSubscription_start_date() {
            return subscription_start_date;
        }

        public void setSubscription_start_date(Date subscription_start_date) {
            this.subscription_start_date = subscription_start_date;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public Date getSubscription_end_date() {
            return subscription_end_date;
        }

        public void setSubscription_end_date(Date subscription_end_date) {
            this.subscription_end_date = subscription_end_date;
        }
    }
    class SupportClass{
        String url,text;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
