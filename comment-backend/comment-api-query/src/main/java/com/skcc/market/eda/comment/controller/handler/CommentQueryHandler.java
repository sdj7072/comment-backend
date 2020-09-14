package com.skcc.market.eda.comment.controller.handler;

import java.util.Optional;

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
	
	@QueryHandler(queryName = "findByCommentId")
	public Optional<CommentEntity> on(Long commentId) {
		return commentQueryRepository.findById(commentId);
	}
	
}
