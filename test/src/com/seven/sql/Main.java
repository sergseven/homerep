package com.seven.sql;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.HashMap;

/**
 * 
 * @author serg
 *
 */
interface Operation {
 double exec(double a, double b);
}

interface OperationFactory {
 Operation getOpInstance(String op);
}

class Calculator {
 OperationFactory of;

 Calculator(MyOpFactory mof) {
  of = mof;
 }

 double exec(String c, String a, String b) {
  return of.getOpInstance(c).exec(Double.valueOf(a), Double.valueOf(b));
 }

}

class MyOpFactory implements OperationFactory {

 public Operation getOpInstance(String op) {
  HashMap<String, Operation> hm = new HashMap<String, Operation>();

  Boolean a = false, b = false, c = false, d = false;
  if ("+".equals(op)) {
   if (!a) {
    hm.put("Plus", new OpPlus());
    a = true;
   }
   return hm.get("Plus");
  }
  if ("-".equals(op)) {
   if (!b) {
    hm.put("Minus", new OpMinus());
    b = true;
   }
   return hm.get("Minus");
  }
  if ("/".equals(op)) {
   if (!c) {
    hm.put("Div", new OpDiv());
    c = true;
   }
   return hm.get("Div");
  }
  if ("*".equals(op)) {
   if (!d) {
    hm.put("Mul", new OpMul());
    d = true;
   }
   return hm.get("Mul");
  }
  return null;
 }
}

class OpPow implements Operation {
 public double exec(double a, double b) {
  return Math.pow(a, b);
 }
}

class OpPlus implements Operation {
 public double exec(double a, double b) {
  return a + b;
 }
}

class OpDiv implements Operation {
 public double exec(double a, double b) {
  return a / b;
 }
}

class OpMul implements Operation {
 public double exec(double a, double b) {
  return a * b;
 }
}

class OpMinus implements Operation {
 public double exec(double a, double b) {
  return a - b;
 }
}

public class Main {

 static class Swing implements ActionListener {
  MyOpFactory mop = new MyOpFactory();
  Calculator calc = new Calculator(mop);
  Boolean first = false;
  String numba = "", numbb = "", oper = "";

  JLabel labres = new JLabel("���������:");
  JButton but[] = new JButton[20];
  JLabel laba = new JLabel("������ �������� :");
  JLabel labb = new JLabel("������ �������� :");
  GridBagLayout gbag = new GridBagLayout();
  GridBagConstraints gbcon = new GridBagConstraints();
  String numbers[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
  String operation[] = { "+", "-", "/", "*", "=" };

  Swing() {

   JFrame jfrm = new JFrame("Okno");
   jfrm.setLayout(gbag);
   jfrm.setSize(400, 400);
   gbcon.weightx = 1;
   gbcon.weighty = 1;
   gbcon.anchor = GridBagConstraints.RELATIVE;
   gbag.setConstraints(laba, gbcon);
   gbag.setConstraints(labb, gbcon);

   jfrm.add(laba);
   jfrm.add(labb);
   gbcon.weighty = 1;
   gbcon.gridy = 1;
   gbcon.gridx = 0;
   gbcon.weightx = 1;
   for (int i = 0; i < numbers.length; i++) {

    but[i] = new JButton("" + numbers[i]);
    but[i].addActionListener(this);
    gbag.setConstraints(but[i], gbcon);
    jfrm.add(but[i]);
    gbcon.gridx++;
    if ((i + 1) % 3 == 0) {
     // gbcon.weighty++;
     gbcon.gridy++;
     gbcon.gridx = 0;
    }
   }
   gbcon.gridx = 0;
   gbcon.gridy = 6;
   gbag.setConstraints(labres, gbcon);
   jfrm.add(labres);

   gbcon.gridy = 1;
   gbcon.gridx = 4;
   for (int i = 0; i < operation.length; i++) {
    but[i + 10] = new JButton("" + operation[i]);
    but[i + 10].addActionListener(this);
    gbag.setConstraints(but[i + 10], gbcon);
    jfrm.add(but[i + 10]);
    gbcon.gridy++;
   }

   jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   jfrm.setVisible(true);

  }

  public void actionPerformed(ActionEvent ae) {
   for (int i = 0; i < 20; i++) {
    if (ae.getSource() == but[i]) {
     if (i < 10) {
      if (!first) {
       numba = numba + but[i].getText();
       laba.setText(numba);
      }
      else {
       numbb = numbb + but[i].getText();
       labb.setText(numbb);
      }

     }

     if (first && but[i].getText().equals("=")) {
      labres.setText("" + calc.exec(oper, numba, numbb));
      numba = numbb = oper = "";
      first = false;
      return;
     }
     if (i >= 10) {
      first = true;
      oper = but[i].getText();
     }
    }
   }

  }

 }

 /**
  * @param args
  */
 public static void main(String[] args) {

  SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    Swing s = new Swing();
   }
  });

 }

}