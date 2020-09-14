package com.skcc.market.eda.comment.core.application.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.market.eda.comment.core.application.object.core.domain.entity.CommentPostType;
import com.skcc.market.eda.comment.core.domain.entity.CommentEntity;
import com.skcc.market.eda.comment.core.event.CommentDisplayYnUpdateEvent;
import com.skcc.market.eda.comment.core.event.CommentModifyEvent;
import com.skcc.market.eda.comment.core.event.CommentWriteEvent;
import com.skcc.market.eda.comment.infrastructure.persistent.jpa.CommentProjectionRepository;
import com.skcc.market.eda.comment.infrastructure.persistent.jpa.CommentQueryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentProjectionService implements ICommentProjectionService {
	
	@Autowired
	CommentProjectionRepository commentProjectionRepository;
	
	@Autowired
	CommentQueryRepository commentQueryRepository;
	
	@Override
	public void doWriteCommentProjectionService(CommentWriteEvent event) throws Exception {
		CommentEntity commentEntity = CommentEntity.builder()
				.postId(event.getPostId())
				.memberId(event.getMemberId())
				.postType(CommentPostType.valueOf(event.getPostType()))
				.content(event.getContent())
				.displayYn(event.getDisplayYn())
				.registerTime(LocalDateTime.now())
				.updateTime(LocalDateTime.now())
				.build();
		
		commentProjectionRepository.save(commentEntity);
	}
	
	@Override
	public void doModifyCommentProjectionService(CommentModifyEvent event) throws Exception {
		
		CommentEntity commentEntity = commentQueryRepository.findById(event.getCommentId()).get();
		BeanUtils.copyProperties(event, commentEntity);
		commentEntity.setUpdateTime(LocalDateTime.now());
		commentProjectionRepository.save(commentEntity);
	}
	
	@Override
	public void doDisplayYnUpdateCommentProjectionService(CommentDisplayYnUpdateEvent event) throws Exception {
		
		CommentEntity commentEntity = commentQueryRepository.findById(event.getCommentId()).get();
		BeanUtils.copyProperties(event, commentEntity);
		commentEntity.setUpdateTime(LocalDateTime.now());
		commentProjectionRepository.save(commentEntity);
	}
	
}
