package com.springboot.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.test.entities.DeviceInfo;

public interface DeviceInfoRepository extends CrudRepository<DeviceInfo, Long> {
    DeviceInfo findBydSeqAndDeleted(long dSeq, boolean deleted);
}
