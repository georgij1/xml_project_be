package com.xml_project_be.xml_project.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class formChangeData {
    @JsonProperty("newLogin")
    public String newLogin;
    @JsonProperty("oldLogin")
    public String oldLogin;
    @JsonProperty("OldNameCompany")
    public String OldNameCompany;
    @JsonProperty("NewNameCompany")
    public String NewNameCompany;
    @JsonProperty("infoPerson")
    public String infoPerson;
}