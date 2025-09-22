package com.ohgiraffers.travelkidari.api.user.controller;

import com.ohgiraffers.travelkidari.api.user.dto.UserRequestDTO;
import com.ohgiraffers.travelkidari.api.user.dto.UserPhoneRequestDTO;
import com.ohgiraffers.travelkidari.api.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody UserRequestDTO userRequestDTO) {
        userService.registerUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"회원가입에 성공했습니다.\"}");
    }

    @PostMapping("/checkByPhone")
    public ResponseEntity<String> checkUserByPhone(@RequestBody UserPhoneRequestDTO phoneRequest) {
        boolean isUserExist = userService.checkUserExistsByPhone(phoneRequest.getUserPhone());

        if (isUserExist) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"해당 전화번호로 가입된 회원이 존재합니다.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"해당 전화번호로 가입된 회원이 없습니다.\"}");
        }
    }
}