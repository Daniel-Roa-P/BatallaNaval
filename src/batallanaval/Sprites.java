
package batallanaval;

import java.awt.Graphics;
import java.awt.Rectangle;


public interface Sprites {
    
    public void draw(Graphics g);
    public void update(int c);
    public void update();
    public Rectangle getRect();
    public void cambiarSentido();
    
}