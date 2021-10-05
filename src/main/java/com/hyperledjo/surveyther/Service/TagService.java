package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import com.hyperledjo.surveyther.DAO.TagDAO;
import com.hyperledjo.surveyther.DTO.Tag;

@Service
public class TagService {
	
	private TagDAO tagDAO;
	
	public TagService(TagDAO tagDAO) {
		this.tagDAO = tagDAO;
	}
	
	public int deleteTag(int id) {
		return tagDAO.deleteTag(id);
	}
	
	public int putTag(Tag tag) {
		return tagDAO.putTag(tag);
	}
	
	public int postTag(Tag tag) {
		return tagDAO.postTag(tag);
	}
	
	public List<Tag> getTagList(int id) {
		return tagDAO.getTagList(id);
	}
}
