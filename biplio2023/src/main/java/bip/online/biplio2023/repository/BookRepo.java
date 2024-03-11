package bip.online.biplio2023.repository;


import bip.online.biplio2023.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepo extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findBookEntitiesByAuthor_Id(Long id);
    List<BookEntity> findBookEntitiesByTitle(String title);
}