import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public abstract class Bonus {

	protected float x,y,v;
	protected Image img;
	protected int id;

	public Bonus(Image img,int id) {
		super();
		this.x = (float)(Math.random()*620+10);
		this.y = 0;
		this.v = 30.f;
		this.img=img;
		this.id=id;
	}

	abstract void dessiner(Graphics g);
	boolean testCollisionbonus(Vaisseau v) {
		  if(x>=v.getX()-34 && x<= v.getX()+40.f && y>=v.getY()-19 && y<= v.getY()+63.f)
			  return true;
		      return false;
	  }
	
	void deplacer(int delta) {
		setY((float)(getY()+getV()*delta/1000.f));
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
