package com.ms.cachedemo.ranking.service.aop;

import com.ms.cachedemo.ranking.RankingType;
import com.ms.cachedemo.ranking.service.RankingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AopRankingServiceTest {

    @Autowired
    private RankingService aopRankingService;

    @Test
    public void getRanking() {
        this.aopRankingService.getRanking(RankingType.ALL);
        this.aopRankingService.getRanking(RankingType.ALL);
        this.aopRankingService.getRanking(RankingType.MONTH);
    }
}