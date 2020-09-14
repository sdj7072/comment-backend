package com.skcc.market.eda.comment.infrastructure.persistent.axon;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.skcc.market.eda.comment.core.application.object.command.DisplayYnUpdateCommentCommand;
import com.skcc.market.eda.comment.core.application.object.command.ModifyCommentCommand;
import com.skcc.market.eda.comment.core.application.object.command.WriteCommentCommand;
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
		log.debug("#Command : [WriteCommentCommand] 수신");
		
		this.aggregateId = command.getAggregateId();
		apply(new CommentWriteEvent(command.getPostId(),
				command.getMemberId(),
				command.getPostType(),
				command.getContent(),
				command.getDisplayYn()));
		
		log.debug("#Event : [CommentWriteEvent] 송신");
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
		log.debug("#Command : [ModifyCommentCommand] 수신");
		
		this.aggregateId = command.getAggregateId();
		apply(new CommentModifyEvent(command.getCommentId(),
				command.getMemberId(),
				command.getContent()));
		
		log.debug("#Event : [CommentModifyEvent] 송신");
	}
	
	@EventSourcingHandler
	public void on(CommentModifyEvent event) {
		this.commentId = event.getCommentId();
		this.memberId = event.getMemberId();
		this.content= event.getContent();
	}
	
	@CommandHandler
	public CommentAggregate(DisplayYnUpdateCommentCommand command) {
		log.debug("#Command : [DisplayYnUpdateCommentCommand] 수신");
		
		this.aggregateId = command.getAggregateId();
		apply(new CommentDisplayYnUpdateEvent(command.getCommentId(),
				command.getMemberId(),
				command.getDisplayYn()));
		
		log.debug("#Event : [CommentDisplayYnUpdateEvent] 송신");
	}
	
	@EventSourcingHandler
	public void on(CommentDisplayYnUpdateEvent event) {
		this.commentId = event.getCommentId();
		this.memberId = event.getMemberId();
		this.displayYn = event.getDisplayYn();
	}

}
