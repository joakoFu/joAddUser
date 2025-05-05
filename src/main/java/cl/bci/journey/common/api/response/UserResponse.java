package cl.bci.journey.common.api.response;

import cl.bci.journey.common.api.request.PhoneRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class UserResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("creado")
    private Date creado;

    @JsonProperty("modificado")
    private Date modificado;

    @JsonProperty("ultimoLogin")
    private Date ultimoLogin;
    @JsonProperty("token")
    private String token;
    @JsonProperty("activo")
    private boolean activo;

}
