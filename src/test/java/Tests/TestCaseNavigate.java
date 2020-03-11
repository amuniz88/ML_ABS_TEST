package Tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCaseNavigate extends BaseTest{

    @Test
    @Parameters({"search"})
    public void searchAutos(String prod){
        carList = homePage.goToBuscarProducto(prod);

        //crear el archivo de texto y grabar lista de autos con link
        carList.ListCar();
    }
}
