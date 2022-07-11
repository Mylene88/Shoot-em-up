import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class ennemi_hori extends Ennemi {
	
	protected Image imge = new Image("images/im.png");

	protected int intervaltir=(int)Math.random()*3000+2000;
	boolean sens = true;
	
	public ennemi_hori() throws SlickException {
		super(20.f);
		
	}

	@Override
	public void dessiner(Graphics g) {
		    imge.draw(getX(), getY(), 27, 44);

	}

	@Override
	void deplacer(int delta) {
		
		if (sens) {
			setX((float) (getX() + getV() * delta / 100.f));
		
			if (x > 600)
				sens = !sens;
		} else {
			setX((float) (getX() - getV() * delta / 100.f));
			if (x <= 0)
				sens = !sens;
		}
	}


	@Override
	boolean peutDisparaitre() {
		if(getY()>=470)
			return true;
		
		    return false;
	}
}
