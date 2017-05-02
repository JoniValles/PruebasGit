package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Citizen;


@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    //Citizen findByDni(String dni);

}
