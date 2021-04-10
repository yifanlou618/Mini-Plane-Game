package PlaneGame;

import java.awt.*;
import javax.swing.*;

public class Background {

	public int backX, backY;
	public Image imgBackGround;
	public Panel nowP;

	public Background(Panel p) {
		backX = 0;
		backY = 0;
		imgBackGround = new ImageIcon("/Users/michael/eclipse-workspace/MiniPlaneGame/src/PlaneGameImage/background.png")
				.getImage();
		nowP = p;
	}

	public void drawBackGround(Graphics g) {
		g.drawImage(imgBackGround, backX, backY, nowP);
		g.drawImage(imgBackGround, backX, backY - 851, nowP);
	}

	public void moveBackGround() {
		backY += 3;
		if (backY >= 851) {
			backY = 0;
		}
	}

}
