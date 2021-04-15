package shdv_files7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Form1 extends javax.swing.JFrame {

    public String FileName, DirName; // Имя входного файла с данными и его каталог
    public float mass[][] = new float[5][6]; // Массив для обработки данных

    public Form1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Input = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Out = new javax.swing.JTextArea();
        jButton_Task = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Работа с массивами и файлами");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png")));
        setResizable(false);

        jButton_Input.setText("Загрузить исходные данные из файла");
        jButton_Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InputActionPerformed(evt);
            }
        });

        jTextArea_Out.setEditable(false);
        jTextArea_Out.setColumns(20);
        jTextArea_Out.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextArea_Out.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Out);

        jButton_Task.setText("Сохранить обработанные данные в файл");
        jButton_Task.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TaskActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("<html>\n<p align=\"center\">\nОпределить, имеется ли в таблице\n хотя бы один нулевой элемент.\n Если такой элемент есть, то заменить\n все вещественные значения таблицы единицами\n</p>\n</html>");

        jButton1.setText("Обработать данные");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton_Input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Task, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Input)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Task)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(334, 514));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InputActionPerformed
        // Загрузка исходных данных из файла в массив
        JFileChooser chooser = new JFileChooser(); // Создаем объект выбора файла

        chooser.setCurrentDirectory(new File(".").getAbsoluteFile().getParentFile()); // Устанавливаем текущий каталог

        chooser.setFileFilter(new FileNameExtensionFilter("TXT files", "txt")); // Устанавливаем фильтр
        chooser.setDialogTitle("Выбор файла"); // Устанавливаем значение диалогу
        chooser.setAcceptAllFileFilterUsed(false); // Выключаем значение "все файлы" в фильтре

        int ret = chooser.showDialog(null, "Выбрать"); // Вызываем диалог
        if (ret != JFileChooser.APPROVE_OPTION) {
            return;
        } // Если файл не выбран, то выход

        FileName = chooser.getSelectedFile().getPath(); // Получение имени файла
        DirName = chooser.getSelectedFile().getParent() + System.getProperty("file.separator"); // Получение каталога файла

        try {
            Scanner fIN = new Scanner(new FileInputStream(FileName));
            // Читаем с файла данные
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    mass[i][j] = fIN.nextFloat();
                }
            }
            
            // Вывод считанного массива
            jTextArea_Out.setText("Исходный массив:\n");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    jTextArea_Out.append(String.format("%.1f", mass[i][j]));
                    jTextArea_Out.append("\t");
                } jTextArea_Out.append("\n");
            }
            
        } catch (Exception ex) {
            jTextArea_Out.setText("Error read file!");
        }
    }//GEN-LAST:event_jButton_InputActionPerformed

    private void jButton_TaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TaskActionPerformed
        // Запись обработанного массива в выходной файл
        try {
            PrintWriter fOUT = new PrintWriter(new OutputStreamWriter(new FileOutputStream(DirName + "Numbers.txt")));

            // Вывод результирующего массива в файл
            for (int i = 0; i < 5; i++) { fOUT.println("");
                for (int j = 0; j < 6; j++) {
                    fOUT.print(String.format("%.1f", mass[i][j]));
                    jTextArea_Out.append("\t");
                }
            }

            // Сохранение и закрытие файла
            fOUT.flush(); fOUT.close();

            // Вывод результирующего массива на экран
            jTextArea_Out.append("\nНовый массив:\n");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    jTextArea_Out.append(String.format("%.1f", mass[i][j]));
                    jTextArea_Out.append("\t");
                } jTextArea_Out.append("\n");
            }
            
        } catch (Exception ex) {
            jTextArea_Out.setText("Error read file!");
        }
    }//GEN-LAST:event_jButton_TaskActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Обработка данных
        
        boolean key = false;
         for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                if(mass[i][j]==0){
                    key = true;
                    System.out.println("0 элемент есть");
                   
                }}}
         if (key==true) {
             for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    if (mass[i][j] % 1 != 0){//определяют дробное
                        mass[i][j]=(float) 1.0;
                    }
                }
            }
         }
//      
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Input;
    private javax.swing.JButton jButton_Task;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_Out;
    // End of variables declaration//GEN-END:variables
}
