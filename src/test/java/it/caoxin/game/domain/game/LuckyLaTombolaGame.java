package it.caoxin.game.domain.game;

import it.caoxin.game.domain.regulation.LuckyLaTombolaRegulation;
import it.caoxin.game.dto.LuckyLaTombolaGameResultBuilder;
import it.caoxin.game.dto.output.LuckyLaTombolaGameResult;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparingInt;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/9
 * 功能描述:
 * 修改日期:2019/12/9
 * 修改描述:
 */
public class LuckyLaTombolaGame {
    private String id;
    private String gameName;
    private int round;
    private Date roundStartTime;
    private String laTombolaType;
    private int currentOpportunity;
    private List<LuckyLaTombolaGame> laTombolaGames;
    private static LuckyLaTombolaRegulation LUCKYLATOMBOLA_REGULATIONN = new LuckyLaTombolaRegulation();
    private static final int GAME_INIT_OPPORTUNITY = 20;


    public LuckyLaTombolaGameResult getContinueGameData() {
        LuckyLaTombolaGame latestRroundGameRecord = getLatestRroundGameRecord();
        return LuckyLaTombolaGameResultBuilder
                .aLuckyLaTombolaGameResult()
                .withOwnOpportunityTimes(getTotalOpportunity())
                .withRound(latestRroundGameRecord.getRound())
                .withRoundMinutes(LUCKYLATOMBOLA_REGULATIONN.getRoundContinualTime(latestRroundGameRecord.getRound()))
                .withRoundStartDateTime(LUCKYLATOMBOLA_REGULATIONN.formatDate(LUCKYLATOMBOLA_REGULATIONN.transGameStartDateTime(latestRroundGameRecord.getRoundStartTime())))
                .build();
    }
    public LuckyLaTombolaGameResult getInitGameData() {
        LuckyLaTombolaGame latestRroundGameRecord = getLatestRroundGameRecord();
        return LuckyLaTombolaGameResultBuilder
                .aLuckyLaTombolaGameResult()
                .withOwnOpportunityTimes(GAME_INIT_OPPORTUNITY)
                .withRound(latestRroundGameRecord.getRound() + 1)
                .withRoundMinutes(LUCKYLATOMBOLA_REGULATIONN.getRoundContinualTime(latestRroundGameRecord.getRound()+1))
                .withRoundStartDateTime(LUCKYLATOMBOLA_REGULATIONN.formatDate(LocalDateTime.now()))
                .build();
    }
    public LuckyLaTombolaGame getLatestRroundGameRecord() {
        return Optional.of(laTombolaGames.stream()
                .max(comparingInt(LuckyLaTombolaGame::getRound))
                .get()).orElseGet(LuckyLaTombolaGame::new);
    }
    public boolean isAroundContinue() {
        LuckyLaTombolaGame latestRroundGameRecord = getLatestRroundGameRecord();
        return LUCKYLATOMBOLA_REGULATIONN.isAroundContinue(latestRroundGameRecord.getRound(), latestRroundGameRecord.getRoundStartTime());
    }

    public boolean isHasOpportunity() {
        return haveUsedOpportunity() < 20;
    }
    public boolean isHasSpecialOpportunity() {
        return hasSpecialOpportunity() > 0;
    }
    public boolean isHasNormalOpportunity() {
        return hasNormalOpportunity() > 0;
    }
    public int haveUsedOpportunity() {
        return haveUsedNormalOpportunity()+haveSpecialOpportunity();
    }
    public int getTotalOpportunity(){
        return 20 - haveUsedOpportunity();
    }
    public int hasNormalOpportunity() {
        return  20 - haveUsedNormalOpportunity();
    }
    public int hasSpecialOpportunity() {
        return  5 - haveSpecialOpportunity();
    }


    private int haveUsedNormalOpportunity() {
        Optional<Integer> usedOpportunity = laTombolaGames.stream()
                .filter(i -> "普通".equals(i.getLaTombolaType()))
                .map(LuckyLaTombolaGame::getCurrentOpportunity)
                .max(Integer::compareTo);
        return  (usedOpportunity.isPresent() ? usedOpportunity.get() : 0);
    }
    private int haveSpecialOpportunity() {
        Optional<Integer> usedOpportunity = laTombolaGames.stream()
                .filter(i -> "特殊".equals(i.getLaTombolaType()))
                .map(LuckyLaTombolaGame::getCurrentOpportunity)
                .max(Integer::compareTo);
        return (usedOpportunity.isPresent() ? usedOpportunity.get() : 0);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getLaTombolaType() {
        return laTombolaType;
    }

    public void setLaTombolaType(String laTombolaType) {
        this.laTombolaType = laTombolaType;
    }

    public int getCurrentOpportunity() {
        return currentOpportunity;
    }

    public void setCurrentOpportunity(int currentOpportunity) {
        this.currentOpportunity = currentOpportunity;
    }

    public Date getRoundStartTime() {
        return roundStartTime;
    }

    public void setRoundStartTime(Date roundStartTime) {
        this.roundStartTime = roundStartTime;
    }


    public List<LuckyLaTombolaGame> getLaTombolaGames() {
        return laTombolaGames;
    }

    public void setLaTombolaGames(List<LuckyLaTombolaGame> laTombolaGames) {
        this.laTombolaGames = laTombolaGames;
    }



}
