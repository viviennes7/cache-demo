package com.ms.cachedemo.ranking.service;

import com.ms.cachedemo.config.aop.Cacheable;
import com.ms.cachedemo.member.Member;
import com.ms.cachedemo.member.MemberRepository;
import com.ms.cachedemo.ranking.RankingType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("basicRankingService")
public class BasicRankingService implements RankingService {
    private final MemberRepository memberRepository;

    public BasicRankingService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Cacheable
    @Override
    public List<Member> getRanking(RankingType type) {
        return this.memberRepository.findAll()
                .stream()
//              .sorted() 랭킹을 정하는 로직이 있다고 가정
                .collect(Collectors.toList());
    }
}
