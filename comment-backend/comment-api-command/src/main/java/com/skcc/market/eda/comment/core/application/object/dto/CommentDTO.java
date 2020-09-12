package com.skcc.market.eda.comment.core.application.object.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {
	private Long commentId;
	private Long postId;
	private Long memberId;
	private String postType;
	private String content;
	private String displayYn;
	private LocalDateTime registerTime; 
	private LocalDateTime updateTime;
	
	@Builder
	CommentDTO(Long commentId, Long postId, Long memberId, String postType, String content, String displayYn) {
		this.commentId = commentId;
		this.postId = postId;
		this.memberId = memberId;
		this.postType = postType;
		this.content = content;
		this.displayYn = displayYn;
	}
}
