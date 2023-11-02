package umc.spring.domain.mission;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.BaseTimeEntity;
import umc.spring.domain.store.Store;
import umc.spring.mapping.member_mission.MemberMission;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Mission extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Integer reward;

    private LocalDate deadline;

    @Lob
    private String missionSpec;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission")
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @Builder
    private Mission(String missionSpec, Integer reward, LocalDate deadline) {
        this.missionSpec = missionSpec;
        this.reward = reward;
        this.deadline = deadline;
    }

    public static Mission createMission(String missionSpec, Integer reward, LocalDate deadline) {
        return Mission.builder()
                .missionSpec(missionSpec)
                .reward(reward)
                .deadline(deadline)
                .build();
    }
}
