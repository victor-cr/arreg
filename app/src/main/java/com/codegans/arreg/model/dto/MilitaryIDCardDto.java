package com.codegans.arreg.model.dto;

import com.codegans.arreg.model.MilitaryIdentityCard;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
public class MilitaryIDCardDto {
    private String id;
    private String serialNumber;
    private String issuedBy;
    private String issuedAt;
    private String education;
    private String civilOccupation;
    private String maritalStatus;

    public MilitaryIDCardDto(MilitaryIdentityCard militaryIdentityCard) {
        this.id = militaryIdentityCard.id().toString();
        this.serialNumber = militaryIdentityCard.serialNumber();
        this.issuedBy = militaryIdentityCard.issuedBy();
        this.issuedAt = militaryIdentityCard.issuedAt().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.education = militaryIdentityCard.education();
        this.civilOccupation = militaryIdentityCard.civilOccupation();
        this.maritalStatus = militaryIdentityCard.maritalStatus().name();
    }
}
