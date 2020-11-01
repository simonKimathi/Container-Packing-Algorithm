package boxAction;

import com.packing.boxAction.BoxActions;
import com.packing.boxAction.BoxActionsI;
import com.packing.model.Box;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxActionsTest {
    BoxActionsI boxActionsI;
    @BeforeEach
    void setUp() {
        boxActionsI =new BoxActions(
                new Box(3,4,5)
        );
    }

    @Test
    void getSurfaceArea() {
        assertNotNull(boxActionsI);
        assertTrue(boxActionsI.getSurfaceArea()>0);
        assertEquals(94, boxActionsI.getSurfaceArea(),0);
    }

    @Test
    void getVolume() {
        assertNotNull(boxActionsI);
        assertTrue(boxActionsI.getVolume()>0);
        assertEquals(60, boxActionsI.getVolume(),0);
    }
}