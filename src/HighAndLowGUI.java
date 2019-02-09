import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class HighAndLowGUI extends JFrame implements ActionListener{

    JLabel label;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel score;
    JLabel fscore;
    JPanel panel = new JPanel();

    Random rdm = new Random();
    int num1 = rdm.nextInt(13)+1;
    int num2 = rdm.nextInt(13)+1;
    int scr = 0;

    public static void main (String[] args){
        HighAndLowGUI gui = new HighAndLowGUI("HighAndLowGUI");

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

    HighAndLowGUI (String title){
        setTitle("HighAndLowGame");
        setBounds(100, 100, 400, 300);

        label = new JLabel("次の数字はHigh？Low？");
        label3 = new JLabel("?");
        label4 = new JLabel("結果");
        score = new JLabel(Integer.toString(scr));


        JButton buttonH = new JButton("High");
        buttonH.addActionListener(this);
        buttonH.setActionCommand("High");

        JButton buttonL = new JButton("Low");
        buttonL.addActionListener(this);
        buttonL.setActionCommand("Low");

        JButton buttonReset = new JButton("スコアリセット");
        buttonReset.addActionListener(this);
        buttonReset.setActionCommand("reset");

        panel.add(label);
        panel.add(label3);
        panel.add(score);
        panel.add(buttonH);
        panel.add(buttonL);
        panel.add(buttonReset);

        add(panel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        label2 = new JLabel(Integer.toString(num1));
        switch (cmd){
            case "High":
                label3.setText(Integer.toString(num2));
                if (num1 < num2) {
                    scr++;
                    label4.setText("あなたの勝ち！+1点！");
                    score.setText(Integer.toString(scr));
                    panel.add(label4);
                }
                else if(num1==num2){
                    label4.setText("引き分け！");
                    panel.add(label4);
                }
                else{
                    label4.setText("あなたの負け！残念。");
                    fscore = new JLabel("あなたのスコア"+Integer.toString(scr));
                    panel.add(fscore);
                    scr = 0;
                }
                break;

            case "Low":
                label3.setText(Integer.toString(num2));
                if(num1 < num2){
                    label4.setText("あなたの負け！残念。");
                    fscore = new JLabel("あなたのスコア"+Integer.toString(scr));
                    panel.add(fscore);
                    scr = 0;
                }
                else if(num1==num2){
                    label4.setText("引き分け！");
                    panel.add(label4);
                }
                else{
                    scr++;
                    label4.setText("あなたの勝ち！+1点！");
                    score.setText(Integer.toString(scr));
                    panel.add(label4);
                }
                break;

        }
    }
}
