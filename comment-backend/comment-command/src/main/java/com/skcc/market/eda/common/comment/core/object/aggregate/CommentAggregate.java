package com.skcc.market.eda.common.comment.core.object.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.skcc.market.eda.common.comment.core.object.command.WriteCommentCommand;
import com.skcc.market.eda.common.comment.core.object.event.CommentWriteEvent;

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

}
