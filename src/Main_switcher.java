import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class Main_switcher extends StateBasedGame {
	
	public Main_switcher(String name) {
		super(name);
	}
             
	@Override
	
	public void initStatesList(GameContainer gc) throws SlickException {
		
		    this.addState(new Menu());
          	this.addState(new jeu());
          	this.addState(new GameOver());

	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main_switcher("Shoot'em up"));
		app.setShowFPS(false);
		app.setDisplayMode(850, 480,false );
		app.start();

	}

}
