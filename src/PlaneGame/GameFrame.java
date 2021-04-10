package PlaneGame;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class GameFrame extends Frame implements WindowListener {

	private GamePanel gPanel;

	public GamePanel getgPanel() {
		return gPanel;
	}

	public void setgPanel(GamePanel gPanel) {
		this.gPanel = gPanel;
	}

	public GameFrame() {
		this.setTitle("Plane Game");
		this.setBounds(200, 200, 480, 851);
		this.addWindowListener(this);
		GamePanel gPanel = new GamePanel();
		this.add(gPanel);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int s = javax.swing.JOptionPane.showConfirmDialog(this, "Exit Game?");
		if (s == 0) {
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}
