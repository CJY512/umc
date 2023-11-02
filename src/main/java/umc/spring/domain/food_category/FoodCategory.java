package umc.spring.domain.food_category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.BaseTimeEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class FoodCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @Builder
    private FoodCategory(String name) {
        this.name = name;
    }

    public static FoodCategory create(String name) {
        return FoodCategory.builder()
                .name(name)
                .build();
    }
}
