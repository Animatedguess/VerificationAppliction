package com.example.verificationappliction;

public class Post {
    String name;
    String age;
    String gmail;
    String password;
    String percentage;

    public Post() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gmail='" + gmail + '\'' +
                ", password='" + password + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }
}
