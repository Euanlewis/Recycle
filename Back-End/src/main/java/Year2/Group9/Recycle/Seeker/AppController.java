package Year2.Group9.Recycle.Seeker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/HelloHome")
    public String viewHomePage(){
        return "index";
    }
    
}
