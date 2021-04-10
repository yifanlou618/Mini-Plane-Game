package PlaneGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class GamePanel extends Panel implements Runnable, MouseMotionListener {

	public Background bg;
	public Plane plane;

	public int count = 0;
	public int countE = 0;

	public Vector<Bullet> allBullet;
	public Vector<EnemyPlane> allEnemy;
	public Vector<BoomAnime> allBoom;

	public GamePanel() {
		bg = new Background(this);
		plane = new Plane(this);
		allBullet = new Vector<Bullet>();
		allEnemy = new Vector<EnemyPlane>();
		allBoom = new Vector<BoomAnime>();

		Thread t = new Thread(this);
		t.start();
		this.addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		bg.drawBackGround(g);
		plane.drawPlane(g);
		for (int i = 0; i < allBullet.size(); i++) {
			Bullet nowB = allBullet.elementAt(i);
			nowB.drawBullet(g);
		}
		for (int i = 0; i < allEnemy.size(); i++) {
			EnemyPlane nowE = allEnemy.elementAt(i);
			nowE.drawEnemy(g);
		}
		for (int i = 0; i < allBoom.size(); i++) {
			BoomAnime b = allBoom.elementAt(i);
			b.drawBomb(g);
		}
	}

	@Override
	public void run() {
		while (true) {
			bg.moveBackGround();
			count++;
			if (count == 6) {
				allBullet.addElement(new Bullet(this, plane.planeX + plane.planeW / 2, plane.planeY));
				count = 0;
			}
			for (int i = 0; i < allBullet.size(); i++) {
				Bullet nowB = allBullet.elementAt(i);
				nowB.moveTo(nowB.bulletX, nowB.bulletY -= 10);
				if (nowB.bulletY <= 0) {
					allBullet.remove(nowB);
				}
			}
			countE++;
			if (countE >= 20) {
				allEnemy.addElement(new EnemyPlane(this, (int) (Math.random() * 480), -100));
				countE = 0;
			}
			for (int i = 0; i < allEnemy.size(); i++) {
				EnemyPlane nowE = allEnemy.elementAt(i);
				nowE.moveTo(nowE.enemyX, nowE.enemyY + 5);
			}
			for (int i = 0; i < allBullet.size(); i++) {
				Bullet nowB = allBullet.elementAt(i);
				for (int j = 0; j < allEnemy.size(); j++) {
					EnemyPlane nowE = allEnemy.elementAt(j);
					if (this.checkHit(nowB.bulletX, nowB.bulletY, nowB.bulletW, nowB.bulletH, nowE.enemyX, nowE.enemyY,
							nowE.enemyW, nowE.enemyH)) {
						allBoom.addElement(new BoomAnime(this, nowE.enemyX, nowE.enemyY));
						allEnemy.removeElementAt(j);
						allBullet.removeElementAt(i);
						i--;
						break;
					}

				}
			}
			for (int i = 0; i < allBoom.size(); i++) {
				BoomAnime b = allBoom.elementAt(i);
				if (b.isDead) {
					allBoom.removeElementAt(i);
				}
			}
			this.repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}

	public boolean checkHit(int r1x, int r1y, int r1w, int r1h, int r2x, int r2y, int r2w, int r2h) {
		return (r1x > r2x + r2w || r1x + r1w < r2x || r1y > r2y + r2h || r1y + r1h < r2y) ? true : false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		plane.moveTo(e.getX(), e.getY());
	}

}
