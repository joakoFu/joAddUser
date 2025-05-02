package cl.bci.journey.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneRequest {
    @JsonProperty("number")
    private String number;

    @JsonProperty("citycode")
    private String citycode;

    @JsonProperty("countrycode")
    private String countrycode;


}
