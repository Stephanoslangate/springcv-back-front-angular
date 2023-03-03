package sn.groupeisi.m2gl.javaspbootcv.repository;

import org.springframework.stereotype.Repository;
import sn.groupeisi.m2gl.javaspbootcv.entity.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface IEmployerRepository extends JpaRepository<EmployerEntity, Integer> {
    public EmployerEntity findByEmail(String email);
}
