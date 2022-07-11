import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class ennemi_circu extends Ennemi {
	protected Image imga = new Image("images/circuu.png");
	protected int temps = 0;
	protected float R;
	protected float O;
	protected int intervaltir=(int)Math.random()*6000+2000;

	public ennemi_circu() throws SlickException {
		super(20.f);
		R =(float)(Math.random()*50+30);
		O = 0;
	}
	
	@Override
	public void dessiner(Graphics g) {
		
			imga.draw(getX(), getY(), 27, 44);
			

	}

	@Override
	void deplacer(int delta) {
		
		float dO = (float) (2*Math.PI*delta/2000.f);

		x += R*(Math.cos(O+dO)-Math.cos(O)) + 6*delta/1000.f;
		y += R*(Math.sin(O+dO)-Math.sin(O)) + 20*delta/1000.f;
		O += dO;
	

	}
	

	@Override
	boolean peutDisparaitre() {
		if(getY()>=470)
			return true;
		
		    return false;
		
	}

}
