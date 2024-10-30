package com.springboot.test.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.entities.UserInfo;
// import com.springboot.test.entities.DeviceInfo;
// import com.springboot.test.entities.TestEntity;
// import com.springboot.test.model.request.TestEntityRequest;
import com.springboot.test.model.response.RestResponse;
import com.springboot.test.service.TestService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/output")
    public String testOutput() {
        return testService.testOutput();
    }

    @GetMapping("/loadUser")
    public ResponseEntity<RestResponse<?>> loadUser() {
        UserInfo result = testService.readUser();
        return ResponseEntity.ok().body(RestResponse.create(result));
    }

    // @PutMapping("/input")
    // public ResponseEntity<RestResponse<?>> input(@RequestBody TestEntityRequest
    // inData) {
    // System.out.println(inData.getUserInfo());
    // return ResponseEntity.ok().body(RestResponse.create(inData.getUserInfo()));
    // }

}
