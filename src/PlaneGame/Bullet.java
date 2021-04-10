package PlaneGame;

import java.awt.*;
import javax.swing.*;

public class Bullet {

	public int bulletX, bulletY, bulletW, bulletH;
	public Image imgBullet;
	public Panel nowP;

	public Bullet(Panel p, int x, int y) {
		this.nowP = p;
		this.bulletX = x;
		this.bulletY = y;
		imgBullet = new ImageIcon("/Users/michael/eclipse-workspace/MiniPlaneGame/src/PlaneGameImage/fire.png").getImage();
		bulletW = imgBullet.getWidth(nowP);
		bulletH = imgBullet.getHeight(nowP);
	}

	public void drawBullet(Graphics g) {
		g.drawImage(imgBullet, bulletX, bulletY, nowP);
	}

	public void moveTo(int x, int y) {
		this.bulletX = x;
		this.bulletY = y;

	}

}
