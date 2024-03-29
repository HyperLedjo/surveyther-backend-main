package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.DTO.Tag;
import com.hyperledjo.surveyther.Service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {

	private TagService tagService;

	public TagController(TagService tagService) {
		// TODO Auto-generated constructor stub
		this.tagService = tagService;
	}

	@PostMapping("/tag")
	public int postTag(@RequestBody List<Tag> tags) {
		if (tags.isEmpty())
			return -1;
		for (Tag tag : tags) {
			int result = tagService.postTag(tag);
			if (result < 1) {
				return 0;
			}
		}
		return 1;
	}

	@GetMapping("/tag/{id}")
	public List<Tag> getTagList(@PathVariable("id") int id) {
		// id is survey's primary key
		return tagService.getTagList(id);
	}
}
