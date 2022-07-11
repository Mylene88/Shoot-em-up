import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class GameOver extends BasicGameState implements ComponentListener{
	
	private MouseOverArea bouton,bouton1;
	boolean click,click2;
	Image img,img1,imgg,img11;
	Image go;
    
   
    
	public GameOver() {
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		go = new Image("images/game-over.jpg");
		img = new Image ("images/menu_bnt.jfif");
		img1= new Image ("images/restart.png");
		imgg = new Image ("images/m_over.jfif");
		img11= new Image ("images/restart_over.png");
		bouton = new MouseOverArea(gc, img, 160, 350, 141, 32, this);
		bouton1 = new MouseOverArea(gc, img1, 560, 340, 60, 70, this);
		
		bouton.setMouseOverImage(imgg);
		bouton1.setMouseOverImage(img11);	
	
	}
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		go.draw(0, 0, 850, 480);
		g.setColor(Color.green);
		g.drawString("'Echap' pour quitter", 0, 0);
		bouton.render(gc, g);
		bouton1.render(gc, g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		if(click2) {
			sbg.enterState(1);
		}
		if(click) {
			sbg.enterState(0);
		}
		
		if (gc.getInput().isKeyDown(Input.KEY_ESCAPE)) {

			gc.exit();

		}
		
	}
	@Override
	public void componentActivated(AbstractComponent source) {
		if (source == bouton) {
			
	         click=true;
	
		}
		if (source == bouton1) {
			
	          click2 = true;
	
		}

	}
	@Override
	public int getID() {
		
		return 2;
	}

}
