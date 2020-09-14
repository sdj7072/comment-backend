package com.skcc.market.eda.comment.core.application.service;

import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;

public interface ICommentQueryService {
	
	public CommentDTO getCommentByCommentId(Long commentId) throws Exception;
	
}
