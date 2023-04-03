package mazesolver;

import javax.swing.JFrame;
import java.awt.*;
import java.util.*;
public class NewClass extends JFrame {
    private int [][] maze=
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1},
                    {1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                    {1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 9, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
    public ArrayList<Integer>path=new ArrayList<>();
    public NewClass(){
        setLocation(200,200);
        setTitle("Maze Solver");
        setBackground(Color.BLUE);
        setVisible(true);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        depthfirst.searchpath(maze,1,1,path);
        System.out.println(path);
    }

    public void paint(Graphics g){
        g.translate(80,70);
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color;
                switch (maze[i][j]){
                    case 1:color=Color.BLACK;break;
                    case 9:color =Color.red;break;
                    default :color=Color.yellow;break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.blue);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i=0;i<path.size();i+=2){
            int pathx=path.get(i);
            int pathy=path.get(i+1);
            System.out.println("x coordinates"+pathx);
            System.out.println("y coordinate"+pathy);
            g.setColor(Color.green);
            g.fillRect(30*pathx,30*pathy,30,30);
        }
    }
    public static void main(String[] args){
        NewClass view=new NewClass();
        view.setVisible(true);
    }
}
