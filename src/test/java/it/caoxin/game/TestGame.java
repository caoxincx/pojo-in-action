package it.caoxin.game;

import it.caoxin.game.domain.game.LuckyLaTombolaGame;
import it.caoxin.game.domain.regulation.LuckyLaTombolaRegulation;
import it.caoxin.game.dto.InitGameLuckyLaTombolaVOBuilder;
import it.caoxin.game.dto.input.InitGameLuckyLaTombolaVO;
import it.caoxin.game.dto.output.LuckyLaTombolaGameResult;
import it.caoxin.game.repository.LuckLaTombolaGameRepository;
import it.caoxin.game.service.LuckLaTombolaGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;


/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/12/9
 * 功能描述:
 * 修改日期:2019/12/9
 * 修改描述:
 */
public class TestGame {
    @Mock
    private LuckLaTombolaGameService luckLaTombolaGameService;
    @Mock
    private LuckLaTombolaGameRepository luckLaTombolaGameRepository;
    private LuckyLaTombolaRegulation luckyLaTombolaRegulation = new LuckyLaTombolaRegulation();
    private LuckyLaTombolaGame luckyLaTombolaGame = new LuckyLaTombolaGame();

    private
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testIsInCurrentTime() {
        List<LuckyLaTombolaGame> lists = new ArrayList<>();
        LuckyLaTombolaGame luckyLaTombolaGame1 = new LuckyLaTombolaGame();
        luckyLaTombolaGame1.setId("1");
        luckyLaTombolaGame1.setGameName("刮刮乐");
        luckyLaTombolaGame1.setLaTombolaType("普通");
        luckyLaTombolaGame1.setCurrentOpportunity(20);
        luckyLaTombolaGame1.setRoundStartTime(new Date());
        lists.add(luckyLaTombolaGame1);

        luckyLaTombolaGame.setLaTombolaGames(lists);
        // 当前轮次是否有效
        boolean isInAround1 = luckyLaTombolaGame.isAroundContinue();
        assertEquals("是否在当前轮次", isInAround1, true);

        luckyLaTombolaGame1.setRoundStartTime(new Date(111111111));
        boolean isInAround2 = luckyLaTombolaGame.isAroundContinue();
        assertEquals("是否在当前轮次", isInAround2, false);


    }
    @Test
    public void testIsOwnOpportunity() {

        List<LuckyLaTombolaGame> lists = new ArrayList<>();
        LuckyLaTombolaGame luckyLaTombolaGame1 = new LuckyLaTombolaGame();
        luckyLaTombolaGame1.setId("1");
        luckyLaTombolaGame1.setGameName("刮刮乐");
        luckyLaTombolaGame1.setLaTombolaType("普通");
        luckyLaTombolaGame1.setCurrentOpportunity(20);

        LuckyLaTombolaGame luckyLaTombolaGame2 = new LuckyLaTombolaGame();
        luckyLaTombolaGame2.setId("1");
        luckyLaTombolaGame2.setGameName("刮刮乐");
        luckyLaTombolaGame2.setLaTombolaType("特殊");
        luckyLaTombolaGame2.setCurrentOpportunity(5);
        lists.add(luckyLaTombolaGame1);
        lists.add(luckyLaTombolaGame2);

        when(luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(any(InitGameLuckyLaTombolaVO.class))).thenReturn(lists);

        InitGameLuckyLaTombolaVO build = InitGameLuckyLaTombolaVOBuilder.anInitGameLuckyLaTombolaVO().withDate10("").withUserId("").build();
        List<LuckyLaTombolaGame> laTombolaGames = luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(build);
        luckyLaTombolaGame.setLaTombolaGames(laTombolaGames);
        int usedOpportunity = luckyLaTombolaGame.haveUsedOpportunity();
        assertEquals("本轮次已经使用的机会",usedOpportunity,25);

        assertEquals("本轮次已经没有机会",luckyLaTombolaGame.isHasOpportunity(),false);

        verify(luckLaTombolaGameRepository).getLuckyLaTombolaGameByDateAndUserId(build);

    }
    @Test
    public void testHasNoOpportunity() {
        // 普通刮刮卡机会
        // 特殊刮刮卡机会
        List<LuckyLaTombolaGame> lists = new ArrayList<>();
        LuckyLaTombolaGame luckyLaTombolaGame1 = new LuckyLaTombolaGame();
        luckyLaTombolaGame1.setId("1");
        luckyLaTombolaGame1.setGameName("刮刮乐");
        luckyLaTombolaGame1.setLaTombolaType("普通");
        luckyLaTombolaGame1.setCurrentOpportunity(20);

        LuckyLaTombolaGame luckyLaTombolaGame2 = new LuckyLaTombolaGame();
        luckyLaTombolaGame2.setId("1");
        luckyLaTombolaGame2.setGameName("刮刮乐");
        luckyLaTombolaGame2.setLaTombolaType("特殊");
        luckyLaTombolaGame2.setCurrentOpportunity(5);
        lists.add(luckyLaTombolaGame1);
        lists.add(luckyLaTombolaGame2);

        when(luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(any(InitGameLuckyLaTombolaVO.class))).thenReturn(lists);

        InitGameLuckyLaTombolaVO build = InitGameLuckyLaTombolaVOBuilder.anInitGameLuckyLaTombolaVO().withDate10("").withUserId("").build();
        List<LuckyLaTombolaGame> laTombolaGames = luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(build);
        luckyLaTombolaGame.setLaTombolaGames(laTombolaGames);


        int normalOpportunity = luckyLaTombolaGame.hasNormalOpportunity();
        boolean hasNormalOpportunity = luckyLaTombolaGame.isHasNormalOpportunity();
        assertEquals("普通还剩0次机会",normalOpportunity,0);
        assertEquals("普通还剩0次机会",hasNormalOpportunity,false);

        int specialOpportunity = luckyLaTombolaGame.hasSpecialOpportunity();
        boolean hasSpecialOpportunity = luckyLaTombolaGame.isHasSpecialOpportunity();
        assertEquals("特殊还剩0次机会",specialOpportunity,0);
        assertEquals("特殊还剩0次机会",hasSpecialOpportunity,false);

        verify(luckLaTombolaGameRepository).getLuckyLaTombolaGameByDateAndUserId(build);

    }
    @Test
    public void testHasOpportunity() {
        // 普通刮刮卡机会
        // 特殊刮刮卡机会
        List<LuckyLaTombolaGame> lists = new ArrayList<>();
        when(luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(any(InitGameLuckyLaTombolaVO.class))).thenReturn(lists);

        InitGameLuckyLaTombolaVO build = InitGameLuckyLaTombolaVOBuilder.anInitGameLuckyLaTombolaVO().withDate10("").withUserId("").build();
        List<LuckyLaTombolaGame> laTombolaGames = luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(build);
        luckyLaTombolaGame.setLaTombolaGames(laTombolaGames);

        int normalOpportunity = luckyLaTombolaGame.hasNormalOpportunity();
        boolean hasNormalOpportunity = luckyLaTombolaGame.isHasNormalOpportunity();
        assertEquals("普通还剩20次机会",normalOpportunity,20);
        assertEquals("普通还剩0次机会",hasNormalOpportunity,true);

        int specialOpportunity = luckyLaTombolaGame.hasSpecialOpportunity();
        boolean hasSpecialOpportunity = luckyLaTombolaGame.isHasSpecialOpportunity();
        assertEquals("特殊还剩5次机会",specialOpportunity,5);
        assertEquals("特殊还剩5次机会",hasSpecialOpportunity,true);


    }
    @Test
    public void testHasOpportunityNull() {
        // 普通刮刮卡机会
        // 特殊刮刮卡机会
        List<LuckyLaTombolaGame> lists = null;
        // 这个控制
        when(luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(any(InitGameLuckyLaTombolaVO.class))).thenReturn(lists);


        List<LuckyLaTombolaGame> laTombolaGames = luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(InitGameLuckyLaTombolaVOBuilder.anInitGameLuckyLaTombolaVO().withDate10("").withUserId("").build());
        luckyLaTombolaGame.setLaTombolaGames(laTombolaGames);
        try {
            int normalOpportunity = luckyLaTombolaGame.hasNormalOpportunity();
            assertEquals("普通还剩20次机会",normalOpportunity,20);
            int specialOpportunity = luckyLaTombolaGame.hasSpecialOpportunity();
            assertEquals("特殊还剩5次机会",specialOpportunity,5);
        } catch (Exception e) {
            assertEquals("空指针异常", e.getMessage(), null);
            e.printStackTrace();
        }
    }

    @Test
    public void testGetInitData() {
        List<LuckyLaTombolaGame> lists = new ArrayList<>();
        LuckyLaTombolaGame luckyLaTombolaGame1 = new LuckyLaTombolaGame();
        luckyLaTombolaGame1.setId("1");
        luckyLaTombolaGame1.setGameName("刮刮乐");
        luckyLaTombolaGame1.setLaTombolaType("普通");
        luckyLaTombolaGame1.setCurrentOpportunity(20);

        LuckyLaTombolaGame luckyLaTombolaGame2 = new LuckyLaTombolaGame();
        luckyLaTombolaGame2.setId("1");
        luckyLaTombolaGame2.setGameName("刮刮乐");
        luckyLaTombolaGame2.setLaTombolaType("特殊");
        luckyLaTombolaGame2.setCurrentOpportunity(5);
        lists.add(luckyLaTombolaGame1);
        lists.add(luckyLaTombolaGame2);

        when(luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(any(InitGameLuckyLaTombolaVO.class))).thenReturn(lists);

        InitGameLuckyLaTombolaVO build = InitGameLuckyLaTombolaVOBuilder.anInitGameLuckyLaTombolaVO().withDate10("").withUserId("").build();
        List<LuckyLaTombolaGame> laTombolaGames = luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(build);
        luckyLaTombolaGame.setLaTombolaGames(laTombolaGames);

        LuckyLaTombolaGameResult initGameData = luckyLaTombolaGame.getInitGameData();
        LuckyLaTombolaGame latestRroundGameRecord = luckyLaTombolaGame.getLatestRroundGameRecord();
        assertEquals("轮次为LastestRecord的轮次加1",initGameData.getRound(),latestRroundGameRecord.getRound()+1);
        assertEquals("轮次为LastestRecord的轮次加1",initGameData.getOwnOpportunityTimes(),20);
    }

    @Test
    public void testGetContinueData() {
        List<LuckyLaTombolaGame> lists = new ArrayList<>();
        LuckyLaTombolaGame luckyLaTombolaGame1 = new LuckyLaTombolaGame();
        luckyLaTombolaGame1.setId("1");
        luckyLaTombolaGame1.setGameName("刮刮乐");
        luckyLaTombolaGame1.setLaTombolaType("普通");
        luckyLaTombolaGame1.setCurrentOpportunity(20);
        luckyLaTombolaGame1.setRoundStartTime(new Date(System.currentTimeMillis()));

        LuckyLaTombolaGame luckyLaTombolaGame2 = new LuckyLaTombolaGame();
        luckyLaTombolaGame2.setId("1");
        luckyLaTombolaGame2.setGameName("刮刮乐");
        luckyLaTombolaGame2.setLaTombolaType("特殊");
        luckyLaTombolaGame2.setCurrentOpportunity(5);
        lists.add(luckyLaTombolaGame1);
        lists.add(luckyLaTombolaGame2);
        luckyLaTombolaGame1.setRoundStartTime(new Date(System.currentTimeMillis()));

        when(luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(any(InitGameLuckyLaTombolaVO.class))).thenReturn(lists);

        InitGameLuckyLaTombolaVO build = InitGameLuckyLaTombolaVOBuilder.anInitGameLuckyLaTombolaVO().withDate10("").withUserId("").build();
        List<LuckyLaTombolaGame> laTombolaGames = luckLaTombolaGameRepository.getLuckyLaTombolaGameByDateAndUserId(build);
        luckyLaTombolaGame.setLaTombolaGames(laTombolaGames);

        LuckyLaTombolaGameResult continueGameData = luckyLaTombolaGame.getContinueGameData();
        LuckyLaTombolaGame latestRroundGameRecord = luckyLaTombolaGame.getLatestRroundGameRecord();
        assertEquals("轮次为LastestRecord的轮次",continueGameData.getRound(),latestRroundGameRecord.getRound());
        assertEquals("轮次为LastestRecord的轮次",continueGameData.getOwnOpportunityTimes(),luckyLaTombolaGame.getTotalOpportunity());


    }
}
