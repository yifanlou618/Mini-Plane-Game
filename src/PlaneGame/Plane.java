package PlaneGame;

import java.awt.*;
import javax.swing.*;

public class Plane {

	public int planeX, planeY, planeW, planeH;
	public Image imgPlane;
	public Panel nowP;

	public Plane(Panel p) {
		this.nowP = p;
		this.planeX = 190;
		this.planeY = 720;
		imgPlane = new ImageIcon("/Users/michael/eclipse-workspace/MiniPlaneGame/src/PlaneGameImage/plane.png").getImage();
		planeW = imgPlane.getWidth(nowP);
		planeH = imgPlane.getHeight(nowP);
	}

	public void drawPlane(Graphics g) {
		g.drawImage(imgPlane, planeX, planeY, nowP);
	}

	public void moveTo(int x, int y) {
		this.planeX = x - imgPlane.getWidth(nowP) / 2;
		this.planeY = y - imgPlane.getHeight(nowP) / 2;
	}

}
