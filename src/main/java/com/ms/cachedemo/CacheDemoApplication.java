package com.ms.cachedemo;

import com.ms.cachedemo.member.Member;
import com.ms.cachedemo.member.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.Arrays.asList;

@SpringBootApplication
public class CacheDemoApplication implements CommandLineRunner {

    private final MemberRepository memberRepository;

    public CacheDemoApplication(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CacheDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.memberRepository.saveAll(
                asList(
                        new Member("minsoo"),
                        new Member("wonwoo"),
                        new Member("toby"),
                        new Member("adel"),
                        new Member("manbok")
                )
        );
    }
}
