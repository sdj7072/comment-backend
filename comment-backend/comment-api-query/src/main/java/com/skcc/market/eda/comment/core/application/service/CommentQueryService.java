package com.skcc.market.eda.comment.core.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
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
	private final QueryGateway queryGateway;
	
	@Autowired
	CommentQueryRepository commentQueryRepository;
	
	@Override
	public CommentDTO getCommentByCommentId(Long commentId) throws Exception {
		
		CommentEntity commentEntity = queryGateway.query("findCommentByCommentId",commentId, ResponseTypes.instanceOf(CommentEntity.class)).join();
		CommentDTO commentDTO = modelMapper.map(commentEntity, CommentDTO.class);
		
		return commentDTO;
	}

	@Override
	public List<CommentDTO> getCommnetListByMemberId(Long memberId) throws Exception {
		
		List<CommentEntity> commentEntityList = queryGateway.query("findCommentListByMemberId", memberId, ResponseTypes.multipleInstancesOf(CommentEntity.class)).join();
		
		List<CommentDTO> commentDTOList = commentEntityList.stream()
				.map(commentEntity -> modelMapper.map(commentEntity, CommentDTO.class))
				.collect(Collectors.toList());
		
		return commentDTOList;
	}

	@Override
	public List<CommentDTO> getCommnetListByPostId(Long postId) throws Exception {

		List<CommentEntity> commentEntityList = queryGateway.query("findCommentListByPostId", postId, ResponseTypes.multipleInstancesOf(CommentEntity.class)).join();
		
		List<CommentDTO> commentDTOList = commentEntityList.stream()
				.map(commentEntity -> modelMapper.map(commentEntity, CommentDTO.class))
				.collect(Collectors.toList());
		
		return commentDTOList;
	}

}
