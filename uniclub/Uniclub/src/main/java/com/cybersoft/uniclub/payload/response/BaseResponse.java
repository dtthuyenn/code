package com.cybersoft.uniclub.payload.response;

import lombok.Data;

@Data
public class BaseResponse {

    private int code;
    private String message;
    private Object data;
}
