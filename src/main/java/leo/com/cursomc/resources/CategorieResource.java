package leo.com.cursomc.resources;

import leo.com.cursomc.domain.Categorie;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@ComponentScan(basePackages = "leo.com.cursomc.resources")
@RequestMapping(value="/categories")
public class CategorieResource {

    @RequestMapping(method=RequestMethod.GET)
    public List<Categorie> list(){

        Categorie cat1 = new Categorie(1, "Informatica");
        Categorie cat2 = new Categorie(2,"Escritorio");

        List<Categorie> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }
}
