import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball {
	int x,y;
	int size = 16;
	int speed =2;
	int vx, vy; //velocity x and y
	
	Rectangle boundingBox;
	
	
	public Ball(int x, int y){
		this.x=x;
		this.y=y;
		
		vx = speed; //left and up
		vy = speed; //right and down
		
		boundingBox = new Rectangle(x, y, size, size);
		boundingBox.setBounds(x, y, size, size);
		
	}
	public void tick(Game game){
		boundingBox.setBounds(x, y, size, size);
		
		if(x <= 0){ //if top left corner of ball is at 0
			game.p2Score++;
			vx = speed; //sets it positive 
		}
		else if(x + size >= game.getWidth()){//if x"top left" + size"topright corner" is greater than getWidth() "far right of screen"
			game.p1Score++;
			vx = -speed;
			
		}
		if(y <= 0){
			vy = speed;
		}
		else if( y + size >= game.getHeight()){
			vy = -speed;
		}
		x+= vx;
		y+= vy;
		
		paddleCollide(game); 
	}
		private void paddleCollide(Game game){
			if(boundingBox.intersects(game.player.boundingBox)){
				vx = speed;
			}
			else if(boundingBox.intersects(game.ai.boundingBox)){
				vx = -speed;
				
			}
		
	}

	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(x, y, size, size);
	}
}
