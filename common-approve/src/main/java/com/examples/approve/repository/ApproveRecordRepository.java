package com.examples.approve.repository;

import com.examples.approve.entity.ApproveRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApproveRecordRepository extends JpaRepository<ApproveRecord, Long> {
}
