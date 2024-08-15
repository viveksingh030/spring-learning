package com.visher.spring.mvc;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;

public class Athlete {
    @NotEmpty
    @Size(min = 3,max = 30)
    private String lastName;
    @NotBlank(message = "country can't be empty")
    private String country;
    @NotBlank(message = "handedness can't be empty")
    private String handedness;
    @NotEmpty(message = "grandSlams can't be empty")
    private String[] grandSlams;
    @NotNull(message = "This is a required field.")
    @Min(value=1, message="Value must be greater than or equal to 1.")
    @Max(value=100, message="Value must be less than or equal to 100.")
    private Integer rank;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Date must be in the past.")
    private Date lastWon;
    @Pattern(regexp="^\\＄([0-9]{1,3},([0-9]{3},)*[0-9]{3})＄", message="Incorrect format")
    private String prizeMoney;

    public String getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(String prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public Date getLastWon() {
        return lastWon;
    }

    public void setLastWon(Date lastWon) {
        this.lastWon = lastWon;
    }

    public Athlete() {

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHandedness() {
        return handedness;
    }

    public void setHandedness(String handedness) {
        this.handedness = handedness;
    }

    public String[] getGrandSlams() {
        return grandSlams;
    }

    public void setGrandSlams(String[] grandSlams) {
        this.grandSlams = grandSlams;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", handedness='" + handedness + '\'' +
                ", grandSlams=" + Arrays.toString(grandSlams) +
                ", rank=" + rank +
                ", lastWon=" + lastWon +
                ", prizeMoney='" + prizeMoney + '\'' +
                '}';
    }
}