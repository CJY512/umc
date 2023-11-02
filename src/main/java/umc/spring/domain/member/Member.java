package umc.spring.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.BaseTimeEntity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String specAddress;

    @Enumerated(STRING)
    private Gender gender;

    @Enumerated(STRING)
    private SocialType socialType;

    @Enumerated(STRING)
    private MemberStatus status;

    private LocalDate inactiveDate;

    private String email;

    private Integer point;


}
