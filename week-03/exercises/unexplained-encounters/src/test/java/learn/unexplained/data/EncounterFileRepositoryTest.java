package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncounterFileRepositoryTest {

    static final String TEST_PATH = "./data/encounters-test.csv";
    final Encounter[] testEncounters = new Encounter[]{
            new Encounter(1, EncounterType.UFO, "2020-01-01", "short test #1", 1),
            new Encounter(2, EncounterType.CREATURE, "2020-02-01", "short test #2", 1),
            new Encounter(3, EncounterType.SOUND, "2020-03-01", "short test #3", 1)
    };
    final Encounter missingEncounter = new Encounter(17, EncounterType.UFO, "2020-01-01", "short test #17", 1);
    final Encounter updatedEncounter = new Encounter(1, EncounterType.VOICE, "2020-01-01", "short test #4", 1);

    EncounterFileRepository repository = new EncounterFileRepository(TEST_PATH);

    @BeforeEach
    void setup() throws DataAccessException {
        /* this shouldn't work like this. It should use a "data seed" file that never changes, and then copy the contents
        into a "data test" file where all changes are made. Though we are testing methods that we would use to do that
        so it's kind of circular logic to use those methods to duplicate test data to test the methods on. */
        for (Encounter e : repository.findAll()) {
            repository.deleteById(e.getEncounterId());
        }

        for (Encounter e : testEncounters) {
            repository.add(e);
        }
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<Encounter> encounters = repository.findAll();
        Encounter[] actual = encounters.toArray(new Encounter[encounters.size()]);
        assertArrayEquals(testEncounters, actual);
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Encounter encounter = new Encounter();
        encounter.setType(EncounterType.UFO);
        encounter.setWhen("Jan 15, 2005");
        encounter.setDescription("moving pinpoint of light." +
                "seemed to move with me along the highway. " +
                "then suddenly reversed direction without slowing down. it just reversed.");
        encounter.setOccurrences(1);

        Encounter actual = repository.add(encounter);

        assertNotNull(actual);
        assertEquals(4, actual.getEncounterId());
    }

    @Test
    void shouldFindUFO() throws DataAccessException {
        List<Encounter> encounters = repository.findByType(EncounterType.UFO);
        Encounter[] actual = encounters.toArray(new Encounter[encounters.size()]);
        Encounter[] test = new Encounter[1];
        test[0] = testEncounters[0];
        assertArrayEquals(test, actual);
    }

    @Test
    void shouldReturnFalseWhenDoesntExist() throws DataAccessException {
        assertFalse(repository.update(missingEncounter));
    }

    @Test
    void shouldReturnTrueWhenExists() throws DataAccessException {
        assertTrue(repository.update(testEncounters[0]));
    }

    @Test
    void shouldMatchAfterUpdateWhenExists() throws DataAccessException {
        repository.update(updatedEncounter);
        List<Encounter> encounters = repository.findAll();
        Encounter[] actual = new Encounter[1];
        actual[0] = encounters.get(0);
        Encounter[] test = new Encounter[1];
        test[0] = updatedEncounter;
        assertArrayEquals(test, actual);
    }

}































