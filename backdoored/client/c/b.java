package l.c.c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class b extends JFrame implements ActionListener {
   private JTextField fzg;
   private JFrame fzw;
   private JButton fzn;
   private JLabel fzr;
   private Consumer fbk;
   private String fbf;
   public static final int fbq;
   public static final boolean fbt;

   public b(String var1, String var2, String var3, Consumer var4) {
      this.fbk = var4;
      this.fbf = var3;
      this.fzw = new JFrame(var1);
      this.fzr = new JLabel(var2);
      this.fzn = new JButton(var3);
      this.fzn.addActionListener(this);
      this.fzg = new JTextField(16);
      JPanel var5 = new JPanel();
      var5.add(this.fzg);
      var5.add(this.fzn);
      var5.add(this.fzr);
      this.fzw.add(var5);
      this.fzw.setSize(300, 300);
      this.fzw.setVisible(true);
      this.fzw.setAlwaysOnTop(true);
   }

   public void actionPerformed(ActionEvent var1) {
      if (var1.getActionCommand().equals(this.fbf)) {
         this.fbk.accept(this.fzg.getText());
         this.fzw.dispatchEvent(new WindowEvent(this.fzw, 201));
      }

   }
}
