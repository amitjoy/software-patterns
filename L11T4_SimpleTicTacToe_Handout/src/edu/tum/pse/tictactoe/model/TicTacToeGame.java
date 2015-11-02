package edu.tum.pse.tictactoe.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ScheduledExecutorService;

public class TicTacToeGame {
	private ScheduledExecutorService sheduledExecutorService;
	private Map<Integer, Map<Integer, Token>> gameBoard;

	private List<Player> players;
	private Map<Player, Token> playerTokenMap;

	private static final Token[] playerTokens = { new Token("red.png"),
			new Token("lg.png") };

	private int boardSize;
	
	public static final int GAMESTARTSUCCESSFULL = 0;
	public static final int GAMESTARTFAILED = 1;
	

	public TicTacToeGame() {

	}

	public Token[] getPlayertokens() {
		return playerTokens;
	}

	public void init() {
		this.gameBoard = new HashMap<Integer, Map<Integer, Token>>();
		for (int i = 0; i < boardSize; i++) {
			this.gameBoard.put(i, new HashMap<Integer, Token>());
		}
	}

	private final String[] types = new String[] { "z", "s", "d" };

	public TreeMap<String, Integer> getCrossSums() {
		TreeMap<String, Integer> crossSums = new TreeMap<String, Integer>();

		for (int i = 0; i < boardSize; i++) {
			crossSums.put(types[0] + i, rowSum(i));
			crossSums.put(types[1] + i, columnSum(i));
		}

		int first = 0, second = 0;
		for (int i = 0; i < boardSize; i++) {
			first += this.getTokenValue(gameBoard.get(i).get(i));
			second += this.getTokenValue(gameBoard.get(i).get(boardSize - i-1));
		}
		crossSums.put("d" + 0, first);
		crossSums.put("d" + 1, second);

		return crossSums;
	}

	public int rowSum(int n) {
		int sum = 0;
		for (int i = 0; i < boardSize; i++) {
			sum += this.getTokenValue(gameBoard.get(n).get(i));
		}
		return sum;
	}

	public int columnSum(int n) {
		int sum = 0;
		for (int i = 0; i < boardSize; i++) {
			sum += this.getTokenValue(gameBoard.get(i).get(n));
		}
		return sum;
	}

	public Map<Integer, Map<Integer, Token>> getGameBoard() {
		return gameBoard;
	}

	public void putToken(int row, int column, Token token)
			throws RuntimeException {
		if (this.getGameBoard().get(row).get(column) != null) {
			throw new RuntimeException(
					"It is only allowed to place a tokens onto empty game board positions.");
		}
		this.getGameBoard().get(row).put(column, token);
	}

	public int getTokenValue(Token token) {
		if (token == null)
			return 0;
		if (playerTokenMap.get(players.get(0)).equals(token)) {
			return -1;
		} else if (playerTokenMap.get(players.get(1)).equals(token)) {
			return 1;
		}
		throw new RuntimeException(
				"getTokenValue was called with an unnasigned token.");
	}

	private static class TicTacToeGameMoveFinished implements Runnable {
		private TicTacToeGame game;
		private Player player;

		public TicTacToeGameMoveFinished(TicTacToeGame game, Player player) {
			this.game = game;
			this.player = player;
		}

		@Override
		public void run() {
			final List<Player> players = game.getPlayers();
			int currentPlayer = players.indexOf(player) + 1;
			currentPlayer %= players.size();
			players.get(currentPlayer).nextTurn(game);
		}
	};
	
	private final TicTacToeGame game = this;
	private final Runnable gameFinished = new Runnable() {
		@Override
		public void run() {
			for(Player p : getPlayers()) {
				p.gameFinished(game);
			}
		}
	};

	public void moveFinished(Player player) {
		try {
			if (!this.isGameFinished()) {
				sheduledExecutorService.execute(new TicTacToeGameMoveFinished(
						this, player));
			} else {
				sheduledExecutorService.execute(gameFinished);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isGameFinished() {
		boolean finished = false;
		TreeMap<String, Integer> x = this.getCrossSums();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (Entry<String, Integer> s : x.entrySet()) {
			Integer value = s.getValue();
			if (max < value) {
				max = value;
			}
			if (min > value) {
				min = value;
			}
		}

		if (max == 3) {
			System.out.println("PC winns");
			finished = true;
		}
		if (min == -3) {
			System.out.println("Player winns");
			finished = true;
		}
		int occupied = 0;
		for (Map<Integer, Token> row : this.gameBoard.values()) {
			for (Token c : row.values()) {
				if (c != null)
					occupied++;
			}
		}
		if (occupied == 9) {
			System.out.println("Draw.");
			finished = true;
		}
		return finished;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	// FIXME Replace error code with exception
	public int start() {
		final List<Player> players = this.getPlayers();
		if (players.size() > playerTokens.length) {
			return GAMESTARTFAILED;
		}
		if (this.getPlayerTokenMap() == null) {
			final TreeMap<Player, Token> playerTokenMap = new TreeMap<Player, Token>();
			int i = 0;
			for (Player p : this.getPlayers()) {
				playerTokenMap.put(p, playerTokens[i++]);
			}
			this.setPlayerTokenMap(playerTokenMap);
		}
		sheduledExecutorService.execute(new Runnable() {
			@Override
			public void run() {
				players.get(0).nextTurn(game);
			}});
		return GAMESTARTSUCCESSFULL;
	}

	public Map<Player, Token> getPlayerTokenMap() {
		return playerTokenMap;
	}

	public void setPlayerTokenMap(Map<Player, Token> playerTokenMap) {
		this.playerTokenMap = playerTokenMap;
	}

	public ScheduledExecutorService getSheduledExecutorService() {
		return sheduledExecutorService;
	}

	public void setSheduledExecutorService(
			ScheduledExecutorService sheduledExecutorService) {
		this.sheduledExecutorService = sheduledExecutorService;
	}

	public Token getTokenForPlayer(Player player) {
		return this.playerTokenMap.get(player);
	}
}