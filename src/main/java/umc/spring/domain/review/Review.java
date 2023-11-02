package umc.spring.domain.review;

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
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String body;

    private Float score;
}
