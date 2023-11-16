package umc.spring.api.controller.store.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistRegion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StoreRequestDto {

    @Getter
    public static class CreateRequestDto {
        @NotBlank
        private String name;
        @Size(min = 5, max = 12)
        private String address;
        @ExistRegion
        private Long regionId;
    }
}
