package com.skcc.market.eda.comment.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;
import com.skcc.market.eda.comment.core.application.service.CommentQueryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Api(value = "Comment API")
@RestController
@RequestMapping("/v1/api/comment-command")
public class CommentQueryWebController {
	
	@Autowired
	CommentQueryService commentQueryService;
	
	@ApiOperation(value = "댓글 조회")
	@PostMapping(value = "/comment/info/comment")
	public ResponseEntity<Object> getCommentByCommentId(@RequestParam Long commentId) throws Exception {
		
		CommentDTO commentDTO = commentQueryService.getCommentByCommentId(commentId);
		
		return new ResponseEntity<Object>(commentDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 목록 조회")
	@PostMapping(value = "/comment/list/member")
	public ResponseEntity<List> getCommentListByMemberId(@RequestParam Long memberId) throws Exception {
		
		List<CommentDTO> commentDTOList = commentQueryService.getCommnetListByMemberId(memberId);
		
		return new ResponseEntity<List>(commentDTOList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글 목록 조회 POST ID")
	@PostMapping(value = "/comment/list/post")
	public ResponseEntity<List> getCommentListByPostId(@RequestParam Long postId) throws Exception {
		
		List<CommentDTO> commentDTOList = commentQueryService.getCommnetListByPostId(postId);
		
		return new ResponseEntity<List>(commentDTOList, HttpStatus.OK);
	}
}
