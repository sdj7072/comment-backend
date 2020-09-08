package com.skcc.market.eda.common.comment.core.object.projection;

import java.time.Instant;
import java.time.LocalDateTime;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skcc.market.eda.common.comment.core.object.entity.CommentEntity;
import com.skcc.market.eda.common.comment.core.object.event.CommentWriteEvent;
import com.skcc.market.eda.common.comment.core.object.repository.CommentRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@ProcessingGroup("comment")
public class CommentProjection {
	
	@Autowired
	CommentRepository commentRepository;

	@EventHandler
	protected void on(CommentWriteEvent event, @Timestamp Instant instant) {
		
		System.out.println("hello event");
		
		CommentEntity commentEntity = CommentEntity.builder()
				.postId(event.getPostId())
				.memberId(event.getMemberId())
				.postType(event.getPostType())
				.content(event.getContent())
				.displayYn(event.getDisplayYn())
				.registerTime(LocalDateTime.now())
				.updateTime(LocalDateTime.now())
				.build();
		
		System.out.println("Result : " + commentEntity.getPostId());
		
		commentRepository.save(commentEntity);
	}
}
