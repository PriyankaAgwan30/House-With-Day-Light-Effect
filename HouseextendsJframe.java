import java.awt.*; 
import java.awt.event.*; 
import java.awt.geom.*; 
import javax.swing.*; 
public class HouseextendsJframe 
{ 
public static Jframe mFrame; 
public static void main(String[]args) 
{ 
mFrame = new Jframe(“House Drawing”); 
mFrame.setResizable(false); 
mFrame.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE); 
mFrame.getContentPane().add(new HousePanel()); 
mFrame.pack(); 
mFrame.setVisible(true); 
} 
public static class HousePanel extends Jpanel 
{ 
 
final static int DAY = 1; 
final static int NIGHT = 2; 
final Color skyblue = new Color(207,226,243); //day –sky 
final Color midnightblue = new Color(0,0,20); //night –sky 
final Color darktan = new Color(108, 93, 83); //roof 
final Paint sunyellow = new Color(255,217,102); //day – sun 
final Paint lunarsilver = new Color(204, 204, 204); //night – moon 
final Paint green = new Color(102, 128, 0); //unused – previous grass 
final Paint lightGreen = new Color(56,118,29); //grass 
 
 
final Paint tan = new Color(145, 124, 95); //house 
final Paint lightbrown = new Color(246, 178, 107); //door 
final Paint lightblue = new Color(172, 238, 240); //window 
private static int MODE = NIGHT; 
public HousePanel() { 
House.mFrame.setBackground(((MODE == DAY) ? skyblue : midnightblue)); 
setPreferredSize(new Dimension(540,550)); 
addMouseListener(new MouseAdapter() { 
public void mouseClicked(MouseEvent me) { 
MODE = (MODE == DAY) ? NIGHT : DAY; 
House.mFrame.setBackground(((MODE == DAY) ? skyblue : midnightblue)); 
House.mFrame.repaint(); 
} 
}); 
} 
@Override 
public void paintComponent(Graphics g) { 
final Shape grass = new Ellipse2D.Double(3.0, 200.0, 510.0, 300.0); 
final Shape house = new Rectangle2D.Double(120.0, 179.0, 288.0, 210.0); 
final Shape window = new Rectangle2D.Double(130.0, 200.0, 160.0, 100.0); 
final Shape sunmoon = new Ellipse2D.Double(70.0, 14.0, 70.0, 70.0); 
final Shape door = new Rectangle2D.Double(300.0, 320.0, 52.0, 68.0); 
final int[] roofxs = { 90, 430, 260 }; //Triangle x coordinates for the roof 
final int[] roofys = { 180, 180, 60 }; //Triangle y coordinates for the roof 
final Polygon roof = new Polygon(roofxs, roofys, 3); 
Graphics2D g2 = (Graphics2D) g; //allows usage of functions from the Graphics2D package 
//the following 2 lines smooth the edges of all lines that are drawn. 
G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_AN
 TIALIAS_ON);g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
RenderingHints.VALUE_INTERPOLATION_BILINEAR);g2.translate(10, 10); 
//moves entire canvas right and down by 10 pixels 
 
 
g2.setPaint(((MODE == DAY) ? green : lightGreen)); 
g2.fill(grass); 
g2.setPaint(((MODE == DAY) ? sunyellow : lunarsilver)); 
g2.fill(sunmoon); 
g2.setPaint(tan); 
g2.fill(house); 
g.setColor(darktan); 
g.fillPolygon(roof); 
g2.setPaint(lightbrown); 
g2.fill(door); 
g2.setPaint(lightblue); 
g2.fill(window); 
g2.dispose(); 
} 
} 
} 
