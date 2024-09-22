package com.example.test.model;

public class PostDTO {
    private int id;
    private String title;
    private String description;
    private String picture;
    private int ownerId;
    private String ownerFirstname;
    private String ownerLastname;
    private String ownerPicture;
    private int ownerYears;

    public PostDTO(Post post, User owner) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.picture = post.getPicture();
        this.ownerId = post.getOwner();
        if (owner != null) {
            this.ownerFirstname = owner.getFirstname();
            this.ownerLastname = owner.getLastname();
            this.ownerYears = owner.getYears();
            this.ownerPicture=owner.getPicture();
        }
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerFirstname() {
        return ownerFirstname;
    }

    public void setOwnerFirstname(String ownerFirstname) {
        this.ownerFirstname = ownerFirstname;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }

    public String getOwnerPicture() {
        return ownerPicture;
    }

    public void setOwnerPicture(String ownerPicture) {
        this.ownerPicture = ownerPicture;
    }

    public int getOwnerYears() {
        return ownerYears;
    }

    public void setOwnerYears(int ownerYears) {
        this.ownerYears = ownerYears;
    }
}
