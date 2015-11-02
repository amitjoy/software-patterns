package edu.tum.pse.tictactoe.controller;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.tum.pse.tictactoe.model.AbstractPlayer;
import edu.tum.pse.tictactoe.model.Player;
import edu.tum.pse.tictactoe.model.TicTacToeGame;
import edu.tum.pse.tictactoe.view.TicTacToeView;

public class TicTacToeController {
	private JFrame frame;
	private TicTacToeView view;
	private List<TicTacToeAction> actions;
	private TicTacToeGame game;
	private Player player;

	public TicTacToeController() {
		view = new TicTacToeView(this);
		this.player = new AbstractPlayer("Player") {
			@Override
			public void nextTurn(TicTacToeGame game) {
				switchActionsEnabled(true);
			}

			@Override
			public void gameFinished(TicTacToeGame game) {
				if(SwingUtilities.isEventDispatchThread()) {
					gameFinished.run();
				} else {
					SwingUtilities.invokeLater(gameFinished);
				}
			}
		};
	}
	
	private Runnable gameFinished = new Runnable() {
		@Override
		public void run() {
			switchActionsEnabled(false);
			updateActionIcons();
			view.repaint();
		}
	};
	
	public void init() {
		assert(game.getBoardSize() > 2);
		if (frame == null)
			frame = new JFrame("TicTacToe Game");
		Dimension d = new Dimension(400, 450);
		frame.setSize(d);
		frame.setResizable(false);
		frame.setMinimumSize(d);
		this.initTicTacToeView();
		frame.add(view);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		switchActionsEnabled(false);
	}
	
	private void initTicTacToeView() {
		final int boardSize = this.game.getBoardSize();
		actions = new ArrayList<TicTacToeAction>(boardSize*boardSize);
		for(int i = 0 ; i < boardSize ; i++) {
			for(int j = 0 ; j < boardSize ; j++) {
				actions.add(new TicTacToeAction(i,j,this));
			}
		}
		view.setActions(actions);
		view.init();
	}
	
	private boolean actionsEnabled;
	private Runnable switchActionsEnabled = new Runnable(){
		@Override
		public void run() {
			for(TicTacToeAction a : actions) {
				a.setEnabledIfPossible(actionsEnabled);
			}
		}
	};
	private void switchActionsEnabled(boolean enabled) {
		actionsEnabled = enabled;
		if(SwingUtilities.isEventDispatchThread()) {
			switchActionsEnabled.run();
		} else {
			try {
				SwingUtilities.invokeAndWait(switchActionsEnabled);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void updateActionIcons() {
		for(TicTacToeAction action : actions) {
			action.refreshActionIcon();
		}
	}
	
	public void turnPerformed() {
		switchActionsEnabled(false);
		this.game.moveFinished(player);
	}
	
	public void setGame(TicTacToeGame game) {
		this.game = game;
	}
	
	public TicTacToeGame getGame() {
		return game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
