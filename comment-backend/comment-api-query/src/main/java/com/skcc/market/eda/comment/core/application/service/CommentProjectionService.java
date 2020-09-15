package com.skcc.market.eda.comment.core.application.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;
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
	
	private final ModelMapper modelMapper;
	
	@Autowired
	CommentQueryService commentQueryService;
	
	@Autowired
	CommentProjectionRepository commentProjectionRepository;
	
	@Autowired
	CommentQueryRepository commentQueryRepository;
	
	@Override
	public void doWriteCommentProjectionService(CommentWriteEvent event) throws Exception {
		
		CommentEntity commentEntity = modelMapper.map(event, CommentEntity.class);
		commentEntity.setRegisterTime(LocalDateTime.now());
		commentEntity.setUpdateTime(LocalDateTime.now());
		
		commentProjectionRepository.save(commentEntity);
	}
	
	@Override
	public void doModifyCommentProjectionService(CommentModifyEvent event) throws Exception {
		
		CommentDTO commentDTO = commentQueryService.getCommentByCommentId(event.getCommentId());
		
		CommentEntity commentEntity = modelMapper.map(commentDTO, CommentEntity.class);
		BeanUtils.copyProperties(event, commentEntity);
		commentEntity.setUpdateTime(LocalDateTime.now());
		
		commentProjectionRepository.save(commentEntity);
	}
	
	@Override
	public void doDisplayYnUpdateCommentProjectionService(CommentDisplayYnUpdateEvent event) throws Exception {
		
		CommentDTO commentDTO = commentQueryService.getCommentByCommentId(event.getCommentId());
		
		CommentEntity commentEntity = modelMapper.map(commentDTO, CommentEntity.class);
		BeanUtils.copyProperties(event, commentEntity);
		commentEntity.setUpdateTime(LocalDateTime.now());
		
		commentProjectionRepository.save(commentEntity);
	}
	
}
