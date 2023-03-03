package sn.groupeisi.m2gl.javaspbootcv.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.m2gl.javaspbootcv.domain.AppEmployer;
import sn.groupeisi.m2gl.javaspbootcv.service.AppEmployerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employer")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AppEmployerController {
    private AppEmployerService appEmployerService;

    @GetMapping
    public List<AppEmployer> getAll() {
        return appEmployerService.getAppEmployers();

    }
    @RequestMapping(value = "/{id}")
    public AppEmployer getById(@PathVariable int id) {
        return appEmployerService.getAppEmpoyer(id);

    }
    @RequestMapping(value = "/byemail/{email}")
    public AppEmployer getByEmail(@PathVariable String email) {
        return appEmployerService.getAppEmpoyerByEmail(email);

    }
    @GetMapping("/helloAdmin")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("{\"value\": \"Je suis Admin - Stephanos\"}");
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)//si on insert il faut nous envoyer le status create-->200
    //@IsAdmin
    public AppEmployer createAppEmployer(@Valid @RequestBody AppEmployer appEmployeur) {
        return appEmployerService.createAppEmployer(appEmployeur);
    }
    @PutMapping("{id}")
    public void updateEmployer(@RequestBody AppEmployer employer,@PathVariable Integer id ) {
        System.out.println(employer.getId());
        System.out.println(employer.getAge());
        System.out.println(employer.getNiveauEetude());
        System.out.println(employer.getEmail());

        appEmployerService.updatePerson(id, employer);
    }

}