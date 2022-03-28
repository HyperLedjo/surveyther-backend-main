package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.DTO.Like;
import com.hyperledjo.surveyther.Service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@GetMapping("/likes/count/{id}")
	public int getLikedCount(@PathVariable("id") int id) {
		return likeService.getLikedCount(id);
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
