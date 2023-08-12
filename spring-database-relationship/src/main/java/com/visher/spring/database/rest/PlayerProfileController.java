package com.visher.spring.database.rest;

import com.visher.spring.database.onetoone.PlayerProfileService;
import com.visher.spring.database.releationship.PlayerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class PlayerProfileController {

    @Autowired
    PlayerProfileService service;

    @GetMapping("")
    public ResponseEntity<List<PlayerProfile>> getAllProfiles() {
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.findAllProfiles());
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<PlayerProfile> getProfile(@PathVariable("profileId") int profileId) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.findProfile(profileId));
    }

    @PostMapping("")
    public ResponseEntity<PlayerProfile> addProfile(@RequestBody PlayerProfile playerProfile) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.addProfile(playerProfile));
    }

    @DeleteMapping("/profile/{profileId}")
    public ResponseEntity deleteProfile(@PathVariable("profileId") int profileId) {
        service.deleteProfile(profileId);
        return ResponseEntity.ok("");
    }
}