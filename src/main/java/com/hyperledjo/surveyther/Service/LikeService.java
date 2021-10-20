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

	public int dislike(Like like) {
		return likeDAO.dislike(like);
	}

	public int like(Like like) {
		return likeDAO.like(like);
	}

	public int getLikedCount(int id) {
		return likeDAO.getLikedCount(id);
	}

	public Like getMyLike(Like like) {
		return likeDAO.getMyLike(like);
	}

	public List<Like> getLikeFromSurvey(int id) {
		return likeDAO.getLikeFromSurvey(id);
	}

	public List<Like> getLikeList() {
		return likeDAO.getLikeList();
	}
}
