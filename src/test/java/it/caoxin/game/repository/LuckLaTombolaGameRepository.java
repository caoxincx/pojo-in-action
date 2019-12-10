package it.caoxin.game.repository;

import it.caoxin.game.domain.game.LuckyLaTombolaGame;
import it.caoxin.game.dto.input.InitGameLuckyLaTombolaVO;

import java.util.List;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/9
 * 功能描述:
 * 修改日期:2019/12/9
 * 修改描述:
 */
public interface LuckLaTombolaGameRepository {
    List<LuckyLaTombolaGame> getLuckyLaTombolaGameByDateAndUserId(InitGameLuckyLaTombolaVO initGameLuckyLaTombolaVO);

    LuckyLaTombolaGame insertLuckyLaTombolaGame(LuckyLaTombolaGame luckyLaTombolaGame);

    void updateLuckyLaTombolaGame(LuckyLaTombolaGame luckyLaTombolaGame);
}
