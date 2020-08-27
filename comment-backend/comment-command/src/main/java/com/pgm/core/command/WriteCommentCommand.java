package com.pgm.core.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class WriteCommentCommand {

	@TargetAggregateIdentifier
	private final Long commentId;
	
	public WriteCommentCommand(Long commentId) {
		this.commentId = commentId;
	}
	
	public Long getCommentId() {
		return commentId;
	}
}
