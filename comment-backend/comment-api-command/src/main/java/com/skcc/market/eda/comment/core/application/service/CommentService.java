package com.skcc.market.eda.comment.core.application.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.skcc.market.eda.comment.core.application.object.command.ModifyCommentCommand;
import com.skcc.market.eda.comment.core.application.object.command.WriteCommentCommand;
import com.skcc.market.eda.comment.core.event.CommentModifyEvent;
import com.skcc.market.eda.comment.core.event.CommentWriteEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService implements ICommentService {
	
	private final CommandGateway commandGateway;
	
	@Override
	public void doWriteCommentService(CommentWriteEvent event) throws Exception {
		
		commandGateway.send(WriteCommentCommand.builder()
				.postId(event.getPostId())
				.memberId(event.getMemberId())
				.postType(event.getPostType())
				.content(event.getContent())
				.build());
	}
	
	@Override
	public void doModifyCommentService(CommentModifyEvent event) throws Exception {
		
		commandGateway.send(ModifyCommentCommand.builder()
				.commentId(event.getCommentId())
				.postType(event.getPostType())
				.content(event.getContent())
				.build());
	}

}
