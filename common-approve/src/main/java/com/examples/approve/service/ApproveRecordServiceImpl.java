package com.examples.approve.service;

import com.examples.approve.entity.ApproveRecord;
import com.examples.approve.repository.ApproveRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ApproveRecordServiceImpl implements ApproveRecordService {

    @Resource
    private ApproveRecordRepository approveRecordRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApproveRecord save(ApproveRecord approveRecord) {
        return approveRecordRepository.save(approveRecord);
    }

    @Override
    public void delete(Long approveRecordId) {
        approveRecordRepository.deleteById(approveRecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApproveRecord update(ApproveRecord approveRecord) {
        return approveRecordRepository.save(approveRecord);
    }

    @Override
    public ApproveRecord findById(Long approveRecordId) {
        return approveRecordRepository.findById(approveRecordId).orElse(null);
    }
}
