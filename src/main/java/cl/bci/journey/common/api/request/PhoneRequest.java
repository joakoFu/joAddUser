package cl.bci.journey.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PhoneRequest {
    @JsonProperty("numero")
    private String number;

    @JsonProperty("codigoCiudad")
    private String citycode;

    @JsonProperty("codigoPais")
    private String countrycode;


}
