package com.skcc.market.eda.comment.core.application.service;

import java.util.List;

import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;

public interface ICommentQueryService {
	
	public CommentDTO getCommentByCommentId(Long commentId) throws Exception;
	
	public List<CommentDTO> getCommnetListByMemberId(Long memberId) throws Exception;
	
	public List<CommentDTO> getCommnetListByPostId(Long postId) throws Exception;
}
