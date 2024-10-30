package com.springboot.test.model.response;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse<T> {
	private T result;
	private Long totalCount;
	private Integer totalPage;
	private Integer code;
	private String message;

	protected RestResponse(T result, Integer code, String message, Long totalCount, Integer totalPage) {
		this.result = result;
		this.code = code;
		this.message = message;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}

	public static <T> RestResponse<?> create(T result, int code, String message) {
		return new RestResponse<>(result, code == 0 ? null : code, message, null, null);
	}

	public static <T> RestResponse<?> create(T result, Long totalCount, Integer totalPage) {
		return new RestResponse<>(result, null, null, totalCount, totalPage);
	}

	public static <T> RestResponse<?> create(Page<?> result) {
		return new RestResponse<>(result.getContent(), 0, null, result.getTotalElements(), result.getTotalPages());
	}

	public static <T> RestResponse<?> create(T result) {
		return new RestResponse<>(result, null, null, null, null);
	}

	public static <T> RestResponse<?> create() {
		return new RestResponse<>(true, null, null, null, null);
	}

	public static <T> RestResponse<?> error(HttpStatus httpStatus, String message) {
		return new RestResponse<>(null, httpStatus.value(), message, null, null);
	}

	public static <T> RestResponse<?> error(HttpStatus httpStatus, Exception e) {
		return new RestResponse<>(null, httpStatus.value(), e.getMessage(), null, null);
	}
}
