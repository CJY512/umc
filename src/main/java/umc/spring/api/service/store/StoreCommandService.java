package umc.spring.api.service.store;

import umc.spring.api.controller.store.dto.StoreRequestDto;
import umc.spring.domain.store.Store;

public interface StoreCommandService {

    Store createStore(StoreRequestDto.CreateRequestDto storeCreateDto);
}
