package com.skcc.market.eda.comment.core.domain.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.skcc.market.eda.comment.core.application.object.core.domain.entity.CommentPostType;

@Converter
public class CommentPostTypeConverter implements AttributeConverter<CommentPostType, String> {

	@Override
	public String convertToDatabaseColumn(CommentPostType attribute) {
		
		return attribute.getValue();
	}

	@Override
	public CommentPostType convertToEntityAttribute(String dbData) {

		return CommentPostType.getKey(dbData);
	}
	
}
