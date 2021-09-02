/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package previsaomensalvendas.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import previsaomensalvendas.MultLayerPerceptron;
import previsaomensalvendas.Tabela;

/**
 *
 * @author Igor
 */
public class Interface extends javax.swing.JFrame {

    private MultLayerPerceptron rede;
    private Tabela tabela = new Tabela();
    private int mesPrevisao;
    private boolean flag = false;

    /**
     * Creates new form Interface
     */
    public Interface() {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        initComponents();
        hideComponents();

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation(screenWidth / 4, screenHeight / 8);

        this.setVisible(true);

    }

    public final void hideComponents() {
        this.ComboBoxAnoPrevisao.setVisible(false);
        this.ComboBoxMes.setVisible(false);
        this.LabelAnoPrevisao.setVisible(false);
        this.LabelMes.setVisible(false);
        this.ButtonOk.setVisible(false);
        this.ButtonFind.setVisible(false);
        this.LabelValorEsperado.setVisible(false);
        this.ButtonClear.setVisible(false);
    }

    public final void showComponents() {
        this.ComboBoxAnoPrevisao.setVisible(true);
        this.ComboBoxMes.setVisible(true);
        this.LabelAnoPrevisao.setVisible(true);
        this.LabelMes.setVisible(true);
        this.ButtonOk.setVisible(true);
        this.ButtonFind.setVisible(true);
        this.ButtonClear.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        LabelPrevisaoMensal = new javax.swing.JLabel();
        LabelTreinarRede = new javax.swing.JLabel();
        ButtonTreinarRede = new javax.swing.JButton();
        ComboBoxAnoPrevisao = new javax.swing.JComboBox();
        LabelAnoPrevisao = new javax.swing.JLabel();
        LabelMes = new javax.swing.JLabel();
        ComboBoxMes = new javax.swing.JComboBox();
        ButtonClose = new javax.swing.JLabel();
        ButtonOk = new javax.swing.JLabel();
        ButtonFind = new javax.swing.JLabel();
        LabelValorEsperado = new javax.swing.JLabel();
        ButtonClear = new javax.swing.JLabel();
        LabelErroRede = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        LabelPrevisaoMensal.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        LabelPrevisaoMensal.setForeground(new java.awt.Color(255, 255, 255));
        LabelPrevisaoMensal.setText("Previsão Mensal de Vendas");
        LabelPrevisaoMensal.setBounds(80, 20, 300, 30);
        jLayeredPane1.add(LabelPrevisaoMensal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        LabelTreinarRede.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LabelTreinarRede.setForeground(new java.awt.Color(255, 255, 255));
        LabelTreinarRede.setText("Treinar Rede Neural");
        LabelTreinarRede.setBounds(170, 90, 131, 18);
        jLayeredPane1.add(LabelTreinarRede, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ButtonTreinarRede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/previsaomensalvendas/files/brain.png"))); // NOI18N
        ButtonTreinarRede.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonTreinarRede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonTreinarRedeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonTreinarRedeMouseExited(evt);
            }
        });
        ButtonTreinarRede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTreinarRedeActionPerformed(evt);
            }
        });
        ButtonTreinarRede.setBounds(200, 120, 70, 30);
        jLayeredPane1.add(ButtonTreinarRede, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ComboBoxAnoPrevisao.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ComboBoxAnoPrevisao.setForeground(new java.awt.Color(255, 0, 0));
        ComboBoxAnoPrevisao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2012" }));
        ComboBoxAnoPrevisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxAnoPrevisaoActionPerformed(evt);
            }
        });
        ComboBoxAnoPrevisao.setBounds(20, 210, 90, 24);
        jLayeredPane1.add(ComboBoxAnoPrevisao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        LabelAnoPrevisao.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LabelAnoPrevisao.setForeground(new java.awt.Color(255, 255, 255));
        LabelAnoPrevisao.setText("Ano para previsão");
        LabelAnoPrevisao.setBounds(20, 180, 120, 18);
        jLayeredPane1.add(LabelAnoPrevisao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        LabelMes.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LabelMes.setForeground(new java.awt.Color(255, 255, 255));
        LabelMes.setText("Mês");
        LabelMes.setBounds(20, 250, 24, 18);
        jLayeredPane1.add(LabelMes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ComboBoxMes.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ComboBoxMes.setForeground(new java.awt.Color(255, 0, 0));
        ComboBoxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        ComboBoxMes.setBounds(20, 270, 90, 24);
        jLayeredPane1.add(ComboBoxMes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/previsaomensalvendas/files/close.png"))); // NOI18N
        ButtonClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonCloseMouseExited(evt);
            }
        });
        ButtonClose.setBounds(630, 10, 20, 20);
        jLayeredPane1.add(ButtonClose, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ButtonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/previsaomensalvendas/files/ok.png"))); // NOI18N
        ButtonOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonOkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonOkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonOkMouseExited(evt);
            }
        });
        ButtonOk.setBounds(130, 340, 35, 35);
        jLayeredPane1.add(ButtonOk, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ButtonFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/previsaomensalvendas/files/find.png"))); // NOI18N
        ButtonFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonFindMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonFindMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonFindMouseExited(evt);
            }
        });
        ButtonFind.setBounds(70, 340, 40, 40);
        jLayeredPane1.add(ButtonFind, javax.swing.JLayeredPane.DEFAULT_LAYER);

        LabelValorEsperado.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LabelValorEsperado.setForeground(new java.awt.Color(255, 255, 255));
        LabelValorEsperado.setText("Valor Esperado");
        LabelValorEsperado.setBounds(150, 270, 200, 30);
        jLayeredPane1.add(LabelValorEsperado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ButtonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/previsaomensalvendas/files/clear.png"))); // NOI18N
        ButtonClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonClearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonClearMouseExited(evt);
            }
        });
        ButtonClear.setBounds(20, 340, 30, 40);
        jLayeredPane1.add(ButtonClear, javax.swing.JLayeredPane.DEFAULT_LAYER);

        LabelErroRede.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LabelErroRede.setForeground(new java.awt.Color(255, 255, 255));
        LabelErroRede.setBounds(30, 420, 190, 30);
        jLayeredPane1.add(LabelErroRede, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/previsaomensalvendas/files/background.jpg"))); // NOI18N
        jLabel2.setBounds(0, 0, 660, 550);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxAnoPrevisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxAnoPrevisaoActionPerformed
        if (this.ComboBoxAnoPrevisao.getSelectedIndex() == 1) {
            this.ComboBoxMes.removeItemAt(11);
            this.ComboBoxMes.removeItemAt(10);
            this.ComboBoxMes.removeItemAt(9);
            this.flag = true;
        } else {
            if (flag) {
                this.ComboBoxMes.addItem("Outubro");
                this.ComboBoxMes.addItem("Novembro");
                this.ComboBoxMes.addItem("Dezembro");
                flag = false;
            }
        }
    }//GEN-LAST:event_ComboBoxAnoPrevisaoActionPerformed
//Botão usado para treinar a rede
    private void ButtonTreinarRedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTreinarRedeActionPerformed
        System.out.println("---------------------\n Treinando... \n---------------------");
        train();
        showComponents();
    }//GEN-LAST:event_ButtonTreinarRedeActionPerformed

    private void ButtonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCloseMouseClicked
        dispose();
    }//GEN-LAST:event_ButtonCloseMouseClicked

    private void ButtonOkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOkMouseEntered
        this.ButtonOk.setBounds(this.ButtonOk.getX(), this.ButtonOk.getY(), this.ButtonOk.getWidth() + 5, this.ButtonOk.getHeight() + 5);
    }//GEN-LAST:event_ButtonOkMouseEntered

    private void ButtonOkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOkMouseExited
        this.ButtonOk.setBounds(this.ButtonOk.getX(), this.ButtonOk.getY(), this.ButtonOk.getWidth() - 5, this.ButtonOk.getHeight() - 5);
    }//GEN-LAST:event_ButtonOkMouseExited

    private void ButtonCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCloseMouseEntered
        this.ButtonClose.setBounds(this.ButtonClose.getX(), this.ButtonClose.getY(), this.ButtonClose.getWidth() + 5, this.ButtonClose.getHeight() + 5);
    }//GEN-LAST:event_ButtonCloseMouseEntered

    private void ButtonCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCloseMouseExited
        this.ButtonClose.setBounds(this.ButtonClose.getX(), this.ButtonClose.getY(), this.ButtonClose.getWidth() - 5, this.ButtonClose.getHeight() - 5);
    }//GEN-LAST:event_ButtonCloseMouseExited

    private void ButtonFindMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonFindMouseEntered
        this.ButtonFind.setBounds(this.ButtonFind.getX(), this.ButtonFind.getY(), this.ButtonFind.getWidth() + 5, this.ButtonFind.getHeight() + 5);
    }//GEN-LAST:event_ButtonFindMouseEntered

    //função que chama a função treina
    private void train() {

        int inicio = 0;
        int mesAlvo = 12;
        int ultimoMes = 84;
        int cont = 0;
        int iteracoes = 0;
        this.rede = new MultLayerPerceptron(12, 10, 1); // 12 entradas, 10 neuronios camada oculta, 1 na camada de saida
        while (iteracoes < 10000) {
            while (cont < ultimoMes) {
                ArrayList<Double> entradas = new ArrayList<>();
                for (int i = 0; i < 12; i++) {
                    Double temp = new Double(0);
                    entradas.add(temp);
                }
                //recebe as entradas da tabela de 12 em 12 por conta do ano para treinar
                for (int i = inicio, j = 1; i < inicio + 12; i++, j++) {
                    Double aux = entradas.get(j - 1);
                    aux = tabela.getEntradas().get(i);
                    entradas.set(j - 1, aux);
                }
                //define as entradas
                rede.definirEntradas(entradas);
                //treina a tabela
                rede.treinar(tabela.getEntradas().get(mesAlvo));

                cont++;
                inicio++;
                mesAlvo++;
            }
            cont = 0;
            ++iteracoes;
            inicio = 0;
            mesAlvo = 12;
        }

    }

    private void ButtonFindMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonFindMouseExited
        this.ButtonFind.setBounds(this.ButtonFind.getX(), this.ButtonFind.getY(), this.ButtonFind.getWidth() - 5, this.ButtonFind.getHeight() - 5);
    }//GEN-LAST:event_ButtonFindMouseExited

    private void ButtonFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonFindMouseClicked
        TabelaValores tabelaValores = new TabelaValores();
        tabelaValores.setVisible(true);
    }//GEN-LAST:event_ButtonFindMouseClicked

    private void ButtonTreinarRedeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTreinarRedeMouseEntered
        this.ButtonTreinarRede.setBounds(this.ButtonTreinarRede.getX(), this.ButtonTreinarRede.getY(), this.ButtonTreinarRede.getWidth() + 3, this.ButtonTreinarRede.getHeight() + 3);
    }//GEN-LAST:event_ButtonTreinarRedeMouseEntered

    private void ButtonTreinarRedeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTreinarRedeMouseExited
        this.ButtonTreinarRede.setBounds(this.ButtonTreinarRede.getX(), this.ButtonTreinarRede.getY(), this.ButtonTreinarRede.getWidth() - 3, this.ButtonTreinarRede.getHeight() - 3);
    }//GEN-LAST:event_ButtonTreinarRedeMouseExited

    // ação para chamar a previsao
    private void ButtonOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonOkMouseClicked

        System.out.println("---------------------\n Calculando Previsao \n---------------------");

        this.LabelValorEsperado.setVisible(true);

        int ano = this.ComboBoxAnoPrevisao.getSelectedIndex();
        int mes = this.ComboBoxMes.getSelectedIndex();

        int inicio;
        int mesAlvo;

        if (ano == 0) { // 2011
            mesAlvo = 84 + mes;
        } else {
            mesAlvo = 96 + mes; //mes a ser previsto
        }

        this.mesPrevisao = mesAlvo;

        ArrayList<Double> entradas = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Double temp = new Double(0);
            entradas.add(temp);
        }
        inicio = this.mesPrevisao - 12;

        for (int i = inicio, j = 1; i < inicio + 12; i++, j++) {
            Double aux = entradas.get(j - 1);
            aux = tabela.getEntradas().get(i);
            entradas.set(j - 1, aux);
        }
        rede.definirEntradas(entradas);
        rede.prever();

        double resultado = (rede.getResultado() * 40);

        this.LabelValorEsperado.setText(String.valueOf(resultado));
        this.LabelValorEsperado.setVisible(true);

    }//GEN-LAST:event_ButtonOkMouseClicked

    private void ButtonClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClearMouseEntered
        this.ButtonClear.setBounds(this.ButtonClear.getX(), this.ButtonClear.getY(), this.ButtonClear.getWidth() + 5, this.ButtonClear.getHeight() + 5);
    }//GEN-LAST:event_ButtonClearMouseEntered

    private void ButtonClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClearMouseExited
        this.ButtonClear.setBounds(this.ButtonClear.getX(), this.ButtonClear.getY(), this.ButtonClear.getWidth() - 5, this.ButtonClear.getHeight() - 5);
    }//GEN-LAST:event_ButtonClearMouseExited

    private void ButtonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonClearMouseClicked
        this.ComboBoxAnoPrevisao.setSelectedIndex(0);
        this.ComboBoxMes.setSelectedIndex(0);
        this.LabelValorEsperado.setText("");
    }//GEN-LAST:event_ButtonClearMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ButtonClear;
    private javax.swing.JLabel ButtonClose;
    private javax.swing.JLabel ButtonFind;
    private javax.swing.JLabel ButtonOk;
    private javax.swing.JButton ButtonTreinarRede;
    private javax.swing.JComboBox ComboBoxAnoPrevisao;
    private javax.swing.JComboBox ComboBoxMes;
    private javax.swing.JLabel LabelAnoPrevisao;
    private javax.swing.JLabel LabelErroRede;
    private javax.swing.JLabel LabelMes;
    private javax.swing.JLabel LabelPrevisaoMensal;
    private javax.swing.JLabel LabelTreinarRede;
    private javax.swing.JLabel LabelValorEsperado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}