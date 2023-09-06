package org.gggorock.memberservice.application.port.in;

import org.gggorock.memberservice.application.port.out.JoinMemberResponse;

public interface JoinMemberUseCase {

    JoinMemberResponse execute(JoinMemberCommand command);
}
