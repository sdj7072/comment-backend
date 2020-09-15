package com.skcc.market.eda.common.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.skcc.market.eda.comment.core.application.object.dto.CommentDTO;
import com.skcc.market.eda.comment.core.domain.entity.CommentEntity;

@Configuration
public class CommonBean {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
			.setPropertyCondition(Conditions.isNotNull())
			.setFieldMatchingEnabled(true)
			.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
			.setMatchingStrategy(MatchingStrategies.STRICT);
		
		modelMapper.createTypeMap(CommentEntity.class, CommentDTO.class)
			.addMapping(CommentEntity::getId, CommentDTO::setCommentId);
		
		modelMapper.createTypeMap(CommentDTO.class, CommentEntity.class)
			.addMapping(CommentDTO::getCommentId, CommentEntity::setId);
		
		return modelMapper;
	}
}
