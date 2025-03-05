package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  public static final int ROW_PAWN = 2;
  public static final int COL_PAWN = 1;
  public static final int ROW_FOR_MISS_PAWN = 1;
  public static final int COL_FOR_MISS_PAWN = 2;
  public static final int ROW_FOR_NOT_ALLOWED_MOVE = 3;
  public static final int COL_FOR_NOT_ALLOWED_MOVE = 1;
  public static final int ROW_FOR_TEST_INDEX_OUT_OF_BOUND = -1;
  public static final int COL_FOR_TEST_INDEX_OUT_OF_BOUND = -1;
  public static final int ROW_KNIGHT = 0;
  public static final int COL_KNIGHT = 0;
  private Logics logic;

  @BeforeEach
  void init(){
    this.logic = new LogicsImpl();
  }

  @Test
  public void testHitPawn(){
    assertTrue(this.logic.hit(ROW_PAWN, COL_PAWN));
  }

  @Test
  public void testMissPawn(){
    assertFalse(this.logic.hit(ROW_FOR_MISS_PAWN, COL_FOR_MISS_PAWN));
  }

  @Test
  public void testNotAllowedMoveForKnight(){
    assertFalse(this.logic.hit(ROW_FOR_NOT_ALLOWED_MOVE, COL_FOR_NOT_ALLOWED_MOVE));
  }

  @Test
  public void testOutOfBoundKnight(){
    assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(ROW_FOR_TEST_INDEX_OUT_OF_BOUND, COL_FOR_TEST_INDEX_OUT_OF_BOUND));
  }

  @Test
  public void testHasKnight(){
    assertAll(
            () -> assertTrue(this.logic.hasKnight(ROW_KNIGHT, COL_KNIGHT)),
            () -> assertFalse(this.logic.hasKnight(ROW_PAWN, COL_PAWN))
    );

  }

  @Test
  public void testHasPawn(){
    assertAll(
            () -> assertTrue(this.logic.hasPawn(ROW_PAWN, COL_PAWN)),
            () -> assertFalse(this.logic.hasPawn(ROW_KNIGHT, COL_KNIGHT))
    );
  }
}
