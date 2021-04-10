package PlaneGame;

import java.awt.*;
import javax.swing.*;

public class BoomAnime {

	public int boomX, boomY, count;
	public boolean isDead;
	public Panel nowP;
	public Image imgs[] = {
			new ImageIcon("/Users/michael/eclipse-workspace/MiniPlaneGame/src/PlaneGameImage/bomb_1.png").getImage(),
			new ImageIcon("/Users/michael/eclipse-workspace/MiniPlaneGame/src/PlaneGameImage/bomb_2.png").getImage(),
			new ImageIcon("/Users/michael/eclipse-workspace/MiniPlaneGame/src/PlaneGameImage/bomb_3.png").getImage() };

	public BoomAnime(Panel p, int x, int y) {
		this.nowP = p;
		this.boomX = x;
		this.boomY = y;
		count = 0;
		isDead = false;
	}

	public void drawBomb(Graphics g) {
		g.drawImage(imgs[count], boomX, boomY, nowP);
		count++;
		if (count > 2) {
			this.isDead = true;
		}
	}

}
