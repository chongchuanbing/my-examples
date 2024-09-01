package com.examples.approve.controller;

import com.examples.approve.entity.ApproveRecord;
import com.examples.approve.service.ApproveRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("approveRecord")
public class ApproveRecordController {

    @Resource
    private ApproveRecordService approveRecordService;

    @GetMapping(value = "/findById/{id}")
    public ApproveRecord findById(@PathVariable("id") Long id) {
        return approveRecordService.findById(id);
    }

    @PostMapping("save")
    public Long save(@RequestBody ApproveRecord approveRecord) {
        ApproveRecord approveRecordSaved = approveRecordService.save(approveRecord);
        return approveRecordSaved.getId();
    }
}
