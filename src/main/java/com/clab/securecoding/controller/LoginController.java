package com.clab.securecoding.controller;

import com.clab.securecoding.service.LoginService;
import com.clab.securecoding.type.dto.ResponseModel;
import com.clab.securecoding.type.dto.TokenInfo;
import com.clab.securecoding.type.dto.UserLoginRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Tag(name = "Login")
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @Operation(summary = "유저 로그인", description = "JWT 인증 로그인")
    @PostMapping()
    public ResponseModel login(
            @RequestBody UserLoginRequestDto userLoginRequestDto
    ) {
        String id = userLoginRequestDto.getId();
        String password = userLoginRequestDto.getPassword();
        TokenInfo tokenInfo = loginService.login(id, password);
        ResponseModel responseModel = ResponseModel.builder().build();
        responseModel.addData(tokenInfo);
        return responseModel;
    }

    @Operation(summary = "유저 로그인 테스트", description = "유저 로그인 테스트")
    @PostMapping("/test")
    public ResponseModel test() {
        ResponseModel responseModel = ResponseModel.builder().build();
        return responseModel;
    }

}
