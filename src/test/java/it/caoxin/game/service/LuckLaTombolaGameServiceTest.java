package it.caoxin.game.service;

import it.caoxin.game.dto.InitGameLuckyLaTombolaVOBuilder;
import it.caoxin.game.dto.input.InitGameLuckyLaTombolaVO;
import it.caoxin.game.repository.LuckLaTombolaGameRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/10
 * 功能描述:
 * 修改日期:2019/12/10
 * 修改描述:
 */
class LuckLaTombolaGameServiceTest {
    @Mock
    private LuckLaTombolaGameRepository luckLaTombolaGameRepository;

    @BeforeAll
    public void beforeAll() {
        MockitoAnnotations.initMocks(this);
    }


}