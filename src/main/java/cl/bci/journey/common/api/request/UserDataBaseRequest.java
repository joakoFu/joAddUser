package cl.bci.journey.common.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Builder
public class UserDataBaseRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("pass")
    private String pass;

    @JsonProperty("phoneRequestList")
    private List<PhoneDataBaseRequest> phoneRequestList;
}
