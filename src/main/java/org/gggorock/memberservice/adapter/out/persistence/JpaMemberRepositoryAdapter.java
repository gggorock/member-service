package org.gggorock.memberservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.gggorock.memberservice.application.port.out.MemberRepositoryPort;
import org.gggorock.memberservice.domain.Member;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaMemberRepositoryAdapter implements MemberRepositoryPort {

    private final MemberJpaRepository repository;

    @Override
    public Long save(Member member) {
        MemberJpaEntity entity = MemberJpaEntity.from(member);
        return repository.save(entity).getId();
    }
}
