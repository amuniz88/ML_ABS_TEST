package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static Utils.SeleniumUtils.findElements;

public class CarList extends BasePO{

    public List<CarItem> productos;

    public CarList(WebDriver driver){
        super(driver);
        productos = new ArrayList<>();
        List<WebElement> item_info = findElements(driver, By.className("item__info-link"));
        for(WebElement item : item_info){
            productos.add(new CarItem(item));
        }
    }

//    public List<CarList> getListCar(){
    public void ListCar(){
        int contador = 0;
        ArrayList<String> contenido = new ArrayList<>();

        for(CarItem item : productos){
            contador = contador + 1;
            contenido.add(contador + " - Name: " + item.getName() + " - " + item.getLink() + "\n");
        }

        try {
            String ruta = "C:\\archivos\\ml_autos.txt";

                File file = new File(ruta);
//             Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for(String c : contenido) {

                    bw.write(c);
                }

                bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
