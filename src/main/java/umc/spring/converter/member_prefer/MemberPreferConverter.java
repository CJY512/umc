package umc.spring.converter.member_prefer;

import umc.spring.domain.food_category.FoodCategory;
import umc.spring.mapping.member_prefer.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> preferCategory) {
        return preferCategory.stream()
                .map(foodCategory -> MemberPrefer.builder()
                        .foodCategory(foodCategory)
                        .build())
                .collect(Collectors.toList());
    }

}
