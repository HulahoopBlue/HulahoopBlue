package com.hulahoopblue.blue.model.dao;

import com.hulahoopblue.blue.model.dto.GeminiApiDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface GeminiApiDAO {

    @Transactional
    void geminiApiRegist(GeminiApiDTO geminiApiDTO);
}
