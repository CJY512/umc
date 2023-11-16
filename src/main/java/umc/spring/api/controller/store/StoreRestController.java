package umc.spring.api.controller.store;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.api.controller.store.dto.StoreRequestDto;
import umc.spring.api.controller.store.dto.StoreResponseDto;
import umc.spring.api.service.store.StoreCommandService;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.store.StoreConverter;
import umc.spring.domain.store.Store;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("")
    public ApiResponse<StoreResponseDto.CreateResultDto> createStore(@RequestBody @Valid StoreRequestDto.CreateRequestDto createRequestDto) {
        Store store = storeCommandService.createStore(createRequestDto);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultDto(store));
    }
}
