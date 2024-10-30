package com.springboot.test.service;

import org.springframework.stereotype.Service;

import com.springboot.test.entities.UserInfo;
import com.springboot.test.repository.UserInfoRepository;
import com.springboot.test.entities.DeviceInfo;
import com.springboot.test.repository.DeviceInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
    private final UserInfoRepository userInfoRepository;
    private final DeviceInfoRepository deviceInfoRepository;

    public String testOutput() {
        return "testtesttest";
    }

    public UserInfo readUser() {
        UserInfo userInfo = userInfoRepository.findByuSeqAndDeleted(1, false);
        if (userInfo == null) {
            throw new IllegalArgumentException("User not found");
        } else {
            userInfo.setDeviceInfo(readDevice());
        }
        return userInfo;
    }

    public DeviceInfo readDevice() {
        return deviceInfoRepository.findBydSeqAndDeleted(1, false);
    }
}
