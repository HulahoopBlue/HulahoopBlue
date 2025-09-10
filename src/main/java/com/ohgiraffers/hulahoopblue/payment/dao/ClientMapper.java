package com.ohgiraffers.hulahoopblue.payment.dao;

import com.ohgiraffers.hulahoopblue.payment.dto.ClientDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

    @Mapper
    public interface ClientMapper {

        // 전체 고객사 조회
        List<ClientDTO> findAllClient();

        // 단일 고객사 조회
        ClientDTO findClientById(int id);

        // 고객사 등록
        int insertClient(ClientDTO client);

        // 고객사 수정
        int updateClient(ClientDTO client);

        // 고객사 삭제
        int deleteClient(int id);
    }

