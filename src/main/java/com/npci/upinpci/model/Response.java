package com.npci.upinpci.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

    private int statusCode;
    private String statusMsg;

    @JsonIgnore
    private ErrorDetails errorDetails;
}
