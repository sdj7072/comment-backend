package com.skcc.market.eda.comment.infrastructure.persistent.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcc.market.eda.comment.core.domain.entity.CommentEntity;

public interface CommentQueryRepository extends JpaRepository<CommentEntity, Long> {
	
	Optional<CommentEntity> findById(Long commentId);
	
}
