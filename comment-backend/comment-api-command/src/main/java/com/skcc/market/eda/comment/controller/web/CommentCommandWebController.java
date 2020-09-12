package com.skcc.market.eda.comment.controller.web;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;
import com.skcc.market.eda.comment.core.application.service.CommentService;
import com.skcc.market.eda.comment.core.event.CommentModifyEvent;
import com.skcc.market.eda.comment.core.event.CommentWriteEvent;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Api(value = "Comment API")
@RestController
@RequestMapping("/v1/api/comment-command")
public class CommentCommandWebController {

	private final ModelMapper modelMapper;
	private final CommentService commentService;
	
	@ApiOperation(value = "댓글 작성")
	@PostMapping(value = "/comment/create")
	public ResponseEntity<Object> writeComment(@RequestBody CommentDTO commentDTO) throws Exception {
		
		CommentWriteEvent event = modelMapper.map(commentDTO, CommentWriteEvent.class);
		commentService.doWriteCommentService(event);
		
		return new ResponseEntity<Object>(event, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 수정")
	@PostMapping(value = "/comment/update")
	public ResponseEntity<Object> updateComment(@RequestBody CommentDTO commentDTO) throws Exception {
		
		CommentModifyEvent event = modelMapper.map(commentDTO, CommentModifyEvent.class);
		commentService.doModifyCommentService(event);
		
		return new ResponseEntity<Object>(event, HttpStatus.OK);
	}
}
