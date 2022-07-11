import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class BonusB extends Bonus {

	public BonusB() throws SlickException {
		super(new Image("images/tir.png"),2);
		
	}

	@Override
	void dessiner(Graphics g) {
		g.drawImage(img, getX(), getY());

	}

}
