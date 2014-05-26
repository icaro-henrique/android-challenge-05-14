package com.example.android_challenge_05_14.app;

/**
 * Created by lis on 26/05/2014.
 */
public class Profile {
    private String name;
    private String job;
    private String image;

    public Profile(String name,String job,String image){
        this.name = name;
        this.job = job;
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
