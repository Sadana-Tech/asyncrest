package com.npci.upinpci.model;

import lombok.Data;

@Data
public class UPIResponse extends  Response{
    private String upiId;
    private boolean isValid;


}
