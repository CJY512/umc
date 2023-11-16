package umc.spring.api.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.api.controller.member.dto.MemberRequestDto;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.member.MemberConverter;
import umc.spring.converter.member_prefer.MemberPreferConverter;
import umc.spring.domain.food_category.FoodCategory;
import umc.spring.domain.member.Member;
import umc.spring.mapping.member_prefer.MemberPrefer;
import umc.spring.repository.food_category.FoodCategoryRepository;
import umc.spring.repository.member.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Member joinMember(MemberRequestDto.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategories = request.getPreferCategory().stream()
                .map(id ->
                        foodCategoryRepository.findById(id)
                                .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))
                )
                .collect(Collectors.toList());
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategories);
        memberPreferList.forEach(memberPrefer -> memberPrefer.setMember(newMember));

        return memberRepository.save(newMember);
    }
}