package com.hexaware.entity;

public class UserFavoriteArtwork {
	    //Attributes of UserFavoriteArtwork Class
	    private int userId;
	    private int artworkId;

	    // Constructor
	    public UserFavoriteArtwork(int userId, int artworkId) {
	        this.userId = userId;
	        this.artworkId = artworkId;
	    }

	    // Getters and Setters
	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public int getArtworkId() {
	        return artworkId;
	    }

	    public void setArtworkId(int artworkId) {
	        this.artworkId = artworkId;
	    }

	    @Override
	    public String toString() {
	        return "\nUserID: " + userId +
	               "\nArtworkID: " + artworkId;
	    }
	}
