package com.example.mytraveljournal.controller;

import com.example.mytraveljournal.dto.JournalDto;
import com.example.mytraveljournal.entity.Journal;
import com.example.mytraveljournal.service.JournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class JournalController {

    @Autowired
    private JournalService journalService;

    // 메인화면 (일지 목록)
    @GetMapping("/journals")
    public String showJournalList(Model model) {
        List<Journal> journals = journalService.findAllJournals();
        model.addAttribute("journals", journals);
        return "journals/index";
    }

    // 일지 상세 보기 화면
    @GetMapping("journals/{id}")
    public String showJournalDetails(@PathVariable Long id, Model model) {
        Journal journal = journalService.findJournalById(id);
        model.addAttribute("journal", journal);
        return "journals/details";
    }

    // 일지 생성 폼 보여주기
    @GetMapping("/journals/create")
    public String showCreateForm(Model model) {
        model.addAttribute("journalDto", new JournalDto());
        return "journals/create";
    }

    // 일지 생성
    @PostMapping("/journals/create")
    // @ModelAttribute: HTTP 요청 파라미터와 일치하는 객체를 생성하고, 해당 객체를 메서드의 매개변수로 주입해줌
    public String createJournal(@ModelAttribute JournalDto journalDto) {
        Journal created = journalService.create(journalDto);
        return "redirect:/journals/" + created.getId();
    }

    // 일지 수정 폼 보여주기
    @GetMapping("journals/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Journal journal = journalService.findJournalById(id);
        model.addAttribute("journal", journal);
        return "journals/edit";
    }

    // 일지 수정
    @PostMapping("journals/{id}/edit")
    public String editJournal(@PathVariable Long id, @ModelAttribute JournalDto journalDto) {
        Journal updated = journalService.update(id, journalDto);
        return "redirect:/journals/" + updated.getId();
    }

    // 일지 삭제 폼 보여주기
    @GetMapping("journals/{id}/delete")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Journal journal = journalService.delete(id);
        model.addAttribute("journal", journal);
        return "journals/delete";
    }

    // 일지 삭제
    @PostMapping("journals/{id}/delete")
    public String deleteJournal(@PathVariable Long id) {
        journalService.delete(id);
        return "redirect:/journals";
    }

}
