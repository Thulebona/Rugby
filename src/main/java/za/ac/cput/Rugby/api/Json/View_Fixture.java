package za.ac.cput.Rugby.api.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.Rugby.domain.Fixtures;
import za.ac.cput.Rugby.domain.Match_Results;
import za.ac.cput.Rugby.services.FixturesServices;

import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
@RestController
@RequestMapping(value = "/fixture/**")
public class View_Fixture  {

    @Autowired
    FixturesServices services;

    @RequestMapping(value = "/fixtures",method = RequestMethod.GET)
    public List<Fixtures> getFixture() {
          return services.getFixtures();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Match_Results getResults(@PathVariable Long id){
        return services.getResults(id);
    }

}
