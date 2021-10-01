package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.LikeDAO;
import com.hyperledjo.surveyther.DTO.Like;

@Service
public class LikeService {
	private LikeDAO likeDAO;

	public LikeService(LikeDAO likeDAO) {
		this.likeDAO = likeDAO;
	}

	public int dislike() {
		return 0;
	}

	public int like() {
		return 0;
	}

	public int getLikedCount() {
		return 0;
	}

	public Like getLiked() {
		return null;
	}

	public List<Like> getLikedList() {
		return null;
	}
}
