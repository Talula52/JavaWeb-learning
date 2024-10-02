package pratice;

import  jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static java.awt.Color.white;
/**
 * @author Lenovo
 * @description: TODO
 * @date 2024/9/28 14:54
}
}
 */
@WebServlet("/veritycode")
public class VerityCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 160;
        int height = 45;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(white);
        g.fillRect(0, 0, width, height);
        String str = "123456789ADSCKHvbyfz";
        Random random = new Random();
        for (int i=0;i<=5;i++){
            int x = random.nextInt(str.length());
            char ch = str.charAt(x);
            Color c = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            g.setColor(c);
            Font font = new Font("Times New Roman", Font.PLAIN, 20);
            g.setFont(font);
            g.drawString(String.valueOf(ch), width/5*i, height/2);
        }
        for(int i=0;i<=10;i++){
            int x1= random.nextInt(width);
            int y1= random.nextInt(height);
            int x2= random.nextInt(width);
            int y2= random.nextInt(height);
            Color c = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            g.setColor(c);
            g.drawLine(x1, y1, x2, y2);
        }
        ImageIO.write(image, "jpg",resp.getOutputStream());
    }
}



