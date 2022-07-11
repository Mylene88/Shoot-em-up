import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class Menu extends BasicGameState implements ComponentListener {

	private MouseOverArea bouton;
	
	Sons s;
	Image fond_ecran;
	Sound son;
	Image img,img1;
	boolean click;

	public Menu() {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		fond_ecran = new Image("images/card.jpg");
		img = new Image ("images/btn_st.png");
		img1 = new Image ("images/over.png");
		
//		son = new Sound("menu.ogg");
//		son.loop();
		bouton = new MouseOverArea(gc, img, 700, 150, 54, 20, this);
//		bouton1 = new MouseOverArea(gc, img1, 510, 150, 50, 30, this);
		
		bouton.setMouseOverImage(img1);
s =new Sons(new Sound("menu.ogg"));
		
		s.getSon().play();

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		fond_ecran.draw(0, 0, 850, 480);

		bouton.render(gc, g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		if (gc.getInput().isKeyDown(Input.KEY_ESCAPE)) {

			gc.exit();

		}
		
		
		if(click) {
			if(s.getSon()!=null) {
				s.getSon().stop();
				}
			sbg.enterState(1);
		}
	}
	@Override
	public void componentActivated(AbstractComponent source) {
		if (source == bouton) {
			
	click=true;
	
		}

	}
	@Override
	public int getID() {

		return 0;
	}

}
