package org.example.entity;

import java.util.List;

public class Comments {

    private int id;
    private String comment;
    private List<Plants> plants;
    private List<UserApp> userApp;

    public Comments(int id, String comment, List<Plants> plants, List<UserApp> userApp) {
        this.id = id;
        this.comment = comment;
        this.plants = plants;
        this.userApp = userApp;
    }

    public Comments(int id, String comment, List<UserApp> userApp) {
        this.id = id;
        this.comment = comment;
        this.userApp = userApp;
    }

    public Comments(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Comments(String comment, List<UserApp> userApp) {
        this.comment = comment;
        this.userApp = userApp;
    }

    public Comments(String comment) {
        this.comment = comment;
    }

    public Comments() {
    }

    public Comments(String comment, int plantId, int userId) {
        this.comment = comment;
        this.plants = plants;
        this.userApp = userApp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Plants> getPlants() {
        return plants;
    }

    public void setPlants(List<Plants> plants) {
        this.plants = plants;
    }

    public List<UserApp> getUserApp() {
        return userApp;
    }

    public void setUserApp(List<UserApp> userApp) {
        this.userApp = userApp;
    }
}
