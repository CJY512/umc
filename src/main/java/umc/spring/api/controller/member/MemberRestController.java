package umc.spring.api.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.api.controller.member.dto.MemberRequestDto;
import umc.spring.api.controller.member.dto.MemberResponseDto;
import umc.spring.api.service.member.MemberCommandService;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.member.MemberConverter;
import umc.spring.domain.member.Member;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/join")
    public ApiResponse<MemberResponseDto.JoinResultDto> join(@RequestBody @Valid MemberRequestDto.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
