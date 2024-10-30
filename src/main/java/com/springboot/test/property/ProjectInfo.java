package com.springboot.test.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "project", ignoreInvalidFields = true)
public class ProjectInfo {
    private String version;
    private String name;
}
