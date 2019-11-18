package l.c.h.j.a.f;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import l.c.q;
import l.c.h.j.w;
import l.c.u.t;
import l.c.v.x;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class c {
   private JFrame er;
   private JTextArea vk;
   private JTextField vf;
   private JTextArea vq;
   private JPanel vt;
   private JSplitPane ve;
   private JPanel vv;
   private JPanel vu;
   private JScrollPane vi;
   public static final boolean vd;
   public static final int vs;
   public static final boolean vm;

   public c() {
      this.x();
      this.er = new JFrame("SwingImpl");
      Dimension var1 = Toolkit.getDefaultToolkit().getScreenSize();
      this.er.setSize(var1.width / 2, var1.height / 2);
      this.er.setContentPane(this.vt);
      this.er.pack();
      this.er.setVisible(true);
      MinecraftForge.EVENT_BUS.register(this);
   }

   @SubscribeEvent
   public void k(ClientChatReceivedEvent var1) {
      if ((Boolean)i.jy.ti()) {
         this.vk.append(var1.getMessage().getUnformattedText() + "\n");
      }

      JScrollBar var2 = this.vi.getVerticalScrollBar();
      var2.setValue(var2.getMaximum());
   }

   @SubscribeEvent
   public void k(t var1) {
      this.vk.append(var1.iTextComponent.getUnformattedText() + "\n");
      JScrollBar var2 = this.vi.getVerticalScrollBar();
      var2.setValue(var2.getMaximum());
   }

   public void b() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = l.c.h.j.i.qg().iterator();
      if (var2.hasNext()) {
         w var3 = (w)var2.next();
         if (var3.qm()) {
            var1.append(var3.gw).append("\n");
         }
      }

      this.vq.setText(var1.toString());
   }

   public void y() {
      this.er.setVisible(false);
      this.er.dispose();
   }

   private void x() {
      this.vt = new JPanel();
      this.vt.setLayout(new BorderLayout(0, 0));
      this.ve = new JSplitPane();
      this.vt.add(this.ve, "Center");
      this.vv = new JPanel();
      this.vv.setLayout(new BorderLayout(0, 0));
      this.ve.setLeftComponent(this.vv);
      this.vf = new JTextField();
      this.vv.add(this.vf, "South");
      this.vi = new JScrollPane();
      this.vi.setHorizontalScrollBarPolicy(31);
      this.vi.setVerticalScrollBarPolicy(20);
      this.vv.add(this.vi, "Center");
      this.vk = new JTextArea();
      this.vk.setLineWrap(true);
      this.vk.setText("");
      this.vi.setViewportView(this.vk);
      this.vu = new JPanel();
      this.vu.setLayout(new BorderLayout(0, 0));
      this.ve.setRightComponent(this.vu);
      this.vq = new JTextArea();
      this.vu.add(this.vq, "Center");
   }

   public JComponent l() {
      return this.vt;
   }

   // $FF: synthetic method
   private void q(ActionEvent var1) {
      if (this.vf.getText().startsWith(x.zd)) {
         x.c(this.vf.getText());
      }

      q.mc.player.sendChatMessage(this.vf.getText());
      this.vf.setText("");
   }
}
