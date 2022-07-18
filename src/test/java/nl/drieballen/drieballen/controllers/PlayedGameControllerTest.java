package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.PlayedGameDto;
import nl.drieballen.drieballen.models.Profile;
import nl.drieballen.drieballen.models.ScoreCard;
import nl.drieballen.drieballen.security.jwt.AuthEntryPointJwt;
import nl.drieballen.drieballen.security.jwt.JwtUtils;
import nl.drieballen.drieballen.security.services.UserDetailsServiceImpl;
import nl.drieballen.drieballen.services.PlayedGameService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(PlayedGameController.class)
class PlayedGameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PlayedGameService playedGameService;

    @MockBean
    UserDetailsServiceImpl userDetailsService;

    @MockBean
    JwtUtils jwtUtils;

    @MockBean
    AuthEntryPointJwt authEntryPointJwt;

    @Test
    @WithMockUser(username= "user", roles = "ADMIN")
    void getAllPlayedGamesByUsername() throws Exception {

        Profile profile = new Profile();
        profile.setUsername("user");
        ScoreCard sc = new ScoreCard();
        sc.setFilledIn(true);
        sc.setId((long) 1);
        ScoreCard sc2 = new ScoreCard();
        sc2.setFilledIn(false);
        sc2.setId((long) 2);

        ArrayList<PlayedGameDto> dtos = new ArrayList<PlayedGameDto>();
        PlayedGameDto dto = new PlayedGameDto();
        dto.setProfile(profile);
        dto.setScoreCard(sc);
        PlayedGameDto dto2 = new PlayedGameDto();
        dto2.setProfile(profile);
        dto2.setScoreCard(sc2);
        dtos.add(dto2);
        dtos.add(dto);

        Mockito.when(playedGameService.findPlayedGameById("user")).thenReturn(dtos);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/playedgame/find?username=user"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].scoreCard.filledIn").value(true))
                .andExpect(jsonPath("$[1].scoreCard.filledIn").value(true))
                .andExpect(jsonPath("$[0].profile.username").value("user"));
    }

    @Test
    void getUsernamesByScId() {

    }

    @Test
    void createPlayedGame() {
    }
}