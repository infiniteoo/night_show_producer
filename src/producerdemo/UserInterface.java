/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerdemo;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author troy
 */
public class UserInterface extends JPanel implements ActionListener {

    Object[] colHeaders = {"Index", "Artist", "Title", "Intro", "Outro", "Total", "File Name"};

    JButton openLibraryButton, openLogButton;
    JFileChooser fc;
   
    
    JTextArea log;
    JTable table;
    Object[] songList;
    ArrayList<String> songDatabase;
    DefaultTableModel tableModel;
    // clock blueprint: s = song, n = new music stager, j = dj bit
    // multi dimension array consists of segments in an hour
    char[][] popCrushNightsClock = {
        {'s', 'n', 'j', 's'}, // segment 1
        {'s', 'j', 's'}, // segment 2
    };

    public UserInterface() throws FileNotFoundException {

        JFrame jf = new JFrame("PopCrush Producer Demo");
        MainPanel mp = new MainPanel();
        

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(2000, 1200);
        jf.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(colHeaders, 0);

        table = new JTable(tableModel);
        TableColumn column = null;
        for (int i = 0; i < 6; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(5); //sport column is bigger
            } else {
                column.setPreferredWidth(200);
            }
        }

        JScrollPane scroll = new JScrollPane(table);
        log = new JTextArea(20, 40);
        log.setEditable(false);
        log.setMargin(new Insets(5, 5, 5, 5));
        JScrollPane logScrollPane = new JScrollPane(log);
        JPanel buttonPanel = new JPanel();
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        File defaultDirectory = new File("./pcn/");
        fc.setCurrentDirectory(defaultDirectory);
        jf.add(mp);
        jf.pack();
        jf.setVisible(true);

      
        songDatabase = new ArrayList<>(loadMusicFile("./pcn/pcn library.txt"));

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == openLogButton) {

            int returnVal = fc.showOpenDialog(fc);

            if (returnVal == JFileChooser.APPROVE_OPTION) {

                File file = fc.getSelectedFile();
                log.append("Opening " + file.getName() + "." + "\n");

                try {
                    // extracts text from pdf file
                    ArrayList<String> rawMusicLog
                            = new ArrayList<>(loadMusicLog(file.getAbsolutePath(), songDatabase));
                    // parses extracted text into relevant list of songs to use
                    ArrayList<String> generateOfficialLog
                            = new ArrayList<>(createPlaylist(songDatabase, rawMusicLog));
                    // convert songs strings into song objects
                    ArrayList<LogElement> songList
                            = new ArrayList<>(convertToSongObjects(generateOfficialLog));

                    for (int i = 0; i < songList.size(); i++) {

                        int index = i + 1;
                        String artist = songList.get(i).getArtistName() + "\n";
                        String intro = songList.get(i).getIntroTime() + "\n";
                        String outro = songList.get(i).getOutroTime() + "\n";
                        String total = songList.get(i).getTotalTime() + "\n";
                        String title = songList.get(i).getSongTitle() + "\n";
                        String fileN = songList.get(i).getFileName() + "\n";

                        Object[] datainfo = {index, artist, title, intro, outro, total, fileN};
                        tableModel.addRow(datainfo);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(UserInterface.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public ArrayList<LogElement> convertToSongObjects(ArrayList<String> songList) {

        ArrayList<LogElement> songz = new ArrayList<>();
        for (int i = 0; i < songList.size(); i++) {

            String parts[] = songList.get(i).split(",");
            songz.add(new LogElement(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));

        }
        return songz;

    }

    public ArrayList<String> loadMusicFile(String fileName) throws FileNotFoundException {

        ArrayList<String> songList = new ArrayList<>();

        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        reader.useDelimiter("~");

        log.append("reading song database...");
        while (reader.hasNext()) {

            songList.add(reader.next());

        }
        log.append(" complete!\n");
        reader.close();
        return songList;
    }

    public static ArrayList<String> loadMusicLog(String fileName, ArrayList<String> database) throws FileNotFoundException, IOException {

        ArrayList<String> songsPerPage = new ArrayList<>();

        PdfReader reader = new PdfReader(fileName);
        int n = reader.getNumberOfPages();
        System.out.println("Reading a total of  " + n + " pages from the PDF file: " + fileName);
        Pattern p = Pattern.compile("[A-Z](?<=^|[A-Z \\/])[A-Z' ]+(?=[A-Z '.\\/])");
        String str = null;

        for (int i = 0; i < n; i++) {

            str += PdfTextExtractor.getTextFromPage(reader, i + 1).toUpperCase(); //Extracting the content from a particular page.

        }

        
        System.out.println("value of STR: " + str);
        String[] parts = str.split("03:30");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("");
            System.out.println(i + "value of parts in STR using 03:30 splitter: " + parts[i]);
            songsPerPage.add(parts[i]);

            System.out.println("");
        }

        return songsPerPage;

    }

    public static ArrayList<String> createPlaylist(ArrayList<String> database, ArrayList<String> musicLog) {

        ArrayList<String> finalLog = new ArrayList<>();
        int success = 0;

        for (int i = 0; i < musicLog.size(); i++) {

            for (int j = 0; j < database.size(); j++) {
                // System.out.println("value of database[j]: " + database.get(j));

                String songName = getSongTitle(database.get(j));
                String artistName = getArtistName(database.get(j));

                // System.out.println("value of musicLog.get(i): " + musicLog.get(i));
////            System.out.println("value of songName: " + songName);
////            System.out.println("value of artistName:" + artistName);
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

        // System.out.println("incoming variable songInDatabase: " + songInDatabase);
        return songTitle;

    }

    public static String getArtistName(String songInDatabase) {

        String[] parts = songInDatabase.split(",");
        String artistName = parts[0].toUpperCase().trim();
        String songName = parts[1].toUpperCase().trim();
        //System.out.println("artistName value: " + artistName);
        return artistName;

    }

}
