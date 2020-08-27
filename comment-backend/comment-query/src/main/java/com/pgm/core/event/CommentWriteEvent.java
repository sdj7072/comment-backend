	package com.pgm.core.event;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentWriteEvent {

	@TargetAggregateIdentifier
	private final Long commentId;
	
	public CommentWriteEvent(Long commentId) {
		this.commentId = commentId;
	}
	
}
