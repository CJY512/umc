package umc.spring.converter.member;

import umc.spring.api.controller.member.dto.MemberRequestDto;
import umc.spring.api.controller.member.dto.MemberResponseDto;
import umc.spring.domain.member.Gender;
import umc.spring.domain.member.Member;

import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDto.JoinResultDto toJoinResultDTO(Member member){
        return MemberResponseDto.JoinResultDto.builder()
                .id(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberRequestDto.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .name(request.getName())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .memberPreferList(new ArrayList<>())
                .build();

    }
}