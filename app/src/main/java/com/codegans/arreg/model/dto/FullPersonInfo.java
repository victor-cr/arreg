package com.codegans.arreg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FullPersonInfo {
    private PersonDto person;
    private MilitaryIDCardDto militaryIDCard;
    private List<TransferDto> transfers;
}
