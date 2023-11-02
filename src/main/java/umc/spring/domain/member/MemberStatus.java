package umc.spring.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberStatus {

    ACTIVE("활성화"),
    INACTIVE("비활성화"),
    DELETE("삭제");

    private final String text;
}
