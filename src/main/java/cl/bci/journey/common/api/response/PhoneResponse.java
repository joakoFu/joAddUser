package cl.bci.journey.common.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoneResponse {
    @JsonProperty("number")
    private String number;

    @JsonProperty("citycode")
    private String citycode;

    @JsonProperty("countrycode")
    private String countrycode;

}
