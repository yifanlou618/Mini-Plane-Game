package PlaneGame;

import java.awt.*;
import javax.swing.*;

public class EnemyPlane {

	public int enemyX, enemyY, enemyW, enemyH;
	public Image imgEnemy;
	public Panel nowP;

	public EnemyPlane(Panel p, int x, int y) {
		this.nowP = p;
		this.enemyX = x;
		this.enemyY = y;
		imgEnemy = new ImageIcon("/Users/michael/eclipse-workspace/MiniPlaneGame/src/PlaneGameImage/enemyPlane.png")
				.getImage();
		this.enemyW = imgEnemy.getWidth(nowP);
		this.enemyH = imgEnemy.getHeight(nowP);
	}

	public void drawEnemy(Graphics g) {
		g.drawImage(imgEnemy, enemyX, enemyY, nowP);
	}

	public void moveTo(int x, int y) {
		this.enemyX = x;
		this.enemyY = y;

	}

}
