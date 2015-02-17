import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener{

	public InputHandler(Game game){
		game.addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_W){//W is up key
			Game.player.goingUp = true;
		}
		if(keyCode == e.VK_S){//S is down key
			Game.player.goingDown = true;
		}
		
	}

	public void keyReleased(KeyEvent e) {
int keyCode = e.getKeyCode();
		
		if(keyCode == e.VK_W){//W is up key;
			Game.player.goingUp = false;;
		}
		if(keyCode == e.VK_S){//S is down key
			Game.player.goingDown = false;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	
	

}
