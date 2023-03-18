import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ContentFrame extends JFrame implements ActionListener
{
    ImagePanel imagePanel;
    JTextField urlPath;
    JLabel errors;
    JButton executeButton;


    public ContentFrame()
    {
        setDefaultConfigurations();

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 50, 10, 50);

        imagePanel = new ImagePanel("th-536375772.png");

        add(imagePanel, c);

        errors = new JLabel();
        c.weighty = 0;
        c.insets = new Insets(0, 50, 0, 50);
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;

        add(errors, c);

        urlPath = new JTextField();
        c.weighty = 0;
        c.insets = new Insets(10, 50, 2, 50);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;

        add(urlPath, c);

        c.insets = new Insets(2, 50, 10, 50);
        c.gridx = 0;
        c.gridy = 3;

        executeButton = new JButton("Get the picture");
        executeButton.setFocusable(false);
        executeButton.addActionListener(this);

        add(executeButton, c);

        setVisible(true);
    }

    private void setDefaultConfigurations()
    {
        setTitle("ImageURLPreview");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setResizable(true);
        setSize(400,400);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == executeButton)
        {
            URL picture;
            Image newImage;
            try {
                picture = new URL(urlPath.getText());
                newImage = ImageIO.read(picture);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            imagePanel.setImage(newImage);
            imagePanel.repaint();
        }
    }
}
