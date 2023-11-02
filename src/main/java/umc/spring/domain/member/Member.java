package umc.spring.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.BaseTimeEntity;
import umc.spring.domain.review.Review;
import umc.spring.mapping.member_agree.MemberAgree;
import umc.spring.mapping.member_mission.MemberMission;
import umc.spring.mapping.member_prefer.MemberPrefer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberMission> memberMissionList = new ArrayList<>();


}
