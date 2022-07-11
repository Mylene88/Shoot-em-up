import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class ennemi_verti extends Ennemi {

	protected int intervaltir=(int)Math.random()*3000+2000;
	protected int temps = 0;
	public ennemi_verti() throws SlickException {
		super(20.f);

	}

	@Override
	public void dessiner(Graphics g) {

		
			g.drawImage(img, getX(), getY());
			
		
	}

	@Override
	void deplacer(int delta) {

		setY((float) (getY() + getV() * delta / 1000.f));

	}

	

	@Override
	boolean peutDisparaitre() {
		if(getY()>=470)
			return true;
		
		    return false;
	}

}
