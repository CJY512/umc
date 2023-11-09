package umc.spring.converter.test;

import umc.spring.api.controller.test.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempResponse(String testString) {
        return TempResponse.TempTestDTO.builder()
                .testString(testString)
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }

}
