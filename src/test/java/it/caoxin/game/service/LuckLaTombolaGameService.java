package it.caoxin.game.service;

import it.caoxin.game.dto.input.InitGameLuckyLaTombolaVO;
import it.caoxin.game.dto.input.LuckyLaTombolaBonusVO;
import it.caoxin.game.dto.input.ScratchLuckyLaTombolaVO;
import it.caoxin.game.dto.output.LuckyLaTombolaGameBonus;
import it.caoxin.game.dto.output.LuckyLaTombolaGameResult;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/9
 * 功能描述:
 * 修改日期:2019/12/9
 * 修改描述:
 */
public interface LuckLaTombolaGameService {
    LuckyLaTombolaGameResult getCurrentGameData(InitGameLuckyLaTombolaVO initGameData);

    void scratchOffLaTombolaGame(ScratchLuckyLaTombolaVO scratchLuckyLaTombolaGameData);

    LuckyLaTombolaGameBonus getBonus(LuckyLaTombolaBonusVO luckyLaTombolaBonusVO);

}
