package com.skcc.market.eda.comment.core.application.object.dto;

import java.time.LocalDateTime;

import com.skcc.market.eda.comment.core.application.object.core.domain.entity.CommentPostType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CommentDTO {
	private Long commentId;
	private Long postId;
	private Long memberId;
	private CommentPostType postType;
	private String content;
	private String displayYn;
	private LocalDateTime registerTime; 
	private LocalDateTime updateTime;
	
	@Builder
	CommentDTO(Long commentId, Long postId, Long memberId, CommentPostType postType, String content, String displayYn) {
		this.commentId = commentId;
		this.postId = postId;
		this.memberId = memberId;
		this.postType = postType;
		this.content = content;
		this.displayYn = displayYn;
	}
}
