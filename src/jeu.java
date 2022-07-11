import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

////--------------------------------------------------Tsague Alex jordan -------------------------------------------------------------------------

public class jeu extends BasicGameState {
/////
	Boss boss;
/////sons
	Sons s;
/////// score
	int score = 0;
//////sang
	sang health;
/////////
	ArrayList<Bonus> b = new ArrayList<Bonus>();

/////fond d'eran
	Image fond_ecran, boom, po;
/////vaisseau
	Vaisseau v;
/////Liste d'ennemis
	int temps = 0;
	int temp = 0;
	protected int intervaltir = (int) Math.random() * 6000 + 2000;
	ArrayList<Ennemi> E = new ArrayList<Ennemi>();
	ArrayList<Projectile_enne> p = new ArrayList<Projectile_enne>();
	boolean col;
	boolean pause = false;
	/////// temps de tir quand on obtient un bonus
	int random, t;
	private boolean green = false;

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		fond_ecran = new Image("images/bgg.jpg");

		boom = new Image("images/boom.png");

		v = new Vaisseau();

		t = 6000;

		E.add(new ennemi_circu());

		E.add(new ennemi_hori());

		E.add(new ennemi_verti());

		E.add(new ennemi_circu());

//		if(score>=1000) {
//			
//		    boss = new Boss();
//		}

		po = new Image("images/pause.png");

		health = new sang();

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
///////Fond d'ecran
		fond_ecran.draw(0, 0, 640, 480);

///////////////bande de sang et du score
		g.setColor(Color.magenta);

		g.drawString("Votre score : " + score, 645, 120);

		health.dessiner(g);
//////dessinons les bonus
		for (int i = 0; i < b.size(); i++) {
			if (b.size() >= 1)
				b.get(i).dessiner(g);
		}
//dessinons notre vaisseau.
		if (v != null) {
			v.dessiner(g);
		}
//////// ::Boss

//dessinons chaque ennemi.

		if (E.size() >= 1) {
			for (int i = 0; i < E.size(); i++) {
				E.get(i).dessiner(g);
			}
		}

//dessinons un projectile pour chaque ennemi.

		for (int i = 0; i < p.size(); i++) {
			p.get(i).dessiner(g);
		}

//dessinons Les projectiles de notre vaisseau.

		if (v != null) {

			if (v.getP().size() >= 1) {

				for (int i = 0; i < v.getP().size(); i++) {
					if (v.getP().get(i) != null)
						v.getP().get(i).dessiner(g);
				}
			}

		}

///////////gestion de la pause
		if (pause) {
			po.draw(0, 0, 640, 480);
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		///// Bouton de mise en pause
		if (gc.getInput().isKeyPressed(Input.KEY_P)) {
			pause = !pause;
		}
		/////// initialisation du Moment final
//////////Si on push 'espace' le vaisseau tire.
		if (!pause) {
			///// incrementation du temps pour l'annulation du bonus B
			temp += delta;
			if (gc.getInput().isKeyDown(Input.KEY_SPACE)) {

				v.tirer(delta);

			}
////////////////////// Exit
			
			if (gc.getInput().isKeyDown(Input.KEY_ESCAPE)) {

				gc.exit();

			}
/////////// Methode gauche/droite pour deplacer le vaisseau.

			if (gc.getInput().isKeyDown(Input.KEY_LEFT)) {

				if (v.peutGauche()) {

					v.gauche();

				}
			}

			if (gc.getInput().isKeyDown(Input.KEY_RIGHT)) {

				if (v.peutDroite()) {

					v.droite();
				}
			}
			///////// On deplacer le projectile provenant du vaisseau.

			for (int i = 0; i < v.getP().size(); i++) {

				if (v.getP().get(i) != null)

					v.getP().get(i).deplacer(delta);
			}

			for (int j = 0; j < p.size(); j++) {
				if (p.get(j) != null)
					p.get(j).deplacer(delta);

			}
			///// /////////////////////////////////////////////////////////////////////initialisation
			///// des sons
			s = new Sons(new Sound("audios/damageSound.wav"));

			/////////////////////////////////////////////////////// tirer
			for (int i = 0; i < E.size(); i++) {
				temps += delta;

				if (temps >= intervaltir) {
					p.add(new Projectile_enne(E.get(i).getX(), E.get(i).getY() + 30));
					temps = 0;
				}
			}

			///////////////////////////////////////////////////// Ajout des ennemis
			random = (int) (Math.random() * 4000);
			if (score > 1000) {
				random = (int) (Math.random() * 1000);
			} else if (score > 2000) {
				random = (int) (Math.random() * 700);
			}else if (score > 5000) {
				random = (int) (Math.random() * 200);
			}

			switch (random) {
			case 0:
				E.add(new ennemi_circu());
				break;
			case 1:
				E.add(new ennemi_hori());
			case 2:
				E.add(new ennemi_verti());
				break;
			}

//////////////On  verifie si il y'a un ennemi ensuite si c'est true on le deplace .

			if (E.size() >= 1) {
				for (int i = 0; i < E.size(); i++) {
					if (E.get(i) != null) {
						E.get(i).deplacer(delta);
//					
					}
				}
			}

////////////////On verifie si un ennemi sors de l'ecran ensuite on le fait disparaitre.	

			for (int i = 0; i < E.size(); i++) {

				if (E.get(i) != null) {

					if (E.get(i).peutDisparaitre())

						E.remove(i);
				}
			}

//////////test collision et suppression d'ennemi et de projectiles.

			if (E.size() > 0) {
				for (int j = 0; j < E.size(); j++) {
					if (E.get(j) != null) {
						if (v.getP().size() > 0) {
							for (int i = 0; i < v.getP().size(); i++) {
								if (v.getP().get(i).testCollision(E.get(j))) {
									s.getSon().play();
									E.remove(j);
									v.getP().remove(i);
									score += 50;
									break;
								}
							}
						}

					}
				}
			}
///////Collision projectile ennemi-vaisseau
			if (v != null) {
				if (E.size() >= 1) {
					for (int i = 0; i < E.size(); i++) {
						for (int j = 0; j < p.size(); j++) {
							if (p.size() >= 1) {
								if (p.get(j).testCollision(v)) {
									p.remove(j);
									health.setW(health.getW() - 10.f);
								}
							}
						}

					}
				}
			}
/////////collion vaisseau ennemi
			if (v != null) {
				if (E.size() >= 1) {

					for (int i = 0; i < E.size(); i++) {
						if (v.testCollision(E.get(i))) {
							E.remove(i);
							health.setW(health.getW() - 15.f);
						}
					}
				}
			}

//		boss = new Boss();
//		if(boss!=null) {
//		if (boss.alive()) {
//
//			boss.deplacer(delta);
//		}
//	}
//////////tirer
//			for (int i = 0; i < E.size(); i++) {
//				temps += delta;
//
//				if (temps >= intervaltir) {
//					p.add(new Projectile_enne(boss.getX(), boss.getY() + 100));
//					p.add(new Projectile_enne(boss.getX() + 33, boss.getY() + 100));
//					p.add(new Projectile_enne(boss.getX() + 100, boss.getY() + 100));
//					temps = 0;
//				}
//			}
//			////////// deplacons les projectiles
//			for (int j = 0; j < p.size(); j++) {
//				if (p.get(j) != null)
//					p.get(j).deplacer(delta);
//
//			}
//
//			if (boss != null) {
//				if (v.getP().size() > 0) {
//					for (int i = 0; i < v.getP().size(); i++) {
//						if (v.getP().get(i).testCollisionBoss(boss)) {
//							boss.health -= 20;
//							v.getP().remove(i);
//							score += 50;
//							break;
//						}
//					}
//				}
//
//			}
//
//	}

			/////////// Ajout et deplacement de Bonus
			int random = (int) (Math.random() * 15000);
			switch (random) {
			case 0:
				b.add(new BonusA());
				break;
			case 1:
				b.add(new BonusB());
				break;
			case 2:
				b.add(new BonusC());
				break;
			}

			for (int i = 0; i < b.size(); i++) {
				if (b.size() >= 1) {

					b.get(i).deplacer(delta);

				}
			}
			if (green) {
				if (temp > 15000) {
					v.setIntervaltir((int) (Math.random() * 300 + 100));
					temp = 0;
					green = false;
				}

			}
			//////// Collision vaisseau Bonus
			if (v != null) {
				if (b.size() >= 1) {
					for (int i = 0; i < b.size(); i++) {
						if (b.get(i).testCollisionbonus(v)) {
							if (b.get(i).getId() == 1) {
								if (health.getW() < 100 && health.getW() > 0) {
									health.setW(health.getW() + 100.f);
								} else {
									health.setW(200.f);
								}
							} else if (b.get(i).getId() == 2) {
								green = true;
								v.setIntervaltir((int) (Math.random() * 100 + 10));
								temp = 0;
							} else if (b.get(i).getId() == 3) {

								health.setW(200.f);

							}
							b.remove(i);
							break;
						}
					}
				}
			}
		}/////// end !pause
////////////////Game over

		if (health.getW() < 0) {
			gc.reinit();
			sbg.enterState(2);
		}

	} 
		////////////// end update

	@Override
	public int getID() {

		return 1;
	}

}
