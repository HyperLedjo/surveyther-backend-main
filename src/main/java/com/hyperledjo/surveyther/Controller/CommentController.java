package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.DTO.Comment;
import com.hyperledjo.surveyther.Service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		// TODO Auto-generated constructor stub
		this.commentService = commentService;
	}
	
	@PutMapping("/comment")
	public int putComment(@RequestBody Comment comment) {
		return commentService.putComment(comment);
	}

	@DeleteMapping("/comment/{id}")
	public int deleteComment(@PathVariable("id") int id) {
		return commentService.deleteComment(id);
	}

	@PostMapping("/comment")
	public int postComment(@RequestBody Comment comment) {
		return commentService.postComment(comment);
	}

	@GetMapping("/comments/count/{id}")
	public int getCommentCount(@PathVariable("id") int id) {
		return commentService.getCommentCount(id);
	}

	
	@GetMapping("/comments/{id}")
	public List<Comment> getCommentListFromSurvey(@PathVariable("id") int id) {
		return commentService.getCommentListFromSurvey(id);
	}

	// id is comment's primary key
	@GetMapping("/comment/{id}")
	public Comment getComment(@PathVariable("id") int id) {
		return commentService.getComment(id);
	}

	@GetMapping("/comments")
	public List<Comment> getCommentList() {
		return commentService.getCommentList();
	}
}
