package umc.spring.mapping.member_prefer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.BaseTimeEntity;
import umc.spring.domain.food_category.FoodCategory;
import umc.spring.domain.member.Member;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Builder
@AllArgsConstructor
public class MemberPrefer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategory foodCategory;

    public void setMember(Member member){
        if(this.member != null)
            member.getMemberPreferList().remove(this);
        this.member = member;
        member.getMemberPreferList().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
    }
}
