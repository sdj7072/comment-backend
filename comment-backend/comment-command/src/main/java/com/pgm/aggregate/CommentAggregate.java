package com.pgm.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.pgm.core.command.WriteCommentCommand;
import com.pgm.core.event.CommentWriteEvent;

@Aggregate
public class CommentAggregate {
	
	@AggregateIdentifier
	private Long commentId;
	
	@CommandHandler
	public CommentAggregate(WriteCommentCommand command) {
		apply(new CommentWriteEvent(command.getCommentId()));
	}
	
	@EventSourcingHandler
	public void on(CommentWriteEvent event) {
		this.commentId = event.getCommentId();
	}

	protected CommentAggregate() {
		
	}

}
