package com.springboot.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.test.entities.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    UserInfo findByuSeqAndDeleted(long uSeq, boolean deleted);
}
