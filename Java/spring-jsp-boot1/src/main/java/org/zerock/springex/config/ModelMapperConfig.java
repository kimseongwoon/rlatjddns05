package org.zerock.springex.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 스프링 빈으로 설정파일 관리를 해주는 어노테이션
public class ModelMapperConfig {
	
	@Bean	// 해당 메소드도 스프링 빈으로 사용할 수 있도록 세팅
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        
        return modelMapper;
	}
}
