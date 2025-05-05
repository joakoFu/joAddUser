package cl.bci.journey.common.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class UserDataBaseResponse {
    @JsonProperty("id")
    String id;
    @JsonProperty("fechaCreacion")
    Date fechaCreacion;
    @JsonProperty("fechaUltimoLogin")
    Date fechaUltimoLogin;
}
