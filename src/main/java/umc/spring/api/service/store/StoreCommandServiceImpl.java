package umc.spring.api.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.api.controller.store.dto.StoreRequestDto;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.store.StoreConverter;
import umc.spring.domain.region.Region;
import umc.spring.domain.store.Store;
import umc.spring.repository.region.RegionRepository;
import umc.spring.repository.store.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store createStore(StoreRequestDto.CreateRequestDto storeCreateDto) {

        Store newStore = StoreConverter.toStore(storeCreateDto);
        //region 연관 관계
        Region region = regionRepository.findById(storeCreateDto.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        newStore.setRegion(region);

        return storeRepository.save(newStore);
    }

}
