package HELLO.hellospring.service;

import HELLO.hellospring.domain.Member;
import HELLO.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    private void afterEach(){
        memberRepository.clearStore();
    }

    @Test // 회원가입
    void join() {
        // given
        Member member = new Member();
        member.setName("HELLO");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember =  memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test // 회원가입
    void join2() {
        // given
        Member member1 = new Member();
        member1.setName("HELLO");
        Member member2 = new Member();
        member2.setName("HELLO");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}