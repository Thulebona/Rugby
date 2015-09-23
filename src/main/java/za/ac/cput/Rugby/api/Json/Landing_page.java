package za.ac.cput.Rugby.api.Json;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.Rugby.domain.Player_profile;

/**
 * Created by thule on 2015/09/23.
 */
@RestController
@RequestMapping(value = "/")
public class Landing_page {

    @RequestMapping(method = RequestMethod.GET)
    public Player_profile getPlayer(){
        Player_profile player_profile = new Player_profile.Builder("T.H-931206")
                .player_name("Thulebona")
                .DOB("931206-5367-088")
                .position("Hook")
                .height(1.9)
                .test(15)
                .test_tries(10)
                .weight(50)
                .build();
        return player_profile;
    }
}
