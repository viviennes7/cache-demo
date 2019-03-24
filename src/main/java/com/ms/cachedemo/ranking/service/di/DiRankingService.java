package com.ms.cachedemo.ranking.service.di;

import com.ms.cachedemo.member.Member;
import com.ms.cachedemo.ranking.RankingType;
import com.ms.cachedemo.ranking.service.RankingService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

@Service
public class DiRankingService implements RankingService {
    private final ValueOperations<String, List<Member>> operations;
    private final RankingService rankingService;

    public DiRankingService(RedisTemplate redisTemplate, RankingService basicRankingService) {
        this.operations = redisTemplate.opsForValue();
        this.rankingService = basicRankingService;
    }

    @Override
    public List<Member> getRanking(RankingType type) {
        final String key = format("%s:%s", RANKING_GETTING_KEY, type.name().toLowerCase());
        final List<Member> cachedRankingList = this.operations.get(key);

        if (CollectionUtils.isEmpty(cachedRankingList)) {
            final List<Member> rankingList = this.rankingService.getRanking(type);
            this.operations.set(key, rankingList, 30L, TimeUnit.SECONDS);
            return rankingList;
        } else {
            return cachedRankingList;
        }
    }
}
