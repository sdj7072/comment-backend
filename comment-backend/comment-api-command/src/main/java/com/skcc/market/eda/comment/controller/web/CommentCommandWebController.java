package com.skcc.market.eda.comment.controller.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;
import com.skcc.market.eda.comment.core.application.service.CommentCommandService;

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

	private final CommentCommandService commentCommandService;
	
	@ApiOperation(value = "댓글 작성")
	@PostMapping(value = "/comment/create")
	public ResponseEntity<Object> writeComment(@RequestBody CommentDTO commentDTO) throws Exception {
		commentCommandService.doWriteCommentCommandService(commentDTO);
		
		return new ResponseEntity<Object>(commentDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 수정")
	@PostMapping(value = "/comment/modify")
	public ResponseEntity<Object> updateComment(@RequestBody CommentDTO commentDTO) throws Exception {
		commentCommandService.doModifyCommentCommandService(commentDTO);
		
		return new ResponseEntity<Object>(commentDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 노출")
	@PostMapping(value = "/comment/show")
	public ResponseEntity<Object> showComment(@RequestBody CommentDTO commentDTO) throws Exception {
		commentCommandService.doShowCommentCommandService(commentDTO);
		
		return new ResponseEntity<Object>(commentDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 숨김")
	@PostMapping(value = "/comment/hide")
	public ResponseEntity<Object> hideComment(@RequestBody CommentDTO commentDTO) throws Exception {
		commentCommandService.doHideCommentCommandService(commentDTO);
		
		return new ResponseEntity<Object>(commentDTO, HttpStatus.OK);
	}
}
