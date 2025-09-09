package com.ohgiraffers.hulahoopblue.usehistory.model.dao;

import com.ohgiraffers.hulahoopblue.usehistory.model.dto.UseHistoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UseHistoryMapper {

    List<UseHistoryDTO> findAllMenu();

    void registNewMenu(UseHistoryDTO newMenu);

    void modifyMenu(UseHistoryDTO newMenu);

    List<String> findAllName();

    void deleteMenu(UseHistoryDTO newMenu);

    List<UseHistoryDTO> findAllMenu1(@Param("limit") int pageSize, @Param("offset") int offset);

    int countAllMenu();
}
