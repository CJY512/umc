package umc.spring.domain.terms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.BaseTimeEntity;
import umc.spring.domain.member.Member;
import umc.spring.mapping.member_agree.MemberAgree;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Terms extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;

    private String text;

    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}
