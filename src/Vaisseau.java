import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class Vaisseau {
	
	protected Sound bulletSound = new Sound("audios/bulletSound.wav");
	private float x,y;
	Image img;
	ArrayList <Projectile_pers> p = new ArrayList<Projectile_pers>();
	protected int temps=0;
	protected int intervaltir;

	public Vaisseau() throws SlickException {
		
		this.x = 300;
		this.y = 400;
		this.img= new Image("images/IL.png");
		this.intervaltir=(int)(Math.random()*350+100);
	}
	
	
	
	
	public int getIntervaltir() {
		return intervaltir;
	}




	public void setIntervaltir(int intervaltir) {
		this.intervaltir = intervaltir;
	}




	public ArrayList<Projectile_pers> getP() {
		return p;
	}




	public void setP(ArrayList<Projectile_pers> p) {
		this.p = p;
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


	void dessiner(Graphics g) {
		g.drawImage(img, x, y);
		
	}
	
	void tirer(int delta) throws SlickException{
		temps+=delta;
		
		if(temps>=intervaltir) {
			p.add(new Projectile_pers(getX(), getY()));
			bulletSound.play(0.1f,0.1f);
			temps =0;
		}
		
		
	}
	boolean peutGauche() {
		if(x>0) 
		return true;
		return false;
	}
	boolean peutDroite() {
		if(x<595) 
		return true;
		return false;
	}
	void gauche() {
		x-=0.7f;
	}
	void droite() {
		x+=0.7f;
	}
	
  boolean testCollision(Ennemi e) {
	  if(x>=e.getX()-35 && x<= e.getX()+33 && y>=e.getY()-10 && y<= e.getY()+50)
		  return true;
	  return false;
}
	
}
