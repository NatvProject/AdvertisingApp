package kg.megacom.NatvProject.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.megacom.NatvProject.models.enums.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDto {
    Long id;
    String email;
    String fio;
    String phone;
    @JsonIgnore
    LocalDateTime startDate;
    @JsonIgnore
    LocalDateTime endDate;
    @JsonIgnore
    String password;
    @JsonIgnore
    Role role;
}
