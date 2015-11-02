package edu.tum.pse.tictactoe;

import java.util.Arrays;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import edu.tum.pse.tictactoe.controller.TicTacToeController;
import edu.tum.pse.tictactoe.model.Player;
import edu.tum.pse.tictactoe.model.TicTacToeGame;
import edu.tum.pse.tictactoe.model.pcplayer.PCPlayer;

public class Main {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);

		PCPlayer pcplayer = new PCPlayer(PCPlayer.ADVANCEDPCPLAYER);
		TicTacToeController tttc = new TicTacToeController();
		TicTacToeGame game = new TicTacToeGame();

		game.setSheduledExecutorService(scheduler);
		game.setBoardSize(3);
		game.init();
		game.setPlayers(Arrays.asList(new Player[] { tttc.getPlayer(), pcplayer }));

		tttc.setGame(game);
		tttc.init();

		if (!(game.start() == TicTacToeGame.GAMESTARTSUCCESSFULL)) {
			System.err.print("Invalid Game Configuration");
		}

	}

}
