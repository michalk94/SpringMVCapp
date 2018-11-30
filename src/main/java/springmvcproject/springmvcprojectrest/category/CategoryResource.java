package springmvcproject.springmvcprojectrest.category;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryResource {

    private CategoryService categoryService;

    @GetMapping("/names")
    public List<String> findAllNames(){
        return categoryService.findAllNames();
    }

}
