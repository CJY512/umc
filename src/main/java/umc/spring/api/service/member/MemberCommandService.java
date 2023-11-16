package umc.spring.api.service.member;

import umc.spring.api.controller.member.dto.MemberRequestDto;
import umc.spring.domain.member.Member;

public interface MemberCommandService {

    Member joinMember(MemberRequestDto.JoinDto request);
}
