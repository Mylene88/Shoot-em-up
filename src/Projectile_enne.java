import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public  class Projectile_enne {

	private float x,y,v;
	private Image img;
	
	
	public Projectile_enne(float x,float y) throws SlickException {
		this.setX(x);
		this.setY(y);
		this.setV(-10);
		this.setImg(new Image("images/E.png"));
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
	public boolean testCollision(Vaisseau ve) {
		if(x>=ve.getX()-30 && x<= ve.getX()+40 && y>=ve.getY()-30 && y<= ve.getY()+63)
			return true;
		    return false;
	}
	
}
