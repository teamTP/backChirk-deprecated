package ru.vsu.cs.chirk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.chirk.entity.Chirk;
import ru.vsu.cs.chirk.entity.DTO.ChirkFeedDTO;
import ru.vsu.cs.chirk.entity.DTO.UserProfileDTO;
import ru.vsu.cs.chirk.entity.DTO.requestDTO.RequestChirkDTO;
import ru.vsu.cs.chirk.entity.DTO.requestDTO.RequestChirkIdDTO;
import ru.vsu.cs.chirk.entity.User;
import ru.vsu.cs.chirk.security.JwtTokenProvider;
import ru.vsu.cs.chirk.service.ChirkService;
import ru.vsu.cs.chirk.service.UserProfileService;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private ChirkService chirkService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/myChirks")
    public List<ChirkFeedDTO> usersChirks(@RequestHeader("Authorization") String authorizationHeader,@RequestParam int page){
        String accessToken = extractAccessToken(authorizationHeader);
        Long userId = jwtTokenProvider.getIdFromJwt(accessToken);
        return userProfileService.getUsersPosts(userId, page);
    }

    @GetMapping("/myLikedChirks")
    public List<ChirkFeedDTO> userLikedChirks(@RequestHeader("Authorization") String authorizationHeader,@RequestParam int page){
        String accessToken = extractAccessToken(authorizationHeader);
        Long userId = jwtTokenProvider.getIdFromJwt(accessToken);
        return userProfileService.getLikedUsersPosts(userId, page);
    }

    @GetMapping("/myDislikedChirks")
    public List<ChirkFeedDTO> userDislikedChirks(@RequestHeader("Authorization") String authorizationHeader,@RequestParam int page){
        String accessToken = extractAccessToken(authorizationHeader);
        Long userId = jwtTokenProvider.getIdFromJwt(accessToken);
        return userProfileService.getDislikedUsersPosts(userId, page);
    }

    private String extractAccessToken(String authorizationHeader) {
// Assuming the Authorization header value is in the format "Bearer <token>"
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7); // Extract the token part after "Bearer "
        }
        throw new IllegalArgumentException("Invalid Authorization header");
    }



    public UserProfileDTO userProfile(@RequestHeader("Authorization") String authorizationHeader){
        String accessToken = extractAccessToken(authorizationHeader);
        Long userId = jwtTokenProvider.getIdFromJwt(accessToken);
        return userProfileService.getUserProfileDTO(userId);
    }











}
