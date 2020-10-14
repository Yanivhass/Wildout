package com.example.yaniv.wildout4;

public class Club {

    String name, region, age, genre;
    byte[] img;

    public Club(String name, String region, String age, String genre,  byte[] img) {

        this.name = name;
        this.region = region;
        this.age = age;
        this.genre = genre;
        this.img = img;
    }

    public Club() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}

