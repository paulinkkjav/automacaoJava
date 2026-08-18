import org.sikuli.script.*;

import java.io.File;
import java.util.List;

public class Main {

    private static final Screen screen = new Screen();

    public static void main(String[] args) {
        moverMouse(100, 100, true);
    }

    private static void moverMouse(int x ,int y, boolean click) {
        Region region  = new Region(0, 0, 1920, 1080);
        region.hover();
        screen.wait(1.0D);
        if (click){
            region.click();
        }
    }


    private static void clicarImagem(String nomeImagem) {
        try {
            File imagem = new File("imagemClicar/" +nomeImagem+ ".png");
            Pattern imagemBotao = new Pattern(imagem.getAbsolutePath());
            screen.wait(imagemBotao, 10);
            screen.click(imagemBotao);
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }

    private static void executarComandos(List<String> teclas) {
        screen.wait(1.5D);
        teclas.forEach(t -> screen.keyDown(t));
        teclas.forEach(t -> screen.keyUp(t));
    }

    private static void abrirCmd() {
        screen.keyDown(Key.WIN);
        screen.keyDown("r");
        screen.keyUp(Key.WIN);
        screen.keyUp("r");
        screen.type("cmd");
        screen.keyDown(Key.ENTER);
        screen.keyUp(Key.ENTER);
    }

    private static void apertarBotaoWin() {
        screen.keyDown(Key.WIN);
        screen.keyUp(Key.WIN);
    }

}