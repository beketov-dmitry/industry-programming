import static org.junit.jupiter.api.Assertions.*;

class TaylorTest {

    @org.junit.jupiter.api.Test
    public void ln() {
        Taylor M = new Taylor();
        String myRes = M.ln(0.2, 4);
        assertEquals(myRes, "0,182");
    }
}