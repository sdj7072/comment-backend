package com.skcc.market.eda.comment.infrastructure.persistent.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcc.market.eda.comment.core.domain.entity.CommentEntity;

public interface CommentProjectionRepository extends JpaRepository<CommentEntity, Long> {
	
}
