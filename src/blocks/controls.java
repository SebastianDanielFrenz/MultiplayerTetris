package blocks;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class controls implements KeyListener {
	
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;
	
	@Override
	public void keyPressed(KeyEvent key) {
		if(key.getKeyCode() == KeyEvent.VK_UP ) {
			//System.out.println("up");
			up = true;
		} else if(key.getKeyCode() == KeyEvent.VK_DOWN ) {
			//System.out.println("down");
			down = true;
		} else if(key.getKeyCode() == KeyEvent.VK_RIGHT ) {
			//System.out.println("right");
			right = true;
		} else if(key.getKeyCode() == KeyEvent.VK_LEFT ) {
			//System.out.println("left");
			left = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if(key.getKeyCode() == KeyEvent.VK_UP ) {
			//System.out.println("up released");
			up = false;
		} else if(key.getKeyCode() == KeyEvent.VK_DOWN ) {
			//System.out.println("down released");
			down = false;
		} else if(key.getKeyCode() == KeyEvent.VK_RIGHT ) {
			//System.out.println("right released");
			right = false;
		} else if(key.getKeyCode() == KeyEvent.VK_LEFT ) {
			//System.out.println("left released");
			left = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	
	
}