package edu.tum.pse.tictactoe.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import edu.tum.pse.tictactoe.model.TicTacToeGame;
import edu.tum.pse.tictactoe.model.Token;

public class TicTacToeAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private static final Token emptyToken = new Token("empty.png");
	
	private int column;
	private int row;
	private TicTacToeController controller;

	public TicTacToeAction(int x, int y, TicTacToeController controller) {
		this.column = x;
		this.row = y;
		this.controller = controller;
		this.putValue(Action.SMALL_ICON, emptyToken.getImage());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final TicTacToeGame game = this.controller.getGame();
		game.putToken(row,column,game.getTokenForPlayer(this.controller.getPlayer()));
		this.controller.turnPerformed();
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int x) {
		this.column = x;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int y) {
		this.row = y;
	}

	public void changeImageIcon(Token token) {
		this.putValue(Action.SMALL_ICON, token.getImage());
	}
	
	public void setEnabledIfPossible(boolean enabled) {
		if(enabled) {
			reenableIfPerformeable();
		} else {
			this.setEnabled(false);
		}
	}
	
	public void refreshActionIcon() {
		final Token token = this.controller.getGame().getGameBoard().get(row).get(column);
		if(token != null) changeImageIcon(token);
	}
	
	private void reenableIfPerformeable() {
		final Token token = this.controller.getGame().getGameBoard().get(row).get(column);
		if(token == null) {
			this.setEnabled(true);
		} else {
			changeImageIcon(token);
		}
	}
}
