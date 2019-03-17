package com.ms.cachedemo.ranking.service;

import com.ms.cachedemo.member.Member;
import com.ms.cachedemo.ranking.RankingType;

import java.util.List;

public interface RankingService {
    String RANKING_GETTING_KEY = "ranking:get";

    List<Member> getRanking(RankingType type);
}
