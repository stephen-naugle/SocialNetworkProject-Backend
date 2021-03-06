package com.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dao.CommentDao;
import com.web.model.Comment;

@Service
public class CommentService {

	private CommentDao cd;
	@Autowired
	public void setCd(CommentDao cd) {
		this.cd = cd;
	}
	
	/**
	 * finds all comments by post ID
	 * @return list of comments related to specified post ID
	 */
	public List<Comment> findAllByPost(int pid) {
		return cd.findAll().stream()
				.filter(c -> c.getPostId() == pid)
				.collect(Collectors.toList());
	}
	
	/**
	 * finds comment by its ID
	 * @param id unique identifier for comment
	 * @return
	 */
	public Comment findById(int id) {
		return cd.findById(id);
	}
	
	/**
	 * updates comment information
	 * @param comment Comment object with updated information
	 * @return updated comment if successful, null if not
	 */
	public Comment updateComment(Comment comment) {
		return cd.update(comment);
	}
	
	/**
	 * creates a comment
	 * @param comment Comment object with created information
	 * @return created comment if successful, null if not
	 */
	
	public Comment createComment(Comment comment) {
		return cd.save(comment);
	}
	
	/**
	 * deletes a comment from the DB
	 * @param id unique identifier for the comment
	 * @return deleted comment if exists, null if it does not
	 */
	public Comment deleteComment(Comment comment) {
		return cd.delete(comment);
	}
}
