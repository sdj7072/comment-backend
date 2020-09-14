package com.skcc.market.eda.comment.core.application.object.core.domain.entity;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum CommentPostType {
	TIMELINE("T"),
	PRODUCT("P");
	
	private String value;
	
	
	public static CommentPostType getKey(String value) {
		return Arrays.stream(CommentPostType.values())
				.filter(v -> v.getValue().equals(value))
				.findAny()
				.orElse(null);				
	}
}
