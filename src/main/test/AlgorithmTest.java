import com.packing.boxAction.BoxActions;
import com.packing.algorithm.Algorithm;
import com.packing.model.Box;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest extends Algorithm {


    private final BoxActions containerBoxImplI;

    public AlgorithmTest(Box container, Map<Integer, Box> packingBoxes) {
        super(container, packingBoxes);
        this.containerBoxImplI=new BoxActions(new Box(30,40,50));
        packingBoxes=new HashMap<>();
        packingBoxes.put(10,new Box(3,4,5));
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void testGetTotalPackingBoxSA() {
        assertNotNull(this.packingBoxes);
        assertEquals(940,getTotalPackingBoxSA(),0);
    }

    @Test
    void testGetTotalPackingBoxVolume() {
        assertNotNull(this.packingBoxes);
        assertEquals(600,getTotalPackingBoxVolume(),0);
    }

    @Test
    void testGetContainerSA() {
        assertNotNull(this.containerBoxImplI);
        assertEquals(94,getContainerSA(),0);
    }

    @Test
    void testGetWastedSpace() {
        assertEquals(94,getContainerSA(),0);
    }

    @Test
    void testGetNumBoxes() {
        assertTrue(getWastedSpace()>0);
    }

    @Test
    void testGetContainerVolume() {
        assertNotNull(this.containerBoxImplI);
        assertEquals(60,getContainerVolume(),0);
    }
}