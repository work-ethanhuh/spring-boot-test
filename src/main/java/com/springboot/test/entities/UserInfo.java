package com.springboot.test.entities;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table("user_info")
public class UserInfo {
    @Id
    private Long uSeq;

    private String displayName;

    private String email;

    private String uid;

    private String provider;

    @CreatedDate
    private Instant creationTime;

    @Transient
    private DeviceInfo deviceInfo;

    @Builder.Default
    private Boolean deleted = false;
}
