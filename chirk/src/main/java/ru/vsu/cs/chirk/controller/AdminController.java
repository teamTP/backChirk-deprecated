package ru.vsu.cs.chirk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.chirk.entity.DTO.requestDTO.RequestChirkDTO;
import ru.vsu.cs.chirk.security.JwtTokenProvider;
import ru.vsu.cs.chirk.service.ChirkService;
import ru.vsu.cs.chirk.service.UserService;

@RestController
@RequestMapping("/admirator")
public class AdminController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserService userService;

    //TODO: что то сделать с секьюрити куда и как только при токене пускают?


    @PostMapping("/addAdmin")
    @PreAuthorize("hasAuthority('ADD_NEW_MODER_AUTHORITY')")
    public void addAdmin(@RequestHeader(name = "Authorization") String authorizationHeader, @RequestParam String email) {
//        String accessToken = jwtTokenProvider.extractAccessToken(authorizationHeader);
//        Long userId = jwtTokenProvider.getIdFromJwt(accessToken);
        // requestChirkDTO.setIdUser(userId);
        userService.setAdminRole(email);
    }

    @PostMapping("/deleteAdmin")
    @PreAuthorize("hasAuthority('ADD_NEW_MODER_AUTHORITY')")
    public void deleteAdmin(@RequestHeader(name = "Authorization") String authorizationHeader, @RequestParam String email) {
//        String accessToken = jwtTokenProvider.extractAccessToken(authorizationHeader);
//        Long userId = jwtTokenProvider.getIdFromJwt(accessToken);
        // requestChirkDTO.setIdUser(userId);
        userService.deleteAdminRole(email);
    }

}
