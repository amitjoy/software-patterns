package edu.tum.pse.tictactoe.model;

public interface Player extends Comparable<Object> {
	public String getName();
	public void nextTurn(TicTacToeGame game);
	public void gameFinished(TicTacToeGame game);
}
