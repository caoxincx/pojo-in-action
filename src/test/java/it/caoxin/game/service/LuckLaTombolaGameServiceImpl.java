package it.caoxin.game.service;

import it.caoxin.game.domain.game.LuckyLaTombolaGame;
import it.caoxin.game.dto.input.InitGameLuckyLaTombolaVO;
import it.caoxin.game.dto.input.LuckyLaTombolaBonusVO;
import it.caoxin.game.dto.input.ScratchLuckyLaTombolaVO;
import it.caoxin.game.dto.output.LuckyLaTombolaGameBonus;
import it.caoxin.game.dto.output.LuckyLaTombolaGameResult;
import it.caoxin.game.repository.LuckLaTombolaGameRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/10
 * 功能描述:
 * 修改日期:2019/12/10
 * 修改描述:
 */
public class LuckLaTombolaGameServiceImpl implements LuckLaTombolaGameService {
    @Autowired
    private LuckLaTombolaGameRepository luckLaTombolaGameRepository;
    @Override
    public LuckyLaTombolaGameResult getCurrentGameData(InitGameLuckyLaTombolaVO initGameData) {
        List<LuckyLaTombolaGame> luckyLaTombolaGames =
                luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(initGameData);
        LuckyLaTombolaGame luckyLaTombolaGame = new LuckyLaTombolaGame();
        luckyLaTombolaGame.setLaTombolaGames(luckyLaTombolaGames);


        if (luckyLaTombolaGames.isEmpty() || !luckyLaTombolaGame.isAroundContinue()) {
            return luckyLaTombolaGame.getInitGameData();
        }else {
            return luckyLaTombolaGame.getContinueGameData();
        }
    }

    @Override
    public void scratchOffLaTombolaGame(ScratchLuckyLaTombolaVO scratchLuckyLaTombolaGameData) {

    }

    @Override
    public LuckyLaTombolaGameBonus getBonus(LuckyLaTombolaBonusVO luckyLaTombolaBonusVO) {
        return null;
    }
}
