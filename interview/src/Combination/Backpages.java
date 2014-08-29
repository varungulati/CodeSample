package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JEditorPane;

import com.sun.security.ntlm.Client;

public class Backpages {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String link = "http://newlondon.backpage.com/FemaleEscorts/a-flirty-sweetheart-for-your-vip-taste-19/7520537";
        while(true) {
//            String link = "http://birmingham.backpage.com/FemaleEscorts/very-sweet-treat-with-skills-that-cant-be-beat-new-n-town-23/9868270";
//            String link = "http://longbeach.backpage.com/FemaleEscorts/caution-wild-and-fun-available-247-downey-transexual-amy-22/39900102";
//            String link = "http://newlondon.backpage.com/FemaleEscorts/a-flirty-sweetheart-for-your-vip-taste-19/7520537";
//            String link = "http://newlondon.backpage.com/FemaleEscorts/busty-all-natural-sweetness-escape-into-my-world-19/7520537";
            URL a = null;
            try {
                a = new URL(link);
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            URLConnection urlc = null;
            try {
                urlc = a.openConnection();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            InputStream is = null;
            try {
            is = urlc.getInputStream();
            System.out.println("DONE");
            }
            catch (Exception e) {
                System.out.println("GOT ERROR");
                e.printStackTrace();
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("SLEPT");
                link = "http://newlondon.backpage.com/FemaleEscorts/7520537";
                JEditorPane editorPane = new JEditorPane();
                try {
                    editorPane.setPage(new URL(link));
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
//                    e1.printStackTrace();
                }
            }
            
//            BufferedReader r = new BufferedReader(new InputStreamReader(is));
        }
    }

}
