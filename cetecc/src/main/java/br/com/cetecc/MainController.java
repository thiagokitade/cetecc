package br.com.cetecc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	//Métodos utilizado para naturalizar as rotas. As URLs teram os mesmos nome das rotas do angular
	@RequestMapping(value = "/{[path:[^\\.]*}")
	public String redirect() {
	  return "forward:/";
	}

}
