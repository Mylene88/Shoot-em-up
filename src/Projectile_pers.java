import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class Projectile_pers {

	
	private float x,y,v;
	private Image img;
	
	
	public Projectile_pers(float x,float y) throws SlickException {
		this.setX(x);
		this.setY(y);
		this.setV(40);
		this.setImg(new Image("images/projec.gif"));
	}
	void dessiner(Graphics g) {
		g.drawImage(getImg(), getX(), getY());
	}
	
	void deplacer(int delta) {
		this.setY((float)(getY()-getV()*delta/100f));
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
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	
	public boolean testCollision(Ennemi e) {
		if(x>=e.getX()-10 && x<= e.getX()+27 && y>=e.getY()-10 && y<= e.getY()+44)
			return true;
		    return false;
	}
	public boolean testCollisionBoss(Boss b) {
		if(x>=b.getX()-10.f && x<= b.getX()+100.f && y>=b.getY()-10.f && y<= b.getY()+100.f)
			return true;
		    return false;
	}
	
}
