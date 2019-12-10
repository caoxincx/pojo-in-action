package it.caoxin.game.dto;

import it.caoxin.game.dto.input.InitGameLuckyLaTombolaVO;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/10
 * 功能描述:
 * 修改日期:2019/12/10
 * 修改描述:
 */
public final class InitGameLuckyLaTombolaVOBuilder {
    private String userId;
    private String date10;

    private InitGameLuckyLaTombolaVOBuilder() {
    }

    public static InitGameLuckyLaTombolaVOBuilder anInitGameLuckyLaTombolaVO() {
        return new InitGameLuckyLaTombolaVOBuilder();
    }

    public InitGameLuckyLaTombolaVOBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public InitGameLuckyLaTombolaVOBuilder withDate10(String date10) {
        this.date10 = date10;
        return this;
    }

    public InitGameLuckyLaTombolaVO build() {
        InitGameLuckyLaTombolaVO initGameLuckyLaTombolaVO = new InitGameLuckyLaTombolaVO();
        initGameLuckyLaTombolaVO.setUserId(userId);
        initGameLuckyLaTombolaVO.setDate10(date10);
        return initGameLuckyLaTombolaVO;
    }
}
