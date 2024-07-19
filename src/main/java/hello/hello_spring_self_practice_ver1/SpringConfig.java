package hello.hello_spring_self_practice_ver1;

import hello.hello_spring_self_practice_ver1.aop.TimeTraceAop;
import hello.hello_spring_self_practice_ver1.repository.MemberRepository;
import hello.hello_spring_self_practice_ver1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

}
