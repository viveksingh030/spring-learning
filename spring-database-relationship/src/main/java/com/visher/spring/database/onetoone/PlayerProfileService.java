package com.visher.spring.database.onetoone;

import com.visher.spring.database.releationship.PlayerProfile;
import com.visher.spring.database.repo.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerProfileService {
    @Autowired
    private PlayerProfileRepository playerProfileRepository;

    public List<PlayerProfile> findAllProfiles() {
        return playerProfileRepository.findAll();
    }

    public PlayerProfile findProfile(int profileId) {
        Optional<PlayerProfile> byId = playerProfileRepository.findById(profileId);
        return byId.isPresent() ? byId.get() : null;
    }

    public PlayerProfile addProfile(PlayerProfile playerProfile) {
        return playerProfileRepository.save(playerProfile);
    }

    public void deleteProfile(int profileId) {
        playerProfileRepository.deleteById(profileId);
    }
}
