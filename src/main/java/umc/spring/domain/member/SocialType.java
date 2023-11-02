package umc.spring.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SocialType {

    KAKAO("카카오"),
    NAVER("네이버"),
    GOOGLE("구글"),
    FACEBOOK("페이스북"),
    APPLE("애플");

    private final String text;
}
