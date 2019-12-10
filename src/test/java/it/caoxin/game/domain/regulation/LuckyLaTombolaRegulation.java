package it.caoxin.game.domain.regulation;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/9
 * 功能描述:
 * 修改日期:2019/12/9
 * 修改描述:
 */
public class LuckyLaTombolaRegulation {
    public static final long[] ROUND_CONTINUAL_TIME = {0,30, 30, 120, 180};

    public boolean isAroundContinue(int round, Date roundStartDateTime) {
        return transGameStartDateTime(roundStartDateTime)
                .plusMinutes(getRoundContinualTime(round))
                .isAfter(LocalDateTime.now());
    }

    public LocalDateTime transGameStartDateTime(Date roundStartDateTime) {
        Instant instant = roundStartDateTime.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    public int getRoundContinualTime(int round) {
        return round > ROUND_CONTINUAL_TIME.length-2?round:ROUND_CONTINUAL_TIME.length-1;
    }

    public String formatDate(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDateTime);
    }
}
