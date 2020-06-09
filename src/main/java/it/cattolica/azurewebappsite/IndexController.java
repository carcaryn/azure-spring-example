package it.cattolica.azurewebappsite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private RecordRepository recordRepository;

    public IndexController(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("records", recordRepository.findAll());
        return "index";
    }
}
