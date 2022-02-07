package com.example.projects.entity;

public class FeedItem {
    private String Username = null;
    private String UserImage = null;
    private String PostText = null;

    public FeedItem(String username, String userImage, String postText) {
        Username = username;
        UserImage = userImage;
        PostText = postText;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUserImage() {
        return UserImage;
    }

    public void setUserImage(String userImage) {
        UserImage = userImage;
    }

    public String getPostText() {
        return PostText;
    }

    public void setPostText(String postText) {
        PostText = postText;
    }
}
