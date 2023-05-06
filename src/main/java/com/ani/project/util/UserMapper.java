package com.ani.project.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public <T, U> U convertor(T entity, U dto) {
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}


