package com.skcc.market.eda.comment.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcc.market.eda.comment.core.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
