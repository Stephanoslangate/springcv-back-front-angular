package sn.groupeisi.m2gl.javaspbootcv.service;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.groupeisi.m2gl.javaspbootcv.domain.AppEmployer;
import sn.groupeisi.m2gl.javaspbootcv.exception.EntityNotFoundException;
import sn.groupeisi.m2gl.javaspbootcv.mapping.EmployerMapper;
import sn.groupeisi.m2gl.javaspbootcv.repository.IEmployerRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AppEmployerService {
    private IEmployerRepository iAppEmployeurRepository;
    private EmployerMapper appEmployerMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public List<AppEmployer> getAppEmployers() {
        return StreamSupport.stream(iAppEmployeurRepository.findAll().spliterator(), false)
                .map(appEmployerMapper::toAppEmployer)
                .collect(Collectors.toList());
    }
    //si on veut recuperer un seul
    @Transactional(readOnly = true)
    public AppEmployer getAppEmpoyer(int id) {
        return appEmployerMapper.toAppEmployer(iAppEmployeurRepository.findById(id)
                .orElseThrow(() ->//on cherche si on trouve on retourn  sinon on vas simplement envoyer saa
                        new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional(readOnly = true)
    public AppEmployer getAppEmpoyerByEmail(String email) {
        return appEmployerMapper.toAppEmployer(iAppEmployeurRepository.findByEmail(email));

    }
    @Transactional
    public AppEmployer createAppEmployer(AppEmployer appEmployer) {
      return   appEmployerMapper.toAppEmployer(iAppEmployeurRepository.save(appEmployerMapper.fromAppEmployer(appEmployer)));

    }
    @Transactional
    public AppEmployer updateAppEmployer(Integer id,AppEmployer appEmployer) {
        return   appEmployerMapper.toAppEmployer(iAppEmployeurRepository.save(appEmployerMapper.fromAppEmployer(appEmployer)));

    }
    @CachePut(key = "#id")
    @Transactional
    public AppEmployer updatePerson(Integer id, AppEmployer appEmployer) {
        return iAppEmployeurRepository.findById(id)
                .map(entity -> {

                    appEmployer.setId(id);
                    return appEmployerMapper.toAppEmployer(iAppEmployeurRepository.save(appEmployerMapper.fromAppEmployer(appEmployer)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("person.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

}
