package cl.bci.journey.common.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
@Setter
public class UserRequest {
    @JsonProperty("nombre")
    private String name;

    @JsonProperty("correo")
    @Email(message = "Correo electrónico no es válido")
    private String email;

    @JsonProperty("contraseña")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "La contraseña debe tener al menos 6 caracteres, incluyendo letras y números.")
    private String password;

    @JsonProperty("telefonos")
    private List<PhoneRequest> phones;
}
