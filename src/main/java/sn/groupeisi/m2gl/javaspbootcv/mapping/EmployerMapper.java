package sn.groupeisi.m2gl.javaspbootcv.mapping;

import org.mapstruct.Mapper;
import sn.groupeisi.m2gl.javaspbootcv.domain.AppEmployer;
import sn.groupeisi.m2gl.javaspbootcv.entity.EmployerEntity;

@Mapper
public interface EmployerMapper {
    AppEmployer toAppEmployer(EmployerEntity appEmployerEntity);
    EmployerEntity fromAppEmployer(AppEmployer appEmployer);
}
