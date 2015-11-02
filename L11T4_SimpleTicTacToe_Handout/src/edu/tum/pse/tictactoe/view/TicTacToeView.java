package edu.tum.pse.tictactoe.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.tum.pse.tictactoe.controller.TicTacToeAction;
import edu.tum.pse.tictactoe.controller.TicTacToeController;

public class TicTacToeView extends JPanel {
	private static final long serialVersionUID = 1L;

	private GridBagLayout layout;
	private List<TicTacToeAction> actions;
	private TicTacToeController controller;
	
	public TicTacToeView(TicTacToeController controller) {
		this.controller = controller;
	}
	
	public void init(){
		assert(actions.size() == (this.controller.getGame().getBoardSize()*this.controller.getGame().getBoardSize()));
		this.setBackground(Color.black);
		this.layout = new GridBagLayout();
		this.setLayout(this.layout);
		JButton button;
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.BOTH;
		constraint.weightx = 1.0;
		constraint.weighty = 1.0;
		for(int i = 0; i < this.controller.getGame().getBoardSize() ; i++) {
			for(int j = 0; j < this.controller.getGame().getBoardSize() ; j++) {
				button = new JButton();
				constraint.gridx = i;
				constraint.gridy = j;
				button.setAction(actions.get(i*this.controller.getGame().getBoardSize()+j));
				this.add(button,constraint);
			}
		}
	}

	public List<TicTacToeAction> getActions() {
		return actions;
	}

	public void setActions(List<TicTacToeAction> actions) {
		this.actions = actions;
	}
}
