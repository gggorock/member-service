package org.gggorock.memberservice.adapter.in;

import lombok.RequiredArgsConstructor;
import org.gggorock.memberservice.application.port.in.JoinMemberCommand;
import org.gggorock.memberservice.application.port.in.JoinMemberUseCase;
import org.gggorock.memberservice.application.port.out.JoinMemberResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinMemberController {

    private final JoinMemberUseCase joinMember;

    @PostMapping("/members")
    public ResponseEntity<JoinMemberResponse> handlePostMembers(@RequestBody JoinMemberCommand command){
        JoinMemberResponse response = joinMember.execute(command);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
