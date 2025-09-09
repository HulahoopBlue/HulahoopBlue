package com.ohgiraffers.hulahoopblue.usehistory.model.service;

import com.ohgiraffers.hulahoopblue.usehistory.model.dao.UseHistoryMapper;
import com.ohgiraffers.hulahoopblue.usehistory.model.dto.UseHistoryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UseHistoryService {

    private final UseHistoryMapper useHistoryMapper;

    public UseHistoryService(UseHistoryMapper useHistoryMapper) {

        this.useHistoryMapper = useHistoryMapper;
    }

    public List<UseHistoryDTO> findAllMenu() {

        return useHistoryMapper.findAllMenu();
    }

    @Transactional
    public void registNewMenu(UseHistoryDTO newMenu) {

        useHistoryMapper.registNewMenu(newMenu);
    }

    public void modifyMenu(UseHistoryDTO newMenu) {

        useHistoryMapper.modifyMenu(newMenu);
    }

    public List<String> findAllName() {

        return useHistoryMapper.findAllName();
    }

    @Transactional
    public void deleteMenu(UseHistoryDTO newMenu) {

        useHistoryMapper.deleteMenu(newMenu);
    }

    public Page<UseHistoryDTO> findAllMenu1(int page) {
        Pageable pageable = PageRequest.of(page, 10);

        List<UseHistoryDTO> content = useHistoryMapper.findAllMenu1(pageable.getPageSize(), (int) pageable.getOffset());
        int totalElements = useHistoryMapper.countAllMenu();

        return new PageImpl<>(content, pageable, totalElements);
    }
}
