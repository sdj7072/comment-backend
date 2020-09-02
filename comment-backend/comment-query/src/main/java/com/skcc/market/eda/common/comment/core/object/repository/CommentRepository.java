package com.skcc.market.eda.common.comment.core.object.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcc.market.eda.common.comment.core.object.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

	public Optional<CommentEntity> findById(String commentId);
	
}
