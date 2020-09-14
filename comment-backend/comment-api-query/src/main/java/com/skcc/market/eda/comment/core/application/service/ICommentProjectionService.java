package com.skcc.market.eda.comment.core.application.service;

import com.skcc.market.eda.comment.core.event.CommentDisplayYnUpdateEvent;
import com.skcc.market.eda.comment.core.event.CommentModifyEvent;
import com.skcc.market.eda.comment.core.event.CommentWriteEvent;

public interface ICommentProjectionService {
	
	public void doWriteCommentProjectionService(CommentWriteEvent event) throws Exception;
	
	public void doModifyCommentProjectionService(CommentModifyEvent event) throws Exception;
	
	public void doDisplayYnUpdateCommentProjectionService(CommentDisplayYnUpdateEvent event) throws Exception;
	
}
