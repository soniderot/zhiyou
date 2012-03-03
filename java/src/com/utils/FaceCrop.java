package com.utils;

public class FaceCrop {
    
    private long photoId;
    private float centreX;
    private float centreY;
    private double width;
    private double height;
    private boolean multi;
    
    public boolean isMulti() {
		return multi;
	}

	public void setMulti(boolean multi) {
		this.multi = multi;
	}

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public float getCentreX() {
		return centreX;
	}

	public float getCentreY() {
		return centreY;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public void setCentreX(float centreX) {
		this.centreX = centreX;
	}

	public void setCentreY(float centreY) {
		this.centreY = centreY;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}


}