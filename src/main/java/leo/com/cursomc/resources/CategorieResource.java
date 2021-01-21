package leo.com.cursomc.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = "leo.com.cursomc.resources")
@RequestMapping(value="/categories")
public class CategorieResource {

    @RequestMapping(method=RequestMethod.GET)
    public String list(){
        return "Rest esta funcionando!";
    }
}
