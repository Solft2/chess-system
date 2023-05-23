package boardgame;


public class Board {
     private int rows; 
     private int columns; 
     private Piece[][] pieces;
	public Board(int rows, int columns) {
		if(rows < 1 || columns <1 ) {
			throw new BoardException("Precisa ter pelo menos uma coluna e uma linha! ");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public int getColumns() {
		return columns;
	}
	
	public int getRows() {
		return rows;
	}
	
	public Piece piece(int row, int column) {
		if(!positionExist(row,column)) {
			throw new BoardException("Essa posição não existe!");
		}
		return pieces[row][column];
	}
	public Piece piece(Position position) {
		if(!positionExist(position)) {
			throw new BoardException("Essa posição não existe!");
		}
		return pieces[position.getRow()][position.getColumn()];
	} 
    public void placePiece(Piece piece,Position position) {
    	if(thereIsAPeace(position)) {
    		throw new BoardException("Já existe uma peça nessa posição!" + position);
    	}
    	pieces[position.getRow()][position.getColumn()] = piece;
    	piece.position = position;
    }
    public boolean positionExist(int row, int column) {
    	return row>= 0 && row < rows && column >= 0 && column < columns;
    }
    
    private boolean positionExist(Position position) {
    	return positionExist(position.getRow(),position.getColumn());
    }
    public boolean thereIsAPeace(Position position) {
    	if(!positionExist(position)) {
			throw new BoardException("Essa posição não existe!");
		}
    	return piece(position) != null;
    }
}
