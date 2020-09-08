package com.skcc.market.eda.comment.core.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class CommentDisplayYnUpdateEvent {

	private Long commentId;
	private String diplayYn;

}