package com.pgm.core.event;

import lombok.NonNull;

public class CommentWriteEvent {

	private final Long commentId;
	
	public CommentWriteEvent(Long commentId) {
		this.commentId = commentId;
	}
	
	public Long getCommentId() {
		return commentId;
	}
	
}
