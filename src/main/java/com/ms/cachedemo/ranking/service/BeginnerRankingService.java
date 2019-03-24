package com.ms.cachedemo.ranking.service;

import com.ms.cachedemo.member.Member;
import com.ms.cachedemo.member.MemberRepository;
import com.ms.cachedemo.ranking.RankingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class BeginnerRankingService implements RankingService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MemberRepository memberRepository;
    private final ValueOperations<String, List<Member>> operations;

    public BeginnerRankingService(MemberRepository memberRepository, RedisTemplate redisTemplate) {
        this.memberRepository = memberRepository;
        this.operations = redisTemplate.opsForValue();
    }

    @Override
    public List<Member> getRanking(RankingType type) {
        final String key = format("%s:%s", RANKING_GETTING_KEY, type.name().toLowerCase());
        final List<Member> cachedRankingList = this.operations.get(key);

        if (CollectionUtils.isEmpty(cachedRankingList)) {
            log.info("business logic execution");
            final List<Member> rankingList = this.memberRepository.findAll()
                    .stream()
//                    .sorted() 랭킹을 정하는 로직이 있다고 가정
                    .collect(Collectors.toList());

            this.operations.set(key, rankingList, 30L, TimeUnit.SECONDS);
            return rankingList;
        } else {
            return cachedRankingList;
        }
    }
}
