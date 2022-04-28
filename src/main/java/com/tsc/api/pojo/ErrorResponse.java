package com.tsc.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
    public String Area;
    public String Code;
    public String Message;
    public String Guid;

    public String getArea() {        return Area;    }

    public void setArea(String area) {        Area = area;    }

    public String getCode() {        return Code;    }

    public void setCode(String code) {        Code = code;    }

    public String getMessage() {        return Message;    }

    public void setMessage(String message) {        Message = message;    }

    public String getGuid() {        return Guid;    }

    public void setGuid(String guid) {        Guid = guid;    }
}
