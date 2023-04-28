package com.codegans.arreg.controller;

import com.codegans.arreg.model.dto.PersonDto;
import com.codegans.arreg.model.dto.TransferDto;
import com.codegans.arreg.service.PersonnelService;
import com.codegans.arreg.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;
    private final PersonnelService personnelService;

    @GetMapping("/transfers/add")
    public String addTransfer(@RequestParam(value = "personId", required = false) String personId, Model model) {
        if (personId != null) {
            PersonDto selectedPerson = personnelService.getById(personId);
            model.addAttribute("selectedPerson", selectedPerson);
        } else {
            List<PersonDto> personnel = personnelService.getAllPersonnel();
            model.addAttribute("personnel", personnel);
        }
        model.addAttribute("transfer", new TransferDto());
        return "addTransfer";
    }

    @PostMapping("/transfers/save")
    public String saveTransfer(@ModelAttribute("transfer") TransferDto transferDto) {
        transferService.save(transferDto);
        return "redirect:/personnel/" + transferDto.getPersonId();
    }
}
