package za.ac.cput.Rugby.services;

import za.ac.cput.Rugby.domain.Fixtures;
import za.ac.cput.Rugby.domain.Match_Results;

import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
public interface FixturesServices {
    List<Fixtures> getFixtures();
    Match_Results getResults(Long id);
}
