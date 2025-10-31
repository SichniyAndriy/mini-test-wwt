package test.bett.auth.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.bett.auth.domain.model.dto.UserDto;
import test.bett.auth.domain.service.UserService;
import test.bett.auth.security.JwtTokenUtil;


@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthController(
            @Autowired UserService userService,
            @Autowired JwtTokenUtil jwtTokenUtil
    ) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping( {"/register", "/register/" })
    public ResponseEntity<Void> register(
            @Validated @RequestBody final UserDto userDto
    ) {
        userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping({"/login", "/login/"})
    public ResponseEntity<String> login(
            @NotNull @RequestBody final UserDto userDto
    ) {
        String userID = userService.check(userDto);
        String token = jwtTokenUtil.generateToken(userID);
        return ResponseEntity.ok(token);
    }

}
