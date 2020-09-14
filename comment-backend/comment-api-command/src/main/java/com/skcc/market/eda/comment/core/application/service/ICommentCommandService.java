package com.skcc.market.eda.comment.core.application.service;

import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;

public interface ICommentCommandService {
	
	public void doWriteCommentCommandService(CommentDTO commentDTO) throws Exception;
	
	public void doModifyCommentCommandService(CommentDTO commentDTO) throws Exception;
	
	public void doShowCommentCommandService(CommentDTO commentDTO) throws Exception;
	
	public void doHideCommentCommandService(CommentDTO commentDTO) throws Exception;

}
