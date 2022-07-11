import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class Boss {

	public float x, y, v, health;
	public Image img;
	protected float R;
	protected float O;

	public Boss() throws SlickException {
		this.x = (float) (Math.random() * 500 + 50);
		this.y = 5.f;
		this.v = 40.f;
		this.img = new Image("images/boss.png") ;
		this.health = 300.f;
		R = (float) (Math.random() * 50 + 30);
		O = 0;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	public void dessiner(Graphics g) {

		g.drawImage(img, getX(), getY());

	}

	void deplacer(int delta) {

		float dO = (float) (2 * Math.PI * delta / 2000.f);

		x += R * (Math.cos(O + dO) - Math.cos(O))+ 6*delta/1000.f;

		y += R * (Math.sin(O + dO) - Math.sin(O))+ 20*delta/1000.f;

		O += dO;

	}

	boolean alive() {
		if (health > 0)
			return true;
		return false;
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

	public float getV() {
		return v;
	}

	public void setV(float v) {
		this.v = v;
	}

	

}
