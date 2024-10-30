package com.springboot.test.entities;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table("device_info")
public class DeviceInfo {
    @Id
    private Long dSeq;
    @CreatedBy
    private Long uSeq;

    private String fcmToken;

    private String model;

    private String os;

    private String osVersion;

    private String serialNo;

    @CreatedDate
    private Instant deviceCreationTime;

    @LastModifiedDate
    private Instant lastSignTime;

    @Builder.Default
    private Boolean deleted = false;
}
