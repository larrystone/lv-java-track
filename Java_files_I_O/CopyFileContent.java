import java.util.Date;
import java.io.*;

public class CopyFileContent {
  private static final float START_TIME = new Date().getTime();

  private static boolean copyFileContent() {
    InputStream inputStream = null;
    OutputStream outputStream = null;

    try {
      inputStream = new FileInputStream(new File("source.txt"));
      outputStream = new FileOutputStream(new File("destination.txt"));

      byte[] buffer = new byte[1024];

      int length = 0;

      while((length = inputStream.read(buffer)) > 0) {
        outputStream.write(buffer, 0, length);
      }

      return true;
    } catch(IOException exception) {
      System.out.println("Error copying file content");
      return false;
    } finally {
      try{
        if (inputStream != null) {
          inputStream.close();
        }
        if (inputStream != null) { 
          outputStream.close();
        }
      } catch (IOException exception) {
        exception.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Copying source.txt to destination.txt");
    System.out.println("File content copying started....");
    
    boolean status = copyFileContent();

    if (status) {
      StringBuilder result = new StringBuilder();
      result.append("File content copying completed.");
      result.append("\nContent copied to: ");
      result.append("destination.txt");
      result.append("\nTook ");
      result.append((START_TIME/new Date().getTime())/1000);
      result.append(" seconds");

      System.out.println(result.toString());
    }
  }
}