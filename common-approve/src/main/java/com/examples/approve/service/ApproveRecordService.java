package com.examples.approve.service;

import com.examples.approve.entity.ApproveRecord;

import java.util.List;

public interface ApproveRecordService {

    ApproveRecord save(ApproveRecord approveRecord);

    void delete(Long approveRecordId);

    ApproveRecord update(ApproveRecord approveRecord);

    ApproveRecord findById(Long approveRecordId);

}
