package e2;

public class LogicsImpl implements Logics {

	private final MoveValidator validator;
	 
    public LogicsImpl(int size){
		this.validator = new MoveValidatorImpl(size);
    }

	public LogicsImpl(){
		this.validator = new MoveValidatorImpl();
	}

	@Override
	public boolean hit(int row, int col) {
		return this.validator.validateKnightMove(row, col);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.validator.hasKnight(row, col);
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.validator.hasPawn(row,col);
	}
}
