import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public abstract class Ennemi {

	
	public float x, y, v;
	public Image img,boom;
	public boolean isdie;
	ArrayList <Projectile_enne> p =new ArrayList<Projectile_enne>() ;
	
	public Ennemi(float v) throws SlickException {

		this.x = (float) (Math.random() * 500 + 50);
		this.y = 0;
		this.v = v;
		this.img = new Image("images/hori.png");
		this.boom = new Image("images/boom.png");
		
		
	}
	
	
	void retirerp(int i) {
		
		p.remove(i);
	}

	public Image getBoom() {
		return boom;
	}

	public void setBoom(Image boom) {
		this.boom = boom;
	}

	public boolean isIsdie() {
		return isdie;
	}

	public void setIsdie(boolean isdie) {
		this.isdie = isdie;
	}

	public ArrayList<Projectile_enne> getP() {
		return p;
	}

	public void setP(ArrayList<Projectile_enne> p) {
		this.p = p;
	}
	
	protected int intervaltir = (int) Math.random() * 800 + 200;

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

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public abstract void dessiner(Graphics g);

	abstract void deplacer(int delta);

	
	abstract boolean peutDisparaitre();

}
