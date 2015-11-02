package edu.tum.pse.tictactoe.model.pcplayer;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

import edu.tum.pse.tictactoe.model.AbstractPlayer;
import edu.tum.pse.tictactoe.model.TicTacToeGame;
import edu.tum.pse.tictactoe.model.Token;

// FIXME Polymorphism
public class PCPlayer extends AbstractPlayer {

	public PCPlayer(int mode) {
		this.mode = mode;
		switch (mode) {
		case SIMPLEPCPLAYER:
			super.setName("SimplePCPlayer");
			break;
		case RANDOMPCPLAYER:
			super.setName("RandomPCPlayer");
			break;
		case ADVANCEDPCPLAYER:
			super.setName("AdvancedPCPlayer");
			break;
		}
	}

	@Override
	public void nextTurn(TicTacToeGame game) {
		switch (mode) {
		case SIMPLEPCPLAYER:
			this.setNextAvailable(game);
			break;
		case RANDOMPCPLAYER:
			int i = 100;
			boolean fieldSet = false;
			while (i > 0) {
				int row = random.nextInt(3);
				int column = random.nextInt(3);
				if (game.getGameBoard().get(row).get(column) == null) {
					game.putToken(row, column, game.getTokenForPlayer(this));
					fieldSet = true;
					break;
				}
				i--;
			}
			if (!fieldSet) {
				this.setNextAvailable(game);
				break;
			}
			break;
		case ADVANCEDPCPLAYER:
			TreeMap<String, Integer> x = game.getCrossSums();
			String maxKey = null;
			String minKey = null;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (Entry<String, Integer> s : x.entrySet()) {
				Integer value = s.getValue();
				if (max < value) {
					max = value;
					maxKey = s.getKey();
				}
				if (min > value) {
					min = value;
					minKey = s.getKey();
				}
			}
			fieldSet = false;
			if (max == 2) {
				setComputerChareckter(game, maxKey);
				fieldSet = true;
			}
			if (!fieldSet) {
				if (min < 0) {
					setComputerChareckter(game, minKey);
					fieldSet = true;
				}
			}
			if (!fieldSet) {
				this.setNextAvailable(game);
				return;
			}
			break;
		}
		game.moveFinished(this);
	}

	private Random random = new Random(System.currentTimeMillis());

	final int mode;
	public static final int ADVANCEDPCPLAYER = 2;
	public static final int SIMPLEPCPLAYER = 0;
	public static final int RANDOMPCPLAYER = 1;

	@Override
	public void gameFinished(TicTacToeGame game) {

	}

	public void setComputerChareckter(TicTacToeGame game, String key) {
		int row = -1;
		int column = -1;
		if (key.equals("z0")) {
			row = 0;
		}
		if (key.equals("z1")) {
			row = 1;
		}
		if (key.equals("z2")) {
			row = 2;
		}
		if (key.equals("s0")) {
			column = 0;
		}
		if (key.equals("s1")) {
			column = 1;
		}
		if (key.equals("s2")) {
			column = 2;
		}
		if (key.equals("d0")) {
			row = 0;
			column = 0;
		}
		if (key.equals("d1")) {
			row = 2;
			column = 2;
		}
		if (row < 0) {
			for (int i = 0; i < 3; i++) {
				row = i;
				if (game.getGameBoard().get(row).get(column) == null) {
					game.putToken(row, column, game.getTokenForPlayer(this));
					return;
				}
			}
		}
		if (column < 0) {
			for (int i = 0; i < 3; i++) {
				column = i;
				if (game.getGameBoard().get(row).get(column) == null) {
					game.putToken(row, column, game.getTokenForPlayer(this));
					return;
				}
			}
		}
		if (row == 0) {
			for (int i = 0; i < 3; i++) {
				column = i;
				row = i;
				if (game.getGameBoard().get(row).get(column) == null) {
					game.putToken(row, column, game.getTokenForPlayer(this));
					return;
				}
			}
		} else {
			if (game.getGameBoard().get(0).get(2) == null) {
				row = 0;
				column = 2;
			}
			if (game.getGameBoard().get(1).get(1) == null) {
				row = 1;
				column = 1;
			}
			if (game.getGameBoard().get(2).get(0) == null) {
				row = 2;
				column = 0;
			}
			game.putToken(row, column, game.getTokenForPlayer(this));
			return;
		}
		this.setNextAvailable(game);
	}

	private void setNextAvailable(final TicTacToeGame game) {
		for (int i = 0; i < game.getGameBoard().size(); i++) {
			boolean br = false;
			Map<Integer, Token> row = game.getGameBoard().get(i);
			for (int j = 0; j < game.getGameBoard().size(); j++) {
				if (row.get(j) == null) {
					game.putToken(i, j, game.getTokenForPlayer(this));
					br = true;
					break;
				}
			}
			if (br)
				break;
		}
	}
}
