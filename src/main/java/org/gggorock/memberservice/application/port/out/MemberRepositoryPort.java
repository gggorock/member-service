package org.gggorock.memberservice.application.port.out;

import org.gggorock.memberservice.domain.Member;

public interface MemberRepositoryPort {

    Long save(Member member);
}
