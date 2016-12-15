package objects;

public class Player extends GameActor implements Fighter {

	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(Board board,int opponentHint) {
		super( board,opponentHint);
	}
	@Override
	public void attack(int x, int y) {
		if(x>(getBoard().getDimension()-1) ||y>(getBoard().getDimension()-1) ){
				try {
					throw new BoardSizeExceededException();
				} catch (BoardSizeExceededException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
		}
		if(((getBoard().getCells())[x][y].getHit())==false && 
				((getBoard().getCells())[x][y]).getHasShip()==true ){
			
			((getBoard().getCells())[x][y]).setHit(true);
			setOpponentHint(super.getOpponentHint()+1);
			System.out.println("Enemy have hit a ship! Left "+(3-super.getOpponentHint()));
		}
		else if (((getBoard().getCells())[x][y]).getHasShip()==false && 
		((getBoard().getCells())[x][y]).getHasShip()==false)
			System.out.println("Enemy missed!");
		else if(((getBoard().getCells())[x][y].getHit())==true && 
				((getBoard().getCells())[x][y]).getHasShip()==true)
			System.out.println("Enemy have already attacked here!");
	}
	

}
