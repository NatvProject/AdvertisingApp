package kg.megacom.NatvProject.models.dtos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelDataDto {
    String channelName;
    String logo;
    Double pricePerLetter;
    List<DiscountInfoDto> discounts;

}
