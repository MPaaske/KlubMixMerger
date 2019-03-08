/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.HeadlessException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
/**
 *
 * @author Paaske
 */
public class BrowesFile extends JFrame  {

    protected String selectTxt() throws HeadlessException {
        String path = "No File Selected";

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView());
        jfc.setDialogTitle("Select Txt Tabelex File");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter extFilt = new FileNameExtensionFilter("Txt File", "txt");
        jfc.addChoosableFileFilter(extFilt);
        int returnV = jfc.showOpenDialog(null);
        if (returnV == JFileChooser.APPROVE_OPTION) {
            File slcFile = jfc.getSelectedFile();
            path = slcFile.getAbsolutePath();
        }
        return path;
    }

    protected String selectExcel() throws HeadlessException {
        String path = "No File Selected";

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView());
        jfc.setDialogTitle("Select Excel File");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter extFilt = new FileNameExtensionFilter("Excel File", "xls");
        jfc.addChoosableFileFilter(extFilt);
        int returnV = jfc.showOpenDialog(null);
        if (returnV == JFileChooser.APPROVE_OPTION) {
            File slcFile = jfc.getSelectedFile();
            path = slcFile.getAbsolutePath();
        }
        return path;
    }
}
