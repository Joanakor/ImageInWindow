import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(String imagePath) {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setImage(String imagePath)
    {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setImage(Image newImage)
    {
        image = newImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int width = getWidth();
            int height = getHeight();
            int imageWidth = image.getWidth(null);
            int imageHeight = image.getHeight(null);
            double scaleX = (double) width / imageWidth;
            double scaleY = (double) height / imageHeight;
            double scale = Math.min(scaleX, scaleY);
            int newWidth = (int) (imageWidth * scale);
            int newHeight = (int) (imageHeight * scale);
            int x = (width - newWidth) / 2;
            int y = (height - newHeight) / 2;
            g.drawImage(image, x, y, newWidth, newHeight, this);
        }
    }
}