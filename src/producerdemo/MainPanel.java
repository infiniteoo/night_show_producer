/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerdemo;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Math.abs;
import static java.lang.Math.abs;

import static java.lang.Math.abs;
import static java.lang.StrictMath.abs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
//import static jdk.nashorn.internal.runtime.Context.DEBUG;
import static jdk.nashorn.internal.runtime.Context.DEBUG;

//import static nightshowproducer.NightShowProducer.combineThisCollection;
import org.apache.commons.io.FileUtils;
import static org.tritonus.share.TDebug.out;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author troy
 */
public class MainPanel extends javax.swing.JPanel {

    Object[] colHeaders = {"Index", "Artist", "Title", "Intro", "Outro", "Total", "File Name", "Segment"};
    DefaultTableModel tableModel = new DefaultTableModel(colHeaders, 0);
    AePlayWave aw;
    ArrayList<LogElement> songList;
    DefaultListModel listModel = new DefaultListModel();
    boolean noMusicBed;

    // this is the default popcruch nights clock, and to initialize the clock array
    // we load its clock by default.  we change it later by selecting various radio buttons
    String[][][] clock = {
        {
            {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song"},
            {"Song"}
        },
        {
            {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song"},
            {"Song"}
        },
        {
            {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song"},
            {"Song"}
        },
        {
            {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song"},
            {"Song"}
        },
        {
            {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
            {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
            {"Song"},
            {"Song"}
        },};

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {

        initComponents();

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(125);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);

        jTable1.getColumnModel().getColumn(5).setPreferredWidth(25);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {

                // do some actions here, for example
                // print first column value from selected row
                selectedItemArtistLabel.setEnabled(true);
                selectedItemTitleLabel.setEnabled(true);
                selectedItemIntroLabel.setEnabled(true);
                selectedItemOutroLabel.setEnabled(true);
                selectedItemFileLabel.setEnabled(true);
                selectedItemTotalLabel.setEnabled(true);
                selectedItemPlayButton.setEnabled(true);
                selectedItemStopButton.setEnabled(true);

                selectedItemArtistLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                selectedItemTitleLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                selectedItemIntroLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                selectedItemOutroLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
                selectedItemTotalLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
                selectedItemFileLabel.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        clockRadioButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        musicLibraryLocationTextField = new javax.swing.JTextField();
        musicLibraryDataFileLocation = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        voAudioLocationLabel = new javax.swing.JLabel();
        voAudioTextField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        openLogButton = new javax.swing.JButton();
        openMusicLogLabel = new javax.swing.JLabel();
        wholeShowRadioButton = new javax.swing.JRadioButton();
        singleSegmentRadioButton = new javax.swing.JRadioButton();
        wholeOrSingleLabel = new javax.swing.JLabel();
        singleSegmentHRInputLabel = new javax.swing.JLabel();
        singleSegmentSEGInputLabel = new javax.swing.JLabel();
        singleSegmentHRInputTextField = new javax.swing.JTextField();
        singleSegmentSEGInputTextField = new javax.swing.JTextField();
        prepareAudioAssetsButton = new javax.swing.JButton();
        beginMixButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selectedItemPlayButton = new javax.swing.JButton();
        selectedItemArtistLabel = new javax.swing.JLabel();
        selectedItemTitleLabel = new javax.swing.JLabel();
        selectedItemIntroLabel = new javax.swing.JLabel();
        selectedItemOutroLabel = new javax.swing.JLabel();
        selectedItemFileLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selectedItemTotalLabel = new javax.swing.JLabel();
        selectedItemStopButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        pcnCHRRadioButton = new javax.swing.JRadioButton();
        pcnSamAdamsRadioButton = new javax.swing.JRadioButton();
        tocnRadioButton = new javax.swing.JRadioButton();
        lwnRadioButton = new javax.swing.JRadioButton();
        ucrRadioButton = new javax.swing.JRadioButton();
        pcnTop20RadioButton = new javax.swing.JRadioButton();
        xxlRadioButton = new javax.swing.JRadioButton();
        noMusicBedCheckBox = new javax.swing.JCheckBox();
        playCompletedSoundEffectCheckBox = new javax.swing.JCheckBox();
        autoMixCheckBox = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        noMusicBedList = new javax.swing.JList<>();
        noMusicBedHourTextBox = new javax.swing.JTextField();
        noMusicBedSegmentTextBox = new javax.swing.JTextField();
        noMusicBedHourLabel = new javax.swing.JLabel();
        noMusicBedSegLabel = new javax.swing.JLabel();
        noMusicBedAddButton = new javax.swing.JButton();
        noMusicBedDisplayLabel = new javax.swing.JLabel();
        openCommercialLogButton = new javax.swing.JButton();
        commercialLogLabel = new javax.swing.JLabel();

        clockRadioButtonGroup.add(ucrRadioButton);
        clockRadioButtonGroup.add(xxlRadioButton);
        clockRadioButtonGroup.add(pcnCHRRadioButton);
        clockRadioButtonGroup.add(pcnSamAdamsRadioButton);
        clockRadioButtonGroup.add(tocnRadioButton);
        clockRadioButtonGroup.add(lwnRadioButton);
        clockRadioButtonGroup.add(pcnTop20RadioButton);

        jLabel1.setText("Night Show Producer");

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        tabbedPane.addTab("Log", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        tabbedPane.addTab("Library", jScrollPane2);

        jLabel6.setText("Music Library Folder Location:");

        musicLibraryLocationTextField.setText("D:\\\\amazon drive\\\\pcn\\\\library\\\\");
            musicLibraryLocationTextField.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    musicLibraryLocationTextFieldActionPerformed(evt);
                }
            });

            musicLibraryDataFileLocation.setText("D:\\\\amazon drive\\\\pcn\\\\pcn library.txt");
            musicLibraryDataFileLocation.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    musicLibraryDataFileLocationActionPerformed(evt);
                }
            });

            jLabel10.setText("Music Database File Location:");

            voAudioLocationLabel.setText("Voice Over Audio Location:");

            voAudioTextField.setText("D:\\\\amazon drive\\\\pcn\\\\vo\\\\");
                voAudioTextField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        voAudioTextFieldActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(voAudioLocationLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(voAudioTextField)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(musicLibraryLocationTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(musicLibraryDataFileLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                        .addGap(382, 382, 382))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(musicLibraryLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(musicLibraryDataFileLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(voAudioLocationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(voAudioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(409, Short.MAX_VALUE))
                );

                tabbedPane.addTab("Options", jPanel1);

                log.setColumns(20);
                log.setRows(5);
                jScrollPane4.setViewportView(log);

                openLogButton.setText("Open File");
                openLogButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        openLogButtonActionPerformed(evt);
                    }
                });

                openMusicLogLabel.setText("Music Log");

                wholeShowRadioButton.setSelected(true);
                wholeShowRadioButton.setText("Whole Show");
                wholeShowRadioButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        wholeShowRadioButtonActionPerformed(evt);
                    }
                });

                singleSegmentRadioButton.setText("Single Segment");
                singleSegmentRadioButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        singleSegmentRadioButtonActionPerformed(evt);
                    }
                });

                wholeOrSingleLabel.setText("Select One");

                singleSegmentHRInputLabel.setText("HR");
                singleSegmentHRInputLabel.setEnabled(false);

                singleSegmentSEGInputLabel.setText("SEG");
                singleSegmentSEGInputLabel.setEnabled(false);

                singleSegmentHRInputTextField.setEnabled(false);

                singleSegmentSEGInputTextField.setEnabled(false);
                singleSegmentSEGInputTextField.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        singleSegmentSEGInputTextFieldActionPerformed(evt);
                    }
                });

                prepareAudioAssetsButton.setText("Prepare");
                prepareAudioAssetsButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        prepareAudioAssetsButtonActionPerformed(evt);
                    }
                });

                beginMixButton.setText("Begin Mix");
                beginMixButton.setDoubleBuffered(true);
                beginMixButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        beginMixButtonActionPerformed(evt);
                    }
                });

                jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
                jLabel7.setText("Selected Item");

                jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                jLabel8.setText("Artist");

                jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                jLabel9.setText("Title");

                jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                jLabel2.setText("Intro");

                jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                jLabel3.setText("Outro");

                jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                jLabel4.setText("File Name");

                selectedItemPlayButton.setText("Play");
                selectedItemPlayButton.setEnabled(false);
                selectedItemPlayButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        selectedItemPlayButtonActionPerformed(evt);
                    }
                });

                selectedItemArtistLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
                selectedItemArtistLabel.setText("(empty)");
                selectedItemArtistLabel.setEnabled(false);

                selectedItemTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
                selectedItemTitleLabel.setText("(empty)");
                selectedItemTitleLabel.setEnabled(false);

                selectedItemIntroLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
                selectedItemIntroLabel.setText("(empty)");
                selectedItemIntroLabel.setEnabled(false);

                selectedItemOutroLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
                selectedItemOutroLabel.setText("(empty)");
                selectedItemOutroLabel.setEnabled(false);

                selectedItemFileLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
                selectedItemFileLabel.setText("(empty)");
                selectedItemFileLabel.setEnabled(false);

                jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                jLabel5.setText("Total");

                selectedItemTotalLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
                selectedItemTotalLabel.setText("(empty)");
                selectedItemTotalLabel.setEnabled(false);

                selectedItemStopButton.setText("Stop");
                selectedItemStopButton.setEnabled(false);
                selectedItemStopButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        selectedItemStopButtonActionPerformed(evt);
                    }
                });

                jLabel11.setText("Clock:");

                pcnCHRRadioButton.setSelected(true);
                pcnCHRRadioButton.setText("PopCrush Nights (CHR)");
                pcnCHRRadioButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        pcnCHRRadioButtonActionPerformed(evt);
                    }
                });

                pcnSamAdamsRadioButton.setText("PopCrush Nights (Sam Adams)");
                pcnSamAdamsRadioButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        pcnSamAdamsRadioButtonActionPerformed(evt);
                    }
                });

                tocnRadioButton.setText("Taste of Country Nights");
                tocnRadioButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        tocnRadioButtonActionPerformed(evt);
                    }
                });

                lwnRadioButton.setText("Loudwire Nights");
                lwnRadioButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        lwnRadioButtonActionPerformed(evt);
                    }
                });

                ucrRadioButton.setText("Ultimate Classic Rock");
                ucrRadioButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ucrRadioButtonActionPerformed(evt);
                    }
                });

                pcnTop20RadioButton.setText("PopCrush Top 20 Countdown");

                xxlRadioButton.setText("XXL Radio");

                noMusicBedCheckBox.setText("No Music Bed");
                noMusicBedCheckBox.setEnabled(false);

                playCompletedSoundEffectCheckBox.setSelected(true);
                playCompletedSoundEffectCheckBox.setText("Play Completed SFX");

                autoMixCheckBox.setText("Auto Mix");

                noMusicBedList.setModel(listModel);
                jScrollPane3.setViewportView(noMusicBedList);

                noMusicBedHourLabel.setText("Hour #");

                noMusicBedSegLabel.setText("Seg #");

                noMusicBedAddButton.setText("Add");
                noMusicBedAddButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        noMusicBedAddButtonActionPerformed(evt);
                    }
                });

                noMusicBedDisplayLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                noMusicBedDisplayLabel.setText("No Music Bed Exemptions");

                openCommercialLogButton.setText("Open File");
                openCommercialLogButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        openCommercialLogButtonActionPerformed(evt);
                    }
                });

                commercialLogLabel.setText("Commercial Log");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel11)
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pcnCHRRadioButton)
                                            .addComponent(lwnRadioButton)
                                            .addComponent(xxlRadioButton))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pcnSamAdamsRadioButton)
                                            .addComponent(ucrRadioButton))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pcnTop20RadioButton)
                                            .addComponent(tocnRadioButton))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(noMusicBedHourLabel)
                                                    .addComponent(noMusicBedHourTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(noMusicBedAddButton)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(noMusicBedSegmentTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(noMusicBedSegLabel)))
                                            .addComponent(noMusicBedDisplayLabel)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(wholeShowRadioButton)
                                            .addComponent(singleSegmentRadioButton)
                                            .addComponent(wholeOrSingleLabel)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(singleSegmentHRInputLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(singleSegmentHRInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(singleSegmentSEGInputLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(singleSegmentSEGInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(noMusicBedCheckBox)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(openLogButton)
                                                    .addComponent(openMusicLogLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(commercialLogLabel)
                                                    .addComponent(openCommercialLogButton))))))
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(selectedItemArtistLabel)
                                    .addComponent(jLabel2)
                                    .addComponent(selectedItemIntroLabel)
                                    .addComponent(selectedItemTitleLabel)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(selectedItemPlayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(3, 3, 3)
                                            .addComponent(selectedItemStopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(selectedItemOutroLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(selectedItemTotalLabel, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(selectedItemFileLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(beginMixButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(playCompletedSoundEffectCheckBox))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(prepareAudioAssetsButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(autoMixCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel1))
                                .addGap(388, 388, 388)))
                        .addContainerGap())
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(openLogButton)
                                    .addComponent(jLabel7)
                                    .addComponent(openCommercialLogButton))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(openMusicLogLabel)
                                            .addComponent(commercialLogLabel))
                                        .addGap(18, 18, 18)
                                        .addComponent(wholeShowRadioButton)
                                        .addGap(16, 16, 16)
                                        .addComponent(wholeOrSingleLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(singleSegmentRadioButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectedItemArtistLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addGap(4, 4, 4)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(selectedItemTitleLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(4, 4, 4)
                                        .addComponent(selectedItemIntroLabel)
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(selectedItemOutroLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addGap(2, 2, 2)
                                        .addComponent(selectedItemTotalLabel))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(singleSegmentHRInputLabel)
                                            .addComponent(singleSegmentHRInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(singleSegmentSEGInputLabel)
                                            .addComponent(singleSegmentSEGInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(noMusicBedCheckBox)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(noMusicBedHourTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(noMusicBedHourLabel)
                                                    .addComponent(noMusicBedSegLabel)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(noMusicBedAddButton)))
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(noMusicBedDisplayLabel)))
                                    .addComponent(noMusicBedSegmentTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectedItemFileLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(selectedItemPlayButton)
                                    .addComponent(selectedItemStopButton)
                                    .addComponent(jLabel11)
                                    .addComponent(pcnCHRRadioButton)
                                    .addComponent(pcnSamAdamsRadioButton)
                                    .addComponent(tocnRadioButton))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lwnRadioButton)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ucrRadioButton)
                                        .addComponent(pcnTop20RadioButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xxlRadioButton)
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(prepareAudioAssetsButton)
                                    .addComponent(autoMixCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(beginMixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playCompletedSoundEffectCheckBox)
                                .addGap(11, 11, 11))))
                );
            }// </editor-fold>//GEN-END:initComponents

    public ArrayList<LogElement> convertToSongObjects(ArrayList<String> songList) {

        ArrayList<LogElement> songz = new ArrayList<>();
        for (int i = 0; i < songList.size(); i++) {

            String parts[] = songList.get(i).split(",");
            songz.add(new LogElement(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));

        }
        return songz;

    }

    public ArrayList<String> loadMusicDatabase(String fileName) throws FileNotFoundException {

        ArrayList<String> songList = new ArrayList<>();

        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        reader.useDelimiter("~");

        log.append("reading song database...");
        while (reader.hasNext()) {

            songList.add(reader.next());

        }
        log.append(" complete!\n");

        return songList;
    }

    public ArrayList<String> loadMusicLog(String fileName, ArrayList database) throws FileNotFoundException, IOException {

        ArrayList<String> songsPerPage = new ArrayList<>();

        PdfReader reader = new PdfReader(fileName);
        int n = reader.getNumberOfPages();
        log.append("Reading a total of  " + n + " pages from the PDF file: " + fileName);
        String str = null;

        for (int i = 0; i < n; i++) {

            str += PdfTextExtractor.getTextFromPage(reader, i + 1).toUpperCase(); //Extracting the content from a particular page.

        }

        log.append("value of STR: " + str);
        String[] parts = str.split("03:30");
        for (int i = 0; i < parts.length; i++) {
            log.append("");
            log.append(i + "value of parts in STR using 03:30 splitter: " + parts[i]);
            songsPerPage.add(parts[i]);

            log.append("");
        }

        return songsPerPage;

    }

    public static ArrayList<String> createPlaylist(ArrayList<String> database, ArrayList<String> musicLog) {

        ArrayList<String> finalLog = new ArrayList<>();
        int success = 0;

        for (int i = 0; i < musicLog.size(); i++) {

            for (int j = 0; j < database.size(); j++) {
                // log.append("value of database[j]: " + database.get(j));

                String songName = getSongTitle(database.get(j));
                String artistName = getArtistName(database.get(j));

                // log.append("value of musicLog.get(i): " + musicLog.get(i));
////            log.append("value of songName: " + songName);
////            log.append("value of artistName:" + artistName);
                if (musicLog.get(i).contains(songName) && musicLog.get(i).contains(artistName)) {

                    // finalLog.add(musicLog.get(i));
                    finalLog.add(database.get(j).trim().toUpperCase());
                    success++;

                }

            }

        }

        return finalLog;

    }

    public static String getSongTitle(String songInDatabase) {

        String[] parts = songInDatabase.split(",");

        String songTitle = parts[1].toUpperCase().trim();

        // log.append("incoming variable songInDatabase: " + songInDatabase);
        return songTitle;

    }

    public static String getArtistName(String songInDatabase) {

        String[] parts = songInDatabase.split(",");
        String artistName = parts[0].toUpperCase().trim();
        String songName = parts[1].toUpperCase().trim();
        //log.append("artistName value: " + artistName);
        return artistName;

    }
    private void singleSegmentSEGInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleSegmentSEGInputTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singleSegmentSEGInputTextFieldActionPerformed

    private void openLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openLogButtonActionPerformed
        JFileChooser fc;
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = fc.showOpenDialog(fc);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();
            log.append("Opening " + file.getName() + "." + "\n");

            try {
                // loads song database into string array
                ArrayList<String> songDatabase
                        = new ArrayList<>(loadMusicDatabase(musicLibraryDataFileLocation.getText()));
                // extracts text from pdf file
                ArrayList<String> rawMusicLog
                        = new ArrayList<>(loadMusicLog(file.getAbsolutePath(), songDatabase));
                // parses extracted text into relevant list of songs to use
                ArrayList<String> generateSongListFromLog
                        = new ArrayList<>(createPlaylist(songDatabase, rawMusicLog));
                // convert songs strings into song objects
                songList = new ArrayList<>(convertToSongObjects(generateSongListFromLog));

                // display songs in data table
                displayLogInTable(songList);

            } catch (IOException ex) {
                Logger.getLogger(UserInterface.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_openLogButtonActionPerformed

    private void singleSegmentRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleSegmentRadioButtonActionPerformed
        singleSegmentHRInputTextField.setEnabled(true);
        singleSegmentHRInputLabel.setEnabled(true);
        singleSegmentSEGInputLabel.setEnabled(true);
        singleSegmentSEGInputTextField.setEnabled(true);
        wholeShowRadioButton.setSelected(false);
        noMusicBedCheckBox.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_singleSegmentRadioButtonActionPerformed

    private void wholeShowRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wholeShowRadioButtonActionPerformed
        // TODO add your handling code here:
        singleSegmentHRInputTextField.setEnabled(false);
        singleSegmentHRInputLabel.setEnabled(false);
        singleSegmentSEGInputLabel.setEnabled(false);
        singleSegmentSEGInputTextField.setEnabled(false);
        singleSegmentRadioButton.setSelected(false);
        noMusicBedCheckBox.setEnabled(false);


    }//GEN-LAST:event_wholeShowRadioButtonActionPerformed

    private void prepareAudioAssetsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prepareAudioAssetsButtonActionPerformed
        // here we'll check the files then prepare the files base on the log
        if (pcnCHRRadioButton.isSelected()) {
            System.out.println("PopCrush Nights CHR Radio Button IS enabled!");
            log.append("PopCrush Nights CHR Radio Button IS enabled!");
            String[][][] pcnCHRclock = {
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song"},
                    {"Song"}
                },
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song"},
                    {"Song"}
                },
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song"},
                    {"Song"}
                },
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song"},
                    {"Song"}
                },
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ"},
                    {"Song"},
                    {"Song"}
                },};

            System.out.println(clock.length);
            try {
                buildActiveLog(pcnCHRclock, songList);
            } catch (IOException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (pcnSamAdamsRadioButton.isSelected()) {
            String[][][] samAdamsClock = {
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song"},
                    {"Song"}
                },
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song"},
                    {"Song"}
                },
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song"},
                    {"Song"}
                },
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song"},
                    {"Song"}
                },
                {
                    {"Hour Open", "Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song", "DJ", "Song", "Generic Sweeper", "Song"},
                    {"Song", "DJ", "Song", "New Music Sweeper", "Song", "DJ", "Sam Adams"},
                    {"Song"},
                    {"Song"}
                },};

            try {
                buildActiveLog(samAdamsClock, songList);
            } catch (IOException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("PopCrush Nights Sam Adams Radio Button IS enabled!");
            log.append("PopCrush Nights Sam Adams Radio Button IS enabled!");
        }

        beginMixButton.setEnabled(true);
        // if/then conditional to auto start mix upon processing completion
        if (autoMixCheckBox.isSelected()) {

            // some how trigger the begin mix process
            beginMixButton.doClick();

        }
    }//GEN-LAST:event_prepareAudioAssetsButtonActionPerformed

    private void beginMixButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginMixButtonActionPerformed
        // eventually want to add some error handling/asset confirmation before proceeding
        // scan the temp directory for files named HOUR X SEGMENT X ELEMENT 
        // if match found, add them to an arraylist
        // combine that arraylist to an output filename for final step
        // what segments need combining?

        int firstHour = 0;
        int lastHour = 0;
        int firstSegment = 0;
        int lastSegment = 0;
        File mixdownFolder = new File("D:\\Amazon Drive\\pcn\\temp");
        File listOfFiles[] = mixdownFolder.listFiles();

        if (wholeShowRadioButton.isSelected()) {
            // let's change this so it's dynamic and not static variables
            firstHour = 1;
            firstSegment = 1;
            lastHour = 5;
            lastSegment = 6;

        } else {
            lastHour = Integer.parseInt(singleSegmentHRInputTextField.getText());
            firstHour = Integer.parseInt(singleSegmentHRInputTextField.getText());
            lastSegment = Integer.parseInt(singleSegmentSEGInputTextField.getText());
            firstSegment = Integer.parseInt(singleSegmentSEGInputTextField.getText());
        }

        for (int hr = firstHour; hr <= lastHour; hr++) {
            for (int seg = firstSegment; seg <= lastSegment; seg++) {
                ArrayList<String> tracksToCombine = new ArrayList<>();
                for (File file : listOfFiles) {
                    String targetFile = "HOUR " + hr + " SEGMENT " + seg + " ELEMENT";
                    if (file.getName().contains(targetFile)) {

                        if (listModel.getSize() != 0) {

                            for (int i = 0; i < listModel.getSize(); i++) {

                                if (targetFile.contains(listModel.get(i).toString().toUpperCase().trim())) {

                                    noMusicBed = true;

                                }

                            }
                        }

                        if (!(file.getName().contains("MUSIC BED") && noMusicBed)) {
                            tracksToCombine.add(file.getAbsolutePath());

                        }

//                          this is the original code - in panic default to this and delete everything above!
//                          if (!(file.getName().contains("MUSIC BED") && noMusicBedCheckBox.isSelected())) {
//                            tracksToCombine.add(file.getAbsolutePath());
//
//                        }
                    }
                    noMusicBed = false;
                }
                String destinationFileName = "D:\\PCN Hour" + hr + "Seg0" + seg + ".WAV";
                System.out.println("size of tracksToCombine: " + tracksToCombine.size());
                if (tracksToCombine.size() == 1) {
                    // if the segment is only 1 track, no need to combine, just copy the file to the destination
                    // directory and rename it.  simple as that.

                    File sourceFile = new File(tracksToCombine.get(0));
                    File destinationFile = new File(destinationFileName);
                    try {
                        FileUtils.copyFile(sourceFile, destinationFile);
                    } catch (IOException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    mixThisCollection(destinationFileName, tracksToCombine);
                }
            }
            // if/then conditional if the play sound effect checkbox is marked

        }
        if (playCompletedSoundEffectCheckBox.isSelected()) {

            // play sound effect to audibly signify the mix is done
            aw = new AePlayWave("D:\\Amazon Drive\\pcn\\sfx\\ding.wav");
            aw.start();

        }


    }//GEN-LAST:event_beginMixButtonActionPerformed

    private void selectedItemPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedItemPlayButtonActionPerformed
        // TODO add your handling code here:

        aw = new AePlayWave(musicLibraryLocationTextField.getText() + selectedItemFileLabel.getText().trim());
        aw.start();


    }//GEN-LAST:event_selectedItemPlayButtonActionPerformed

    private void selectedItemStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedItemStopButtonActionPerformed
        // find a better way to handle this some day?
        aw.stop();
    }//GEN-LAST:event_selectedItemStopButtonActionPerformed

    private void musicLibraryLocationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicLibraryLocationTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_musicLibraryLocationTextFieldActionPerformed

    private void musicLibraryDataFileLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicLibraryDataFileLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_musicLibraryDataFileLocationActionPerformed

    private void pcnCHRRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcnCHRRadioButtonActionPerformed
        // TODO add your handling code here:
        log.append("clock changed to PopCrush Nights (CHR). \n");
    }//GEN-LAST:event_pcnCHRRadioButtonActionPerformed

    private void tocnRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tocnRadioButtonActionPerformed
        // TODO add your handling code here:d
        log.append("clock changed to Taste of Country Nights. \n");


    }//GEN-LAST:event_tocnRadioButtonActionPerformed

    private void lwnRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lwnRadioButtonActionPerformed
        // TODO add your handling code here:

        log.append("clock changed to Loudwire Nights.\n");


    }//GEN-LAST:event_lwnRadioButtonActionPerformed

    private void ucrRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ucrRadioButtonActionPerformed
        // TODO add your handling code here:
        log.append("clock changed to Ultimate Classic Rock.\n");

    }//GEN-LAST:event_ucrRadioButtonActionPerformed

    private void voAudioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voAudioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_voAudioTextFieldActionPerformed

    private void pcnSamAdamsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcnSamAdamsRadioButtonActionPerformed
        log.append("clock changed to PopCrush Nights (Sam Adams Billboards");
    }//GEN-LAST:event_pcnSamAdamsRadioButtonActionPerformed

    private void noMusicBedAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noMusicBedAddButtonActionPerformed
        // TODO add your handling code here:

        // user enters exempted hour/segment numbers that will remove the music bed
        // during the whole show mix, to save me the hassle of having to do it manually
        // when user clicks add - the segment is added to the list. 
        String tempListName = "Hour " + noMusicBedHourTextBox.getText() + " Segment " + noMusicBedSegmentTextBox.getText();

        listModel.addElement(tempListName);
        noMusicBedHourTextBox.setText("");
        noMusicBedSegmentTextBox.setText("");


    }//GEN-LAST:event_noMusicBedAddButtonActionPerformed

    private void openCommercialLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openCommercialLogButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc;
        fc = new JFileChooser();
        PdfReader reader;
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = fc.showOpenDialog(fc);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();
            log.append("Opening " + file.getName() + "." + "\n");
           

        }


    }//GEN-LAST:event_openCommercialLogButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoMixCheckBox;
    private javax.swing.JButton beginMixButton;
    private javax.swing.ButtonGroup clockRadioButtonGroup;
    private javax.swing.JLabel commercialLogLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea log;
    private javax.swing.JRadioButton lwnRadioButton;
    private javax.swing.JTextField musicLibraryDataFileLocation;
    private javax.swing.JTextField musicLibraryLocationTextField;
    private javax.swing.JButton noMusicBedAddButton;
    private javax.swing.JCheckBox noMusicBedCheckBox;
    private javax.swing.JLabel noMusicBedDisplayLabel;
    private javax.swing.JLabel noMusicBedHourLabel;
    private javax.swing.JTextField noMusicBedHourTextBox;
    private javax.swing.JList<String> noMusicBedList;
    private javax.swing.JLabel noMusicBedSegLabel;
    private javax.swing.JTextField noMusicBedSegmentTextBox;
    private javax.swing.JButton openCommercialLogButton;
    private javax.swing.JButton openLogButton;
    private javax.swing.JLabel openMusicLogLabel;
    private javax.swing.JRadioButton pcnCHRRadioButton;
    private javax.swing.JRadioButton pcnSamAdamsRadioButton;
    private javax.swing.JRadioButton pcnTop20RadioButton;
    private javax.swing.JCheckBox playCompletedSoundEffectCheckBox;
    private javax.swing.JButton prepareAudioAssetsButton;
    private javax.swing.JLabel selectedItemArtistLabel;
    private javax.swing.JLabel selectedItemFileLabel;
    private javax.swing.JLabel selectedItemIntroLabel;
    private javax.swing.JLabel selectedItemOutroLabel;
    private javax.swing.JButton selectedItemPlayButton;
    private javax.swing.JButton selectedItemStopButton;
    private javax.swing.JLabel selectedItemTitleLabel;
    private javax.swing.JLabel selectedItemTotalLabel;
    private javax.swing.JLabel singleSegmentHRInputLabel;
    private javax.swing.JTextField singleSegmentHRInputTextField;
    private javax.swing.JRadioButton singleSegmentRadioButton;
    private javax.swing.JLabel singleSegmentSEGInputLabel;
    private javax.swing.JTextField singleSegmentSEGInputTextField;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JRadioButton tocnRadioButton;
    private javax.swing.JRadioButton ucrRadioButton;
    private javax.swing.JLabel voAudioLocationLabel;
    private javax.swing.JTextField voAudioTextField;
    private javax.swing.JLabel wholeOrSingleLabel;
    private javax.swing.JRadioButton wholeShowRadioButton;
    private javax.swing.JRadioButton xxlRadioButton;
    // End of variables declaration//GEN-END:variables

    private void displayLogInTable(ArrayList<LogElement> songList) {
        String artist = null, intro = null, outro = null, total = null, title = null, fileN = null;

        int hour = 1;
        int segment = 1;
        int element = 1;
        int songCounter = 0;
        int index = 1;
        int breakNumber = 0;

        String currentVOFile = "D:\\Amazon Drive\\pcn\\vo\\HOUR" + hour + "BREAK0" + breakNumber + ".WAV";

        // create a color picker
        tableModel.setRowCount(0);
//        
        for (int i = 0; i < clock.length; i++) {
            System.out.println("length of clock: " + clock.length);

            for (int j = 0; j < clock[i].length; j++) {
                for (int k = 0; k < clock[i][j].length; k++) {
                    System.out.println("Values at arr[" + i + "][" + j + "][" + k + " is " + clock[i][j][k]);
                    System.out.println("Hour: " + hour + " Segment: " + segment + " Element # in Seg: " + element);

                    switch (clock[i][j][k]) {

                        case "Song":
                            artist = songList.get(songCounter).getArtistName() + "\n";
                            intro = songList.get(songCounter).getIntroTime() + "\n";
                            outro = songList.get(songCounter).getOutroTime() + "\n";
                            total = songList.get(songCounter).getTotalTime() + "\n";
                            title = songList.get(songCounter).getSongTitle() + "\n";
                            fileN = songList.get(songCounter).getFileName() + "\n";
                            System.out.println(artist + intro + outro + total + title + fileN);
                            songCounter++;

                            break;

                        case "DJ":
                            breakNumber++;
                            artist = "Lisa Paige";
                            title = "DJ Break: Hour 0" + hour + " Segment 0" + breakNumber;
                            intro = "--";
                            outro = "--";
                            currentVOFile = "D:\\Amazon Drive\\pcn\\vo\\HOUR" + hour + "BREAK0" + breakNumber + ".WAV";
                            File thisDJBit = new File(currentVOFile);
                            total = lengthOfAudioFile(thisDJBit) + "";
                            fileN = currentVOFile;
                            System.out.println(artist + intro + outro + total + title + fileN);

                            break;

                        case "New Music Stager":
                            artist = "PopCrush Nights";
                            title = "NEW MUSIC STAGER IMAGING PIECE";
                            intro = "--";
                            outro = "--";
                            total = "03";
                            fileN = "--";
                            System.out.println(artist + intro + outro + total + title + fileN);
                            break;

                        case "New Music Sweeper":
                            artist = "PopCrush Nights";
                            title = "NEW MUSIC GENERIC SWEEPER IMAGING PIECE";
                            intro = "--";
                            outro = "--";
                            total = "04";
                            fileN = "--";
                            System.out.println(artist + intro + outro + total + title + fileN);
                            break;

                        case "Hour Open":
                            artist = "PopCrush Nights";
                            title = "HOUR KICK-OFF IMAGING PIECE";
                            intro = "--";
                            outro = "--";
                            total = "06";
                            fileN = "--";
                            System.out.println(artist + intro + outro + total + title + fileN);
                            break;

                        case "Generic Sweeper":
                            artist = "PopCrush Nights";
                            title = "GENERIC SWEEPER IMAGING PIECE";
                            intro = "--";
                            outro = "--";
                            total = "04";
                            fileN = "--";
                            System.out.println(artist + intro + outro + total + title + fileN);

                            break;

                    }
                    Object datainfo[] = {index, artist, title, intro, outro, total, fileN};
                    tableModel.addRow(datainfo);

                    element++;
                    index++;
                }
                segment++;
                element = 1;

            }
            hour++;
            segment = 1;
            breakNumber = 0;
        }

    }

    private void buildActiveLog(String[][][] clock, ArrayList<LogElement> songList) throws IOException, ParseException {

        // this iterates over the clock blueprint and allows actions based on element pieces.
        int hour = 1;
        int segment = 1;
        int element = 1;
        int songCounter = 0;
        double silenceToAdd = 0;
        int djBreakNumber = 1;

        String currentVOFile = "D:\\Amazon Drive\\pcn\\vo\\HOUR" + hour + "BREAK0" + djBreakNumber + ".WAV";
        File djBit = new File(currentVOFile);
        File tempDJBit = new File("D:\\Amazon Drive\\pcn\\temp\\tempdjbit.wav");
        FileUtils.copyFile(djBit, tempDJBit);

        for (int i = 0; i < clock.length; i++) {
            // System.out.println("length of clock: " + clock.length);

            for (int j = 0; j < clock[i].length; j++) {
                for (int k = 0; k < clock[i][j].length; k++) {
                    // System.out.println("Values at arr[" + i + "][" + j + "][" + k + " is " + clock[i][j][k]);
                    System.out.println("Hour: " + hour + " Segment: " + segment + " Element # in Seg: " + element);
                    System.out.println("value of silenceToAdd: " + silenceToAdd);

                    //System.out.println("value of songLength: " + songLength);
                    //System.out.println("value of outroTime: " + outroTime);
                    currentVOFile = "D:\\Amazon Drive\\pcn\\vo\\HOUR" + hour + "BREAK0" + djBreakNumber + ".WAV";
                    djBit = new File(currentVOFile);
                    tempDJBit = new File("D:\\Amazon Drive\\pcn\\temp\\tempdjbit.wav");
                    double lengthOfCurrentVOFile = 0;

                    double musicBedHole = 0;
                    double previousTalkOutRamp = 0;
                    double lengthOfPreviousSong = 0;
                    double previousLengthWithPlayMarkerTime = 0;
                    double nextSongIntro = 0;
                    double lengthOfCurrentSong = convertTimeStringToSeconds(songList.get(songCounter).getTotalTime());
                    if (songCounter > 0) {
                        lengthOfPreviousSong = convertTimeStringToSeconds(songList.get(songCounter - 1).getTotalTime());
                        previousLengthWithPlayMarkerTime = convertTimeStringToSeconds(songList.get(songCounter - 1).getOutroTime());
                        previousTalkOutRamp = lengthOfPreviousSong - previousLengthWithPlayMarkerTime;
                    }

                    double lengthWithPlayMarkerTime = convertTimeStringToSeconds(songList.get(songCounter).getOutroTime());

                    if (songCounter < songList.size() - 1) {
                        nextSongIntro = Double.parseDouble(songList.get(songCounter + 1).getIntroTime());
                    }

                    double currentSongIntro = Double.parseDouble(songList.get(songCounter).getIntroTime());
                    double talkOutRamp = lengthOfCurrentSong - lengthWithPlayMarkerTime;

                    double startOfNextSong = lengthWithPlayMarkerTime + musicBedHole + talkOutRamp;

                    // here we do a switch statement based on the clock values
                    switch (clock[i][j][k]) {
                        case "DJ":
                            // grabs the designated dry voice over bit for the segment
                            // copies the file to the temp directory in uniform naming convention
                            // adds silence to beginning based on silenceToAdd variable
                            String copiedDJBit = "D:\\Amazon Drive\\pcn\\temp\\HOUR " + hour + " SEGMENT " + segment
                                    + " ELEMENT " + element + ".WAV";
                            FileUtils.copyFile(djBit, tempDJBit);

                            System.out.println("adding " + silenceToAdd + " seconds to " + tempDJBit.getAbsolutePath());

                            addSilenceToTrack(tempDJBit.getAbsolutePath(), silenceToAdd, copiedDJBit);
                            System.out.println("adding " + lengthOfAudioFile(tempDJBit) + " seconds to silenceToAdd");
                            lengthOfCurrentVOFile = lengthOfAudioFile(tempDJBit);
                            musicBedHole = ((previousLengthWithPlayMarkerTime + lengthOfCurrentVOFile) - lengthOfPreviousSong) - currentSongIntro;

                            System.out.println("value of previouslengthwithplaymarker: " + previousLengthWithPlayMarkerTime);
                            System.out.println("value of lengthofCurrentVOFile: " + lengthOfCurrentVOFile);
                            System.out.println("value of length of Previous song: " + lengthOfPreviousSong);
                            System.out.println("value of next song intro time: " + currentSongIntro);
                            System.out.println("in DJ CASE value of musicBedHole: " + musicBedHole);

                            startOfNextSong = silenceToAdd + previousTalkOutRamp;

                            System.out.println("value of element : " + element + " and IJ.LENGTH" + clock[i][j].length);

                            if (element + 1 >= clock[i][j].length) {
                                System.out.println("element finally equals length - changing");
                                musicBedHole += currentSongIntro;
                                System.out.println("adding currentsongintro: " + currentSongIntro);
                                System.out.println("to musicBedHole");
                                System.out.println("new value of musicBedHole: " + musicBedHole);

                            }

                            if (musicBedHole > 10) {

                                element++;

                                String musicBed = pickPCNMusicBed();
                                //musicBedHole -= previousTalkOutRamp;

                                musicBed = loopMusicBed(hour, segment, musicBed, musicBedHole);
                                String musicBedDestinationFileLocation = "D:\\Amazon Drive\\pcn\\temp\\HOUR " + hour + " SEGMENT " + segment
                                        + " ELEMENT " + element + " MUSIC BED.WAV";

                                addSilenceToTrack(musicBed, startOfNextSong, musicBedDestinationFileLocation);
                            }

                            silenceToAdd += lengthOfAudioFile(tempDJBit) - currentSongIntro;

                            // if element is last in array then we DONT do this calculation
                            // if ijk is last item in array dont do this:
                            double newSilenceToAdd = silenceToAdd + currentSongIntro - lengthOfAudioFile(tempDJBit) + previousTalkOutRamp;
                            System.out.println("value of newsilenceToAdd: " + newSilenceToAdd);

                            if (silenceToAdd < newSilenceToAdd) {
                                silenceToAdd = newSilenceToAdd;

                            }
                            System.out.println("value of silenceToAdd: " + silenceToAdd);

                            // if the previous element in the clock was a song we need to determine
                            // the gap between previous song's outro and next song's intro
                            // if the gap is smaller than the voice over, we need to add a music bed
                            djBreakNumber++;
                            break;

                        case "Song":
//                            System.out.println("title:" + songList.get(songCounter).getSongTitle());
//                            System.out.println("length: " + songList.get(songCounter).getTotalTime());
//                            System.out.println("converted into double: " + lengthOfCurrentSong);
//                            System.out.println("song found!  vaule of silenceToAdd: " + silenceToAdd);
                            lengthOfCurrentSong = convertTimeStringToSeconds(songList.get(songCounter).getTotalTime());

                            lengthWithPlayMarkerTime = convertTimeStringToSeconds(songList.get(songCounter).getOutroTime());
                            File songFile = new File("D:\\Amazon Drive\\pcn\\library\\" + songList.get(songCounter).getFileName().trim());
                            File tempSong = new File("D:\\Amazon Drive\\pcn\\temp\\songxtemp.wav");
                            String copiedSong = "D:\\Amazon Drive\\pcn\\temp\\HOUR " + hour + " SEGMENT " + segment
                                    + " ELEMENT " + element + ".WAV";

                            if (silenceToAdd > 0) {
                                FileUtils.copyFile(songFile, tempSong);

                                addSilenceToTrack(tempSong.getAbsolutePath(), silenceToAdd, copiedSong);

                            } else {
                                FileUtils.copyFile(songFile, new File(copiedSong));
                            }

                            silenceToAdd += lengthWithPlayMarkerTime;
                            System.out.println("value of silence to add changed to: " + silenceToAdd);
                            songCounter++;
                            break;

                        case "Generic Sweeper":
                            System.out.println("generic sweep found value of silencetoadd: " + silenceToAdd);
                            File genericSweeper = getImagingPiece("GENERIC SWEEP");
                            File tempSweeper = new File("D:\\Amazon Drive\\pcn\\temp\\tempsweeper.wav");
                            String copiedGenericSweeper = "D:\\Amazon Drive\\pcn\\temp\\HOUR " + hour + " SEGMENT " + segment
                                    + " ELEMENT " + element + ".WAV";
                            FileUtils.copyFile(genericSweeper, tempSweeper);
                            // if the previous song's talk out ramp is too long, we need to delay the sweeper's start

                            if (previousTalkOutRamp > 4) {
                                silenceToAdd += previousTalkOutRamp - 2;
                            }
                            addSilenceToTrack(tempSweeper.getAbsolutePath(), silenceToAdd, copiedGenericSweeper);
                            silenceToAdd += 5;
                            break;
                        case "New Music Sweeper":
                            System.out.println("generic sweep found value of silencetoadd: " + silenceToAdd);
                            File newMusicSweeper = getNewMusicIntro(songList.get(songCounter).getArtistName(), songList.get(songCounter).getSongTitle());
                            File tempNMSweeper = new File("D:\\Amazon Drive\\pcn\\temp\\tempNMsweeper.wav");
                            String copiedNewMusicSweeper = "D:\\Amazon Drive\\pcn\\temp\\HOUR " + hour + " SEGMENT " + segment
                                    + " ELEMENT " + element + ".WAV";
                            FileUtils.copyFile(newMusicSweeper, tempNMSweeper);
                            if (previousTalkOutRamp > 2) {
                                silenceToAdd += previousTalkOutRamp - 2;
                            }
                            addSilenceToTrack(tempNMSweeper.getAbsolutePath(), silenceToAdd, copiedNewMusicSweeper);
                            silenceToAdd += 4;

                            if (Integer.parseInt(songList.get(songCounter).getIntroTime().trim()) == 0) {

                                silenceToAdd += 3;
                            }

                            break;

                        case "Hour Open":
                            File hourOpen = getImagingPiece("HOUR OPEN");
                            File copiedHourOpen = new File("D:\\Amazon Drive\\pcn\\temp\\HOUR " + hour + " SEGMENT " + segment
                                    + " ELEMENT " + element + ".WAV");
                            FileUtils.copyFile(hourOpen, copiedHourOpen);
                            silenceToAdd += 6;
                            break;

                        case "Sam Adams":

                            silenceToAdd += currentSongIntro;
                            File billboard = new File("D:\\Amazon Drive\\pcn\\sponsorships\\CM_BOLG06220000.wav");
                            File tempBillboard = new File("D:\\Amazon Drive\\pcn\\temp\\tempbillboard.wav");
                            String copiedBillboard = "D:\\Amazon Drive\\pcn\\temp\\HOUR " + hour + " SEGMENT " + segment
                                    + " ELEMENT " + element + ".WAV";
                            FileUtils.copyFile(billboard, tempBillboard);
                            addSilenceToTrack(tempBillboard.getAbsolutePath(), silenceToAdd, copiedBillboard);
                            // silenceToAdd += 15;
                            break;

                    }

                    element++;

                }

                segment++;
                element = 1;
                // reset silenceToAdd to zero
                silenceToAdd = 0;
            }
            hour++;
            djBreakNumber = 1;
            segment = 1;
            // comment this to prepare assets for whole show
//            if (hour == 3) {
//                System.exit(i);
//            }

        }

    }

    private File getImagingPiece(String category) {

        File imagingFolder = new File("D:\\Amazon Drive\\pcn\\imaging\\");
        File[] imagingFiles = imagingFolder.listFiles();
        ArrayList<File> imagingToPickFrom = new ArrayList<>();

        for (File file : imagingFiles) {

            if (file.getName().contains(category)) {
                imagingToPickFrom.add(file);
            }

        }
        Random rand = new Random();

        return imagingToPickFrom.get(rand.nextInt(imagingToPickFrom.size()));

    }

    private File getNewMusicIntro(String artist, String title) {

        File imagingFolder = new File("D:\\Amazon Drive\\pcn\\new music\\");
        File[] imagingFiles = imagingFolder.listFiles();
        ArrayList<File> imagingToPickFrom = new ArrayList<>();
        File newMusicFileChosen = new File("D:\\Amazon Drive\\pcn\\temp\\newMusicIntroFileChosen.wav");

        for (File file : imagingFiles) {

            if (file.getName().contains(artist) && file.getName().contains(title)) {
                System.out.println("!!!!! FOUND A NEW MUSIC INTRO !!!!!");
                imagingToPickFrom.add(file);
            }

        }

        if (imagingToPickFrom.size() == 1) {
            newMusicFileChosen = imagingToPickFrom.get(0);
        } else {

            newMusicFileChosen = getImagingPiece("NEW MUSIC GENERIC");

        }

        return newMusicFileChosen;

    }

    public static void addSilenceToTrack(String inputFile, double amount, String destinationFile) throws ParseException {

        ArrayList<String> filesToCombine = new ArrayList<>();
        // System.out.println("in addSilenceToTrack value of amount: " + amount);

        double totalFullMinutes = (int) amount / 60;

        //  System.out.println("value of totalFullMinutes: " + totalFullMinutes);
        //add 3 one minute files to the collections queue to be combined
        for (int i = 0; i < totalFullMinutes; i++) {

            filesToCombine.add("D:\\Amazon Drive\\pcn\\silence\\one minute.wav");

        }
        double remainder = amount - totalFullMinutes * 60;
        // System.out.println("value of remainder: " + remainder);
        double totalFullThirtySeconds = (int) remainder / 30;
        // System.out.println("value of TotalFullThirtySeconds" + totalFullThirtySeconds);

        for (int i = 0; i < totalFullThirtySeconds; i++) {

            filesToCombine.add("D:\\Amazon Drive\\pcn\\silence\\thirty seconds.wav");

        }
        remainder = remainder - totalFullThirtySeconds * 30;
        // System.out.println("value of remainder: " + remainder);
        double totalFullFifteenSeconds = (int) remainder / 15;
        // System.out.println("value of totalFullFifteenSeconds" + totalFullFifteenSeconds);
        for (int i = 0; i < totalFullFifteenSeconds; i++) {

            filesToCombine.add("D:\\Amazon Drive\\pcn\\silence\\fifteen seconds.wav");

        }
        remainder = remainder - totalFullFifteenSeconds * 15;
        // System.out.println("value of remainder: " + remainder);
        double totalFullSeconds = (int) remainder / 1;
        // System.out.println("value of totalFullSeconds:" + totalFullSeconds);
        for (int i = 0; i < totalFullSeconds; i++) {
            filesToCombine.add("D:\\Amazon Drive\\pcn\\silence\\one second.wav");

        }
        remainder = remainder - totalFullSeconds * 1;
        System.out.println("value of remainder: " + remainder);
        double totalFullHalfSeconds = (int) remainder / 0.5;
        System.out.println("value of totalFullHalfSeconds:" + totalFullHalfSeconds);
        for (int i = 0; i < totalFullHalfSeconds; i++) {
            // System.out.println("adding half second.wav to filesToCombine!");
            filesToCombine.add("D:\\Amazon Drive\\pcn\\silence\\half second.wav");
        }
        remainder = remainder - totalFullHalfSeconds * 0.5;
        System.out.println("value of remainder: " + remainder);
        double totalFullQuarterSeconds = (int) remainder / 0.25;
        System.out.println("value of totalFullQuarterSeconds:" + totalFullQuarterSeconds);
        for (int i = 0; i < totalFullQuarterSeconds; i++) {
            filesToCombine.add("D:\\Amazon Drive\\pcn\\silence\\quarter second.wav");

        }
        remainder = remainder - totalFullQuarterSeconds * 0.25;
        System.out.println("value of remainder: " + remainder);
        double totalFullEighthSeconds = (int) remainder / 0.125;
        System.out.println("value of totalFull Eighth Seconds:" + totalFullEighthSeconds);
        for (int i = 0; i < totalFullEighthSeconds; i++) {
            filesToCombine.add("D:\\Amazon Drive\\pcn\\silence\\eighth second.wav");

        }

        // after determining how much silence to put before we need to finally add the passed file into the array
        filesToCombine.add(inputFile);

        combineThisCollection(destinationFile, filesToCombine);

    }

    public static void combineThisCollection(String filename, ArrayList<String> audioCollection) {

        String strOutputFilename = filename;
        AudioFormat audioFormat = null;
        ArrayList audioInputStreamList = new ArrayList();
        String strFilename = null;


        /*
			 *	We have to read in the sound file.
         */
        for (int i = 0; i < audioCollection.size(); i++) {

            strFilename = audioCollection.get(i);
            //System.out.println("strFilename value " + strFilename);

            File soundFile = new File(strFilename);
            AudioInputStream audioInputStream = null;
            try {
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            } catch (Exception e) {
                /*
				 *	In case of an exception, we dump the exception
				 *	including the stack trace to the console output.
				 *	Then, we exit the program.
                 */
                e.printStackTrace();
                System.exit(1);
            }
            AudioFormat format = audioInputStream.getFormat();
            if (audioFormat == null) {
                audioFormat = format;
                if (DEBUG) {
                    out("AudioConcat.main(): format: " + audioFormat);
                }
            } else if (!audioFormat.matches(format)) {
                // TODO: try to convert
                out("AudioConcat.main(): WARNING: AudioFormats don't match");
                out("AudioConcat.main(): master format: " + audioFormat);
                out("AudioConcat.main(): this format: " + format);
            }
            audioInputStreamList.add(audioInputStream);

        }
        // System.out.println(audioInputStreamList);
        AudioInputStream audioInputStream = null;

        audioInputStream = new SequenceAudioInputStream(audioFormat, audioInputStreamList);
        File outputFile = new File(strOutputFilename);
        //FileUtils.copyFile(songFile, tempSong);System.out.println("BLAH VALUE OF OUTPUTFILE: " + outputFile);
        try {
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (DEBUG) {
            out("AudioConcat.main(): before exit");
        }

    }

    private double convertTimeStringToSeconds(String outroTime) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = sdf.parse(outroTime);
        cal.setTime(date);
        double songTotalInMins = cal.get(Calendar.HOUR) * 60 + cal.get(Calendar.MINUTE);
        return songTotalInMins;
    }

    public static double lengthOfAudioFile(File filename) {

        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(filename);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        AudioFormat format = audioInputStream.getFormat();
        long audioFileLength = filename.length();
        double frameSize = format.getFrameSize();
        float frameRate = format.getFrameRate();
        double durationInSeconds = (audioFileLength / (frameSize * frameRate));

        return durationInSeconds;

    }

    public static String loopMusicBed(int hours, int segment, String fileName, double time) {

        // here we will take a randomly selected 5 second music bed and loop it as many times 
        // as will allow without going over the sent integer variable time
        // this should overwrite the file that then gets silence added to the front 
        // IN THEORY
        // added this last time.. we appear to be looping 1 too many times
        ArrayList<String> bedsToLoop = new ArrayList<>();

        System.out.println("in loopMusicBed() value of time: " + time);
        System.out.println("in loopMusicBed() value of filename: " + fileName);
        int amount = (int) time / 5;
        System.out.println("in loopMusicBed() value of amount: " + amount);

        for (int i = 0; i < amount; i++) {

            bedsToLoop.add(fileName);

        }

        String baseUrl = FilenameUtils.getPath(fileName);
        String myFile = FilenameUtils.getBaseName(fileName) + "." + FilenameUtils.getExtension(fileName);
        bedsToLoop.add("D:\\Amazon Drive\\pcn\\closers\\closer " + myFile);
        System.out.println("in loopMusicBed value of baseURL: " + baseUrl);
        System.out.println("in loopMusicBed value of myFile: " + myFile);

        String finalString = "D:\\" + baseUrl + "hr" + hours + "seg" + segment + myFile;
        System.out.println("in loopMusicBed value of finalString:" + finalString);

        combineThisCollection(finalString, bedsToLoop);

        return finalString;

    }

    private static String pickPCNMusicBed() throws IOException {

        File folder = new File("D:\\Amazon Drive\\pcn\\bed");
        File[] listOfFiles = folder.listFiles();

        ArrayList<String> musicBedsToPickFrom = new ArrayList<>();

        for (File file : listOfFiles) {

            //System.out.println("filename: " + file.getName());
            //System.out.println("length in seconds: " + lengthOfAudioFile(file));
            musicBedsToPickFrom.add(file.getName());

            // System.out.println(lengthOfVOFiles.get(counter));
        }
        Random rand = new Random();

        System.out.println("size of musicBedToPickFrom array: " + musicBedsToPickFrom.size());
        int selectedFileNumber = rand.nextInt(musicBedsToPickFrom.size());
        File copiedMusicBedFile = new File("D:\\Amazon Drive\\pcn\\temp\\" + musicBedsToPickFrom.get(selectedFileNumber));
        System.out.println("random selectedFileNumber: " + selectedFileNumber);
        System.out.println("copied Music Bed File value: " + copiedMusicBedFile.toString());

        FileUtils.copyFile(listOfFiles[selectedFileNumber], copiedMusicBedFile);

        return copiedMusicBedFile.getPath();

    }

    public static void mixThisCollection(String destinationFilename, ArrayList<String> audioCollection) {

        String strOutputFilename = destinationFilename;
        AudioFormat audioFormat = null;
        ArrayList audioInputStreamList = new ArrayList();
        String strFilename = null;


        /*
			 *	We have to read in the sound file.
         */
        for (int i = 0; i < audioCollection.size(); i++) {

            //need filename from the database string IE 001.wav
            System.out.println("in mixThisCollection audioCollection.size()" + audioCollection.size());
            //String[] parts = audioCollection.get(i).split(",");

            String fileName = audioCollection.get(i);
            System.out.println("in mixThisCollection fileName: " + fileName);

            strFilename = fileName;
            System.out.println(strFilename);
            File soundFile = new File(strFilename);
            AudioInputStream audioInputStream = null;
            try {
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            } catch (Exception e) {
                /*
				 *	In case of an exception, we dump the exception
				 *	including the stack trace to the console output.
				 *	Then, we exit the program.
                 */
                e.printStackTrace();
                System.exit(1);
            }
            AudioFormat format = audioInputStream.getFormat();
            if (audioFormat == null) {
                audioFormat = format;
                if (DEBUG) {
                    out("AudioConcat.main(): format: " + audioFormat);
                }
            } else if (!audioFormat.matches(format)) {
                // TODO: try to convert
                out("AudioConcat.main(): WARNING: AudioFormats don't match");
                out("AudioConcat.main(): master format: " + audioFormat);
                out("AudioConcat.main(): this format: " + format);
            }
            audioInputStreamList.add(audioInputStream);

        }
        System.out.println(audioInputStreamList);
        AudioInputStream audioInputStream = null;

        audioInputStream = new MixingAudioInputStream(audioFormat, audioInputStreamList);
        File outputFile = new File(strOutputFilename);
        try {
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (DEBUG) {
            out("AudioConcat.main(): before exit");
        }
        // System.exit(0);

    }

}
