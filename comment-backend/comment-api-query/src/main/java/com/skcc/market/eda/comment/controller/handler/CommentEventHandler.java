package com.skcc.market.eda.comment.controller.handler;

import java.time.Instant;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import com.skcc.market.eda.comment.core.application.service.CommentProjectionService;
import com.skcc.market.eda.comment.core.event.CommentDisplayYnUpdateEvent;
import com.skcc.market.eda.comment.core.event.CommentModifyEvent;
import com.skcc.market.eda.comment.core.event.CommentWriteEvent;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@ProcessingGroup("comment-event")
public class CommentEventHandler {
	
	private final CommentProjectionService commentProjectionService;
	
	@EventHandler
	protected void on(CommentWriteEvent event, @Timestamp Instant instant) {
		try {
			commentProjectionService.doWriteCommentProjectionService(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@EventHandler
	protected void on(CommentModifyEvent event, @Timestamp Instant instant) {
		try {
			commentProjectionService.doModifyCommentProjectionService(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@EventHandler
	protected void on(CommentDisplayYnUpdateEvent event, @Timestamp Instant instant) {
		try {
			commentProjectionService.doDisplayYnUpdateCommentProjectionService(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
