package cl.bci.journey.common.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDataBaseRequest {
    @JsonProperty("numero")
    private String numero;

    @JsonProperty("codigoCiudad")
    private String codigoCiudad;

    @JsonProperty("codigoPais")
    private String codigoPais;
}
