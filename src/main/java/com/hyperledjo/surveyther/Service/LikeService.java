package com.hyperledjo.surveyther.Service;

import com.hyperledjo.surveyther.DAO.LikeDAO;
import com.hyperledjo.surveyther.DAO.SurveyDAO;
import com.hyperledjo.surveyther.DTO.Like;
import com.hyperledjo.surveyther.DTO.TransferLikes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
	private LikeDAO likeDAO;
	private SurveyDAO surveyDAO;

	public LikeService(LikeDAO likeDAO, SurveyDAO surveyDAO) {
		this.likeDAO = likeDAO;
		this.surveyDAO = surveyDAO;
	}

	public int dislike(Like like) {
		TransferLikes tl = new TransferLikes();
		tl.setSurveyId(like.getSurveyId());

		int result = likeDAO.dislike(like);
		if (result < 1)
			return -1;

		int count = likeDAO.getLikedCount(like.getSurveyId());
		tl.setLikes(count);
		result = surveyDAO.updateLikes(tl);
		
		if (result < 1)
			return 0;

		return 1;
	}

	public int like(Like like) {
		TransferLikes tl = new TransferLikes();
		tl.setSurveyId(like.getSurveyId());

		int result = likeDAO.like(like);
		if (result < 1)
			return -1;

		int count = likeDAO.getLikedCount(like.getSurveyId());
		tl.setLikes(count);
		result = surveyDAO.updateLikes(tl);
		if (result < 1)
			return 0;

		return 1;
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
