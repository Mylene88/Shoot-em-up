import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class BonusC extends Bonus {

	public BonusC() throws SlickException {
		super(new Image("images/bouclier.png"),3);
		
	}

	@Override
	void dessiner(Graphics g) {
		g.drawImage(img, getX(), getY());

	}

}
