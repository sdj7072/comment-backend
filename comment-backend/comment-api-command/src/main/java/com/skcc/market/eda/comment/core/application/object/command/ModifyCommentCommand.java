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
public class ModifyCommentCommand {

	@TargetAggregateIdentifier
	private String aggregateId;
	private Long commentId;
	private Long memberId;
	private String content;

	@Builder
	public ModifyCommentCommand(Long commentId, Long postId, Long memberId, String postType, String content, String displayYn) {
		this.aggregateId = UUID.randomUUID().toString();
		this.memberId = memberId;
		this.content = content;
	}
}
