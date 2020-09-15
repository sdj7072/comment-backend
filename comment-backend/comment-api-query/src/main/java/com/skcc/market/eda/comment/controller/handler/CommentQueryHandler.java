package com.skcc.market.eda.comment.controller.handler;

import java.util.List;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skcc.market.eda.comment.core.domain.entity.CommentEntity;
import com.skcc.market.eda.comment.infrastructure.persistent.jpa.CommentQueryRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@ProcessingGroup("comment-query")
public class CommentQueryHandler {
	
	@Autowired
	CommentQueryRepository commentQueryRepository;
	
	@QueryHandler(queryName = "findCommentByCommentId")
	public CommentEntity findCommentByCommentId(Long commentId) {
		return (commentQueryRepository.findById(commentId)).get();
	}
	
	@QueryHandler(queryName = "findCommentListByMemberId")
	public List<CommentEntity> findCommentListByMemberId(Long memberId) {
		return commentQueryRepository.findByMemberId(memberId);
	}
	
	@QueryHandler(queryName = "findCommentListByPostId")
	public List<CommentEntity> findCommentListByPostId(Long postId) {
		return commentQueryRepository.findByPostId(postId);
	}
	
}
