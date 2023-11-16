package umc.spring.api.controller.member.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberRequestDto {

    @Getter
    public static class JoinDto{
        @NotBlank
        private String name;
        @NotNull
        private Integer gender;
        @NotNull
        private Integer birthYear;
        @NotNull
        private Integer birthMonth;
        @NotNull
        private Integer birthDay;
        @Size(min = 5, max = 12)
        private String address;
        @Size(min = 5, max = 12)
        private String specAddress;
        @ExistCategories
        private List<Long> preferCategory;
    }
}
