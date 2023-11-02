package umc.spring.mapping.member_mission;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberMissionStatus {

    CHALLENGING("진행중"),
    COMPLETE("진행완료"),
    FAIL("실패");

    private final String text;
}
