package umc.spring.repository.food_category;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.food_category.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
