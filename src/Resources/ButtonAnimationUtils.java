
package Resources;


import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAnimationUtils {
    private static Dimension originalSize;
    private static Dimension newSize;
    private static Timer timer;
    private static int duration = 100;
    private static int stepCount = 10;

    public static void animateButtonOnMouseEnter(JButton button) {
        originalSize = button.getSize();

        int nuevoAncho = (int) (originalSize.getWidth() * 1.1);
        int nuevoAlto = (int) (originalSize.getHeight() * 1.1);
        newSize = new Dimension(nuevoAncho, nuevoAlto);

        int incrementoAncho = (nuevoAncho - originalSize.width) / stepCount;
        int incrementoAlto = (nuevoAlto - originalSize.height) / stepCount;

        timer = new Timer(duration / stepCount, new ActionListener() {
            int step = 0;

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (step < stepCount) {
                    int ancho = originalSize.width + incrementoAncho * step;
                    int alto = originalSize.height + incrementoAlto * step;
                    Dimension size = new Dimension(ancho, alto);
                    button.setSize(size);
                    step++;
                } else {
                    timer.stop();
                }
            }
        });

        timer.start();
    }

    public static void resetButtonSizeOnMouseExit(JButton button) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        button.setSize(originalSize);
    }
}


