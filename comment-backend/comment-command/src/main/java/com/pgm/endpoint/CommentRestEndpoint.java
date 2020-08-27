package com.pgm.endpoint;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgm.core.command.WriteCommentCommand;

@RestController
public class CommentRestEndpoint {

	private final CommandGateway commandGateway;
	
	public CommentRestEndpoint(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}
	
	@GetMapping("/api/writeCommand")
	public void writeComment() {
		commandGateway.send(new WriteCommentCommand((long) 1));
	}
}
