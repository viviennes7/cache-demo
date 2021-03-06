package com.ms.cachedemo.ranking;

import com.ms.cachedemo.ranking.service.RankingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BeginnerRankingServiceTest {

    @Autowired
    private RankingService beginnerRankingService;

    @Test
    public void getRanking() {
        this.beginnerRankingService.getRanking(RankingType.ALL);
        this.beginnerRankingService.getRanking(RankingType.ALL);
        this.beginnerRankingService.getRanking(RankingType.MONTH);
    }
}