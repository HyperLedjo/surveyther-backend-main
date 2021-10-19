package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Like;
import com.hyperledjo.surveyther.Service.LikeService;

@RestController
@RequestMapping("/api")
public class LikeController {

	private LikeService likeService;

	public LikeController(LikeService likeService) {
		// TODO Auto-generated constructor stub
		this.likeService = likeService;
	}

	@PutMapping("/dislike")
	public int dislike(@RequestBody Like like) {
		return likeService.dislike(like);
	}

	@PostMapping("/like")
	public int like(@RequestBody Like like) {
		return likeService.like(like);
	}

	@GetMapping("/likes/count")
	public int getLikedCount() {
		return likeService.getLikedCount();
	}

	@PostMapping("/likes/me")
	public Like getMyLike(@RequestBody Like like) {
		return likeService.getMyLike(like);
	}

	@GetMapping("/likes/{id}")
	public List<Like> getLikeFromSurvey(@PathVariable("id") int id) {
		return likeService.getLikeFromSurvey(id);
	}

	@GetMapping("/likes")
	public List<Like> getLikeList() {
		return likeService.getLikeList();
	}
}
