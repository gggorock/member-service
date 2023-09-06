package org.gggorock.memberservice.application.service;

import lombok.RequiredArgsConstructor;
import org.gggorock.memberservice.application.port.in.JoinMemberCommand;
import org.gggorock.memberservice.application.port.in.JoinMemberUseCase;
import org.gggorock.memberservice.application.port.out.JoinMemberResponse;
import org.gggorock.memberservice.application.port.out.MemberRepositoryPort;
import org.gggorock.memberservice.application.port.out.PasswordEncoderPort;
import org.gggorock.memberservice.domain.Member;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinMemberService implements JoinMemberUseCase {

    private final MemberRepositoryPort repository;
    private final PasswordEncoderPort passwordEncoder;

    @Override
    public JoinMemberResponse execute(JoinMemberCommand command) {
        Member member = command.toDomainEntity(passwordEncoder);
        Long memberId = repository.save(member);
        return new JoinMemberResponse(memberId);
    }
}
