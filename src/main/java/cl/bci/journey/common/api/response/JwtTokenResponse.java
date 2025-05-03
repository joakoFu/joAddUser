package cl.bci.journey.common.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class JwtTokenResponse {
    @JsonProperty("token")
    private String token;
    @JsonProperty("err")
    private String err;

}
