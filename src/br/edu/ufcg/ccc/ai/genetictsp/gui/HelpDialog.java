/*
 * DialogoAjuda.java
 *
 * Created on 29 de Outubro de 2006, 13:18
 */

package br.edu.ufcg.ccc.ai.genetictsp.gui;

/**
 *
 * @author Gustavo de Farias
 * @author Diego Renato
 * @author Helder Fernando
 */
public class HelpDialog extends javax.swing.JDialog {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Creates new form DialogoAjuda */
    public HelpDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(parent);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoOK = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        painelTexto = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("br/edu/ufcg/ccc/ai/genetictsp/gui/resources/local_help"); // NOI18N
        setTitle(bundle.getString("HD_window_title")); // NOI18N
        setModal(true);
        setResizable(false);

        botaoOK.setText("OK");
        this.getRootPane().setDefaultButton(this.botaoOK);
        botaoOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOKActionPerformed(evt);
            }
        });

        painelTexto.setEditable(false);
        painelTexto.setFont(new java.awt.Font("Monospaced", 0, 13));
        painelTexto.setText(bundle.getString("HD_texto_ajuda")); // NOI18N
        this.painelTexto.setCaretPosition(0);
        scrollPane.setViewportView(painelTexto);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, scrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .add(botaoOK, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(scrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(botaoOK)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoOKActionPerformed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoOK;
    private javax.swing.JTextPane painelTexto;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
    
}
