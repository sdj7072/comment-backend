package com.pgm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgm.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

	public Optional<CommentEntity> findById(String commentId);
	
}
