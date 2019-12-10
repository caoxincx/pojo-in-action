package it.caoxin.game.dto;

import it.caoxin.game.dto.output.LuckyLaTombolaGameResult;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/10
 * 功能描述:
 * 修改日期:2019/12/10
 * 修改描述:
 */
public final class LuckyLaTombolaGameResultBuilder {
    private String roundStartDateTime;
    private int roundMinutes;
    private int ownOpportunityTimes;
    private int round;

    private LuckyLaTombolaGameResultBuilder() {
    }

    public static LuckyLaTombolaGameResultBuilder aLuckyLaTombolaGameResult() {
        return new LuckyLaTombolaGameResultBuilder();
    }

    public LuckyLaTombolaGameResultBuilder withRoundStartDateTime(String roundStartDateTime) {
        this.roundStartDateTime = roundStartDateTime;
        return this;
    }

    public LuckyLaTombolaGameResultBuilder withRoundMinutes(int roundMinutes) {
        this.roundMinutes = roundMinutes;
        return this;
    }

    public LuckyLaTombolaGameResultBuilder withOwnOpportunityTimes(int ownOpportunityTimes) {
        this.ownOpportunityTimes = ownOpportunityTimes;
        return this;
    }

    public LuckyLaTombolaGameResultBuilder withRound(int round) {
        this.round = round;
        return this;
    }

    public LuckyLaTombolaGameResult build() {
        LuckyLaTombolaGameResult luckyLaTombolaGameResult = new LuckyLaTombolaGameResult();
        luckyLaTombolaGameResult.setRoundStartDateTime(roundStartDateTime);
        luckyLaTombolaGameResult.setRoundMinutes(roundMinutes);
        luckyLaTombolaGameResult.setOwnOpportunityTimes(ownOpportunityTimes);
        luckyLaTombolaGameResult.setRound(round);
        return luckyLaTombolaGameResult;
    }
}
