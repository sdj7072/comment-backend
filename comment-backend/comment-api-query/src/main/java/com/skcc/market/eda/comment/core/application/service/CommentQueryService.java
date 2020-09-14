package com.skcc.market.eda.comment.core.application.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;
import com.skcc.market.eda.comment.core.domain.entity.CommentEntity;
import com.skcc.market.eda.comment.infrastructure.persistent.jpa.CommentQueryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentQueryService implements ICommentQueryService {
	
	private final ModelMapper modelMapper;
	
	@Autowired
	CommentQueryRepository commentQueryRepository;
	
	@Override
	public CommentDTO getCommentByCommentId(Long commentId) throws Exception {
		
		CommentEntity commentEntity = commentQueryRepository.findById(commentId).get();
		
		CommentDTO commentDTO = modelMapper.map(commentEntity, CommentDTO.class);
		
		return commentDTO;
	}

}
