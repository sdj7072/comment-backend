package com.skcc.market.eda.comment.core.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class CommentWriteEvent {

	private Long postId;
	private Long memberId;
	private String postType;
	private String content;
	private String displayYn;

}