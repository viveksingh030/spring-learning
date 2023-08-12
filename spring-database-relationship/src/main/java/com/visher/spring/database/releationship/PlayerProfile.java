package com.visher.spring.database.releationship;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlayerProfile {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;
    private String twitter;

    public PlayerProfile() {
    }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getTwitter() {
    return twitter;
  }

  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }
}