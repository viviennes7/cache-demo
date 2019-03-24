package com.ms.cachedemo.ranking.service.di;

import com.ms.cachedemo.ranking.RankingType;
import com.ms.cachedemo.ranking.service.RankingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheRankingServiceTest {

    @Autowired
    private RankingService cacheRankingService;

    @Test
    public void getRanking() {
        this.cacheRankingService.getRanking(RankingType.ALL);
        this.cacheRankingService.getRanking(RankingType.ALL);
        this.cacheRankingService.getRanking(RankingType.MONTH);
    }
}