package umc.spring.converter.store;

import umc.spring.api.controller.store.dto.StoreRequestDto;
import umc.spring.api.controller.store.dto.StoreResponseDto;
import umc.spring.domain.store.Store;

public class StoreConverter {

    public static StoreResponseDto.CreateResultDto toCreateResultDto(Store store) {
        return StoreResponseDto.CreateResultDto.builder()
                .id(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDto.CreateRequestDto createRequestDto) {
        return Store.builder()
                .name(createRequestDto.getName())
                .address(createRequestDto.getAddress())
                .build();
    }
}
