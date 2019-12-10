package it.caoxin.game.dto.output;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/9
 * 功能描述:
 * 修改日期:2019/12/9
 * 修改描述:
 */
public class LuckyLaTombolaGameResult {
    private String roundStartDateTime;
    private int roundMinutes;
    private int ownOpportunityTimes;
    private int round;


    public String getRoundStartDateTime() {
        return roundStartDateTime;
    }

    public void setRoundStartDateTime(String roundStartDateTime) {
        this.roundStartDateTime = roundStartDateTime;
    }

    public int getRoundMinutes() {
        return roundMinutes;
    }

    public void setRoundMinutes(int roundMinutes) {
        this.roundMinutes = roundMinutes;
    }

    public int getOwnOpportunityTimes() {
        return ownOpportunityTimes;
    }

    public void setOwnOpportunityTimes(int ownOpportunityTimes) {
        this.ownOpportunityTimes = ownOpportunityTimes;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

}
