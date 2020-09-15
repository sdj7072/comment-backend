package com.skcc.market.eda.comment.core.application.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.skcc.market.eda.comment.core.application.object.command.DisplayYnUpdateCommentCommand;
import com.skcc.market.eda.comment.core.application.object.command.ModifyCommentCommand;
import com.skcc.market.eda.comment.core.application.object.command.WriteCommentCommand;
import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;
import com.skcc.market.eda.comment.core.event.CommentDisplayYnUpdateEvent;
import com.skcc.market.eda.comment.core.event.CommentModifyEvent;
import com.skcc.market.eda.comment.core.event.CommentWriteEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentCommandService implements ICommentCommandService {
	
	private final ModelMapper modelMapper;
	private final CommandGateway commandGateway;
	
	@Override
	public void doWriteCommentCommandService(CommentDTO commentDTO) throws Exception {
		
		CommentWriteEvent event = modelMapper.map(commentDTO, CommentWriteEvent.class);
		event.setPostType(commentDTO.getPostType().name());
		
		commandGateway.send(WriteCommentCommand.builder()
				.postId(event.getPostId())
				.memberId(event.getMemberId())
				.postType(event.getPostType())
				.content(event.getContent())
				.build());
	}
	
	@Override
	public void doModifyCommentCommandService(CommentDTO commentDTO) throws Exception {
		
		CommentModifyEvent event = modelMapper.map(commentDTO, CommentModifyEvent.class);
		
		commandGateway.send(ModifyCommentCommand.builder()
				.commentId(event.getCommentId())
				.memberId(event.getMemberId())
				.content(event.getContent())
				.build());
	}

	@Override
	public void doShowCommentCommandService(CommentDTO commentDTO) throws Exception {
		
		CommentDisplayYnUpdateEvent event = modelMapper.map(commentDTO, CommentDisplayYnUpdateEvent.class);
		
		commandGateway.send(DisplayYnUpdateCommentCommand.builder()
				.commentId(event.getCommentId())
				.memberId(event.getMemberId())
				.displayYn("Y")
				.build());
	}

	@Override
	public void doHideCommentCommandService(CommentDTO commentDTO) throws Exception {
		
		CommentDisplayYnUpdateEvent event = modelMapper.map(commentDTO, CommentDisplayYnUpdateEvent.class);
		
		commandGateway.send(DisplayYnUpdateCommentCommand.builder()
				.commentId(event.getCommentId())
				.memberId(event.getMemberId())
				.displayYn("N")
				.build());
	}

}
