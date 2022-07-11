import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class sang {

	private float x, y, w, h;
	private Color c;

	public sang() {

		this.x = 645;
		this.y = 30;
		this.w = 200;
		this.h = 40;
		this.setC(new Color(Color.green));
	}

	void dessiner(Graphics g) {
		if (getW() > 100) {
			
			g.setColor(c);
			g.drawString("Health :", 710, 5);
			g.fillRoundRect(getX(), getY(), getW(), getH(), 8);
			
		} else if (getW() < 50) {
			
			g.setColor(Color.red);
			g.drawString("Faites attention!!!!!!!!!!!!!", 645, 140);
			g.drawString("Faites attention!!!!!!!!!!!!!", 645, 155);
			g.drawString("Faites attention!!!!!!!!!!!!!", 645, 170);
			g.fillRoundRect(getX(), getY(), getW(), getH(), 8);
			
		} else  {
			
			g.setColor(Color.orange);
			g.fillRoundRect(getX(), getY(), getW(), getH(), 8);
			
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

}
