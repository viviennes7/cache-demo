package com.ms.cachedemo.ranking;

import com.ms.cachedemo.ranking.service.RankingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BeginnerRankingServiceTest {

    @Resource(name = "beginnerRankingService")
    private RankingService rankingService;

    @Test
    public void getRanking() {
        this.rankingService.getRanking(RankingType.ALL);
        this.rankingService.getRanking(RankingType.ALL);
    }
}