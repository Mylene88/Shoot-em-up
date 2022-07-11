import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class BonusA extends Bonus {

	

	public BonusA() throws SlickException {
		super(new Image("images/coeurr.png"),1);	
	}

	@Override
	void dessiner(Graphics g) {
		
		g.drawImage(img, getX(), getY());

	}

}
