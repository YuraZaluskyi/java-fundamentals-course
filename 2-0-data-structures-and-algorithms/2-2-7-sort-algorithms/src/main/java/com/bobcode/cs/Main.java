package com.bobcode.cs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Main {

  public static void main(String[] args) throws IOException {

    try (Socket socket = new Socket("93.175.204.87", 8899)) {
      var writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      var message = "Hello!!!! \n";
      writer.write(message);
      writer.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
