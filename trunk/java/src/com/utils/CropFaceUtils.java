package com.utils;

import java.util.List;

import com.github.mhendred.face4j.DefaultFaceClient;
import com.github.mhendred.face4j.FaceClient;
import com.github.mhendred.face4j.exception.FaceClientException;
import com.github.mhendred.face4j.exception.FaceServerException;
import com.github.mhendred.face4j.model.Face;
import com.github.mhendred.face4j.model.Photo;

public class CropFaceUtils {

	private static final String API_KEY = "29e317749626d2afc1f76ba49ac4f5b7";
	
	private static final String API_SEC = "510949d529e26608c79e82a7836f86b9";

	private static FaceClient faceClient = null;
	
	static {
		faceClient = new DefaultFaceClient(API_KEY, API_SEC);
	}
	
	public static List<Face> getFaces(String imgSrc) {
		Photo photo = null;
		try {
			photo = faceClient.detect(imgSrc).get(0);
		} catch (FaceClientException e) {
			e.printStackTrace();
		} catch (FaceServerException e) {
			e.printStackTrace();
		}
		if (photo != null) {
			return photo.getFaces();
		} else {
			return null;
		}
	}
	
	public static Face getFirstFace(String imgSrc) {
		Photo photo = null;
		try {
			photo = faceClient.detect(imgSrc).get(0);
		} catch (FaceClientException e) {
			e.printStackTrace();
		} catch (FaceServerException e) {
			e.printStackTrace();
		}
		if (photo != null && photo.getFaces() != null&&photo.getFaces().size() > 0) {
			return photo.getFaces().get(0);
		} else {
			return null;
		}
	}
	
	public static int getFaceCount(String imgSrc) {
		Photo photo = null;
		try {
			photo = faceClient.detect(imgSrc).get(0);
		} catch (FaceClientException e) {
			e.printStackTrace();
		} catch (FaceServerException e) {
			e.printStackTrace();
		}
		if (photo != null && photo.getFaces() != null) {
			return photo.getFaces().size();
		} else {
			return 0;
		}
	}
}