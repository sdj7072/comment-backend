package com.skcc.market.eda.comment.core.application.object.command;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.skcc.market.eda.comment.core.application.object.core.domain.entity.CommentPostType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class WriteCommentCommand {

	@TargetAggregateIdentifier
	private String aggregateId;
	private Long postId;
	private Long memberId;
	private String postType;
	private String content;
	private String displayYn;

	@Builder
	public WriteCommentCommand(Long postId, Long memberId, String postType, String content) {
		this.aggregateId = UUID.randomUUID().toString();
		this.postId = postId;
		this.memberId = memberId;
		this.postType = postType;
		this.content = content;
		this.displayYn = "Y";
	}
}
