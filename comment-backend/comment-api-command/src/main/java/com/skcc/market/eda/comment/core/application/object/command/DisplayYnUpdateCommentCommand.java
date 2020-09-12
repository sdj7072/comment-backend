package com.skcc.market.eda.comment.core.application.object.command;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DisplayYnUpdateCommentCommand {

	@TargetAggregateIdentifier
	private String aggregateId;
	private Long commentId;
	private String displayYn;

	@Builder
	public DisplayYnUpdateCommentCommand(Long commentId, String displayYn) {
		this.aggregateId = UUID.randomUUID().toString();
		this.commentId = commentId;
		this.displayYn = displayYn;
	}
}
