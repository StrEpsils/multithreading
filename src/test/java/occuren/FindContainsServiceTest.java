package occuren;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindContainsServiceTest {

    @Test
    void isFind() {
        assertTrue(FindContainsService.isFind(new String[]{"OLOLO", "TEST"}, new String[]{"TEST"}));
    }
}