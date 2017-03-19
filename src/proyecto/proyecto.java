/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;


//import java.util.Timer;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mario
 */
public class proyecto extends javax.swing.JFrame {

    public Parqueo[] sotano1;
    public Parqueo[] sotano2;
    public Parqueo[] sotano3;
    public long tarifa;
    public long fraccion;
    public String archivo;

    /**
     * Creates new form proyecto
     */
    public proyecto() {
        initComponents();

        this.tarifa   = 411; // Centavos (por redondeo)
        this.fraccion = 10;  // Segundos
        this.archivo  = "registro.log";

        // Inicialización de parqueos
        this.sotano1 = new Parqueo[12];
        this.sotano2 = new Parqueo[9];
        this.sotano3 = new Parqueo[11];
        int i;
        for(i=0; i < sotano1.length; i++){
            this.sotano1[i] = new Parqueo(1,i+1,this.fraccion);
        }
        for(i=0; i < sotano2.length; i++){
            this.sotano2[i] = new Parqueo(2,i+1,this.fraccion);
        }
        for(i=0; i < sotano3.length; i++){
            this.sotano3[i] = new Parqueo(3,i+1,this.fraccion);
        }

        // Marcajes iniciales
        this.contarParqueos();
        this.marcarParqueos();
    }

    private void marcarParqueos() {
        this.Parqueo101.setBackground(this.sotano1[0].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo102.setBackground(this.sotano1[1].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo103.setBackground(this.sotano1[2].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo104.setBackground(this.sotano1[3].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo105.setBackground(this.sotano1[4].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo106.setBackground(this.sotano1[5].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo107.setBackground(this.sotano1[6].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo108.setBackground(this.sotano1[7].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo109.setBackground(this.sotano1[8].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo110.setBackground(this.sotano1[9].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo111.setBackground(this.sotano1[10].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo301.setBackground(this.sotano3[0].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo302.setBackground(this.sotano3[1].libre() == 1?Color.GREEN:Color.RED);
    }

    private void contarParqueos () {
        int libre;
        int libres = 0;

        libre = 0;
        for(int i = 0 ; i < this.sotano1.length; i++) {
            libre+= this.sotano1[i].libre();
        }
        libres+=libre;
        lSotano1Libre.setText(Integer.toString(libre));
        lSotano1ocupado.setText(Integer.toString(this.sotano1.length-libre));

        libre = 0;
        for(int i = 0 ; i < this.sotano2.length; i++) {
            libre+= this.sotano2[i].libre();
        }
        libres+=libre;
        lSotano2libre.setText(Integer.toString(libre));
        lSotano2ocupado.setText(Integer.toString(this.sotano2.length-libre));

        libre = 0;
        for(int i = 0 ; i < this.sotano3.length; i++) {
            libre+= this.sotano3[i].libre();
        }
        libres+=libre;
        lSotano3libre.setText(Integer.toString(libre));
        lSotano3ocupado.setText(Integer.toString(this.sotano3.length-libre));

        lTotalLibre.setText(Integer.toString(libres));
        lTotalOcupado.setText(Integer.toString(this.sotano1.length+this.sotano2.length+this.sotano3.length-libres));
    }

    private Parqueo accionParqueo(Parqueo parqueo){
        if( parqueo.libre() == 1){
            if(JOptionPane.showConfirmDialog (null,"¿Desea asignar este parqueo?",null,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                parqueo.marcarEntrada();
            }
        } else {
            if(JOptionPane.showConfirmDialog (null,"¿Desea pagar este parqueo?",null,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                parqueo.marcarSalida();
                long tiempo = parqueo.calcularTiempo();
                String texto = "Paraqueo El Descanso\n\n";
                texto+="Hora de entrada: " + parqueo.getStingEntrada()+"\n";
                texto+="Hora de salida:  " + parqueo.getStingSalida()+"\n";
                texto+="Tiempo total:    " + parqueo.getStringTiempo(tiempo)+"\n";
                texto+="Total a cancelar: Q "+ String.format("%.2f",parqueo.calcularCobro(this.tarifa)/100) +"\n";
                parqueo.escribirArchivo(this.archivo,this.tarifa);
                parqueo.limpiar();
                tTicketText.setText(texto);
                dTicket.setModal(true);
                dTicket.setVisible(true);
            }
        }
        return parqueo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fSotano1 = new javax.swing.JFrame();
        lSotano1titulo = new javax.swing.JLabel();
        Parqueo101 = new javax.swing.JButton();
        Parqueo102 = new javax.swing.JButton();
        Parqueo103 = new javax.swing.JButton();
        Parqueo104 = new javax.swing.JButton();
        Parqueo105 = new javax.swing.JButton();
        Parqueo107 = new javax.swing.JButton();
        Parqueo106 = new javax.swing.JButton();
        Parqueo108 = new javax.swing.JButton();
        Parqueo109 = new javax.swing.JButton();
        Parqueo110 = new javax.swing.JButton();
        bSotano1Regresar = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        Parqueo111 = new javax.swing.JButton();
        fSotano2 = new javax.swing.JFrame();
        lSotano2titulo = new javax.swing.JLabel();
        Parqueo201 = new javax.swing.JButton();
        Parqueo206 = new javax.swing.JButton();
        Parqueo207 = new javax.swing.JButton();
        Parqueo202 = new javax.swing.JButton();
        Parqueo208 = new javax.swing.JButton();
        Parqueo203 = new javax.swing.JButton();
        Parqueo204 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        Parqueo209 = new javax.swing.JButton();
        Parqueo205 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        bSotano2regresar = new javax.swing.JButton();
        fSotano3 = new javax.swing.JFrame();
        lSotano3titulo = new javax.swing.JLabel();
        Parqueo301 = new javax.swing.JButton();
        Parqueo303 = new javax.swing.JButton();
        Parqueo305 = new javax.swing.JButton();
        Parqueo307 = new javax.swing.JButton();
        Parqueo309 = new javax.swing.JButton();
        Parqueo311 = new javax.swing.JButton();
        Parqueo302 = new javax.swing.JButton();
        Parqueo304 = new javax.swing.JButton();
        Parqueo306 = new javax.swing.JButton();
        Parqueo308 = new javax.swing.JButton();
        Parqueo310 = new javax.swing.JButton();
        Parqueo312 = new javax.swing.JButton();
        Parqueo314 = new javax.swing.JButton();
        bSotano3regresar = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        dTicket = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTicketText = new javax.swing.JTextArea();
        bCerrarTicket = new javax.swing.JButton();
        fStats = new javax.swing.JFrame();
        fStatsRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        statText1 = new javax.swing.JTextField();
        statText2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bSotano1ir = new javax.swing.JButton();
        bSotano2ir = new javax.swing.JButton();
        bSotano3ir = new javax.swing.JButton();
        lSotano1Libre = new javax.swing.JLabel();
        lSotano1ocupado = new javax.swing.JLabel();
        lSotano2libre = new javax.swing.JLabel();
        lSotano2ocupado = new javax.swing.JLabel();
        lSotano3libre = new javax.swing.JLabel();
        lSotano3ocupado = new javax.swing.JLabel();
        lTotalLibre = new javax.swing.JLabel();
        lTotalOcupado = new javax.swing.JLabel();
        bStats = new javax.swing.JButton();

        lSotano1titulo.setText("Sotano 1");

        Parqueo101.setText("01");
        Parqueo101.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo101MouseClicked(evt);
            }
        });

        Parqueo102.setText("02");
        Parqueo102.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo102MouseClicked(evt);
            }
        });

        Parqueo103.setText("03");
        Parqueo103.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo103MouseClicked(evt);
            }
        });

        Parqueo104.setText("04");
        Parqueo104.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo104MouseClicked(evt);
            }
        });

        Parqueo105.setText("05");
        Parqueo105.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo105MouseClicked(evt);
            }
        });

        Parqueo107.setText("07");
        Parqueo107.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo107MouseClicked(evt);
            }
        });

        Parqueo106.setText("06");
        Parqueo106.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo106MouseClicked(evt);
            }
        });

        Parqueo108.setText("08");
        Parqueo108.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo108MouseClicked(evt);
            }
        });

        Parqueo109.setText("09");
        Parqueo109.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo109MouseClicked(evt);
            }
        });

        Parqueo110.setText("10");
        Parqueo110.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo110MouseClicked(evt);
            }
        });

        bSotano1Regresar.setText("Regresar");
        bSotano1Regresar.setPreferredSize(new java.awt.Dimension(100, 100));
        bSotano1Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSotano1RegresarActionPerformed(evt);
            }
        });

        jButton16.setText("Regresar");
        jButton16.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        Parqueo111.setText("11");
        Parqueo111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo111MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fSotano1Layout = new javax.swing.GroupLayout(fSotano1.getContentPane());
        fSotano1.getContentPane().setLayout(fSotano1Layout);
        fSotano1Layout.setHorizontalGroup(
            fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano1Layout.createSequentialGroup()
                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fSotano1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lSotano1titulo))
                    .addGroup(fSotano1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fSotano1Layout.createSequentialGroup()
                                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Parqueo106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Parqueo101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Parqueo102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Parqueo107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fSotano1Layout.createSequentialGroup()
                                .addComponent(bSotano1Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fSotano1Layout.createSequentialGroup()
                                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Parqueo108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Parqueo103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Parqueo104, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Parqueo109, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Parqueo105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(fSotano1Layout.createSequentialGroup()
                                        .addComponent(Parqueo110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                        .addComponent(Parqueo111))))
                            .addGroup(fSotano1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(23, 23, 23))
        );
        fSotano1Layout.setVerticalGroup(
            fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSotano1titulo)
                .addGap(61, 61, 61)
                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Parqueo101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Parqueo109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo111, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSotano1Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        fSotano2.setSize(new java.awt.Dimension(800, 500));

        lSotano2titulo.setText("Sotano 2");

        Parqueo201.setText("01");

        Parqueo206.setText("06");

        Parqueo207.setText("07");

        Parqueo202.setText("02");

        Parqueo208.setText("08");

        Parqueo203.setText("03");

        Parqueo204.setText("04");

        jButton21.setText("jButton1");

        Parqueo209.setText("09");

        Parqueo205.setText("05");

        jButton24.setText("Regresar");

        bSotano2regresar.setText("Regresar");

        javax.swing.GroupLayout fSotano2Layout = new javax.swing.GroupLayout(fSotano2.getContentPane());
        fSotano2.getContentPane().setLayout(fSotano2Layout);
        fSotano2Layout.setHorizontalGroup(
            fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSotano2titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(fSotano2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSotano2regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fSotano2Layout.createSequentialGroup()
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Parqueo206, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo201, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Parqueo207, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo202, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Parqueo208, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo203, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fSotano2Layout.createSequentialGroup()
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(fSotano2Layout.createSequentialGroup()
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Parqueo209, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fSotano2Layout.createSequentialGroup()
                                .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Parqueo204, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(Parqueo205, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(13, Short.MAX_VALUE))))
        );
        fSotano2Layout.setVerticalGroup(
            fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSotano2titulo)
                .addGap(31, 31, 31)
                .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fSotano2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(Parqueo206, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fSotano2Layout.createSequentialGroup()
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Parqueo202, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo201, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Parqueo207, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo208, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo209, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Parqueo204, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Parqueo203, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Parqueo205, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSotano2regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        fSotano3.setSize(new java.awt.Dimension(800, 500));

        lSotano3titulo.setText("Sotano 3");

        Parqueo301.setText("01");
        Parqueo301.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo301MouseClicked(evt);
            }
        });
        Parqueo301.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Parqueo301ActionPerformed(evt);
            }
        });

        Parqueo303.setText("Parqueo302");
        Parqueo303.setToolTipText("");

        Parqueo305.setText("jButton14");

        Parqueo307.setText("jButton17");

        Parqueo309.setText("jButton18");

        Parqueo311.setText("jButton19");

        Parqueo302.setText("jButton14");

        Parqueo304.setText("jButton17");

        Parqueo306.setText("jButton18");

        Parqueo308.setText("jButton19");

        Parqueo310.setText("jButton20");

        Parqueo312.setText("jButton21");

        Parqueo314.setText("jButton22");

        bSotano3regresar.setText("Regresar");
        bSotano3regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSotano3regresarMouseClicked(evt);
            }
        });

        jButton17.setText("jButton17");

        javax.swing.GroupLayout fSotano3Layout = new javax.swing.GroupLayout(fSotano3.getContentPane());
        fSotano3.getContentPane().setLayout(fSotano3Layout);
        fSotano3Layout.setHorizontalGroup(
            fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSotano3titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fSotano3Layout.createSequentialGroup()
                .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fSotano3Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(Parqueo301, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(Parqueo303, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(Parqueo305, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(Parqueo307, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Parqueo309, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(Parqueo311, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fSotano3Layout.createSequentialGroup()
                        .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fSotano3Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(bSotano3regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(fSotano3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Parqueo302, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(Parqueo304, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(Parqueo306, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(Parqueo308, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(Parqueo310, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addComponent(Parqueo312, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Parqueo314, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        fSotano3Layout.setVerticalGroup(
            fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSotano3titulo)
                .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fSotano3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Parqueo303, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo305, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo307, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo309, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo311, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo301, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Parqueo314, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo310, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo312, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo308, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo306, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo304, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo302, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 104, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fSotano3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bSotano3regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        dTicket.setMinimumSize(new java.awt.Dimension(400, 300));
        dTicket.setResizable(false);
        dTicket.setSize(new java.awt.Dimension(400, 300));

        tTicketText.setColumns(20);
        tTicketText.setRows(5);
        jScrollPane2.setViewportView(tTicketText);

        bCerrarTicket.setText("Cerrar");
        bCerrarTicket.setMaximumSize(new java.awt.Dimension(100, 25));
        bCerrarTicket.setMinimumSize(new java.awt.Dimension(100, 25));
        bCerrarTicket.setPreferredSize(new java.awt.Dimension(100, 25));
        bCerrarTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCerrarTicketMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dTicketLayout = new javax.swing.GroupLayout(dTicket.getContentPane());
        dTicket.getContentPane().setLayout(dTicketLayout);
        dTicketLayout.setHorizontalGroup(
            dTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(dTicketLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(bCerrarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        dTicketLayout.setVerticalGroup(
            dTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCerrarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fStats.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        fStats.setMinimumSize(new java.awt.Dimension(425, 400));
        fStats.setResizable(false);
        fStats.setSize(new java.awt.Dimension(425, 400));

        fStatsRegresar.setText("Regresar");
        fStatsRegresar.setMaximumSize(new java.awt.Dimension(100, 25));
        fStatsRegresar.setMinimumSize(new java.awt.Dimension(100, 25));
        fStatsRegresar.setPreferredSize(new java.awt.Dimension(100, 25));
        fStatsRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fStatsRegresarMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "Usuarios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Horas de mas vehiculos");

        statText1.setEditable(false);

        statText2.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Estadísticas");

        javax.swing.GroupLayout fStatsLayout = new javax.swing.GroupLayout(fStats.getContentPane());
        fStats.getContentPane().setLayout(fStatsLayout);
        fStatsLayout.setHorizontalGroup(
            fStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fStatsLayout.createSequentialGroup()
                .addGroup(fStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fStatsLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(fStatsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statText1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statText2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(fStatsRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        fStatsLayout.setVerticalGroup(
            fStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fStatsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(fStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(statText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fStatsRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bSotano1ir.setToolTipText("");
        bSotano1ir.setLabel("Sotano 1");
        bSotano1ir.setMaximumSize(new java.awt.Dimension(100, 25));
        bSotano1ir.setMinimumSize(new java.awt.Dimension(100, 25));
        bSotano1ir.setPreferredSize(new java.awt.Dimension(100, 25));
        bSotano1ir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSotano1irMouseClicked(evt);
            }
        });

        bSotano2ir.setLabel("Sotano 2");
        bSotano2ir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSotano2irMouseClicked(evt);
            }
        });

        bSotano3ir.setLabel("Sotano 3");
        bSotano3ir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSotano3irMouseClicked(evt);
            }
        });

        lSotano1Libre.setBackground(new java.awt.Color(0, 255, 0));
        lSotano1Libre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano1Libre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano1Libre.setText("0");
        lSotano1Libre.setToolTipText("");
        lSotano1Libre.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano1Libre.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano1Libre.setName(""); // NOI18N
        lSotano1Libre.setOpaque(true);
        lSotano1Libre.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano1ocupado.setBackground(new java.awt.Color(255, 0, 0));
        lSotano1ocupado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano1ocupado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano1ocupado.setText("0");
        lSotano1ocupado.setToolTipText("");
        lSotano1ocupado.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano1ocupado.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano1ocupado.setName(""); // NOI18N
        lSotano1ocupado.setOpaque(true);
        lSotano1ocupado.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano2libre.setBackground(new java.awt.Color(0, 255, 0));
        lSotano2libre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano2libre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano2libre.setText("0");
        lSotano2libre.setToolTipText("");
        lSotano2libre.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano2libre.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano2libre.setName(""); // NOI18N
        lSotano2libre.setOpaque(true);
        lSotano2libre.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano2ocupado.setBackground(new java.awt.Color(255, 0, 0));
        lSotano2ocupado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano2ocupado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano2ocupado.setText("0");
        lSotano2ocupado.setToolTipText("");
        lSotano2ocupado.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano2ocupado.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano2ocupado.setName(""); // NOI18N
        lSotano2ocupado.setOpaque(true);
        lSotano2ocupado.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano3libre.setBackground(new java.awt.Color(0, 255, 0));
        lSotano3libre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano3libre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano3libre.setText("0");
        lSotano3libre.setToolTipText("");
        lSotano3libre.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano3libre.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano3libre.setName(""); // NOI18N
        lSotano3libre.setOpaque(true);
        lSotano3libre.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano3ocupado.setBackground(new java.awt.Color(255, 0, 0));
        lSotano3ocupado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano3ocupado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano3ocupado.setText("0");
        lSotano3ocupado.setToolTipText("");
        lSotano3ocupado.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano3ocupado.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano3ocupado.setName(""); // NOI18N
        lSotano3ocupado.setOpaque(true);
        lSotano3ocupado.setPreferredSize(new java.awt.Dimension(25, 17));

        lTotalLibre.setBackground(new java.awt.Color(0, 255, 0));
        lTotalLibre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lTotalLibre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTotalLibre.setText("0");
        lTotalLibre.setToolTipText("");
        lTotalLibre.setMaximumSize(new java.awt.Dimension(25, 17));
        lTotalLibre.setMinimumSize(new java.awt.Dimension(25, 17));
        lTotalLibre.setName(""); // NOI18N
        lTotalLibre.setOpaque(true);
        lTotalLibre.setPreferredSize(new java.awt.Dimension(25, 17));

        lTotalOcupado.setBackground(new java.awt.Color(255, 0, 0));
        lTotalOcupado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lTotalOcupado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTotalOcupado.setText("0");
        lTotalOcupado.setToolTipText("");
        lTotalOcupado.setMaximumSize(new java.awt.Dimension(25, 17));
        lTotalOcupado.setMinimumSize(new java.awt.Dimension(25, 17));
        lTotalOcupado.setName(""); // NOI18N
        lTotalOcupado.setOpaque(true);
        lTotalOcupado.setPreferredSize(new java.awt.Dimension(25, 17));

        bStats.setLabel("Stats");
        bStats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bStatsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bStats, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bSotano1ir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bSotano2ir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bSotano3ir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lTotalLibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lTotalOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lSotano3libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lSotano3ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lSotano2libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lSotano2ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lSotano1Libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lSotano1ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSotano1ir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSotano1Libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSotano1ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSotano2ir)
                    .addComponent(lSotano2libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSotano2ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSotano3ir)
                    .addComponent(lSotano3libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSotano3ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTotalLibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTotalOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        bStats.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Parqueo301MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo301MouseClicked
        this.sotano3[0] = this.accionParqueo(this.sotano3[0]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo301MouseClicked

    private void bSotano1irMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSotano1irMouseClicked
        this.setVisible(false);
        fSotano1.setVisible(true);
    }//GEN-LAST:event_bSotano1irMouseClicked

    private void bSotano2irMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSotano2irMouseClicked
        this.setVisible(false);
        fSotano2.setVisible(true);
    }//GEN-LAST:event_bSotano2irMouseClicked

    private void bSotano3irMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSotano3irMouseClicked
        this.setVisible(false);
        fSotano3.setVisible(true);
    }//GEN-LAST:event_bSotano3irMouseClicked

    private void bSotano3regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSotano3regresarMouseClicked
        fSotano3.setVisible(false);
        this.setVisible(true);
        this.contarParqueos();
    }//GEN-LAST:event_bSotano3regresarMouseClicked

    private void bCerrarTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCerrarTicketMouseClicked
        dTicket.setModal(false);
        dTicket.setVisible(false);
    }//GEN-LAST:event_bCerrarTicketMouseClicked

    private void bSotano1RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSotano1RegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bSotano1RegresarActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void bStatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bStatsMouseClicked
        stats estadisticas = new stats();
        String[] registro = new String[6];
        String linea;

        try{
            BufferedReader br = new BufferedReader(new FileReader(this.archivo));
            while ( (linea = br.readLine() ) != null) {
                registro = linea.split("\\|");
                estadisticas.procesarRegistro(Long.parseLong(registro[2]));
            }
            br.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se puede encontrar el archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se puede leer el archivo");
        }

        estadisticas.ordenarFechas();
        estadisticas.horasMaximas();

        for(int i = 0; i < estadisticas.registros; i++){
            jTable1.setValueAt(estadisticas.fechas[i], i, 0);
            jTable1.setValueAt(estadisticas.autos[i],  i, 1);
        }
        statText1.setText(String.valueOf(estadisticas.maxHoras[0]));
        statText2.setText(String.valueOf(estadisticas.maxHoras[1]));

/*
        for(int i = 0; i < 24; i++){
            jTable1.setValueAt(i, i, 0);
            jTable1.setValueAt(String.valueOf(estadisticas.horas[i]), i, 1);
        }
//*/

        this.setVisible(false);
        fStats.setVisible(true);
    }//GEN-LAST:event_bStatsMouseClicked

    private void fStatsRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fStatsRegresarMouseClicked
        for(int i = 0;i < jTable1.getRowCount();i++){
            jTable1.setValueAt("", i, 0);
            jTable1.setValueAt("", i, 1);
        }
        statText1.setText("");
        statText2.setText("");

        fStats.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_fStatsRegresarMouseClicked

    private void Parqueo301ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Parqueo301ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Parqueo301ActionPerformed

    private void Parqueo101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo101MouseClicked
        this.sotano1[0] = this.accionParqueo(this.sotano1[0]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo101MouseClicked

    private void Parqueo102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo102MouseClicked
        this.sotano1[1] = this.accionParqueo(this.sotano1[1]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo102MouseClicked

    private void Parqueo103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo103MouseClicked
        this.sotano1[2] = this.accionParqueo(this.sotano1[2]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo103MouseClicked

    private void Parqueo104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo104MouseClicked
        this.sotano1[3] = this.accionParqueo(this.sotano1[3]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo104MouseClicked

    private void Parqueo105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo105MouseClicked
        this.sotano1[4] = this.accionParqueo(this.sotano1[4]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo105MouseClicked

    private void Parqueo106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo106MouseClicked
        this.sotano1[5] = this.accionParqueo(this.sotano1[5]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo106MouseClicked

    private void Parqueo107MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo107MouseClicked
        this.sotano1[6] = this.accionParqueo(this.sotano1[6]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo107MouseClicked

    private void Parqueo108MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo108MouseClicked
        this.sotano1[7] = this.accionParqueo(this.sotano1[7]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo108MouseClicked

    private void Parqueo109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo109MouseClicked
        this.sotano1[8] = this.accionParqueo(this.sotano1[8]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo109MouseClicked

    private void Parqueo110MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo110MouseClicked
        this.sotano1[9] = this.accionParqueo(this.sotano1[9]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo110MouseClicked

    private void Parqueo111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo111MouseClicked
        this.sotano1[10] = this.accionParqueo(this.sotano1[10]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo111MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new proyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Parqueo101;
    private javax.swing.JButton Parqueo102;
    private javax.swing.JButton Parqueo103;
    private javax.swing.JButton Parqueo104;
    private javax.swing.JButton Parqueo105;
    private javax.swing.JButton Parqueo106;
    private javax.swing.JButton Parqueo107;
    private javax.swing.JButton Parqueo108;
    private javax.swing.JButton Parqueo109;
    private javax.swing.JButton Parqueo110;
    private javax.swing.JButton Parqueo111;
    private javax.swing.JButton Parqueo201;
    private javax.swing.JButton Parqueo202;
    private javax.swing.JButton Parqueo203;
    private javax.swing.JButton Parqueo204;
    private javax.swing.JButton Parqueo205;
    private javax.swing.JButton Parqueo206;
    private javax.swing.JButton Parqueo207;
    private javax.swing.JButton Parqueo208;
    private javax.swing.JButton Parqueo209;
    private javax.swing.JButton Parqueo301;
    private javax.swing.JButton Parqueo302;
    private javax.swing.JButton Parqueo303;
    private javax.swing.JButton Parqueo304;
    private javax.swing.JButton Parqueo305;
    private javax.swing.JButton Parqueo306;
    private javax.swing.JButton Parqueo307;
    private javax.swing.JButton Parqueo308;
    private javax.swing.JButton Parqueo309;
    private javax.swing.JButton Parqueo310;
    private javax.swing.JButton Parqueo311;
    private javax.swing.JButton Parqueo312;
    private javax.swing.JButton Parqueo314;
    private javax.swing.JButton bCerrarTicket;
    private javax.swing.JButton bSotano1Regresar;
    private javax.swing.JButton bSotano1ir;
    private javax.swing.JButton bSotano2ir;
    private javax.swing.JButton bSotano2regresar;
    private javax.swing.JButton bSotano3ir;
    private javax.swing.JButton bSotano3regresar;
    private javax.swing.JButton bStats;
    private javax.swing.JDialog dTicket;
    private javax.swing.JFrame fSotano1;
    private javax.swing.JFrame fSotano2;
    private javax.swing.JFrame fSotano3;
    private javax.swing.JFrame fStats;
    private javax.swing.JButton fStatsRegresar;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton24;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lSotano1Libre;
    private javax.swing.JLabel lSotano1ocupado;
    private javax.swing.JLabel lSotano1titulo;
    private javax.swing.JLabel lSotano2libre;
    private javax.swing.JLabel lSotano2ocupado;
    private javax.swing.JLabel lSotano2titulo;
    private javax.swing.JLabel lSotano3libre;
    private javax.swing.JLabel lSotano3ocupado;
    private javax.swing.JLabel lSotano3titulo;
    private javax.swing.JLabel lTotalLibre;
    private javax.swing.JLabel lTotalOcupado;
    private javax.swing.JTextField statText1;
    private javax.swing.JTextField statText2;
    private javax.swing.JTextArea tTicketText;
    // End of variables declaration//GEN-END:variables
}
