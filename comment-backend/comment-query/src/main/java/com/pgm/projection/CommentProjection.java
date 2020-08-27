package com.pgm.projection;

import java.time.Instant;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import com.pgm.core.event.CommentWriteEvent;
import com.pgm.entity.CommentEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@ProcessingGroup("comment")
public class CommentProjection {

	@EventHandler
	protected void on(CommentWriteEvent event, @Timestamp Instant instant) {
		CommentEntity commentEntity = CommentEntity.builder()
				.id(event.getCommentId())
				.build();
		System.out.println("Result : " + commentEntity.getId());
	}
}
