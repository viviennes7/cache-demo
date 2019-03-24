package com.ms.cachedemo.ranking.service.di;

import com.ms.cachedemo.member.Member;
import com.ms.cachedemo.member.MemberRepository;
import com.ms.cachedemo.ranking.RankingType;
import com.ms.cachedemo.ranking.service.RankingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("basicRankingService")
public class BasicRankingService implements RankingService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MemberRepository memberRepository;

    public BasicRankingService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getRanking(RankingType type) {
        log.info("business logic execution");
        return this.memberRepository.findAll()
                .stream()
//              .sorted() 랭킹을 정하는 로직이 있다고 가정
                .collect(Collectors.toList());
    }
}
