package umc.spring.domain.mission;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.BaseTimeEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;

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

    private String missionSpec;

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
