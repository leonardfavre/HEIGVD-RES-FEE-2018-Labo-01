package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import org.apache.commons.io.filefilter.DirectoryFileFilter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor vistor) {
      vistor.visit(rootDirectory);
      if (rootDirectory.exists()) {
          try {
              for (File f : rootDirectory.listFiles()){
                  if(f.isFile()){
                      vistor.visit(f);
                  }
              }
              for (File f : rootDirectory.listFiles()) {
                  if(f.isDirectory()){
                      f.getPath().toString();
                      explore(f, vistor);
                  }
              }
          } catch (NullPointerException e) {
          }
      }

  }
  }


