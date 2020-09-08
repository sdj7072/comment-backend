package com.skcc.market.eda.comment.core.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.skcc.market.eda.comment.core.command.DisplayYnUpdateCommentCommand;
import com.skcc.market.eda.comment.core.command.ModifyCommentCommand;
import com.skcc.market.eda.comment.core.command.WriteCommentCommand;
import com.skcc.market.eda.comment.core.event.CommentDisplayYnUpdateEvent;
import com.skcc.market.eda.comment.core.event.CommentModifyEvent;
import com.skcc.market.eda.comment.core.event.CommentWriteEvent;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aggregate
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class CommentAggregate {
	
	@AggregateIdentifier
	private String aggregateId;
	private Long commentId;
	private Long postId;
	private Long memberId;
	private String postType;
	private String content;
	private String displayYn;
	
	
	@CommandHandler
	public CommentAggregate(WriteCommentCommand command) {
		this.aggregateId = command.getAggregateId();
		apply(new CommentWriteEvent(command.getPostId(), command.getMemberId(), command.getPostType(), command.getContent(), command.getDisplayYn()));
	}
	
	@EventSourcingHandler
	public void on(CommentWriteEvent event) {
		this.postId = event.getPostId();
		this.memberId = event.getMemberId();
		this.postType = event.getPostType();
		this.content= event.getContent();
		this.displayYn = event.getDisplayYn();
	}
	
	@CommandHandler
	public CommentAggregate(ModifyCommentCommand command) {
		this.aggregateId = command.getAggregateId();
		apply(new CommentModifyEvent(command.getCommentId(), command.getPostType(), command.getContent()));
	}
	
	@EventSourcingHandler
	public void on(CommentModifyEvent event) {
		this.commentId = event.getCommentId();
		this.postType = event.getPostType();
		this.content= event.getContent();
	}
	
	@CommandHandler
	public CommentAggregate(DisplayYnUpdateCommentCommand command) {
		this.aggregateId = command.getAggregateId();
		apply(new CommentDisplayYnUpdateEvent(command.getCommentId(), command.getDisplayYn()));
	}
	
	@EventSourcingHandler
	public void on(CommentDisplayYnUpdateEvent event) {
		this.commentId = event.getCommentId();
		this.displayYn = event.getDiplayYn();
	}

}
