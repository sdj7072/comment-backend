package com.skcc.market.eda.comment.core.application.service;

import com.skcc.market.eda.comment.core.event.CommentDisplayYnUpdateEvent;
import com.skcc.market.eda.comment.core.event.CommentModifyEvent;
import com.skcc.market.eda.comment.core.event.CommentWriteEvent;

public interface ICommentService {
	
	public void doWriteCommentService(CommentWriteEvent event) throws Exception;
	
	public void doModifyCommentService(CommentModifyEvent event) throws Exception;
	
	//public void doShowCommentService(CommentDisplayYnUpdateEvent event) throws Exception;
	
	//public void doHideCommentService(CommentDisplayYnUpdateEvent event) throws Exception;

}
