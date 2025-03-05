package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  public static final int ROW_PAWN = 2;
  public static final int COL_PAWN = 1;
  private Logics logic;

  @BeforeEach
  void init(){
    this.logic = new LogicsImpl();
  }

  @Test
  public void testHitPawn(){
    assertTrue(this.logic.hit(ROW_PAWN, COL_PAWN));
  }
}
