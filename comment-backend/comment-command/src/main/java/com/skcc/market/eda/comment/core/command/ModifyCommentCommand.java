package com.skcc.market.eda.comment.core.command;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ModifyCommentCommand {

	@TargetAggregateIdentifier
	private String aggregateId;
	private Long commentId;
	private String postType;
	private String content;
	private String displayYn;

	@Builder
	public ModifyCommentCommand(Long commentId, String postType, String content, String displayYn) {
		this.aggregateId = UUID.randomUUID().toString();
		this.commentId = commentId;
		this.postType = postType;
		this.content = content;
		this.displayYn = displayYn;
	}
}
